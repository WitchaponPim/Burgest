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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.BasketActivity;
import com.example.ptwitchapon.burgest.Callback.ProductCallback;
import com.example.ptwitchapon.burgest.Model.Order;
import com.example.ptwitchapon.burgest.Model.Orderlist_item;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.Model.ProductModel;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.okhttp.ResponseBody;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit.Retrofit;

/**
 * Created by Killy77 on 27/4/2561.
 */

public class CustomDialog_edit extends Dialog implements View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no,add,del;
    List<String> extraarray;
    List<String> vegarray;
    int p, exp, qtyp, total,position;
    String sauce;
    CheckBox c1, c2, c3, c4, ex1, ex2, ex3;
    String veg, extra, q;
    TextView name, price, txtextra, txttotal;
    EditText qty, comment;
    RadioButton r1, r2, r3, r4;
    ImageView proImg;
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


    public CustomDialog_edit(Activity a, Order.OrderBean orderBean, int position) {
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
        setContentView(R.layout.form_burger);
        yes = (Button) findViewById(R.id.btn_ok);
        no = (Button) findViewById(R.id.btn_cancel);
        add= (Button) findViewById(R.id.add);
        del = (Button) findViewById(R.id.del);
        proImg = (ImageView) findViewById(R.id.proImg);
        name = (TextView) findViewById(R.id.name);
        price = (TextView) findViewById(R.id.price);
        txtextra = (TextView) findViewById(R.id.extra);
        txttotal = (TextView) findViewById(R.id.totalprice);
        qty = (EditText) findViewById(R.id.qty);
        comment = (EditText) findViewById(R.id.comment);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);
        c1 = (CheckBox) findViewById(R.id.c1);
        c2 = (CheckBox) findViewById(R.id.c2);
        c3 = (CheckBox) findViewById(R.id.c3);
        c4 = (CheckBox) findViewById(R.id.c4);
        ex1 = (CheckBox) findViewById(R.id.ex1);
        ex2 = (CheckBox) findViewById(R.id.ex2);
        ex3 = (CheckBox) findViewById(R.id.ex3);

        c1.setChecked(false);
        c2.setChecked(false);
        c3.setChecked(false);
        c4.setChecked(false);

        qty.setText(orderBean.getQty());
        q = qty.getText().toString();
        qtyp = Integer.valueOf(q);
        p = Integer.valueOf(orderBean.getPrice());
        total = Integer.valueOf(p * qtyp);

        connect.getProduct(callback,orderBean.getId_product());

        Picasso.with(c)
                .load(Utils.ipPic + orderBean.getPath())
                .into(proImg);

        if(!orderBean.getComment().isEmpty()){
            comment.setText(orderBean.getComment());
        }

        if (!orderBean.getSauce().isEmpty()){
            switch (orderBean.getSauce()){
                case "20024":
                    r1.setChecked(true);
                    break;
                case "20025":
                    r2.setChecked(true);
                    break;
                case "20027":
                    r3.setChecked(true);
                    break;
                case "20026":
                    r4.setChecked(true);
                    break;
            }

        }

        if (!orderBean.getExtra().isEmpty()){
            extraarray = orderBean.getExtra();
            for (int i=0;i<extraarray.size();i++){
                switch (extraarray.get(i)){
                    case "20007":
                        ex1.setChecked(true);
                        break;
                    case "20008":
                        ex2.setChecked(true);
                        break;
                    case "20009":
                        ex3.setChecked(true);
                        break;
                    default:
                        break;
                }
            }
        }
        if (!orderBean.getVeg().isEmpty()){
            vegarray = orderBean.getVeg();
            for (int i=0;i<vegarray.size();i++){
                switch (vegarray.get(i)){
                    case "20013":
                        c1.setChecked(true);
                        break;
                    case "20011":
                        c2.setChecked(true);
                        break;
                    case "20012":
                        c3.setChecked(true);
                        break;
                    case "20014":
                        c4.setChecked(true);
                        break;
                    default:
                        break;
                }
            }
        }
        qty.setText(orderBean.getQty());
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
        setAlltext();
        ex1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                setAlltext();
            }
        });
        ex2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                setAlltext();
            }
        });
        ex3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                setAlltext();
            }
        });

        add.setOnClickListener(this);
        del.setOnClickListener(this);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }

    public void setAlltext() {
        price.setText(total + " ฿");
        qtyp = Integer.valueOf(q);
        exp = getexp() * qtyp;
        if (ex1.isChecked() || ex2.isChecked() || ex3.isChecked()) {
            txtextra.setVisibility(View.VISIBLE);
            txtextra.setText(" + " + exp + " ฿");
            txttotal.setText(String.valueOf(total + exp) + " ฿");
        } else {
            txtextra.setVisibility(View.GONE);
            txttotal.setVisibility(View.GONE);
        }


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
                //                Utils.object2.put("id_product", orderBean.getId_product());
//                Utils.object2.put("price", orderBean.getPrice());
//                Utils.object2.put("qty", qty.getText().toString());

//                Utils.object2.put("total", String.valueOf(total));
//                Utils.object2.put("id_promotion", "1");
//                Utils.object2.put("comment", comment.getText().toString());
//                Utils.object2.put("sauce", getsauce());
//                Utils.object2.put("veg", getVeg());
                Utils.orderbean = new Order.OrderBean();

                Utils.orderbean.setId_product(orderBean.getId_product());
                Utils.orderbean.setPrice(orderBean.getPrice());
                Utils.orderbean.setQty(qty.getText().toString());
                Utils.orderbean.setTotal(String.valueOf(total+exp));
                Utils.orderbean.setId_promotion("1");
                Utils.orderbean.setComment(comment.getText().toString());
                Utils.orderbean.setSauce(getsauce());
                Utils.orderbean.setVeg(getVeg());
                Utils.orderbean.setExtra(getExtra());
                Utils.orderbean.setPath(orderBean.getPath());

//                Utils.orderbean.setId_product(products.getId_product());
//                Utils.orderbean.setPrice(products.getPrice());
//                Utils.orderbean.setQty(qty.getText().toString());
//                Utils.orderbean.setTotal(String.valueOf(total+exp));
//                Utils.orderbean.setId_promotion("1");
//                Utils.orderbean.setComment(comment.getText().toString());
//                Utils.orderbean.setSauce(getsauce());
//                Utils.orderbean.setVeg(getVeg());
//                Utils.orderbean.setExtra(getExtra());
//                Utils.orderbean.setPath(products.getPath());

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

    public String getsauce() {
        if (r1.isChecked()) {
            sauce = "20024";
        }
        if (r2.isChecked()) {
            sauce = "20025";
        }
        if (r3.isChecked()) {
            sauce = "20027";
        }
        if (r4.isChecked()) {
            sauce = "20026";
        }
        return sauce;
    }

    public List<String> getVeg() {
        List<String> veg = new ArrayList<>();
        if (c1.isChecked()) {
            veg.add("20013");
        }

        if (c2.isChecked()) {
            veg.add("20011");
        }

        if (c3.isChecked()) {
            veg.add("20012");
        }

        if (c4.isChecked()) {
            veg.add("20014");
        }
        Log.d("Veg", "getVeg: " + veg.size());
        return veg;
    }

    public List<String> getExtra() {
        List<String> ex = new ArrayList<>();
        if (ex1.isChecked()) {
            ex.add("20007");
        }

        if (ex2.isChecked()) {
            ex.add("20008");
        }

        if (ex3.isChecked()) {
            ex.add("20009");
        }
        return ex;
    }

    public int getexp() {
        if (ex1.isChecked() || ex2.isChecked() || ex3.isChecked()) {
            txttotal.setVisibility(View.VISIBLE);
            if (ex1.isChecked()) {
                exp = 10;
            }

            if (ex2.isChecked()) {
                exp = 10;
            }

            if (ex3.isChecked()) {
                exp = 10;
            }

            if (ex1.isChecked() && ex2.isChecked()) {
                exp = 20;
            }

            if (ex1.isChecked() && ex3.isChecked()) {
                exp = 20;
            }

            if (ex2.isChecked() && ex3.isChecked()) {
                exp = 20;
            }

            if (ex1.isChecked() && ex2.isChecked() && ex3.isChecked()) {
                exp = 30;
            }

        } else {
            exp = 0;
//            txttotal.setVisibility(View.GONE);
        }


        return exp;
    }

}