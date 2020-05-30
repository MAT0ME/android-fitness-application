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


public class ProfileActivity extends AppCompatActivity implements  Dialog_prof.Dialog_prof_Listener, View.OnClickListener{

    public static String user_pref = "user_details";
    boolean IfsharedExist;
    SharedPreferences Pref_usr_details;
    private int which_txt;
    private TextView Usr__current_height ,Usr__current_weight ,Usr__current_age , usr_name, usr_lastname;
    private CardView _prof_height, _prof_weight ,_prof_age, _prof_name, _prof_last;

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        dialog_text_helper.which_activty = 3;




        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);


        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        Intent iii = new Intent(ProfileActivity.this, HomeActivity.class);
                        startActivity(iii);

                        break;
                    case R.id.navigation_Target:
                        Intent ii = new Intent(ProfileActivity.this, TargetActivity.class);
                        startActivity(ii);
                        break;
                    case R.id.navigation_Profile:

                        break;
                        case R.id.navigation_Graph:
                        Intent iiii = new Intent(ProfileActivity.this, Chart_Activity.class);
                        startActivity(iiii);
                        break;
                }
                return false;
            }
        });


        _prof_age = findViewById(R.id.card_prof_age);
        _prof_height = findViewById(R.id.card_prof_height);
        _prof_weight = findViewById(R.id.card_prof_weight);
        _prof_name = findViewById(R.id.card_prof_Name);
        _prof_last = findViewById(R.id.card_prof_lastname);

        _prof_height.setOnClickListener(this);
        _prof_weight.setOnClickListener(this);
        _prof_age.setOnClickListener(this);
        _prof_name.setOnClickListener(this);
        _prof_last.setOnClickListener(this);

        Usr__current_age = findViewById(R.id.usr__current_age);
        Usr__current_height = findViewById(R.id.usr__current_height);
        Usr__current_weight = findViewById(R.id.usr__current_weight);
       usr_name = findViewById(R.id.usr_name);
       usr_lastname = findViewById(R.id.usr_lastname);

        sharedData();

        if(!IfsharedExist){
            Pref_usr_details = getSharedPreferences(user_pref, Context.MODE_PRIVATE);
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
                Intent i = new Intent(ProfileActivity.this, SettingsActivity.class);
                startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View v){


        switch(v.getId()){
            case R.id.card_prof_Name:
                dialog_text_helper.dialog_which_header = 1;
                which_txt = 1;
                openDialog(); break;
            case R.id.card_prof_lastname:
                dialog_text_helper.dialog_which_header = 2;
                which_txt = 2;
                openDialog(); break;
            case R.id.card_prof_age:
                dialog_text_helper.dialog_which_header = 5;
                which_txt = 3;
                openDialog(); break;
            case R.id.card_prof_height:
                dialog_text_helper.dialog_which_header = 3;
                which_txt = 4;
                openDialog(); break;
            case R.id.card_prof_weight:
                dialog_text_helper.dialog_which_header = 4;
                which_txt = 5;
                openDialog(); break;

        }

    }
    public void applyTexts(String data) {

        Pref_usr_details = getSharedPreferences(user_pref,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Pref_usr_details.edit();
        switch (which_txt) {
            case  3:

                editor.putString("age",data);
                Usr__current_age.setText(data);
                editor.apply();break;
            case 4:
                editor.putString("height",data);
                Usr__current_height.setText(data);
                editor.apply();break;
            case 5:
                editor.putString("weight",data);
                Usr__current_weight.setText(data);
                editor.apply();break;
            case  1:
                editor.putString("name",data);
                usr_name.setText(data);
                editor.apply();break;
            case 2:
                editor.putString("last_name",data);
                usr_lastname.setText(data);editor.apply();
                break;
        }

    }
    public void openDialog() {
        Dialog_prof exampleDialog = new Dialog_prof();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    public void sharedWork(){
        SharedPreferences sharedpref = getSharedPreferences("user_details", Context.MODE_PRIVATE);
    }

    public void sharedData(){

        Pref_usr_details = getSharedPreferences(user_pref,Context.MODE_PRIVATE);

        if( Pref_usr_details.contains("name"))
        {IfsharedExist = true;
            String p_name = Pref_usr_details.getString("name", "name");
         usr_name.setText(p_name);}
        if( Pref_usr_details.contains("last_name"))
        {String p_lasnt_name = Pref_usr_details.getString("last_name", "last name");
        usr_lastname.setText(p_lasnt_name);}
        if( Pref_usr_details.contains("age"))
        {String p_age = Pref_usr_details.getString("age","age");
        Usr__current_age.setText(p_age);}
        if( Pref_usr_details.contains("weight"))
        {String p_weight = Pref_usr_details.getString("Weight", "Weight");
        Usr__current_weight.setText(p_weight);}
        if( Pref_usr_details.contains("height"))
        {String p_height = Pref_usr_details.getString("Height","height");
        Usr__current_height.setText(p_height);}



    }
}