package com.example.robert.imei;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import android.app.Activity;
import android.app.ListActivity;
import android.widget.TextView;
import android.widget.Toast;


public class List extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.robert.IMEI.MESSAGE";

    private ListView mainListView0 ;
    private ArrayAdapter<String> listAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Find the ListView resource.
        mainListView0 = (ListView) findViewById( R.id.mainListView );

        // Create and populate a List of planet names.
        String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars", "Jupiter"};
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll(Arrays.asList(planets));

        // Create ArrayAdapter using the planet list.

        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);

        listAdapter.add( "Ceres" );
        listAdapter.add( "Pluto" );
        listAdapter.add("Haumea");
        listAdapter.add("Makemake");
        listAdapter.add( "Eris" );
        listAdapter.add( "Conny" );
        listAdapter.add( "Eric" );
        listAdapter.add( "Micha" );
        listAdapter.add( "Maik" );
        listAdapter.add( "Bernd" );
        listAdapter.add( "Rolf" );
        listAdapter.add( "Gudrun" );
        listAdapter.add( "Johanna" );
        listAdapter.add( "Kevin" );

        listAdapter.add( "Flori" );

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView0.setAdapter( listAdapter );

        mainListView0.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
                        .show();
                StartIntent(parent.getItemAtPosition(position).toString());

            }
        });
    }

    public void StartIntent(String rowcontent)
    {
        Intent intent = new Intent(this, ListRow.class);
        //TextView imei = (TextView) findViewById(R.id.rec_imei);
        //String message = imei.getText().toString();
        //String message =
        String message = rowcontent;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
//    protected void onListItemClick(ListView l, View v, int position, long id) {
//        Context context = getApplicationContext();
//        //CharSequence text = Integer.toString(position);
//        CharSequence text = "pushed";
//        int duration = Toast.LENGTH_SHORT;
//        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
