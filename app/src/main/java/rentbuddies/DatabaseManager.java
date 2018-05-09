package com.example.dombalj.rentbuddies;

/**
 * Created by dombalj on 3/15/18.
 */



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "recordsDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_RECORDS = "records";
    private static final String ID = "id";
    private static final String DATE = "date";
    private static final String AMOUNT = "amount";


    public DatabaseManager( Context context ) {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // build sql create statement
        String sqlCreate = "create table " + TABLE_RECORDS + "( " + ID;
        sqlCreate += " integer primary key autoincrement, " + DATE;
        sqlCreate += " text, " + AMOUNT + " real )" ;

        db.execSQL( sqlCreate );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop old table if it exists
        db.execSQL( "drop table if exists " + TABLE_RECORDS );
        // Re-create tables
        onCreate( db );

    }


    public void insert( Record rec ) {
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlInsert = "insert into " + TABLE_RECORDS;
        sqlInsert += " values( null, '" + rec.getDate( );
        sqlInsert += "', '" + rec.getAmount( ) + "' )";

        db.execSQL( sqlInsert );
        db.close( );
    }

    public void deleteById( int id ) {
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlDelete = "delete from " + TABLE_RECORDS;
        sqlDelete += " where " + ID + " = " + id;

        db.execSQL( sqlDelete );
        db.close( );
    }


    public void updateById( int id, String date, double price ) {
        SQLiteDatabase db = this.getWritableDatabase();

        String sqlUpdate = "update " + TABLE_RECORDS;
        sqlUpdate += " set " + DATE + " = '" + date + "', ";
        sqlUpdate += AMOUNT + " = '" + price + "'";
        sqlUpdate += " where " + ID + " = " + id;

        db.execSQL( sqlUpdate );
        db.close( );
    }


    public ArrayList<Record> selectAll( ) {
        String sqlQuery = "select * from " + TABLE_RECORDS;

        SQLiteDatabase db = this.getWritableDatabase( );
        Cursor cursor = db.rawQuery( sqlQuery, null );

        ArrayList<Record> records = new ArrayList<Record>( );
        while( cursor.moveToNext( ) ) {
            Record currentRecord
                    = new Record( Integer.parseInt( cursor.getString( 0 ) ),
                    cursor.getString( 1 ), cursor.getDouble( 2 ) );
            records.add( currentRecord );
        }
        db.close( );
        cursor.close();

        return records;
    }


    public Record selectById( int id ) {
        String sqlQuery = "select * from " + TABLE_RECORDS;
        sqlQuery += " where " + ID + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase( );
        Cursor cursor = db.rawQuery( sqlQuery, null );

        Record record = null;
        if( cursor.moveToFirst( ) )
            record = new Record( Integer.parseInt( cursor.getString( 0 ) ),
                    cursor.getString( 1 ), cursor.getDouble( 2 ) );
        db.close( );
        cursor.close();

        return record;
    }





















}
