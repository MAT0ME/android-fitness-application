package com.matome.task_32;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class TargetActivity extends AppCompatActivity implements  Dialog_prof.Dialog_prof_Listener, View.OnClickListener{


    boolean IfsharedExist;
    SharedPreferences Pref_usr_details;
    private int which_txt;
    private TextView Usr__target_height ,Usr__target_weight ,Usr__target_steps ;
    CardView _target_step, _target_height, _target_weight;




    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        dialog_text_helper.which_activty = 2;



        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        Intent ii = new Intent(TargetActivity.this, HomeActivity.class);
                        startActivity(ii);
                        break;
                    case R.id.navigation_Target:

                        break;
                    case R.id.navigation_Profile:
                        Intent iii = new Intent(TargetActivity.this, ProfileActivity.class);
                        startActivity(iii);
                        break;
                    case R.id.navigation_Graph:
                        Intent iiii = new Intent(TargetActivity.this, Chart_Activity.class);
                        startActivity(iiii);
                        break;
                }
                return false;
            }
        });

        _target_step = findViewById(R.id.card_target_steps);
        _target_height = findViewById(R.id.card_target_height);
        _target_weight = findViewById(R.id.card_target_weight);

        _target_height.setOnClickListener(this);
        _target_weight.setOnClickListener(this);
        _target_step.setOnClickListener(this);

        Usr__target_steps = findViewById(R.id.usr__target_steps);
        Usr__target_height = findViewById(R.id.usr__target_height);
        Usr__target_weight = findViewById(R.id.usr__target_weight);

        sharedData();

        if(!IfsharedExist){
            Pref_usr_details = getSharedPreferences(ProfileActivity.user_pref, Context.MODE_PRIVATE);
        }else{sharedData();}



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.top_menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId())
        {
            case R.id.settAct:
                Intent i = new Intent(TargetActivity.this, SettingsActivity.class);
                startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View v){




        switch(v.getId()){
            case R.id.card_target_height:
                dialog_text_helper.dialog_which_header = 11;
                which_txt = 1;
                openDialog(); break;
            case R.id.card_target_weight:
                dialog_text_helper.dialog_which_header = 22;
                which_txt = 2;
                openDialog(); break;
            case R.id.card_target_steps:
                dialog_text_helper.dialog_which_header = 33;
                which_txt = 3;
                openDialog(); break;
        }

    }
    public void applyTexts(String data) {

        Pref_usr_details = getSharedPreferences(ProfileActivity.user_pref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Pref_usr_details.edit();

        switch (which_txt) {
            case  1:
                editor.putString("target_height",data);
                Usr__target_height.setText(data);
                editor.apply();
                break;
            case 2:
                editor.putString("target_weight",data);
                Usr__target_weight.setText(data);
                editor.apply();
                break;
            case 3:
                editor.putString("target_steps",data);
                Usr__target_steps.setText(data);
                editor.apply();
               break;

        }
    }
    public void openDialog() {
        Dialog_prof exampleDialog = new Dialog_prof();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    public void sharedData(){

        Pref_usr_details = getSharedPreferences(ProfileActivity.user_pref,Context.MODE_PRIVATE);

        if( Pref_usr_details.contains("target_height"))
        {IfsharedExist = true;
            String p_name = Pref_usr_details.getString("target_height", "height");
            Usr__target_height.setText(p_name);}
        if( Pref_usr_details.contains("target_weight"))
        {String p_lasnt_name = Pref_usr_details.getString("target_weight", "weight");
            Usr__target_weight.setText(p_lasnt_name);}
        if( Pref_usr_details.contains("target_steps"))
        {String p_age = Pref_usr_details.getString("target_steps","steps");
            Usr__target_steps.setText(p_age);}
    }


}
