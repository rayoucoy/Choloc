package com.skripsi.yudha.choloc;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * Created by yudha on 29/05/16.
 */
public class MapsActivity2 extends ActionBarActivity implements LocationListener{
    Button ceklokasi, cekdekat;
    public String kode="kode", KEY1 = "key1", KEY2 = "key2", KEY3 = "key3", KEY4 = "key4", LAT1 = "1", LAT2 = "2", LAT3 = "3", LAT4 = "4", LONG1 = "11", LONG2 = "22", LONG3 = "33", LONG4 = "44", CURLAT = "111", CURLONG = "222";
    public static String satu, dua, tiga, empat, lat1, lat2, lat3, lat4, long1, long2, long3, long4;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    String provider;
    public static String curlat = "-6.973981", curlong = "107.6293685";
    protected boolean gps_enabled, network_enabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        ceklokasi = (Button) findViewById(R.id.ceklokasi);
        cekdekat=(Button) findViewById(R.id.cekdekat);

        ceklokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCurrentLocation();
            }
        });
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

        cekdekat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), MapsLoc.class);
                in.putExtra(kode,"ALL");
                in.putExtra(CURLAT, curlat);
                in.putExtra(CURLONG, curlong);
                startActivity(in);
            }
        });
    }

    private void showCurrentLocation() {

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location != null) {
            String message = String.format(
                    "Current Location \n Longitude: %1$s \n Latitude: %2$s",
                    location.getLongitude(), location.getLatitude());
            curlat=String.valueOf(location.getLatitude());
            curlong=String.valueOf(location.getLongitude());
            Toast.makeText(MapsActivity2.this, message, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MapsActivity2.this, "Lokasi tidak terdeteksi", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
