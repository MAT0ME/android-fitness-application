package com.matome.task_32;

import android.content.Context;
import android.content.SharedPreferences;

public class system_type {


    public static String current_system_type;

    public static String Dialog_heading, weight_type = "", height_type = "";
    public static String Dialog_datatype;

    public static String Current_type;

    public float weight, height, target_weight, target_height;

    public static double cm_to_foot(double w){

        double ww = w / 30.48;
        return ww;
    }

    public static double foot_to_cm(double f){

        double ff = 30.48 * f;
        return ff;


    }

    public static   double pounce_to_kg(double p){

        double pp = p *  0.45359237;
        return pp;
    }

    public  static double kg_to_pounce(double p){

        double pp = p / 0.45359237;
        return pp;

    }

    public static void setImp(){ weight_type = "lb"; height_type = "ft";}
    public static void setMet(){ weight_type = "kg"; height_type = "cm";}


}
