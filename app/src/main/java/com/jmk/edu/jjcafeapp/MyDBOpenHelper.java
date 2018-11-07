package com.jmk.edu.jjcafeapp;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDBOpenHelper extends SQLiteOpenHelper {

    private static MyDBOpenHelper INSTANCE;
    private static SQLiteDatabase mDB;


    public static MyDBOpenHelper getInstance(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        if (INSTANCE == null) {
            INSTANCE = new MyDBOpenHelper(context, name, factory, version);
            mDB = INSTANCE.getWritableDatabase();
        }
        return INSTANCE;
    }

    public MyDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE jjcafe_menu (menu_seq integer PRIMARY KEY AUTOINCREMENT not null, menu_name TEXT, cost integer);");
        db.execSQL("INSERT INTO jjcafe_menu VALUES(null,'아메리카노',1000);");
        db.execSQL("INSERT INTO jjcafe_menu VALUES(null,'카페라떼',2000);");
        db.execSQL("INSERT INTO jjcafe_menu VALUES(null,'에그토스트',2500);");
        db.execSQL("INSERT INTO jjcafe_menu VALUES(null,'햄토스트',2500);");
        db.execSQL("INSERT INTO jjcafe_menu VALUES(null,'샌드위치',3000);");
        db.execSQL("INSERT INTO jjcafe_menu VALUES(null,'스콘',1500);");

        db.execSQL("CREATE TABLE jjcafe_ordered_list (ordered_list_seq text not null, ordered_count integer, payed_flag text);");

        db.execSQL("CREATE TABLE jjcafe_tableseat (TABLESEAT_SEQ integer not null);");
        db.execSQL("INSERT INTO jjcafe_tableseat VALUES(1);");
        db.execSQL("INSERT INTO jjcafe_tableseat VALUES(2);");
        db.execSQL("INSERT INTO jjcafe_tableseat VALUES(3);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE jjcafe_menu ;");
        db.execSQL("DROP TABLE jjcafe_ordered_list ;");
        db.execSQL("DROP TABLE jjcafe_tableseat ;");
        onCreate(db);
    }


   /* public void deleteRecord(SQLiteDatabase mdb, String country) {
        mdb.execSQL("DELETE FROM jmk_country WHERE country='" + country + "';");
    }*/


}
