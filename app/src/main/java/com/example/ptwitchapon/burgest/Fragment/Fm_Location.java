package com.example.ptwitchapon.burgest.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.TabActivity;
import com.example.ptwitchapon.burgest.Tool.GPSTracker;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

/**
 * Created by Killy77 on 17/6/2561.
 */

public class Fm_Location extends Fragment implements OnMapReadyCallback ,LocationListener {
    private GoogleMap mMap;
    EditText searchView;

    Button button;
    int REQUEST_LOCATION =1;
    LocationManager locationManager;
    String lattitude,longitude;

    public static Fm_Location newInstance() {
        return new Fm_Location();
    }


    @SuppressLint("MissingPermission")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_location, container, false);
        button = (Button) v.findViewById(R.id.button);

//        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Utils.toast(getContext(),"GPS not Support");
        }else if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            getLocation();
        }


        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera , ,

        LatLng burgest = new LatLng(13.775139, 100.562442);
        LatLng me = new LatLng(Double.valueOf(lattitude),Double.valueOf(longitude));


        PolylineOptions rectLine = new PolylineOptions()
                .add(new LatLng(13.761519, 100.548816))
                .add(new LatLng(13.761519, 100.576368))
                .add(new LatLng(13.787612, 100.576368))
                .add(new LatLng(13.787612, 100.548816))
                .add(new LatLng(13.761519, 100.548816))
                .color(getResources().getColor(R.color.colorPrimary));
        mMap.addPolyline(rectLine);

        mMap.addMarker(new MarkerOptions().position(me).title("I'm Here").snippet("Hello myfriend"));

        mMap.addMarker(new MarkerOptions().position(burgest).title("Burgest").snippet("The Burgest Delivery"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(me));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(burgest.latitude, burgest.longitude), 14.0f));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                if (latLng.latitude > 13.761519 && latLng.longitude > 100.548816&&latLng.latitude < 13.787612 && latLng.longitude < 100.576368) {
                    Utils.toast(getContext(), String.valueOf(latLng.latitude) + " , " + String.valueOf(latLng.longitude));

                }else {
                    Utils.toast(getContext(), "Out of area !!!!");

                }
            }
        });
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View infoWindow = getLayoutInflater().inflate(R.layout.custom_info, null);
                TextView snippet = ((TextView) infoWindow.findViewById(R.id.textViewSnippet));
                ImageView img = (ImageView) infoWindow.findViewById(R.id.imageView);
                TextView title = ((TextView) infoWindow.findViewById(R.id.textViewName));

                title.setText(marker.getTitle());

                snippet.setText(marker.getSnippet());
                if ("Burgest".equals(marker.getTitle())) {
                    img.setImageResource(R.mipmap.ic_logo_round);
                }
                if ("Hey I'm Here".equals(marker.getTitle())){
                    img.setImageResource(R.drawable.ic_pin_user);
                }
                return infoWindow;
            }
        });
    }

    private void getLocation(){
        if(ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_FINE_LOCATION)
            !=PackageManager.PERMISSION_GRANTED&&ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);

        }else{
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if(location != null){
                double latti = location.getLatitude();
                double longi = location.getLongitude();
                Utils.mylattitude = String.valueOf(latti);
                Utils.mylongitude = String.valueOf(longi);
                lattitude = String.valueOf(latti);
                longitude =String.valueOf(longi);

                Log.d("Latitude", "getLocation: "+lattitude +" , "+longitude);
            }
            else{
                Log.d("Latitude", "getLocation: "+lattitude +" , "+longitude);
            }
        }

    }
    @Override
    public void onLocationChanged(Location location) {
        Log.d("Latitude", "onLocationChanged: "+location.getLatitude() +" + "+location.getLongitude());

    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude","disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude","status");
    }
}

