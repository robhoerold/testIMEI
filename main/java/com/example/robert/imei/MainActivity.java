package com.example.robert.imei;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.telephony.TelephonyManager;
import android.content.Context;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.robert.IMEI.MESSAGE";

    public void sendMessage(View view)
    {
        Context context = getApplicationContext();
        CharSequence text = "Delivered IMEI";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Intent intent = new Intent(this, Act2.class);
        TextView imei = (TextView) findViewById(R.id.imeiid);
        String message = imei.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void showIMEI()
    {
        TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String device_id = tm.getDeviceId();

        TextView selection = (TextView) findViewById(R.id.imeiid);
        selection.setText(device_id);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showIMEI();

        final TextView view = (TextView) findViewById(R.id.hwid);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Pushed Hello_World";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
