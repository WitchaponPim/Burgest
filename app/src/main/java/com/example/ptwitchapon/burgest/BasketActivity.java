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
import com.example.ptwitchapon.burgest.Adapter.CustomDialog;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_edit;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_other;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_other_edit;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_water;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_water_edit;
import com.example.ptwitchapon.burgest.Callback.OrderCallback;
import com.example.ptwitchapon.burgest.Callback.OrderList_ItemCallback;
import com.example.ptwitchapon.burgest.Model.Order;
import com.example.ptwitchapon.burgest.Model.OrderResponse;
import com.example.ptwitchapon.burgest.Model.Orderlist;
import com.example.ptwitchapon.burgest.Model.Orderlist_item;
import com.example.ptwitchapon.burgest.Tool.GPSTracker;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit.Retrofit;

public class BasketActivity extends AppCompatActivity {
    RecyclerView orderlist;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private static final int REQUEST_LOCATION = 1;

    LocationManager locationManager;
    StringBuffer sb;
    TextView txttotal;
    String id_promotion = "0";
    String TAG = "Basket";
    Button pay,scan;
    ConnectManager connectManager = new ConnectManager();
    OrderCallback orderCallback = new OrderCallback() {
        @Override
        public void onResponse(OrderResponse orderResponse, Retrofit retrofit) {
            Utils.object = new JSONObject();
            Utils.object2 = new JSONObject();
            Utils.array = new JSONArray();
            Utils.orderbanlist = new ArrayList<>();
            Utils.order = new Order();
            Utils.toast(getApplicationContext(), orderResponse.getDescription());
            onBackPressed();
        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG, "onFailure: ");
        }

        @Override
        public void onBodyError(ResponseBody responseBody) {
            Log.d(TAG, "onBodyError: " + responseBody.toString());
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
        scan = (Button) findViewById(R.id.scan) ;

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new IntentIntegrator(BasketActivity.this).initiateScan();
            }
        });

        orderlist.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        orderlist.setLayoutManager(layoutManager);
        adapter = new BasketAdapter(Utils.order, getApplicationContext(), this, new BasketAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Order.OrderBean orderlist, int position) {
                Utils.toast(getApplicationContext(), orderlist.getId_product());
                if (Integer.valueOf(orderlist.getId_product()) >= 10035 && Integer.valueOf(orderlist.getId_product()) <= 10039) {
                    CustomDialog_other_edit other = new CustomDialog_other_edit(BasketActivity.this, orderlist, position);
                    other.show();
                } else if (Integer.valueOf(orderlist.getId_product()) >= 10040 && Integer.valueOf(orderlist.getId_product()) <= 10045) {
                    CustomDialog_water_edit water = new CustomDialog_water_edit(BasketActivity.this, orderlist, position);
                    water.show();
                } else {
                    CustomDialog_edit cdd = new CustomDialog_edit(BasketActivity.this, orderlist, position);
                    cdd.show();
                }
            }
        });
        orderlist.setAdapter(adapter);

        txttotal.setText(String.valueOf(gettotal()) + " ฿");


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Utils.Checklocation(getLocation().latitude, getLocation().longitude)) {
                    if (Double.valueOf(Utils.user.getChecklogin().getCash()) < gettotal()) {
                        Utils.toast(getApplicationContext(), "กรุณาเติมเงินในระบบก่อนครับ");
                    } else {
                        Gson g = new Gson();
                        String jsonString = g.toJson(Utils.order.getOrder());
                        sb = new StringBuffer("{\"order\":");
                        sb.append(jsonString);
                        sb.append(",\"id_member\":\"" + Utils.user.getChecklogin().getId_member() + "\",\"lat\":\"" + Utils.lat1 + "\",\"lng\":\"" + Utils.lng1 + "\",\"id_promotion\":\"" + id_promotion + "\"}");
                        Log.d("Ammy", "onCreate: " + sb.toString());
                        connectManager.order(orderCallback, sb.toString());
                    }
                } else {
                    Utils.toast(getApplicationContext(), "ไม่สามารถสั่งได้ เนื่องจากอยุ่นอกพื้นที่");
                }
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void addOn(View view) {

        Utils.addup = true;

        onBackPressed();

    }

    public static int gettotal() {
        int total = 0;
        for (int i = 0; i < Utils.order.getOrder().size(); i++) {
            total = total + Integer.valueOf(Utils.order.getOrder().get(i).getTotal());
        }
        return total;
    }

    public LatLng getLocation() {

        LocationManager locationManager = (LocationManager) BasketActivity.this.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(BasketActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(BasketActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }
        Location location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        double lng = location.getLongitude();
        double lat = location.getLatitude();
        LatLng myLocation = new LatLng(lat, lng);


        return myLocation;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Log.d("Ammy", "fail ");
            } else {

                Log.d("Ammy", "onActivityResult: "+result.getContents());
                    id_promotion = result.getContents();

            }
        }

    }
}
