package com.example.ptwitchapon.burgest;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.Adapter.BasketAdapter;
import com.example.ptwitchapon.burgest.Callback.OrderCallback;
import com.example.ptwitchapon.burgest.Model.OrderResponse;
import com.example.ptwitchapon.burgest.Tool.GPSTracker;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.google.android.gms.maps.model.LatLng;
import com.squareup.okhttp.ResponseBody;

import org.w3c.dom.Text;

import retrofit.Retrofit;

public class BasketActivity extends AppCompatActivity {
    RecyclerView orderlist;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;

    TextView txttotal;
    String TAG = "Basket";
    Button pay;

    ConnectManager connectManager = new ConnectManager();
    OrderCallback orderCallback = new OrderCallback() {
        @Override
        public void onResponse(OrderResponse orderResponse, Retrofit retrofit) {
            Log.d(TAG, "onResponse: ");
            Utils.toast(getApplicationContext(),"Order success");
            onBackPressed();
            Utils.object = null;
            Utils.object2 = null;
            Utils.array = null;
        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG, "onFailure: ");
        }

        @Override
        public void onBodyError(ResponseBody responseBody) {
            Log.d(TAG, "onBodyError: ");
        }

        @Override
        public void onBodyErrorIsNull() {
            Log.d(TAG, "onBodyErrorIsNull: ");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        orderlist = (RecyclerView) findViewById(R.id.order);
        txttotal = (TextView) findViewById(R.id.totaltxt);
        pay = (Button) findViewById(R.id.pay);
        orderlist.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        orderlist.setLayoutManager(layoutManager);
        adapter = new BasketAdapter(Utils.order,getApplicationContext());
        orderlist.setAdapter(adapter);

        txttotal.setText(String.valueOf(gettotal())+" ฿");

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(Utils.Checklocation(getLocation().latitude,getLocation().longitude)){

                    if (Double.valueOf(Utils.user.getChecklogin().getCash())<gettotal()){
                        Utils.toast(getApplicationContext(),"กรุณาเติมเงินในระบบก่อนครับ");
                    }else {
                        connectManager.order(orderCallback,Utils.object.toString());
                    }
//                }
//                else{
//
//
//                    Utils.toast(getApplicationContext(),"ไม่สามารถสั่งได้ เนื่องจากอยุ่นอกพื้นที่");
//                }
            }
        });



    }

    public void addOn(View view){

        Utils.addup = true;

        onBackPressed();


    }
    public int gettotal(){
        int total = 0;
        for (int i = 0;i<Utils.order.getOrder().size();i++){
            total = total+  Integer.valueOf(Utils.order.getOrder().get(i).getTotal());
        }
        return total;
    }

//    public LatLng getLocation() {
//
//        LocationManager locationManager = (LocationManager) BasketActivity.this.getSystemService(Context.LOCATION_SERVICE);
//        if (ActivityCompat.checkSelfPermission(BasketActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(BasketActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//        }
//
//        Location location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
//
//        double lng = location.getLongitude();
//
//        double lat = location.getLatitude();
//
//        LatLng myLocation = new LatLng(lat, lng);
//
//
//        return myLocation;
//
//    }


}
