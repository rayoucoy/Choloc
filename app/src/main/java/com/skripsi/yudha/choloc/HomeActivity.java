package com.skripsi.yudha.choloc;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class HomeActivity extends ActionBarActivity implements LocationListener {
    // Session Management Class
    static SessionManagement session;

    Button ceklokasi, cekdekat;
    ImageButton chatlistbutton, friendlistbutton, mapsbutton;
    public String kode="kode", CURLAT = "111", CURLONG = "222";
    protected LocationManager locationManager;
    protected Context context;
    public static String curlat = "-6.973981", curlong = "107.6293685";

    //
    private RequestQueue mRequestQueue;
    public static final String TAG = HomeActivity.class.getSimpleName();
    private static HomeActivity mInst;

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
        chatlistbutton = (ImageButton) findViewById(R.id.chatlist_button);
        friendlistbutton = (ImageButton) findViewById(R.id.friendlist_button);
        mapsbutton = (ImageButton) findViewById(R.id.maps_button);

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

        ImageButton imageButtonChatlist = (ImageButton)findViewById(R.id.chatlist_button);
        imageButtonChatlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Berpindah ke menu Chatlist", Toast.LENGTH_SHORT).show();
                Intent a;
                a = new Intent(HomeActivity.this, com.skripsi.yudha.choloc.activity.MainActivity.class);
                startActivity(a);
            }
        });

        ImageButton imageButtonMaps = (ImageButton)findViewById(R.id.maps_button);
        imageButtonMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Berpindah ke menu Maps", Toast.LENGTH_SHORT).show();
                Intent i;
                i = new Intent(HomeActivity.this,MapsActivity.class);
                startActivity(i);
            }
        });
        mInst = this;
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

    public static HomeActivity getInstance(){
        return mInst;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public static SessionManagement getSession(){
        return session;
    }

}