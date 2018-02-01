package com.example.mizmer2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kullanıcı on 25.01.2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";
    //private static final int COLUMN_TYPE = 0;

    SQLiteDatabase sqLiteDatabase;

    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null , " +
            "name text not null , email text not null , uname text not null);";

    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(TABLE_CREATE);
        this.sqLiteDatabase = sqLiteDatabase;
    }

    public void insertContact(Contact contact){
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        int count = cursor.getCount();


        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, contact.getName());
        values.put(COLUMN_EMAIL, contact.getEmail());
        values.put(COLUMN_UNAME, contact.getUname());
        values.put(COLUMN_PASS, contact.getPass());

        sqLiteDatabase.insert(TABLE_NAME, null, values);
        sqLiteDatabase.close();

    }

//    public void setColumnType(Contact contact){
//        sqLiteDatabase = this.getWritableDatabase();
//        ContentValues val = new ContentValues();
//
//        String query = "select * from contacts";
//        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
//        int counter = cursor.getCount();
//
//        val.put(String.valueOf(COLUMN_TYPE), contact.getType());
//
//        sqLiteDatabase.insert(TABLE_NAME,null, val );
//        sqLiteDatabase.close();
//
//    }
//    public void getColumnType(){
//        sqLiteDatabase = this.getReadableDatabase();
//        String query = "select type from " + TABLE_NAME;
//        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
//
//
//        int a = 0;
//        if (cursor.moveToFirst()){
//            a = cursor.getInt(0);
//        }
//    }

    public String searchPass(String uname){
        sqLiteDatabase = this.getReadableDatabase();
        String query = "select uname, pass from "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);


        String a, b;
        b = "not found";
        if (cursor.moveToFirst()){
            do {
                a = cursor.getString(0);
                if (a.equals(uname)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String query = "DROP TABLE IF EXISTS"+TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        this.onCreate(sqLiteDatabase);

    }
}
