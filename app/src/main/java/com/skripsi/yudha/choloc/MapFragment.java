package com.skripsi.yudha.choloc;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by affan on 22/05/16.
 */
public class MapFragment extends Fragment {
    MapView mMapView;
    private GoogleMap googleMap;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
        // inflate and return the layout
        View v = inflater.inflate(R.layout.activity_map_fragment, container, false);
        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstaceState);

        mMapView.onResume(); // dibutuhkan pada saat memunculkan map dengan segera
        try{
            MapsInitializer.initialize(getActivity().getApplicationContext());

        }catch (Exception e) {
            e.printStackTrace();
        }
        googleMap = mMapView.getMap();
        //lat and long
        double latitude =-7.049645;
        double longtitude = 110.438541;

        // bikin marker
        MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude,longtitude)).title("hallo Choloc");

        // ganti icon marker
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

        // nambahin marker
        googleMap.addMarker(marker);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(-7.049645,110.438541)).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        //tampilin update camera di fungsi ini
        return v;

    }

    public void onResme(){
        super.onResume();
        mMapView.onResume();
    }

    public void onPause(){
        super.onPause();
        mMapView.onPause();
    }

    public void onDestry(){
        super.onDestroy();
        mMapView.onDestroy();
    }

    public void onLowMemmory(){
        super.onLowMemory();
        mMapView.onLowMemory();
    }

}
