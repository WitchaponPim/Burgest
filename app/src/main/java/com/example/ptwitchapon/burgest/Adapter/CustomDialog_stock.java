package com.example.ptwitchapon.burgest.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.Callback.UpdateStockCallback;
import com.example.ptwitchapon.burgest.Model.Order;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.Model.StockModel;
import com.example.ptwitchapon.burgest.Model.UpdateStockResponse;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.okhttp.ResponseBody;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import retrofit.Retrofit;

/**
 * Created by Killy77 on 27/4/2561.
 */

public class CustomDialog_stock extends Dialog implements View.OnClickListener {

    public Activity c;
    private GoogleMap mMap;
    Button yes;
    TextView id,name;
    EditText exp,amount;
    LatLng latLng;
    StockModel stock;
    ConnectManager connectManager = new ConnectManager();
    UpdateStockCallback updateStockCallback = new UpdateStockCallback() {
        @Override
        public void onResponse(UpdateStockResponse response, Retrofit retrofit) {
            Utils.toast(getContext(),response.getUpdate().getDescription());
            dismiss();
        }

        @Override
        public void onFailure(Throwable t) {

        }

        @Override
        public void onBodyError(ResponseBody responseBody) {

        }

        @Override
        public void onBodyErrorIsNull() {

        }
    };

    public CustomDialog_stock(Activity a, StockModel stock) {
        super(a);
        // TODO Auto-generated constructor stub
        this.stock = stock;
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.form_map);
        yes = (Button) findViewById(R.id.btn_ok);
        id = (TextView) findViewById(R.id.ID);
        name = (TextView) findViewById(R.id.name);
        exp = (EditText) findViewById(R.id.exp);
        amount = (EditText) findViewById(R.id.amount);

        id.setText(stock.getStocks().get(0).getId_stock());
        name.setText(stock.getStocks().get(0).getName());



        yes.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                    connectManager.updatestock(updateStockCallback,id.getText().toString()
                            ,name.getText().toString()
                            ,amount.getText().toString()
                            ,exp.getText().toString());
                break;
            default:
                break;
        }
    }

}