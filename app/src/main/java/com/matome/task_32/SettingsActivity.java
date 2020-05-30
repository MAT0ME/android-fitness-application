package com.matome.task_32;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {


    String current_system_type;
    Button b1;
    boolean IfsharedExist;
    SharedPreferences Pref_usr_details;

    RadioButton rbIm, rbMa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Old_sys();

        rbIm = findViewById(R.id.rbImperial);
        rbMa = findViewById(R.id.rbMetric);
        b1 = findViewById(R.id.sett_button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                apply_sys();
                New_sys();

                if(Old_sys().equals(New_sys())){
                    Toast.makeText(SettingsActivity.this, "system type already active", Toast.LENGTH_SHORT).show();
                }
                else{ calculations();Toast.makeText(SettingsActivity.this, "Settings Applied", Toast.LENGTH_SHORT).show();}

            }
        });
    }



    public void apply_sys(){

        Pref_usr_details = getSharedPreferences(ProfileActivity.user_pref,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Pref_usr_details.edit();

        if (rbIm.isSelected()){
            editor.putString("system_type","imperial");
            editor.apply();
        }else if(rbMa.isSelected()){
            editor.putString("system_type","metric");
            editor.apply();
        }
    }

    public String which_sys(){

        Pref_usr_details = getSharedPreferences(ProfileActivity.user_pref, Context.MODE_PRIVATE);


        String sys_type = Pref_usr_details.getString("system_type","metric");

        assert sys_type != null;
        if(sys_type.equals("imperial")){
            current_system_type = "imperial";
        }
        else if(sys_type.equals("metric")){
            current_system_type = "metric";
        }

        return sys_type;

    }

    public void toImp(){
        Pref_usr_details = getSharedPreferences(ProfileActivity.user_pref,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Pref_usr_details.edit();
        editor.putString("target_height","imperial");
        editor.putString("target_weight","imperial");
        editor.putString("weight","imperial");
        editor.putString("height","imperial");
        editor.apply();

    }
    public void toMet(){
        Pref_usr_details = getSharedPreferences(ProfileActivity.user_pref,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Pref_usr_details.edit();
        editor.putString("target_height","imperial");
        editor.putString("target_weight","imperial");
        editor.putString("weight","imperial");
        editor.putString("height","imperial");
        editor.apply();
    }

    public  void calculations(){
        Pref_usr_details = getSharedPreferences(ProfileActivity.user_pref, Context.MODE_PRIVATE);
        String target_height= Pref_usr_details.getString("target_height","0");
        String target_weight = Pref_usr_details.getString("target_weight","0");
        String height = Pref_usr_details.getString("height","0");
        String weight = Pref_usr_details.getString("weight","0");



        double d_target_height = Double.parseDouble(target_height);
        double d_target_weight = Double.parseDouble(target_weight);
        double d_height = Double.parseDouble(height);
        double d_weight = Double.parseDouble(weight);

        if(which_sys().equals("metric"))
        {
            Pref_usr_details = getSharedPreferences(ProfileActivity.user_pref,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = Pref_usr_details.edit();


            editor.putString("target_height", Double.toString(system_type.foot_to_cm(d_target_height)));
            editor.putString("target_weight",Double.toString(system_type.foot_to_cm(d_target_weight)));
            editor.putString("weight",Double.toString(system_type.pounce_to_kg(d_weight)));
            editor.putString("height",Double.toString( system_type.pounce_to_kg(d_height)));
            editor.apply();
        }
        else if(which_sys().equals("imperial"))
        {
            Pref_usr_details = getSharedPreferences(ProfileActivity.user_pref,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = Pref_usr_details.edit();


            editor.putString("target_height", Double.toString(system_type.cm_to_foot(d_target_height)));
            editor.putString("target_weight",Double.toString(system_type.cm_to_foot(d_target_weight)));
            editor.putString("weight",Double.toString(system_type.kg_to_pounce(d_weight)));
            editor.putString("height",Double.toString( system_type.kg_to_pounce(d_height)));
            editor.apply();

        }



    }

    public String Old_sys(){
        Pref_usr_details = getSharedPreferences(ProfileActivity.user_pref, Context.MODE_PRIVATE);
        String sys = Pref_usr_details.getString("system_type", "metric");
        return sys;
    }

    public String New_sys(){
        Pref_usr_details = getSharedPreferences(ProfileActivity.user_pref, Context.MODE_PRIVATE);
        String sys = Pref_usr_details.getString("system_type", "metric");
        return sys;
    }


}
