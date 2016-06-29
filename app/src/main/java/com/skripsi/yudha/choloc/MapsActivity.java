package com.skripsi.yudha.choloc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.skripsi.yudha.choloc.activity.ChatRoomActivity;
import com.skripsi.yudha.choloc.activity.MainActivity;
import com.skripsi.yudha.choloc.app.EndPoints;
import com.skripsi.yudha.choloc.model.ChatRoom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.skripsi.yudha.choloc.model.ObjekWisata;

/**
 * Created by affan on 03/06/16.
 */
public class MapsActivity extends FragmentActivity implements LocationListener {

	//jarak max
	private static double MaxJarak = 5.0; //5KM or less
    protected LocationManager locationManager;
    private double curlat,curlong;

    private static LatLng CURRENT= new LatLng(-7.048015,110.441016);
    public static String KEY1="key1",KEY2="key2",KEY3="key3",KEY4="key4",lat1="1", lat2="2",lat3="3",lat4="4",long1="11",long2="22",long3="33",long4="44",CURLAT="111",CURLONG="222";
    public static String latsek,longsek,lokasi1,lokasi2,lokasi3,lokasi4,lokasi5,lokasi6,lokasi7,lokasi8,lokasi9,lokasi10,
            lokasi11,lokasi12,lokasi13,lokasi14,lokasi15,lokasi16,lokasi17,lokasi18,lokasi19,lokasi20,
            lokasi21,lokasi22,lokasi23,lokasi24,lokasi25,lokasi26,lokasi27,lokasi28,
            lati1,lati2,lati3,lati4,longi1,longi2,longi3,longi4;

    GoogleMap googleMap;
    final String TAG = "PathGoogleMapActivity";
    SessionManagement session;

    private ArrayList<ObjekWisata> objlist;
    private MarkerOptions currentMarker;
	
	public static double distanceInKM(LatLng c1, LatLng c2) {
		int R = 6371; // Radius of the earth in km
		  
		double lat1 = c1.latitude;
		double lat2 = c2.latitude;
		  
		double lon1 = c1.longitude;
		double lon2 = c2.longitude;
		  
		double dLat = deg2rad(lat2-lat1); 
		double dLon = deg2rad(lon2-lon1);
		  
		double a = 
		Math.sin(dLat/2) * Math.sin(dLat/2) +
		Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
		Math.sin(dLon/2) * Math.sin(dLon/2); 
		  
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		double d = R * c; // Distance in km
		return d;
	}

	public static double deg2rad(double deg) {
		return deg * (Math.PI/180);
	}

    @Override
    public void onLocationChanged(Location location) {
        // TODO Auto-generated method stub
        curlat = location.getLatitude();
        curlong = location.getLongitude();
        CURRENT = new LatLng(curlat,curlong);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CURRENT, 13));
        currentMarker.position(CURRENT);
        currentMarker.title("Current Location "+CURRENT.toString());
    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maplayout);
        session = new SessionManagement(getApplicationContext());
        session.checkLogin();
        SupportMapFragment fm = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.maps);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria crit = new Criteria();
        String bestLocSer = locationManager.getBestProvider(crit,false);

        locationManager.requestLocationUpdates(bestLocSer, 0, 0, this);

        //Location location = locationManager.getLastKnownLocation(bestLocSer);
        //CURRENT = new LatLng(location.getLatitude(),location.getLongitude());

        objlist = new ArrayList<>();
        currentMarker = new MarkerOptions().position(CURRENT).title("Current Location "+CURRENT.toString())
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

        googleMap = fm.getMap();
        loadResources();

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CURRENT, 13));
        addMarkers();



        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                for(ObjekWisata w: objlist){
                    if(marker.getTitle().equalsIgnoreCase(w.getName())){
                        LatLng locall = new LatLng(w.getLat(),w.getLng());
                        if(distanceInKM(CURRENT,locall) <= MaxJarak){
                            i.putExtra("value",w.getId());
                            startActivity(i);
                        } else {
                            Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });

    }

    private String getMapsApiDirectionsUrl() {
        //String url = "https://maps.googleapis.com/maps/api/directions/json?origin="+latsek+","+longsek+"&destination="+lati4+","+longi4+"&waypoints=optimize:true|"+lati1+","+longi1+"|"+lati2+","+longi2+"|"+lati3+","+longi3+"|"+lati4+","+longi4+"&sensor=false&key=AIzaSyBw7PQkQlqYryvdFF1PaTP6POI9QX2kB8Q";
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin="+latsek+","+longsek+"&destination="+lati2+","+longi2+"&waypoints=optimize:true|" + lati4 + "," + longi4 + "|" + lati3 + "," + longi3 + "|" + lati1 + "," + longi1 + "&sensor=false&key=AIzaSyBw7PQkQlqYryvdFF1PaTP6POI9QX2kB8Q";
        Log.e(TAG, url);
        return url;
    }

    private void loadResources() {
        StringRequest strReq = new StringRequest(Request.Method.GET,
                EndPoints.OBJEK_WISATA, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e(TAG, "response: " + response);

                try {
                    JSONObject obj = new JSONObject(response);
                    //MarkerOptions options = new MarkerOptions();
                    // check for error flag
                    if (obj.getBoolean("error") == false) {
                        JSONArray chatRoomsArray = obj.getJSONArray("chat_rooms");
                        for (int i = 0; i < chatRoomsArray.length(); i++) {
                            JSONObject chatRoomsObj = (JSONObject) chatRoomsArray.get(i);
                            ObjekWisata cr = new ObjekWisata();

                            cr.setId(chatRoomsObj.getString("chat_room_id"));
                            cr.setName(chatRoomsObj.getString("username"));
                            cr.setLat(Double.parseDouble(chatRoomsObj.getString("lat")));
                            cr.setLng(Double.parseDouble(chatRoomsObj.getString("lng")));
                            cr.setLastMessage("");
                            cr.setUnreadCount(0);
                            cr.setTimestamp(chatRoomsObj.getString("created_at"));

                            Log.d("chat_room_id",cr.getId());
                            objlist.add(cr);
                            //options.position(new LatLng(cr.getLat(),cr.getLng()));
                        }
                        addMarkers();
                    } else {
                        // error in fetching chat rooms
                        Toast.makeText(getApplicationContext(), "" + obj.getJSONObject("error").getString("message"), Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    Log.e(TAG, "json parsing error: " + e.getMessage());
                    Toast.makeText(getApplicationContext(), "Json parse error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

                //mAdapter.notifyDataSetChanged();

                // subscribing to all chat room topics
                //subscribeToAllTopics();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse networkResponse = error.networkResponse;
                Log.e(TAG, "Volley error: " + error.getMessage() + ", code: " + networkResponse);
                Toast.makeText(getApplicationContext(), "Volley error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //Adding request to request queue
        HomeActivity.getInstance().addToRequestQueue(strReq);
    }

    private void addMarkers() {
        if (googleMap != null) {
            googleMap.addMarker(currentMarker);
            for(ObjekWisata w: objlist){
                googleMap.addMarker(new MarkerOptions().position(new LatLng(w.getLat(), w.getLng())).title(w.getName()));
            }
        }
    }
}