package com.digitalmirko.wifionoffswitch;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Wifi Manager
    WifiManager wifiManager;
    // WiFi status text
    TextView wifiStatusTextView;
    //Wifi Switch
    Switch wifiSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Defining Variables
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiStatusTextView = (TextView) findViewById(R.id.wifi_status_text_view);
        wifiSwitch = (Switch) findViewById(R.id.wifi_switch);

        /* Checking wifi state
         * If wifi is enabled, display "wifi is on" and set toggle button to on position
         * If wifi is disabled, display "wifi is off" and set toggle button to off position.
         */
        if (wifiManager.isWifiEnabled()){
            wifiStatusTextView.setText("Wifi is currently ON");
            wifiSwitch.setChecked(true);
        } else {
            wifiStatusTextView.setText("Wifi is currently OFF");
            wifiSwitch.setChecked (false);
        }

        /* Adds listener to toggle button
         * If toggle is checked, wifi is enables and "wifi is currently ON" is displayed
         * If toggle is unchecked, wifi is enabled and "Wi fi is currently OFF is displayed
         */
        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wifiManager.setWifiEnabled(true);
                    wifiStatusTextView.setText("Wifi is currently ON");
                    Toast.makeText(MainActivity.this,"Wifi may take a moment to turn on", Toast.LENGTH_LONG).show();
                } else {
                    wifiManager.setWifiEnabled(false);
                    wifiStatusTextView.setText("Wifi is currently OFF");
                }
            }
        });

    }
}