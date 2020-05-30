package com.matome.task_32;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.core.content.FileProvider;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Date;

import androidx.annotation.RequiresApi;

public class HomeActivity extends AppCompatActivity  implements SensorEventListener {

    boolean activityRunning;
    private SensorManager sensorManager;
    Sensor sensor;
    private TextView count;
    static String P_B;
    private static final int CAMERA_REQUIEST = 1;


    private TextView mTextMessage;
    FloatingActionButton cb;
    private Button btnCapture;
    private ImageView imgCapture;
    private static final int Image_Capture_Code = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        count = findViewById(R.id.step_counter_);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


        ////
        cb = findViewById(R.id.floatingActionButton2);
        cb.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File picturedirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                String picturename = getPictureName();
                File imgfile = new File(picturedirectory, picturename);
                Uri pictureUri = Uri.fromFile(imgfile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);
                startActivityForResult(cameraIntent, CAMERA_REQUIEST);
            }
        });
        ////

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        break;
                    case R.id.navigation_Target:
                        Intent ii = new Intent(HomeActivity.this, TargetActivity.class);
                        startActivity(ii);
                        break;
                    case R.id.navigation_Profile:
                        Intent iii = new Intent(HomeActivity.this, ProfileActivity.class);
                        startActivity(iii);
                        break;
                    case R.id.navigation_Graph:
                        Intent iiii = new Intent(HomeActivity.this, Chart_Activity.class);
                        startActivity(iiii);
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settAct:
                Intent i = new Intent(HomeActivity.this, SettingsActivity.class);
                startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

///

///

    @Override
    protected void onResume() {
        super.onResume();
        activityRunning = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        if (countSensor != null){ sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);}
        else { Toast.makeText(this , "Counter sensor invalid", Toast.LENGTH_LONG).show();}
    }

    @Override
    public void onPause() {
        super.onPause();
        activityRunning = false;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (activityRunning){  count.setText(String.valueOf(event.values[0])); P_B = String.valueOf(event.values[0]); }
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private String getPictureName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date());
        return "Plane place img" + timestamp + ".jpg";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK) {
            if (requestCode == CAMERA_REQUIEST) {
            }
        }
    }

}