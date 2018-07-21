package com.example.ptwitchapon.burgest.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.BasketActivity;
import com.example.ptwitchapon.burgest.Callback.ProductCallback;
import com.example.ptwitchapon.burgest.Model.Order;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.Model.ProductModel;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.okhttp.ResponseBody;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit.Retrofit;



/**
 * Created by Killy77 on 27/4/2561.
 */

public class CustomDialog_water_edit extends Dialog implements View.OnClickListener {

    public Activity c;
    public Dialog d;
    int position;
    TextView name,price;
    ImageView proImg;
    public Button yes, no ,add,del;
    String sauce,q;
    int  qtyp,p,total;
    EditText qty;
    Order.OrderBean orderBean;
    ConnectManager connect = new ConnectManager();
    ProductCallback callback = new ProductCallback() {
        @Override
        public void onResponse(ProductModel productModel, Retrofit retrofit) {
            name.setText(productModel.getProduct().get(0).getProductName());
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
    public CustomDialog_water_edit(Activity a, Order.OrderBean orderBean, int position) {
        super(a);
        // TODO Auto-generated constructor stub
        this.orderBean = orderBean;
        this.position = position;
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.from_water);
        yes = (Button) findViewById(R.id.btn_ok);
        add = (Button) findViewById(R.id.add);
        del = (Button) findViewById(R.id.del);
        no = (Button) findViewById(R.id.btn_cancel);
        proImg = (ImageView) findViewById(R.id.proImg);
        name = (TextView) findViewById(R.id.name);
        price = (TextView) findViewById(R.id.price) ;
        qty = (EditText) findViewById(R.id.qty);
        connect.getProduct(callback,orderBean.getId_product());
        qty.setText(orderBean.getQty());
        q = qty.getText().toString();
        qtyp = Integer.valueOf(q);
        p = Integer.valueOf(orderBean.getPrice());
        connect.getProduct(callback,orderBean.getId_product());
        total = Integer.valueOf(p * qtyp);

        setAlltext();
        qty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String a;
                if (charSequence.toString().isEmpty()) {
                    charSequence = "0";
                    a = String.valueOf(charSequence);
                    q = a;
                    qtyp = Integer.valueOf(q);
                    total = qtyp * p;
                    setAlltext();
                } else {
                    a = String.valueOf(charSequence);
                    q = a;
                    qtyp = Integer.valueOf(q);
                    total = qtyp * p;
                    setAlltext();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        Picasso.with(c)
                .load(Utils.ipPic + orderBean.getPath())
                .into(proImg);

        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        add.setOnClickListener(this);
        del.setOnClickListener(this);

    }

    public void setAlltext() {
        price.setText(total + " ฿");
        qtyp = Integer.valueOf(q);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                qtyp = qtyp +1;
                qty.setText(String.valueOf(qtyp));
                break;
            case R.id.del:
                qtyp = qtyp -1;
                qty.setText(String.valueOf(qtyp));
                break;
            case R.id.btn_ok:
                Utils.orderbean = new Order.OrderBean();

                Utils.orderbean.setId_product(orderBean.getId_product());
                Utils.orderbean.setPrice(orderBean.getPrice());
                Utils.orderbean.setQty(qty.getText().toString());
                int total = Integer.valueOf(qty.getText().toString()) * Integer.valueOf(orderBean.getPrice());
                Utils.orderbean.setTotal(String.valueOf(total));
                Utils.orderbean.setId_promotion("1");
                Utils.orderbean.setPath(orderBean.getPath());
                Utils.orderbanlist.set(position,Utils.orderbean);

                c.startActivity(new Intent(c,BasketActivity.class));
                c.finish();
                break;
            case R.id.btn_cancel:
                dismiss();
                break;
            default:
                break;
        }

    }
}