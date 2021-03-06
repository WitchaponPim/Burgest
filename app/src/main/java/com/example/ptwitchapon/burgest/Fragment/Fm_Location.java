package com.example.ptwitchapon.burgest.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
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

import com.example.ptwitchapon.burgest.AR.ARActivity;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.TabActivity;
import com.example.ptwitchapon.burgest.Tool.GPSTracker;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

/**
 * Created by Killy77 on 17/6/2561.
 */

public class Fm_Location extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    EditText searchView;
    private Circle circle;
    Location Burgest = new Location("Burgest");
    Button button;
    int REQUEST_LOCATION =1;
    LocationManager locationManager;
    String lattitude,longitude;
    float distance;
    public static Fm_Location newInstance() {
        return new Fm_Location();
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_location, container, false);
        button = (Button) v.findViewById(R.id.button);

        if(ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_FINE_LOCATION)
                !=PackageManager.PERMISSION_GRANTED&&ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        }

            //ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AR();
            }
        });
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

        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            getContext(), R.raw.style_json));

            if (!success) {
                Log.e("test", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("test", "Can't find style. Error: ", e);
        }
        // Add a marker in Sydney and move the camera , ,
        LatLng burgest = new LatLng(Double.valueOf(Utils.storeModel.getStore().get(0).getLatitude()), Double.valueOf(Utils.storeModel.getStore().get(0).getLongitude()));
        Burgest.setLatitude(Double.valueOf(Utils.storeModel.getStore().get(0).getLatitude()));
        Burgest.setLongitude(Double.valueOf(Utils.storeModel.getStore().get(0).getLongitude()));
        Burgest.setAltitude(0);

        Log.d("Ammy", "onMapReady: "+burgest.latitude + " / "+ burgest.longitude);
        LatLng me = new LatLng(Double.valueOf(lattitude),Double.valueOf(longitude));
//        PolylineOptions rectLine = new PolylineOptions()
//                .add(new LatLng(13.761519, 100.548816))
//                .add(new LatLng(13.761519, 100.576368))
//                .add(new LatLng(13.787612, 100.576368))
//                .add(new LatLng(13.787612, 100.548816))
//                .add(new LatLng(13.761519, 100.548816))
//                .color(getResources().getColor(R.color.colorPrimary));
         circle = mMap.addCircle(new CircleOptions()
                .center(new LatLng(Double.valueOf(Utils.storeModel.getStore().get(0).getLatitude()), Double.valueOf(Utils.storeModel.getStore().get(0).getLongitude())))
                .radius(Double.valueOf(Utils.storeModel.getStore().get(0).getDistance()))
                .strokeWidth(10)
                .strokeColor(getResources().getColor(R.color.colorPrimary))
                .fillColor(Color.argb(128,201,126,29))
                .clickable(true));
        mMap.setOnCircleClickListener(new GoogleMap.OnCircleClickListener() {

            @Override
            public void onCircleClick(Circle circle) {
                // Flip the r, g and b components of the circle's
                // stroke color.
                Utils.toast(getContext(), "อยู่ในพื้นที่" +
                        "");
            }
        });


        mMap.addMarker(new MarkerOptions().position(me).title("I'm Here").snippet("Hello myfriend"));

        mMap.addMarker(new MarkerOptions().position(burgest).title("Burgest").snippet("The Burgest Delivery"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(me));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(burgest.latitude, burgest.longitude), 12.5f));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Location a = new Location("check");
                a.setLatitude(latLng.latitude);
                a.setLongitude(latLng.longitude);
                a.setAltitude(0);
                distance = a.distanceTo(Burgest);

//                if (latLng.latitude > 13.761519 && latLng.longitude > 100.548816&&latLng.latitude < 13.787612 && latLng.longitude < 100.576368) {
//                    Utils.toast(getContext(), String.valueOf(latLng.latitude) + " , " + String.valueOf(latLng.longitude));
//                }else {
//                    Utils.toast(getContext(), "Out of area !!!!");
//                }
                if (distance<4000) {
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
    public void AR(){
        startActivity(new Intent(getActivity(), ARActivity.class));
    }

}

