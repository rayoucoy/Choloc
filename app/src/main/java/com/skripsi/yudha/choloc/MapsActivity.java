package com.skripsi.yudha.choloc;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.skripsi.yudha.choloc.activity.MainActivity;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by affan on 03/06/16.
 */
public class MapsActivity extends FragmentActivity {

    private static LatLng LAT1= new LatLng(-6.985906,110.345631);
    private static LatLng LAT2= new LatLng(-6.924171,110.478484);
    private static LatLng LAT3= new LatLng(-7.038525,110.351087);
    private static LatLng LAT4= new LatLng(-7.116164,110.422420);
    private static LatLng LAT5= new LatLng(-7.194939,110.373513);
    private static LatLng LAT6= new LatLng(-7.205499,110.341971);
    private static LatLng LAT7= new LatLng(-7.021035,110.376843);
    private static LatLng LAT8= new LatLng(-7.359403,110.422859);
    private static LatLng LAT9= new LatLng(-7.129845,110.389233);
    private static LatLng LAT10= new LatLng(-7.208178,110.341753);
    private static LatLng LAT11= new LatLng(-7.148884,110.360616);
    private static LatLng LAT12= new LatLng(-7.304380,110.411302);
    private static LatLng LAT13= new LatLng(-7.131754,110.395018);
    private static LatLng LAT14= new LatLng(-7.192791,110.364666);
    private static LatLng LAT15= new LatLng(-6.990378,110.423124);
    private static LatLng LAT16= new LatLng(-6.984069,110.410814);
    private static LatLng LAT17= new LatLng(-6.984336,110.409301);
    private static LatLng LAT18= new LatLng(-7.049550,110.438541);
    private static LatLng LAT19= new LatLng(-6.994744,110.424609);
    private static LatLng LAT20= new LatLng(-7.050616,110.392740);
    private static LatLng LAT21= new LatLng(-7.183613,110.348332);
    private static LatLng LAT22= new LatLng(-7.208187,110.341747);
    private static LatLng LAT23= new LatLng(-7.189797,110.365043);
    private static LatLng LAT24= new LatLng(-7.193205,110.366087);
    private static LatLng LAT25= new LatLng(-7.194812,110.373951);
    private static LatLng LAT26= new LatLng(-7.056871,110.487885);
    private static LatLng LAT27= new LatLng(-7.022884,110.438683);
    private static LatLng LAT28= new LatLng(-6.983540,110.445196);

	//jarak max
	private static double MaxJarak = 5.0; //5KM or less

    private static LatLng CURRENT= new LatLng(-7.048015,110.441016);
    public static String KEY1="key1",KEY2="key2",KEY3="key3",KEY4="key4",lat1="1", lat2="2",lat3="3",lat4="4",long1="11",long2="22",long3="33",long4="44",CURLAT="111",CURLONG="222";
    public static String latsek,longsek,lokasi1,lokasi2,lokasi3,lokasi4,lokasi5,lokasi6,lokasi7,lokasi8,lokasi9,lokasi10,
            lokasi11,lokasi12,lokasi13,lokasi14,lokasi15,lokasi16,lokasi17,lokasi18,lokasi19,lokasi20,
            lokasi21,lokasi22,lokasi23,lokasi24,lokasi25,lokasi26,lokasi27,lokasi28,
            lati1,lati2,lati3,lati4,longi1,longi2,longi3,longi4;

