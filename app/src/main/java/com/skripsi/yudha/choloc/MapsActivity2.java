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
 * Created by yudha on 03/06/16.
 */
public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Location end,bd1,bd2,bd3,bd4,sk1,sk2,sk3,sk4,bg1,bg2,bg3,bg4,cr1,cr2,cr3,cr4;
    static Location start;
    String kode="kode",CURLAT="111",CURLONG="222";
    static String code,curlatt,curlongg,lokasi;
    static double curlat,curlong,jarak;
    static double[] temp= new double[16];
    Double KPlat = -7.1661110,KPlong = 107.4022220;
    Double SPlat = -7.1669440,SPlong = 107.3580560;
    Double TSBlat = -6.9259410,TSBlong = 107.6361910;
    Double GSlat = -6.8999250,GSlong = 107.6229660;
    Double TAISlat = -6.7178013,TAISlong = 108.5715166;
    Double KKlat = -6.7263338,KKlong = 108.5688174;
    Double BPPlat = -6.6975145,BPPlong = 108.3980838;
    Double PKlat = -6.7336135,PKlong = 108.5836023;
    Double GBAlat = -7.0365391,GBAlong = 106.9042672;
    Double SGlat = -6.8319442,SGlong = 106.9143008;
    Double SSlat = -6.794454,SSlong = 106.710364;
    Double TRSlat = -6.8489119,TRSlong = 106.9591489;
    Double KRBlat = -6.5976289,KRBlong = 106.7973811;
    Double DSGlat = -6.5533715,DSGlong = 106.7447576;
    Double TSBRlat = -6.7166697,TSBRlong = 106.9474347;
    Double TWMlat = -6.4219834,TWMlong = 106.9821608;
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
        bd1=new Location("");
        bd2=new Location("");
        bd3=new Location("");
        bd4=new Location("");
        cr1=new Location("");
        cr2=new Location("");
        cr3=new Location("");
        cr4=new Location("");
        bg1=new Location("");
        bg2=new Location("");
        bg3=new Location("");
        bg4=new Location("");
        sk1=new Location("");
        sk2=new Location("");
        sk3=new Location("");
        sk4=new Location("");
        start=new Location("");
        code=i.getStringExtra(kode);
        curlatt=i.getStringExtra(CURLAT);
        curlongg=i.getStringExtra(CURLONG);
        curlat=Double.parseDouble(curlatt);
        curlong=Double.parseDouble(curlongg);
        start.setLatitude(curlat);
        start.setLongitude(curlong);
        if (code.equalsIgnoreCase("BDG")){
            bd1.setLatitude(KPlat);
            bd1.setLongitude(KPlong);
            bd2.setLatitude(SPlat);
            bd2.setLongitude(SPlong);
            bd3.setLatitude(TSBlat);
            bd3.setLongitude(TSBlong);
            bd4.setLatitude(GSlat);
            bd4.setLongitude(GSlong);
            temp[0]=start.distanceTo(bd1);
            temp[1]=start.distanceTo(bd2);
            temp[2]=start.distanceTo(bd3);
            temp[3]=start.distanceTo(bd4);
            jarak=999999999;
            for (int n=0;n<=3;n++){
                if (jarak>temp[n]) {
                    jarak = temp[n];
                }
            }
            if(jarak==temp[0]){
                end=bd1;
                lokasi="Kawah putih";
            }else if(jarak==temp[1]){
                end=bd2;
                lokasi="Situ Patengan";
            }else if(jarak==temp[2]){
                end=bd3;
                lokasi="Trans Studio Bandung";
            }else if(jarak==temp[3]){
                end=bd4;
                lokasi="Gedung Sate";
            }

        }else if (code.equalsIgnoreCase("CRB")){
            cr1.setLatitude(TAISlat);
            cr1.setLongitude(TAISlong);
            cr2.setLatitude(KKlat);
            cr2.setLongitude(KKlong);
            cr3.setLatitude(BPPlat);
            cr3.setLongitude(BPPlong);
            cr4.setLatitude(PKlat);
            cr4.setLongitude(PKlong);
            temp[0]=start.distanceTo(cr1);
            temp[1]=start.distanceTo(cr2);
            temp[2]=start.distanceTo(cr3);
            temp[3]=start.distanceTo(cr4);
            jarak=999999999;
            for (int n=0;n<=3;n++){
                if (jarak>temp[n]) {
                    jarak = temp[n];
                }
            }
            if(jarak==temp[0]){
                end=cr1;
                lokasi="Taman Ade Irma Suryani";
            }else if(jarak==temp[1]){
                end=cr2;
                lokasi="Keraton Kasepuhan";
            }else if(jarak==temp[2]){
                end=cr3;
                lokasi="Banyu Panas Palimanan";
            }else if(jarak==temp[3]){
                end=cr4;
                lokasi="Pantai Kejawanan";
            }
        }else if (code.equalsIgnoreCase("SKB")){
            sk1.setLatitude(GBAlat);
            sk1.setLongitude(GBAlong);
            sk2.setLatitude(SGlat);
            sk2.setLongitude(SGlong);
            sk3.setLatitude(SSlat);
            sk3.setLongitude(SSlong);
            sk4.setLatitude(TRSlat);
            sk4.setLongitude(TRSlong);
            temp[0]=start.distanceTo(sk1);
            temp[1]=start.distanceTo(sk2);
            temp[2]=start.distanceTo(sk3);
            temp[3]=start.distanceTo(sk4);
            jarak=999999999;
            for (int n=0;n<=3;n++){
                if (jarak>temp[n]) {
                    jarak = temp[n];
                }
            }
            if(jarak==temp[0]){
                end=sk1;
                lokasi="Goa BumiAyu";
            }else if(jarak==temp[1]){
                end=sk2;
                lokasi="Situ Gunung";
            }else if(jarak==temp[2]){
                end=sk3;
                lokasi="Situ Sukarame";
            }else if(jarak==temp[3]){
                end=sk4;
                lokasi="Taman Rekreasi Selabintana";
            }
        }else if (code.equalsIgnoreCase("BGR")){
            bg1.setLatitude(KRBlat);
            bg1.setLongitude(KRBlong);
            bg2.setLatitude(DSGlat);
            bg2.setLongitude(DSGlong);
            bg3.setLatitude(TSBRlat);
            bg3.setLongitude(TSBRlong);
            bg4.setLatitude(TWMlat);
            bg4.setLongitude(TWMlong);
            temp[0]=start.distanceTo(bg1);
            temp[1]=start.distanceTo(bg2);
            temp[2]=start.distanceTo(bg3);
            temp[3]=start.distanceTo(bg4);
            jarak=999999999;
            for (int n=0;n<=3;n++){
                if (jarak>temp[n]) {
                    jarak = temp[n];
                }
            }
            if(jarak==temp[0]){
                end=bg1;
                lokasi="Kebun Raya Bogor";
            }else if(jarak==temp[1]){
                end=bg2;
                lokasi="Danau Situ Gede";
            }else if(jarak==temp[2]){
                end=bg3;
                lokasi="Taman Safari Bogor";
            }else if(jarak==temp[3]){
                end=bg4;
                lokasi="Taman Wisata Mekarsari";
            }
        }else if (code.equalsIgnoreCase("ALL")){
            bg1.setLatitude(KRBlat);
            bg1.setLongitude(KRBlong);
            bg2.setLatitude(DSGlat);
            bg2.setLongitude(DSGlong);
            bg3.setLatitude(TSBRlat);
            bg3.setLongitude(TSBRlong);
            bg4.setLatitude(TWMlat);
            bg4.setLongitude(TWMlong);
            sk1.setLatitude(GBAlat);
            sk1.setLongitude(GBAlong);
            sk2.setLatitude(SGlat);
            sk2.setLongitude(SGlong);
            sk3.setLatitude(SSlat);
            sk3.setLongitude(SSlong);
            sk4.setLatitude(TRSlat);
            sk4.setLongitude(TRSlong);
            cr1.setLatitude(TAISlat);
            cr1.setLongitude(TAISlong);
            cr2.setLatitude(KKlat);
            cr2.setLongitude(KKlong);
            cr3.setLatitude(BPPlat);
            cr3.setLongitude(BPPlong);
            cr4.setLatitude(PKlat);
            cr4.setLongitude(PKlong);
            bd1.setLatitude(KPlat);
            bd1.setLongitude(KPlong);
            bd2.setLatitude(SPlat);
            bd2.setLongitude(SPlong);
            bd3.setLatitude(TSBlat);
            bd3.setLongitude(TSBlong);
            bd4.setLatitude(GSlat);
            bd4.setLongitude(GSlong);
            temp[0]=start.distanceTo(bg1);
            temp[1]=start.distanceTo(bg2);
            temp[2]=start.distanceTo(bg3);
            temp[3]=start.distanceTo(bg4);
            temp[4]=start.distanceTo(bd1);
            temp[5]=start.distanceTo(bd2);
            temp[6]=start.distanceTo(bd3);
            temp[7]=start.distanceTo(bd4);
            temp[8]=start.distanceTo(sk1);
            temp[9]=start.distanceTo(sk2);
            temp[10]=start.distanceTo(sk3);
            temp[11]=start.distanceTo(sk4);
            temp[12]=start.distanceTo(cr1);
            temp[13]=start.distanceTo(cr2);
            temp[14]=start.distanceTo(cr3);
            temp[15]=start.distanceTo(cr4);
            jarak=999999999;
            for (int n=0;n<=15;n++){
                if (jarak>temp[n]) {
                    jarak = temp[n];
                }
            }
            if(jarak==temp[0]){
                end=bg1;lokasi="Kebun Raya Bogor";
            }else if(jarak==temp[1]){
                end=bg2;lokasi="Danau Situ Gede";
            }else if(jarak==temp[2]){
                end=bg3;lokasi="Taman Safari Bogor";
            }else if(jarak==temp[3]){
                end=bg4;lokasi="Taman Wisata Mekarsari";
            }else if(jarak==temp[8]){
                end=sk1;lokasi="Goa BumiAyu";
            }else if(jarak==temp[9]){
                end=sk2;lokasi="Situ Gunung";
            }else if(jarak==temp[10]){
                end=sk3;lokasi="Situ Sukarame";
            }else if(jarak==temp[11]){
                end=sk4;lokasi="Taman Rekreasi Selabintana";
            }else if(jarak==temp[12]){
                end=cr1;lokasi="Taman Ade Irma Suryani";
            }else if(jarak==temp[13]){
                end=cr2;lokasi="Keraton Kasepuhan";
            }else if(jarak==temp[14]){
                end=cr3;lokasi="Banyu Panas Palimanan";
            }else if(jarak==temp[15]){
                end=cr4;lokasi="Pantai Kejawanan";
            }else if(jarak==temp[4]){
                end=bd1;lokasi="Kawah putih";
            }else if(jarak==temp[5]){
                end=bd2;lokasi="Situ Patengan";
            }else if(jarak==temp[6]){
                end=bd3;lokasi="Trans Studio Bandung";
            }else if(jarak==temp[7]){
                end=bd4;lokasi="Gedung Sate";
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
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent i = new Intent(getApplicationContext(), Descriptor.class);
                if (marker.getTitle().equalsIgnoreCase("kawah putih")) {
                    //handle click here
                    i.putExtra("value", "1");
                    startActivity(i);
                } else if (marker.getTitle().equalsIgnoreCase("trans studio bandung")) {
                    //handle click here
                    i.putExtra("value", "2");
                    startActivity(i);
                } else if (marker.getTitle().equalsIgnoreCase("gedung sate")) {
                    //handle click here
                    i.putExtra("value", "3");
                    startActivity(i);
                } else if (marker.getTitle().equalsIgnoreCase("situ patengan")) {
                    i.putExtra("value", "4");
                    startActivity(i);
                    //handle click here
                } else if (marker.getTitle().equalsIgnoreCase("Taman Ade Irma Suryani")) {
                    //handle click here
                    i.putExtra("value", "5");
                    startActivity(i);

                } else if (marker.getTitle().equalsIgnoreCase("Keraton Kasepuhan")) {
                    i.putExtra("value", "6");
                    startActivity(i);

                    //handle click here
                } else if (marker.getTitle().equalsIgnoreCase("banyu panas palimanan")) {
                    //handle click here
                    i.putExtra("value", "7");
                    startActivity(i);

                } else if (marker.getTitle().equalsIgnoreCase("pantai kejawanan")) {
                    //handle click here
                    i.putExtra("value", "8");
                    startActivity(i);

                } else if (marker.getTitle().equalsIgnoreCase("goa bumiayu")) {
                    //handle click here
                    i.putExtra("value", "9");
                    startActivity(i);

                } else if (marker.getTitle().equalsIgnoreCase("situ gunung")) {
                    //handle click here
                    i.putExtra("value", "10");
                    startActivity(i);

                } else if (marker.getTitle().equalsIgnoreCase("situ sukarame")) {
                    //handle click here
                    i.putExtra("value", "11");
                    startActivity(i);

                } else if (marker.getTitle().equalsIgnoreCase("taman rekreasi selabintana")) {
                    //handle click here
                    i.putExtra("value", "12");
                    startActivity(i);

                } else if (marker.getTitle().equalsIgnoreCase("Kebun Raya Bogor")) {
                    //handle click here
                    i.putExtra("value", "13");
                    startActivity(i);

                } else if (marker.getTitle().equalsIgnoreCase("Danau Situ Gede")) {
                    //handle click here
                    i.putExtra("value", "14");
                    startActivity(i);

                } else if (marker.getTitle().equalsIgnoreCase("Taman Safari Bogor")) {
                    //handle click here
                    i.putExtra("value", "15");
                    startActivity(i);

                } else if (marker.getTitle().equalsIgnoreCase("Taman Wisata Mekarsari")) {
                    //handle click here
                    i.putExtra("value", "16");
                    startActivity(i);

                }
            }
        });
    }
}


