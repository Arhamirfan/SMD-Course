package com.example.smd_aftermid.SQLiteExample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DbTools extends SQLiteOpenHelper {


    public DbTools(@Nullable Context context) {
        super(context,"ContactsDB",null,1);
        Log.d("TAG", "Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE CONTACTS("+"_id INTEGER PRIMARY KEY AUTOINCREMENT,"+"firstName TEXT,"+"secondName TEXT,"+"phoneNumber TEXT,"+"emailAddress TEXT,"+
                "homeAddress TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void AddContact(HashMap<String, String> contact)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id",contact.get("_id"));
        contentValues.put("firstName",contact.get("firstName"));
        contentValues.put("secondName",contact.get("secondName"));
        contentValues.put("phoneNumber",contact.get("phoneNumber"));
        contentValues.put("emailAddress",contact.get("emailAddress"));
        contentValues.put("homeAddress",contact.get("homeAddress"));
        long i = db.insert("CONTACTS",null,contentValues);
        if(i!=-1) {
            Log.d("TAG", "New Contact inserted with id = " + i);
        }else
        {
            Log.d("TAG", "Insertion Failed");
        }
        db.close();
    }

    public ArrayList<HashMap<String,String>> getAllContacts()
    {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<HashMap<String,String>> contactlist = new ArrayList<HashMap<String, String>>();
        String query = "SELECT * FROM CONTACTS ORDER BY _id DESC";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do {
                HashMap<String,String> contact = new HashMap<String, String>();
                contact.put("_id",cursor.getString(0));
                contact.put("firstName",cursor.getString(1));
                contact.put("secondName",cursor.getString(2));
                contact.put("phoneNumber",cursor.getString(3));
                contact.put("emailAddress",cursor.getString(4));
                contact.put("homeAddress",cursor.getString(5));
                contactlist.add(contact);
            }while (cursor.moveToNext());

        }
        return contactlist;
    }

    public  HashMap<String,String> getSingleRecord(String id)
    {
        SQLiteDatabase db = getReadableDatabase();
        HashMap<String,String> singlerecord = new HashMap<String, String>();
        String query = "SELECT * FROM CONTACTS WHERE _id ="+id;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            singlerecord.put("_id",cursor.getString(0));
            singlerecord.put("firstName",cursor.getString(1));
            singlerecord.put("secondName",cursor.getString(2));
            singlerecord.put("phoneNumber",cursor.getString(3));
            singlerecord.put("emailAddress",cursor.getString(4));
            singlerecord.put("homeAddress",cursor.getString(5));
        }
        return singlerecord;
    }

    public boolean UpdateContact(HashMap<String, String> contact, String id)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id",contact.get("_id"));
        contentValues.put("firstName",contact.get("firstName"));
        contentValues.put("secondName",contact.get("secondName"));
        contentValues.put("phoneNumber",contact.get("phoneNumber"));
        contentValues.put("emailAddress",contact.get("emailAddress"));
        contentValues.put("homeAddress",contact.get("homeAddress"));
        Integer ID = Integer.valueOf(id);
        String query = "Select * From CONTACTS Where _id="+ID;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.getCount() > 0)
        {
            long result = db.update("CONTACTS",contentValues,"_id="+ID,null);
            if(result == -1)
            {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    public boolean DeleteContact(String id) {
        Integer ID = Integer.valueOf(id);
        SQLiteDatabase db = getWritableDatabase();
        String query = "Select * From CONTACTS Where _id="+ID;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.getCount() > 0)
        {
            long result = db.delete("CONTACTS","_id="+ID,null);
            if(result == -1)
            {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }
}
