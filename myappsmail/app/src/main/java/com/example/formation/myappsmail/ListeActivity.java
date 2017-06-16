package com.example.formation.myappsmail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListeActivity extends AppCompatActivity {

    private ListView mListView;
    private String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
            "Yann", "Zoé"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        mListView = (ListView) findViewById(R.id.listView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListeActivity.this,android.R.layout.simple_list_item_1,prenoms);
        mListView.setAdapter(adapter);



    // USE DataBaseHelper

    List<Contact> orders = genererOrders();
    OrderAdapter adapter = new OrderAdapter(ImportActivity.this,0, orders);
        listView.setAdapter(adapter);
}
    private List<Order> genererOrders(){
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        List<Order> orders = dataBaseHelper.getAllOrders();

        Log.d("IMPORT LIST ORDERS",orders.toString() );

        /*List<Order> orders = new ArrayList<Order>();

        orders.add(new Order("4", "3","2", "1", "5"));
        orders.add(new Order("9", "9","9", "9", "774"));
        orders.add(new Order("2", "0","3", "1", "5"));*/

        return orders;
    }
}
