package com.skripsi.yudha.choloc;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yudha on 29/05/16.
 */
public class MapsLoc extends FragmentActivity {

    private static LatLng LAT1= new LatLng(-7.1661110,107.4022220);
    private static LatLng LAT2= new LatLng(-7.1669440,107.3580560);
    private static LatLng LAT3= new LatLng(-6.9259410,107.6361910);
    private static LatLng LAT4= new LatLng(-6.8999250,107.6229660);
    private static LatLng CURRENT= new LatLng(-6.973981, 107.6293685);
    public static String KEY1="key1",KEY2="key2",KEY3="key3",KEY4="key4",lat1="1", lat2="2",lat3="3",lat4="4",long1="11",long2="22",long3="33",long4="44",CURLAT="111",CURLONG="222";
    public static String latsek,longsek,lokasi1,lokasi2,lokasi3,lokasi4,lati1,lati2,lati3,lati4,longi1,longi2,longi3,longi4;
    GoogleMap googleMap;
    final String TAG = "PathGoogleMapActivity";

    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);
        setContentView(R.layout.maplayout);
        SupportMapFragment fm = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        Intent i=getIntent();
        lokasi1=i.getStringExtra(KEY1);
        lokasi2=i.getStringExtra(KEY2);
        lokasi3=i.getStringExtra(KEY3);
        lokasi4=i.getStringExtra(KEY4);
        lati1=i.getStringExtra(lat1);longi1=i.getStringExtra(long1);
        lati2=i.getStringExtra(lat2);longi2=i.getStringExtra(long2);
        lati3=i.getStringExtra(lat3);longi3=i.getStringExtra(long3);
        lati4=i.getStringExtra(lat4);longi4=i.getStringExtra(long4);
        latsek=i.getStringExtra(CURLAT);longsek=i.getStringExtra(CURLONG);
        LAT1= new LatLng((Double.parseDouble(lati1)), (Double.parseDouble(longi1)));
        LAT2=new LatLng((Double.parseDouble(lati2)),(Double.parseDouble(longi2)));
        LAT3=new LatLng((Double.parseDouble(lati3)),(Double.parseDouble(longi3)));
        LAT4=new LatLng((Double.parseDouble(lati4)),(Double.parseDouble(longi4)));
        CURRENT=new LatLng((Double.parseDouble(latsek)),(Double.parseDouble(longsek)));
        googleMap = fm.getMap();
        MarkerOptions options = new MarkerOptions();
        options.position(CURRENT);
        options.position(LAT1);
        options.position(LAT2);
        options.position(LAT3);
        options.position(LAT4);
        googleMap.addMarker(options);
        String url = getMapsApiDirectionsUrl();
        ReadTask downloadTask = new ReadTask();
        downloadTask.execute(url);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CURRENT, 13));
        addMarkers();
        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent i=new Intent(getApplicationContext(), Descriptor.class);
                if (marker.getTitle().equalsIgnoreCase("kawah putih"))
                {
                    //handle click here
                    i.putExtra("value","1");
                    startActivity(i);
                }else if (marker.getTitle().equalsIgnoreCase("trans studio bandung"))
                {
                    //handle click here
                    i.putExtra("value","2");
                    startActivity(i);
                }else if (marker.getTitle().equalsIgnoreCase("gedung sate"))
                {
                    //handle click here
                    i.putExtra("value","3");
                    startActivity(i);
                }else if (marker.getTitle().equalsIgnoreCase("situ patengan"))
                {
                    i.putExtra("value","4");
                    startActivity(i);
                    //handle click here
                }else if (marker.getTitle().equalsIgnoreCase("Taman Ade Irma Suryani"))
                {
                    //handle click here
                    i.putExtra("value","5");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Keraton Kasepuhan"))
                {
                    i.putExtra("value","6");
                    startActivity(i);

                    //handle click here
                }else if (marker.getTitle().equalsIgnoreCase("banyu panas palimanan"))
                {
                    //handle click here
                    i.putExtra("value","7");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("pantai kejawanan"))
                {
                    //handle click here
                    i.putExtra("value","8");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("goa bumiayu"))
                {
                    //handle click here
                    i.putExtra("value","9");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("situ gunung"))
                {
                    //handle click here
                    i.putExtra("value","10");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("situ sukarame"))
                {
                    //handle click here
                    i.putExtra("value","11");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("taman rekreasi selabintana"))
                {
                    //handle click here
                    i.putExtra("value","12");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Kebun Raya Bogor"))
                {
                    //handle click here
                    i.putExtra("value","13");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Danau Situ Gede"))
                {
                    //handle click here
                    i.putExtra("value","14");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Taman Safari Bogor"))
                {
                    //handle click here
                    i.putExtra("value","15");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Taman Wisata Mekarsari"))
                {
                    //handle click here
                    i.putExtra("value","16");
                    startActivity(i);

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

    private void addMarkers() {
        if (googleMap != null) {
            googleMap.addMarker(new MarkerOptions().position(CURRENT)
                    .title("Current Location")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
            googleMap.addMarker(new MarkerOptions().position(LAT1)
                    .title(lokasi1));
            googleMap.addMarker(new MarkerOptions().position(LAT2)
                    .title(lokasi2));
            googleMap.addMarker(new MarkerOptions().position(LAT3)
                    .title(lokasi3));
            googleMap.addMarker(new MarkerOptions().position(LAT4)
                    .title(lokasi4));
        }
    }



    private class ReadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... url) {
            String data = "";
            try {
                HttpConnection http = new HttpConnection();
                data = http.readUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            new ParserTask().execute(result);
        }
    }

    private class ParserTask extends
            AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String...jsonData) {
            JSONObject jObject;
            List<List<HashMap<String,String>>> routes = null;
            try {
                jObject = new JSONObject(jsonData[0]);
                PathJSONParser parser = new PathJSONParser();
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> routes) {
            ArrayList<LatLng> points = null;
            PolylineOptions polyLineOptions = null;
            // traversing through routes
            for (int i = 0; i < routes.size(); i++) {
                points = new ArrayList<LatLng>();
                polyLineOptions = new PolylineOptions();
                List<HashMap<String, String>> path = routes.get(i);

                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);
                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                polyLineOptions.addAll(points);
                polyLineOptions.width(4);
                polyLineOptions.color(Color.RED);
            }

            googleMap.addPolyline(polyLineOptions);
        }
    }
}