    GoogleMap googleMap;
    final String TAG = "PathGoogleMapActivity";
    SessionManagement session;
	
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maplayout);
        session = new SessionManagement(getApplicationContext());
        session.checkLogin();
        SupportMapFragment fm = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.maps);
        /*Intent i=getIntent();
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
        CURRENT=new LatLng((Double.parseDouble(latsek)),(Double.parseDouble(longsek)));*/
        googleMap = fm.getMap();
        MarkerOptions options = new MarkerOptions();
        options.position(CURRENT);
        options.position(LAT1);
        options.position(LAT2);
        options.position(LAT3);
        options.position(LAT4);
        options.position(LAT5);
        options.position(LAT6);
        options.position(LAT7);
        options.position(LAT8);
        options.position(LAT9);
        options.position(LAT10);
        options.position(LAT11);
        options.position(LAT12);
        options.position(LAT13);
        options.position(LAT14);
        options.position(LAT15);
        options.position(LAT16);
        options.position(LAT17);
        options.position(LAT18);
        options.position(LAT19);
        options.position(LAT20);
        options.position(LAT21);
        options.position(LAT22);
        options.position(LAT23);
        options.position(LAT24);
        options.position(LAT25);
        options.position(LAT26);
        options.position(LAT27);
        options.position(LAT28);
        googleMap.addMarker(options);
        String url = getMapsApiDirectionsUrl();
        ReadTask downloadTask = new ReadTask();
        downloadTask.execute(url);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CURRENT, 13));
        addMarkers();
		
		//

        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                if (marker.getTitle().equalsIgnoreCase("Kampung Wisata Taman Lele"))
                {
                    //handle click here
					//memasukan fungsi batasan location based service
					if(distanceInKM(CURRENT,LAT1) <= MaxJarak){
						i.putExtra("value","1");
						startActivity(i);
					} else {
						Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
					}
                }else if (marker.getTitle().equalsIgnoreCase("Wisata Bahari Morosari"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT2) <= MaxJarak){
                        i.putExtra("value","2");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Wisata Goa Kreo"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT3) <= MaxJarak){
                        i.putExtra("value","3");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Wisata Alam Wana Wisata Penggaron"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT4) <= MaxJarak){
                        i.putExtra("value","4");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Umbul Sidomukti"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT5) <= MaxJarak){
                        i.putExtra("value","5");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Vanaprastha Gedongsongo Park"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT6) <= MaxJarak){
                        i.putExtra("value","6");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Desa Wisata Lembah Kalipancur"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT7) <= MaxJarak){
                        i.putExtra("value","7");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Air Terjun Kalipancur Nogosaren"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT8) <= MaxJarak){
                        i.putExtra("value","8");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Watu Gunung"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT9) <= MaxJarak){
                        i.putExtra("value","9");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Candi Gedong Songo"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT10) <= MaxJarak){
                        i.putExtra("value","10");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Curug Lawe Benowo Kalisidi"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT11) <= MaxJarak){
                        i.putExtra("value","11");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Bukit Cinta Rawa Pening"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT12) <= MaxJarak){
                        i.putExtra("value","12");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Kolam Renang Tirto Agung Siwarak"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT13) <= MaxJarak){
                        i.putExtra("value","13");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Basecamp Mawar"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT14) <= MaxJarak){
                        i.putExtra("value","14");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Simpang Lima Semarang"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT15) <= MaxJarak){
                        i.putExtra("value","15");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Lawang Sewu"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT16) <= MaxJarak){
                        i.putExtra("value","16");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Tugu Muda"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT17) <= MaxJarak){
                        i.putExtra("value","17");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Universitas Diponegoro, Kampus Tembalang Semarang"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT18) <= MaxJarak){
                        i.putExtra("value","18");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Universitas Diponegoro, Kampus Pleburan Semarang"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT19) <= MaxJarak){
                        i.putExtra("value","19");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Universitas Negeri Semarang"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT20) <= MaxJarak){
                        i.putExtra("value","20");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Gunung Ungaran"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT21) <= MaxJarak){
                        i.putExtra("value","21");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Candi Gedong Songo"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT22) <= MaxJarak){
                        i.putExtra("value","22");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Bukit Paralayang"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT23) <= MaxJarak){
                        i.putExtra("value","23");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Pondok Kopi Umbul Sidomukti"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT24) <= MaxJarak){
                        i.putExtra("value","24");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("RAGENTAR Outbound dan Olah Nyali"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT25) <= MaxJarak){
                        i.putExtra("value","25");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Browncanyon Semarang"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT26) <= MaxJarak){
                        i.putExtra("value","26");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Water Blaster"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT27) <= MaxJarak){
                        i.putExtra("value","27");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
                    }
                }else if (marker.getTitle().equalsIgnoreCase("Masjid Agung Jawa Tengah"))
                {
                    //handle click here
                    if(distanceInKM(CURRENT,LAT28) <= MaxJarak){
                        i.putExtra("value","28");
                        startActivity(i);
                    } else {
                        Toast.makeText(MapsActivity.this, "Lokasi anda sekarang terlalu jauh dari objek ini", Toast.LENGTH_LONG).show();
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

    private void addMarkers() {
        if (googleMap != null) {
            googleMap.addMarker(new MarkerOptions().position(CURRENT)
                    .title("Current Location")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
            googleMap.addMarker(new MarkerOptions().position(LAT1)
                    .title("Kampung Wisata Taman Lele"));
            googleMap.addMarker(new MarkerOptions().position(LAT2)
                    .title("Wisata Bahari Morosari"));
            googleMap.addMarker(new MarkerOptions().position(LAT3)
                    .title("Wisata Goa Kreo"));
            googleMap.addMarker(new MarkerOptions().position(LAT4)
                    .title("Wisata Alam Wana Wisata Penggaron"));
            googleMap.addMarker(new MarkerOptions().position(LAT5)
                    .title("Umbul Sidomukti"));
            googleMap.addMarker(new MarkerOptions().position(LAT6)
                    .title("Vanaprastha Gedongsongo Park"));
            googleMap.addMarker(new MarkerOptions().position(LAT7)
                    .title("Desa Wisata Lembah Kalipancur"));
            googleMap.addMarker(new MarkerOptions().position(LAT8)
                    .title("Air Terjun Kalipancur Nogosaren"));
            googleMap.addMarker(new MarkerOptions().position(LAT9)
                    .title("Watu Gunung"));
            googleMap.addMarker(new MarkerOptions().position(LAT10)
                    .title("Candi Gedong Songo"));
            googleMap.addMarker(new MarkerOptions().position(LAT11)
                    .title("Curug Lawe Benowo Kalisidi"));
            googleMap.addMarker(new MarkerOptions().position(LAT12)
                    .title("Bukit Cinta Rawa Pening"));
            googleMap.addMarker(new MarkerOptions().position(LAT13)
                    .title("Kolam Renang Tirto Agung Siwarak"));
            googleMap.addMarker(new MarkerOptions().position(LAT14)
                    .title("Basecamp Mawar"));
            googleMap.addMarker(new MarkerOptions().position(LAT15)
                    .title("Simpang Lima Semarang"));
            googleMap.addMarker(new MarkerOptions().position(LAT16)
                    .title("Lawang Sewu"));
            googleMap.addMarker(new MarkerOptions().position(LAT17)
                    .title("Tugu Muda"));
            googleMap.addMarker(new MarkerOptions().position(LAT18)
                    .title("Universitas Diponegoro, Kampus Tembalang Semarang"));
            googleMap.addMarker(new MarkerOptions().position(LAT19)
                    .title("Universitas Diponegoro, Kampus Pleburan Semarang"));
            googleMap.addMarker(new MarkerOptions().position(LAT20)
                    .title("Universitas Negeri Semarang"));
            googleMap.addMarker(new MarkerOptions().position(LAT21)
                    .title("Gunung Ungaran"));
            googleMap.addMarker(new MarkerOptions().position(LAT22)
                    .title("Candi Gedong Songo"));
            googleMap.addMarker(new MarkerOptions().position(LAT23)
                    .title("Bukit Paralayang"));
            googleMap.addMarker(new MarkerOptions().position(LAT24)
                    .title("Pondok Kopi Umbul Sidomukti"));
            googleMap.addMarker(new MarkerOptions().position(LAT25)
                    .title("RAGENTAR Outbound dan Olah Nyali"));
            googleMap.addMarker(new MarkerOptions().position(LAT26)
                    .title("Browncanyon Semarang"));
            googleMap.addMarker(new MarkerOptions().position(LAT27)
                    .title("Water Blaster"));
            googleMap.addMarker(new MarkerOptions().position(LAT28)
                    .title("Masjid Agung Jawa Tengah"));
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