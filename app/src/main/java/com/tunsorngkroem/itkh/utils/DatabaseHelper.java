package com.tunsorngkroem.itkh.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME= "listen.sqlite";
    public static final String DBLOCATION="/data/data/com.tunsorngkroem.itkh/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context){
        super(context,DBNAME,null,1);
        this.mContext=context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void openDatabase(){
        String dbPath=mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase!=null && mDatabase.isOpen()){
            return;
        }
        mDatabase=SQLiteDatabase.openDatabase(dbPath,null,SQLiteDatabase.OPEN_READWRITE);
    }
    public void closeDatabase(){
        if(mDatabase !=null){
            mDatabase.close();
        }
    }

    public List<ListenModel> getListWord(String wordSearch){
        ListenModel listenModel =null;
        List<ListenModel> listenModelList =new ArrayList<>();
        openDatabase();
        String[] args={"%"+wordSearch+"%"};

        Cursor cursor=mDatabase.rawQuery("Select * From tblWord Where word Like ?",args);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            listenModel =new ListenModel(cursor.getString(0),cursor.getString(1),cursor.getString(2));
            listenModelList.add(listenModel);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listenModelList;
    }

}

