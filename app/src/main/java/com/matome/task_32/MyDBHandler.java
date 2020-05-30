package com.matome.task_32;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "user_records.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TARGET_HEIGHT_TABLE = "target_height";
    public static final String TARGET_WEIGHT_TABLE = "target_weight";

    public static final String COLUMN_DAY = "day";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_HEIGHT = "height";


    public static final String CURRENT_HEIGHT_TABLE = "current_height";
    public static final String CURRENT_WEIGHT_TABLE = "current_height";

    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String TH_table = "CREATE TABLE "+TARGET_HEIGHT_TABLE+"("+COLUMN_DAY +" int ,"+COLUMN_HEIGHT +"int  );";
        String CH_table = "CREATE TABLE "+TARGET_WEIGHT_TABLE+"("+COLUMN_DAY +" int ,"+COLUMN_WEIGHT +"int  );";;
        String TW_table = "CREATE TABLE "+CURRENT_HEIGHT_TABLE+"("+COLUMN_DAY +" int ,"+COLUMN_HEIGHT +"int  );";;
        String CW_table = "CREATE TABLE "+CURRENT_WEIGHT_TABLE+"("+COLUMN_DAY +" int ,"+COLUMN_WEIGHT +"int  );";;

        try {
            db.execSQL(TH_table);
            db.execSQL(CH_table);
            db.execSQL(TW_table);
            db.execSQL(CW_table);
        }catch (Exception e){

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void Insert_Target_height(String d, String v) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_DAY, d);
        cv.put(COLUMN_HEIGHT, v);
        db.insert(TARGET_HEIGHT_TABLE, null, cv);
    }


    public void Insert_current_height(String d, String v){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(COLUMN_DAY, d);
        cv.put(COLUMN_HEIGHT, v);
        db.insert(CURRENT_HEIGHT_TABLE, null, cv);
    }

    public void Insert_current_weight(String d, String v){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(COLUMN_DAY, d);
        cv.put(COLUMN_WEIGHT, v);
        db.insert(CURRENT_WEIGHT_TABLE, null, cv);
    }

    public void Insert_targvet_weight(String d, String v){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(COLUMN_DAY, d);
        cv.put(COLUMN_WEIGHT, v);
        db.insert(TARGET_WEIGHT_TABLE, null, cv);
    }


}
