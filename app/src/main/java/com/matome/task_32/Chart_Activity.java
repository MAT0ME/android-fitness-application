package com.matome.task_32;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class Chart_Activity extends AppCompatActivity {

    public static String detail_pref = "user_weight_height";
    SharedPreferences pref_cw, pref_ch, pref_tw, pref_th;

    String pref_cw_n = "weight_c" , pref_ch_n ="height_c", pref_tw_n = "weight_t", pref_th_n ="height_t";
    boolean IfsharedExist;
    private LineChart height_chart;
    private LineChart weight_chart;
    TextView h, w, dh, dw;
    Button bt_t_weight, bt_t_height, bt_c_weight, bt_c_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        height_chart = findViewById(R.id.Line_height);
        weight_chart = findViewById(R.id.Line_weight);
       // txt view

        h = findViewById(R.id.graph_height_value);
        w = findViewById(R.id.graph_weight_value);
        dh = findViewById(R.id.graph_height_day);
        dw = findViewById(R.id.graph_weight_day);


        final String  ah,adh,adw, aw;

        ah = h.getText().toString();
        adh = dh.getText().toString();
        adw = dw.getText().toString();
        aw = w.getText().toString();




        //button for current height
        bt_c_height = findViewById(R.id.bt_height_current);
        bt_c_height.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = pref_ch.edit();
                String i = dh.getText().toString();
                int g = 1;

                switch(i){
                    case "1": editor.putString("0",h.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "2": editor.putString("1",h.getText().toString());editor.apply();  Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "3": editor.putString("2",h.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "4": editor.putString("3",h.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "5": editor.putString("4",h.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "6": editor.putString("5",h.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "7": editor.putString("6",h.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;

                }


            }
        });

        //button for target height
        bt_t_height = findViewById(R.id.bt_height_target);
        bt_t_height.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = pref_th.edit();

                String i = dh.getText().toString();

                switch(i){
                    case "1": editor.putString("0",h.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "2": editor.putString("1",h.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "3": editor.putString("2",h.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "4": editor.putString("3",h.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "5": editor.putString("4",h.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "6": editor.putString("5",h.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "7": editor.putString("6",h.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;

                }



            }
        });


        //button for current weight
        bt_c_weight = findViewById(R.id.bt_weight_current);
        bt_c_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = pref_cw.edit();

                String g = dw.getText().toString();

                switch(g){
                    case "1": editor.putString("0",w.getText().toString()); editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "2": editor.putString("1",w.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "3": editor.putString("2",w.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "4": editor.putString("3",w.getText().toString()); editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "5": editor.putString("4",w.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "6": editor.putString("5",w.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;
                    case "7": editor.putString("6",w.getText().toString());editor.apply(); Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                        break;

                }




            }
        });

        //button for target weight
        bt_t_weight = findViewById(R.id.bt_weight_target);
        bt_t_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = pref_tw.edit();

                String g = dw.getText().toString();

                switch (g) {
                    case "1":
                        editor.putString("0", w.getText().toString());
                        editor.apply();
                        Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();

                        break;
                    case "2":
                        editor.putString("1", w.getText().toString());
                        editor.apply();
                        Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();

                        break;
                    case "3":
                        editor.putString("2", w.getText().toString());
                        editor.apply();
                        Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();

                        break;
                    case "4":
                        editor.putString("3", w.getText().toString());
                        editor.apply();
                        Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();

                        break;
                    case "5":
                        editor.putString("4", w.getText().toString());
                        editor.apply();
                        Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();

                        break;
                    case "6":
                        editor.putString("5", w.getText().toString());
                        editor.apply();
                        Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();

                        break;
                    case "7":
                        editor.putString("6", w.getText().toString());
                        editor.apply();
                        Toast.makeText(Chart_Activity.this, "data added", Toast.LENGTH_SHORT).show();

                        break;
                }



            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

      Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);


        Weight_chart_work();
        height_chart_work();


        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        Intent iii = new Intent(Chart_Activity.this, HomeActivity.class);
                        startActivity(iii);

                        break;
                    case R.id.navigation_Target:
                        Intent ii = new Intent(Chart_Activity.this, TargetActivity.class);
                        startActivity(ii);
                        break;
                    case R.id.navigation_Profile:
                        Intent iiii = new Intent(Chart_Activity.this, ProfileActivity.class);
                        startActivity(iiii);
                        break;

                    case R.id.navigation_Graph:

                }
                return false;
            }
        });



        if(!IfsharedExist){

        }else{ pref_cw = getSharedPreferences(pref_cw_n, Context.MODE_PRIVATE);
            pref_ch = getSharedPreferences(pref_ch_n, Context.MODE_PRIVATE);
            pref_tw = getSharedPreferences(pref_tw_n, Context.MODE_PRIVATE);
            pref_th = getSharedPreferences(pref_th_n, Context.MODE_PRIVATE);}

    }

    public void height_chart_work(){

/* {String p_height = Pref_usr_details.getString("Height","height");
        Usr__current_height.setText(p_height);}
        pref_cw = getSharedPreferences(pref_cw_n, Context.MODE_PRIVATE);
            pref_ch = getSharedPreferences(pref_ch_n, Context.MODE_PRIVATE);
            pref_tw = getSharedPreferences(pref_tw_n, Context.MODE_PRIVATE);
            pref_th = getSharedPreferences(pref_th_n, Context.MODE_PRIVATE);

* */

        pref_cw = getSharedPreferences(pref_cw_n, Context.MODE_PRIVATE);
        pref_ch = getSharedPreferences(pref_ch_n, Context.MODE_PRIVATE);
        pref_tw = getSharedPreferences(pref_tw_n, Context.MODE_PRIVATE);
        pref_th = getSharedPreferences(pref_th_n, Context.MODE_PRIVATE);
        Description d = height_chart.getDescription();

        d.setEnabled(true);
        d.setText("Height Chart");

        height_chart.setDrawGridBackground(false);
        height_chart.setAutoScaleMinMaxEnabled(true);

        d.setTextSize(15);
        ArrayList<Entry> c_height = new ArrayList<>();
        ArrayList<Entry> t_height = new ArrayList<>();



        height_chart.setDragEnabled(true);
        height_chart.setScaleEnabled(false);

        final String[] days = new String[]{"Mon", "Tue" ,"Wed","Thur", "Fri", "Sat","Sun"};



      //  pref_ch.getSharedPreferences(pref_ch_n,Context.MODE_PRIVATE);



        String pch_1 = pref_ch.getString("1","4");
        String pch_2 = pref_ch.getString("2","4");
        String pch_3 = pref_ch.getString("3","4");
        String pch_4 = pref_ch.getString("4","4");
        String pch_5 = pref_ch.getString("5","4");
        String pch_6 = pref_ch.getString("6","4");
        String pch_7 = pref_ch.getString("7","4");


        int pch_11 = Integer.parseInt(pch_1);
        int pch_22 = Integer.parseInt(pch_2);
        int pch_33 = Integer.parseInt(pch_3);
        int pch_44 = Integer.parseInt(pch_4);
        int pch_55 = Integer.parseInt(pch_5);
        int pch_66 = Integer.parseInt(pch_6);
        int pch_77 = Integer.parseInt(pch_7);


        try {
            c_height.add(new Entry(0, pch_11));
            c_height.add(new Entry(1, pch_22));
            c_height.add(new Entry(2, pch_33));
            c_height.add(new Entry(3, pch_44));
            c_height.add(new Entry(4, pch_55));
            c_height.add(new Entry(5, pch_66));
            c_height.add(new Entry(6, pch_77));
        }catch(Exception e) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }


        //pref_th.getSharedPreferences(pref_th_n,Context.MODE_PRIVATE);

        String pth_1 = pref_ch.getString("1","4");
        String pth_2 = pref_ch.getString("2","4");
        String pth_3 = pref_ch.getString("3","4");
        String pth_4 = pref_ch.getString("4","4");
        String pth_5 = pref_ch.getString("5","4");
        String pth_6 = pref_ch.getString("6","4");
        String pth_7 = pref_ch.getString("7","4");



        int pth_11 = Integer.parseInt(pth_1);
        int pth_22 = Integer.parseInt(pth_2);
        int pth_33 = Integer.parseInt(pth_3);
        int pth_44 = Integer.parseInt(pth_4);
        int pth_55 = Integer.parseInt(pth_5);
        int pth_66 = Integer.parseInt(pth_6);
        int pth_77 = Integer.parseInt(pth_7);

try{
        t_height.add(new Entry(0, pth_11));
        t_height.add(new Entry(1,pth_22));
        t_height.add(new Entry(2, pth_33));
        t_height.add(new Entry(3, pth_44));
        t_height.add(new Entry(4,  pth_55));
        t_height.add(new Entry(5,  pth_66));
        t_height.add(new Entry(6,  pth_77));
    }catch(Exception e) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }


    LineDataSet c_height_set = new LineDataSet(c_height, "User Height");
        LineDataSet t_height_set = new LineDataSet(t_height, "Target Height");

        c_height_set.setFillAlpha(100);
        c_height_set.setColors(Color.BLACK);



        t_height_set.setFillAlpha(100);
        t_height_set.setColors(Color.GREEN);

        ArrayList<ILineDataSet> dtset = new ArrayList<ILineDataSet>();
        dtset.add(c_height_set);
        dtset.add(t_height_set);


        LineData dt = new LineData(dtset);


        height_chart.setData(dt);
        height_chart.invalidate();

        XAxis xs = height_chart.getXAxis();
        xs.setGranularity(1);
        xs.setValueFormatter(new MyxsFormater(days));



    }
    public void Weight_chart_work(){

        pref_cw = getSharedPreferences(pref_cw_n, Context.MODE_PRIVATE);
        pref_ch = getSharedPreferences(pref_ch_n, Context.MODE_PRIVATE);
        pref_tw = getSharedPreferences(pref_tw_n, Context.MODE_PRIVATE);
        pref_th = getSharedPreferences(pref_th_n, Context.MODE_PRIVATE);

        String pcw_1 = pref_cw.getString("1","1");
        String pcw_2 = pref_cw.getString("2","1");
        String pcw_3 = pref_cw.getString("3","1");
        String pcw_4 = pref_cw.getString("4","4");
        String pcw_5 = pref_cw.getString("5","4");
        String pcw_6 = pref_cw.getString("6","4");
        String pcw_7 = pref_cw.getString("7","4");

        String ptw_1 = pref_tw.getString("1","4");
        String ptw_2 = pref_tw.getString("2","4");
        String ptw_3 = pref_tw.getString("3","4");
        String ptw_4 = pref_tw.getString("4","4");
        String ptw_5 = pref_tw.getString("5","4");
        String ptw_6 = pref_tw.getString("6","4");
        String ptw_7 = pref_tw.getString("7","4");



        Description d = weight_chart.getDescription();

        d.setEnabled(true);
        d.setText("Weight Chart");

        weight_chart.setDrawGridBackground(false);
        weight_chart.setAutoScaleMinMaxEnabled(true);

        d.setTextSize(15);
        ArrayList<Entry> c_weight = new ArrayList<>();
        ArrayList<Entry> t_weight = new ArrayList<>();



        weight_chart.setDragEnabled(true);
        weight_chart.setScaleEnabled(false);

        final String[] days = new String[]{"Mon", "Tue" ,"Wen","Thur", "Fri", "Sat","Sun"};

        int pcw_11 = Integer.valueOf(pcw_1);
        int pcw_22 = Integer.parseInt(pcw_2);
        int pcw_33 = Integer.parseInt(pcw_3);
        int pcw_44 = Integer.parseInt(pcw_4);

        int pcw_55 = Integer.parseInt(pcw_5);

        int pcw_66 = Integer.parseInt(pcw_6);
        int pcw_77 = Integer.parseInt(pcw_7);



        int ptw_11 = Integer.valueOf(ptw_1);
        int ptw_22 = Integer.parseInt(ptw_2);
        int ptw_33 = Integer.parseInt(ptw_3);
        int ptw_44 = Integer.parseInt(ptw_4);

        int ptw_55 = Integer.parseInt(ptw_5);

        int ptw_66 = Integer.parseInt(ptw_6);
        int ptw_77 = Integer.parseInt(ptw_7);




     try{   c_weight.add(new Entry(0, pcw_11));
        c_weight.add(new Entry(1, pcw_22));
        c_weight.add(new Entry(2, pcw_33));
        c_weight.add(new Entry(3, pcw_44));
        c_weight.add(new Entry(4, pcw_55));
        c_weight.add(new Entry(5, pcw_66));
        c_weight.add(new Entry(6, pcw_77));



        t_weight.add(new Entry(0, ptw_11));
        t_weight.add(new Entry(1, ptw_22));
        t_weight.add(new Entry(2, ptw_33));
        t_weight.add(new Entry(3,ptw_44));
        t_weight.add(new Entry(4, ptw_55));
        t_weight.add(new Entry(5, ptw_66));
        t_weight.add(new Entry(6, ptw_77));

    }catch(Exception e) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }


    LineDataSet c_weight_set = new LineDataSet(c_weight, "User Weight");
        LineDataSet t_weight_set = new LineDataSet(t_weight, "Target Weight");

        c_weight_set.setCircleRadius(3f);
        c_weight_set.setCircleHoleRadius(1f);


        c_weight_set.setFillAlpha(100);
        c_weight_set.setColors(Color.BLACK);



        t_weight_set.setFillAlpha(100);
        t_weight_set.setColors(Color.GREEN);

        ArrayList<ILineDataSet> dtset = new ArrayList<ILineDataSet>();
        dtset.add(c_weight_set);
        dtset.add(t_weight_set);


        LineData dt = new LineData(dtset);


        weight_chart.setData(dt);
        XAxis xs = weight_chart.getXAxis();
        xs.setGranularity(1);
        xs.setValueFormatter(new MyxsFormater(days));

    }

    public void saveWeight(){}
    public void saveHeight(){}

public class MyxsFormater implements IAxisValueFormatter{

        private String[] mValues;

        public MyxsFormater(String[] v){
            this.mValues = v;
        }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return mValues[(int) value];
    }
}
}
