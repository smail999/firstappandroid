package com.example.formation.myappsmail;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DATABSE_VERSION = 1;
    private static final String DATABASE_NAME = "cheapCoffee";
    private static final String TABLE_ORDERS = "orders";
    private static final String KEY_ID = "id";
    private static final String KEY_NBCOFFEE = "nb_coffee";
    private static final String KEY_NBCOFFEECHANTILLY = "nb_coffee_chantilly";
    private static final String KEY_NBCHOCOLATE = "nb_chocolate";
    private static final String KEY_NBCHOCOLATECHANTILLY = "nb_chocolate_chantilly";
    private static final String KEY_PRICETOTAL = "price_total";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_ORDERS = "CREATE TABLE " + TABLE_ORDERS + "( "
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NBCOFFEE + " TEXT,"
                + KEY_NBCOFFEECHANTILLY + " TEXT,"
                + KEY_NBCHOCOLATE + " TEXT,"
                + KEY_NBCHOCOLATECHANTILLY + " TEXT,"
                + KEY_PRICETOTAL + " TEXT" + " )";

        db.execSQL(CREATE_TABLE_ORDERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);

        onCreate(db);
    }

    void addOrder(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("ADD ORDER",contact.toString() );
        ContentValues values = new ContentValues();
        values.put(KEY_NBCOFFEE, contact.getQuantitiesCoffees());
        values.put(KEY_NBCOFFEECHANTILLY, contact.getQuantitiesChantillyCoffees());
        values.put(KEY_NBCHOCOLATE, contact.getQuantitiesChocolates());
        values.put(KEY_NBCHOCOLATECHANTILLY, contact.getQuantitiesChantillyChocolates());
        values.put(KEY_PRICETOTAL, contact.getTotal());
        Log.d("ADD VALUES ORDER",values.toString() );
        db.insert(TABLE_ORDERS, null, values);
        db.close();
    }

    Contact getContact(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ORDERS, new String[]
                        {KEY_ID,
                                KEY_NBCOFFEE,
                                KEY_NBCOFFEECHANTILLY,
                                KEY_NBCHOCOLATE,
                                KEY_NBCHOCOLATECHANTILLY,
                                KEY_PRICETOTAL},
                KEY_ID + "=?", new String[]{String.valueOf(id)},null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5));

        return contact;
    }

    public List<Contact> getAllContact(){
        List<Contact> contactList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_ORDERS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        Log.d("Count ALL CURSOR ORDER", ""+cursor.getCount() );
        if(cursor.moveToFirst()){
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setQuantitiesCoffees(cursor.getString(1));
                contact.setQuantitiesChantillyCoffees(cursor.getString(2));
                contact.setQuantitiesChocolates(cursor.getString(3));
                contact.setQuantitiesChantillyChocolates(cursor.getString(4));
                contact.setTotal(cursor.getString(5));
                contactList.add(contact);
            }while (cursor.moveToNext());
        }

        return contactList;
    }

    public int updateOrder(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NBCOFFEE, contact.getQuantitiesCoffees());
        values.put(KEY_NBCOFFEECHANTILLY, contact.getQuantitiesChantillyCoffees());
        values.put(KEY_NBCHOCOLATE, contact.getQuantitiesChocolates());
        values.put(KEY_NBCHOCOLATECHANTILLY, contact.getQuantitiesChantillyChocolates());
        values.put(KEY_PRICETOTAL, contact.getTotal());

        return db.update(TABLE_ORDERS, values, KEY_ID + "=?",
                new String[]{String.valueOf(contact.getId())});
    }

    public void delteOrder(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_ORDERS, KEY_ID + "=?",
                new String[]{String.valueOf(contact.getId())});
        db.close();
    }

    public int getNumberContact(){
        int countNumberOrders = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT * FROM " + TABLE_ORDERS;

        Cursor cursor = db.rawQuery(countQuery, null);
        countNumberOrders =  cursor.getCount();
        db.close();
        return countNumberOrders;
    }
}
