package com.skripsi.yudha.choloc;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by affan on 03/06/16.
 */
public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Location end,wisata1,wisata2,wisata3,wisata4,wisata5,wisata6,wisata7,wisata8,wisata9,wisata10,
            wisata11,wisata12,wisata13,wisata14,wisata15,wisata16;

    static Location start;
    String kode="kode",CURLAT="111",CURLONG="222";
    static String code,curlatt,curlongg,lokasi;
    static double curlat,curlong,jarak;
    static double[] temp= new double[16];
    Double LAT1 = -6.985906,LONG1 = 110.345631;
    Double LAT2 = -6.924171,LONG2 = 110.478484;
    Double LAT3 = -7.038525,LONG3 = 110.351087;
    Double LAT4 = -7.116164,LONG4 = 110.422420;
    Double LAT5 = -7.194939,LONG5 = 110.373513;
    Double LAT6 = -7.205499,LONG6 = 110.341971;
    Double LAT7 = -7.021035,LONG7 = 110.376843;
    Double LAT8 = -7.359403,LONG8 = 110.422859;
    Double LAT9 = -7.129845,LONG9 = 110.389233;
    Double LAT10 = -7.208178,LONG10 = 110.341753;
    Double LAT11 = -7.148884,LONG11 = 110.360616;
    Double LAT12 = -7.304380,LONG12 = 110.411302;
    Double LAT13 = -7.131754,LONG13 = 110.395018;
    Double LAT14 = -7.192791,LONG14 = 110.364666;
    Double LAT15 = -6.990378,LONG15 = 110.423124;
    Double LAT16 = -6.984069,LONG16 = 110.410814;
    Double LAT17 = -6.984336,LONG17 = 110.409301;
    Double LAT18 = -7.049550,LONG18 = 110.438541;
    Double LAT19 = -6.994744,LONG19 = 110.424609;
    Double LAT20 = -7.050616,LONG20 = 110.392740;
    SessionManagement session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        session = new SessionManagement(getApplicationContext());
        session.checkLogin();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Intent i=getIntent();
        start=new Location("");
        wisata1=new Location("");
        wisata2=new Location("");
        wisata3=new Location("");
        wisata4=new Location("");
        wisata5=new Location("");
        wisata6=new Location("");
        wisata7=new Location("");
        wisata8=new Location("");
        wisata9=new Location("");
        wisata10=new Location("");
        wisata11=new Location("");
        wisata12=new Location("");
        wisata13=new Location("");
        wisata14=new Location("");
        wisata15=new Location("");
        wisata16=new Location("");

        start=new Location("");
        code=i.getStringExtra(kode);
        curlatt=i.getStringExtra(CURLAT);
        curlongg=i.getStringExtra(CURLONG);
        curlat=Double.parseDouble(curlatt);
        curlong=Double.parseDouble(curlongg);
        start.setLatitude(curlat);
        start.setLongitude(curlong);
        if (code.equalsIgnoreCase("WISATA")){
            wisata1.setLatitude(LAT1);
            wisata1.setLongitude(LONG1);
            wisata2.setLatitude(LAT2);
            wisata2.setLongitude(LONG2);
            wisata3.setLatitude(LAT3);
            wisata3.setLongitude(LONG3);
            wisata4.setLatitude(LAT4);
            wisata4.setLongitude(LONG4);
            temp[0]=start.distanceTo(wisata1);
            temp[1]=start.distanceTo(wisata2);
            temp[2]=start.distanceTo(wisata3);
            temp[3]=start.distanceTo(wisata4);
            jarak=999999999;
            for (int n=0;n<=3;n++){
                if (jarak>temp[n]) {
                    jarak = temp[n];
                }
            }
            if(jarak==temp[0]){
                end=wisata1;
                lokasi="Kampung Wisata Taman Lele";
            }else if(jarak==temp[1]){
                end=wisata2;
                lokasi="Wisata Bahari Morosari";
            }else if(jarak==temp[2]){
                end=wisata3;
                lokasi="Wisata Goa Kreo";
            }else if(jarak==temp[3]){
                end=wisata4;
                lokasi="Wisata Alam Wana Wisata Penggaron";
            }

        }else if (code.equalsIgnoreCase("WISATA")){
            wisata5.setLatitude(LAT5);
            wisata5.setLongitude(LONG5);
            wisata6.setLatitude(LAT6);
            wisata6.setLongitude(LONG6);
            wisata7.setLatitude(LAT7);
            wisata7.setLongitude(LONG7);
            wisata8.setLatitude(LAT8);
            wisata8.setLongitude(LONG8);
            temp[0]=start.distanceTo(wisata5);
            temp[1]=start.distanceTo(wisata6);
            temp[2]=start.distanceTo(wisata7);
            temp[3]=start.distanceTo(wisata8);
            jarak=999999999;
            for (int n=0;n<=3;n++){
                if (jarak>temp[n]) {
                    jarak = temp[n];
                }
            }
            if(jarak==temp[0]){
                end=wisata5;
                lokasi="Umbul Sidomukti";
            }else if(jarak==temp[1]){
                end=wisata6;
                lokasi="Vanaprastha Gedongsongo Park";
            }else if(jarak==temp[2]){
                end=wisata7;
                lokasi="Desa Wisata Lembah Kalipancur";
            }else if(jarak==temp[3]){
                end=wisata8;
                lokasi="Air Terjun Kalipancur Nogosaren";
            }
        }else if (code.equalsIgnoreCase("WISATA")){
            wisata9.setLatitude(LAT9);
            wisata9.setLongitude(LONG9);
            wisata10.setLatitude(LAT10);
            wisata10.setLongitude(LONG10);
            wisata11.setLatitude(LAT11);
            wisata11.setLongitude(LONG11);
            wisata12.setLatitude(LAT12);
            wisata12.setLongitude(LONG12);
            temp[0]=start.distanceTo(wisata9);
            temp[1]=start.distanceTo(wisata10);
            temp[2]=start.distanceTo(wisata11);
            temp[3]=start.distanceTo(wisata12);
            jarak=999999999;
            for (int n=0;n<=3;n++){
                if (jarak>temp[n]) {
                    jarak = temp[n];
                }
            }
            if(jarak==temp[0]){
                end=wisata9;
                lokasi="Watu Gunung";
            }else if(jarak==temp[1]){
                end=wisata10;
                lokasi="Candi Gedong Songo";
            }else if(jarak==temp[2]){
                end=wisata11;
                lokasi="Curug Lawe Benowo Kalisidi";
            }else if(jarak==temp[3]){
                end=wisata12;
                lokasi="Bukit Cinta Rawa Pening";
            }
        }else if (code.equalsIgnoreCase("WISATA")){
            wisata13.setLatitude(LAT13);
            wisata13.setLongitude(LONG13);
            wisata14.setLatitude(LAT14);
            wisata14.setLongitude(LONG14);
            wisata15.setLatitude(LAT15);
            wisata15.setLongitude(LONG15);
            wisata16.setLatitude(LAT16);
            wisata16.setLongitude(LONG16);
            temp[0]=start.distanceTo(wisata13);
            temp[1]=start.distanceTo(wisata14);
            temp[2]=start.distanceTo(wisata15);
            temp[3]=start.distanceTo(wisata16);
            jarak=999999999;
            for (int n=0;n<=3;n++){
                if (jarak>temp[n]) {
                    jarak = temp[n];
                }
            }
            if(jarak==temp[0]){
                end=wisata13;
                lokasi="Kolam Renang Tirto Agung Siwarak";
            }else if(jarak==temp[1]){
                end=wisata14;
                lokasi="Basecamp Mawar";
            }else if(jarak==temp[2]){
                end=wisata15;
                lokasi="Simpang Lima Semarang";
            }else if(jarak==temp[3]){
                end=wisata16;
                lokasi="Lawang Sewu";
            }
        }else if (code.equalsIgnoreCase("ALL")){
            wisata1.setLatitude(LAT1);
            wisata1.setLongitude(LONG1);
            wisata2.setLatitude(LAT2);
            wisata2.setLongitude(LONG2);
            wisata3.setLatitude(LAT3);
            wisata3.setLongitude(LONG3);
            wisata4.setLatitude(LAT4);
            wisata4.setLongitude(LONG4);
            wisata5.setLatitude(LAT5);
            wisata5.setLongitude(LONG5);
            wisata6.setLatitude(LAT6);
            wisata6.setLongitude(LONG6);
            wisata7.setLatitude(LAT7);
            wisata7.setLongitude(LONG7);
            wisata8.setLatitude(LAT8);
            wisata8.setLongitude(LONG8);
            wisata9.setLatitude(LAT9);
            wisata9.setLongitude(LONG9);
            wisata10.setLatitude(LAT10);
            wisata10.setLongitude(LONG10);
            wisata11.setLatitude(LAT11);
            wisata11.setLongitude(LONG11);
            wisata12.setLatitude(LAT12);
            wisata12.setLongitude(LONG12);
            wisata13.setLatitude(LAT13);
            wisata13.setLongitude(LONG13);
            wisata14.setLatitude(LAT14);
            wisata14.setLongitude(LONG14);
            wisata15.setLatitude(LAT15);
            wisata15.setLongitude(LONG15);
            wisata16.setLatitude(LAT16);
            wisata16.setLongitude(LONG16);
            temp[0]=start.distanceTo(wisata1);
            temp[1]=start.distanceTo(wisata2);
            temp[2]=start.distanceTo(wisata3);
            temp[3]=start.distanceTo(wisata4);
            temp[4]=start.distanceTo(wisata5);
            temp[5]=start.distanceTo(wisata6);
            temp[6]=start.distanceTo(wisata7);
            temp[7]=start.distanceTo(wisata8);
            temp[8]=start.distanceTo(wisata9);
            temp[9]=start.distanceTo(wisata10);
            temp[10]=start.distanceTo(wisata11);
            temp[11]=start.distanceTo(wisata12);
            temp[12]=start.distanceTo(wisata13);
            temp[13]=start.distanceTo(wisata14);
            temp[14]=start.distanceTo(wisata15);
            temp[15]=start.distanceTo(wisata16);
            jarak=999999999;
            for (int n=0;n<=15;n++){
                if (jarak>temp[n]) {
                    jarak = temp[n];
                }
            }
            if(jarak==temp[0]){
                end=wisata1;lokasi="Kampung Wisata Taman Lele";
            }else if(jarak==temp[1]){
                end=wisata2;lokasi="Wisata Bahari Morosari";
            }else if(jarak==temp[2]){
                end=wisata3;lokasi="Wisata Goa Kreo";
            }else if(jarak==temp[3]){
                end=wisata4;lokasi="Wisata Alam Wana Wisata Penggaron";
            }else if(jarak==temp[4]){
                end=wisata5;lokasi="Umbul Sidomukti";
            }else if(jarak==temp[5]){
                end=wisata6;lokasi="Vanaprastha Gedongsongo Park";
            }else if(jarak==temp[6]){
                end=wisata7;lokasi="Desa Wisata Lembah Kalipancur";
            }else if(jarak==temp[7]){
                end=wisata8;lokasi="Air Terjun Kalipancur Nogosaren";
            }else if(jarak==temp[8]){
                end=wisata9;lokasi="Watu Gunung";
            }else if(jarak==temp[9]){
                end=wisata10;lokasi="Candi Gedong Songo";
            }else if(jarak==temp[10]){
                end=wisata11;lokasi="Curug Lawe Benowo Kalisidi";
            }else if(jarak==temp[11]){
                end=wisata12;lokasi="Bukit Cinta Rawa Pening";
            }else if(jarak==temp[12]){
                end=wisata13;lokasi="Kolam Renang Tirto Agung Siwarak";
            }else if(jarak==temp[13]){
                end=wisata14;lokasi="Basecamp Mawar";
            }else if(jarak==temp[14]){
                end=wisata15;lokasi="Simpang Lima Semarang";
            }else if(jarak==temp[15]){
                end=wisata16;lokasi="Lawang Sewu";
            }
        }

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        LatLng endloc = new LatLng(end.getLatitude(), end.getLongitude());
        mMap.addMarker(new MarkerOptions().position(endloc).title(lokasi));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(endloc,10));

        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent i=new Intent(getApplicationContext(), Descriptor.class);
                if (marker.getTitle().equalsIgnoreCase("Kampung Wisata Taman Lele"))
                {
                    //handle click here
                    i.putExtra("value","1");
                    startActivity(i);
                }else if (marker.getTitle().equalsIgnoreCase("Wisata Bahari Morosari"))
                {
                    //handle click here
                    i.putExtra("value","2");
                    startActivity(i);
                }else if (marker.getTitle().equalsIgnoreCase("Wisata Goa Kreo"))
                {
                    //handle click here
                    i.putExtra("value","3");
                    startActivity(i);
                }else if (marker.getTitle().equalsIgnoreCase("Wisata Alam Wana Wisata Penggaron"))
                {
                    i.putExtra("value","4");
                    startActivity(i);
                    //handle click here
                }else if (marker.getTitle().equalsIgnoreCase("Umbul Sidomukti"))
                {
                    //handle click here
                    i.putExtra("value","5");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Vanaprastha Gedongsongo Park"))
                {
                    i.putExtra("value","6");
                    startActivity(i);

                    //handle click here
                }else if (marker.getTitle().equalsIgnoreCase("Desa Wisata Lembah Kalipancur"))
                {
                    //handle click here
                    i.putExtra("value","7");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Air Terjun Kalipancur Nogosaren"))
                {
                    //handle click here
                    i.putExtra("value","8");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Watu Gunung"))
                {
                    //handle click here
                    i.putExtra("value","9");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Candi Gedong Songo"))
                {
                    //handle click here
                    i.putExtra("value","10");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Curug Lawe Benowo Kalisidi"))
                {
                    //handle click here
                    i.putExtra("value","11");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Bukit Cinta Rawa Pening"))
                {
                    //handle click here
                    i.putExtra("value","12");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Kolam Renang Tirto Agung Siwarak"))
                {
                    //handle click here
                    i.putExtra("value","13");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Basecamp Mawar"))
                {
                    //handle click here
                    i.putExtra("value","14");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Simpang Lima Semarang"))
                {
                    //handle click here
                    i.putExtra("value","15");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Lawang Sewu"))
                {
                    //handle click here
                    i.putExtra("value","16");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Tugu Muda"))
                {
                    //handle click here
                    i.putExtra("value","17");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Universitas Diponegoro, Kampus Tembalang Semarang"))
                {
                    //handle click here
                    i.putExtra("value","18");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Universitas Diponegoro, Kampus Pleburan Semarang"))
                {
                    //handle click here
                    i.putExtra("value","19");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Universitas Negeri Semarang"))
                {
                    //handle click here
                    i.putExtra("value","20");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Gunung Ungaran"))
                {
                    //handle click here
                    i.putExtra("value","21");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Candi Gedong Songo"))
                {
                    //handle click here
                    i.putExtra("value","22");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Bukit Paralayang"))
                {
                    //handle click here
                    i.putExtra("value","23");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Pondok Kopi Umbul Sidomukti"))
                {
                    //handle click here
                    i.putExtra("value","24");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("RAGENTAR Outbound dan Olah Nyali"))
                {
                    //handle click here
                    i.putExtra("value","25");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Browncanyon Semarang"))
                {
                    //handle click here
                    i.putExtra("value","26");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Water Blaster"))
                {
                    //handle click here
                    i.putExtra("value","27");
                    startActivity(i);

                }else if (marker.getTitle().equalsIgnoreCase("Masjid Agung Jawa Tengah"))
                {
                    //handle click here
                    i.putExtra("value","28");
                    startActivity(i);

                }
            }
        });
    }
}


