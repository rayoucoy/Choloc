package com.skripsi.yudha.choloc;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends ActionBarActivity implements LocationListener {
    // Session Management Class
    SessionManagement session;

    Button ceklokasi, cekdekat;
    public String kode="kode", KEY1 = "key1", KEY2 = "key2", KEY3 = "key3", KEY4 = "key4", LAT1 = "1", LAT2 = "2", LAT3 = "3", LAT4 = "4", LONG1 = "11", LONG2 = "22", LONG3 = "33", LONG4 = "44", CURLAT = "111", CURLONG = "222";
    public static String satu, dua, tiga, empat, lat1, lat2, lat3, lat4, long1, long2, long3, long4;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    String provider;
//    public static String curlat = "-6.973981", curlong = "107.6293685";
    public static String curlat = "-6.247149", curlong = "106.815172";
    protected boolean gps_enabled, network_enabled;

    @Override
    public void onLocationChanged(Location location) {
        // TODO Auto-generated method stub
        curlat = String.valueOf(location.getLatitude());
        curlong = String.valueOf(location.getLongitude());
    }

    // Disable back button
    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Session class instance
        session = new SessionManagement(getApplicationContext());
        session.checkLogin();

        ceklokasi = (Button) findViewById(R.id.ceklokasi);
        cekdekat = (Button) findViewById(R.id.cekdekat);

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
                Intent in = new Intent(getApplicationContext(), MapsActivity2.class);
                in.putExtra(kode, "ALL");
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
            Toast.makeText(HomeActivity.this, message, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(HomeActivity.this, "Lokasi tidak terdeteksi", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub

    }





}
