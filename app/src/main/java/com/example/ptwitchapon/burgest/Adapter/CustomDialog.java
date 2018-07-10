package com.example.ptwitchapon.burgest.Adapter;

import android.app.Activity;
import android.app.Dialog;
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

import com.example.ptwitchapon.burgest.Model.Order;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Killy77 on 27/4/2561.
 */

public class CustomDialog extends Dialog implements View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;
    int p,exp;
    String sauce;
    CheckBox c1, c2, c3, c4,ex1,ex2,ex3;
    String veg,extra;
    TextView name, price;
    EditText qty, comment;
    RadioButton r1, r2, r3, r4;
    ImageView proImg;
    Product.ProductBean.BurgurBean products;
    //pap na

    public CustomDialog(Activity a, Product.ProductBean.BurgurBean products) {
        super(a);
        // TODO Auto-generated constructor stub
        this.products = products;
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.form_burger);
        yes = (Button) findViewById(R.id.btn_ok);
        no = (Button) findViewById(R.id.btn_cancel);
        proImg = (ImageView) findViewById(R.id.proImg);
        name = (TextView) findViewById(R.id.name);
        price = (TextView) findViewById(R.id.price);
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
        ex1 =(CheckBox) findViewById(R.id.ex1);
        ex2 =(CheckBox) findViewById(R.id.ex2);
        ex3 =(CheckBox) findViewById(R.id.ex3);

        name.setText(products.getProductName());
        p = Integer.valueOf(products.getPrice())+getexp();

        price.setText(String.valueOf(p) + " ฿");


        Picasso.with(c)
                .load(Utils.ipPic + products.getPath())
                .into(proImg);
        qty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String a;
                if (charSequence.toString().isEmpty()){
                    charSequence="0";
                    a = String.valueOf(charSequence);
                    p =(Integer.valueOf(a)*Integer.valueOf(products.getPrice()))+getexp();
                    price.setText(p+ " ฿");
                }else {
                    a = String.valueOf(charSequence);
                    p =(Integer.valueOf(a)*Integer.valueOf(products.getPrice()))+getexp();
                    price.setText(p+ " ฿");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
//        ex1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b){
//                    p = (Integer.valueOf(qty.getText().toString())*Integer.valueOf(products.getPrice()))+getexp();
//                    price.setText(String.valueOf(p) + " ฿");
//                }else {
//                    p = (Integer.valueOf(qty.getText().toString())*Integer.valueOf(products.getPrice()))+getexp();
//                    price.setText(String.valueOf(p) + " ฿");
//                }
//            }
//        });
//        ex2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b){
//                    p = (Integer.valueOf(qty.getText().toString())*Integer.valueOf(products.getPrice()))+getexp();
//                    price.setText(String.valueOf(p) + " ฿");
//                }else {
//                    p = (Integer.valueOf(qty.getText().toString())*Integer.valueOf(products.getPrice()))+getexp();
//                    price.setText(String.valueOf(p) + " ฿");
//                }
//            }
//        });
//        ex3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b){
//                    p = (Integer.valueOf(qty.getText().toString())*Integer.valueOf(products.getPrice()))+getexp();
//                    price.setText(String.valueOf(p) + " ฿");
//                }else {
//                    p = (Integer.valueOf(qty.getText().toString())*Integer.valueOf(products.getPrice()))+getexp();
//                    price.setText(String.valueOf(p) + " ฿");
//                }
//            }
//        });
//
//
//        qty.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            }
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                String a;
//                if (charSequence.toString().isEmpty()){
//                    charSequence="0";
//                    a = String.valueOf(charSequence);
//                    p =(Integer.valueOf(a)*Integer.valueOf(products.getPrice()))+getexp();
//                    price.setText(p+ " ฿");
//                }else {
//                    a = String.valueOf(charSequence);
//                    p =(Integer.valueOf(a)*Integer.valueOf(products.getPrice()))+getexp();
//                    price.setText(p+ " ฿");
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:

                try {
                    Utils.object2.put("id_product", products.getId_product());
                    Utils.object2.put("price", products.getPrice());
                    Utils.object2.put("qty", qty.getText().toString());
                    int total = Integer.valueOf(qty.getText().toString()) * Integer.valueOf(products.getPrice());
                    Utils.object2.put("total", String.valueOf(total));
                    Utils.object2.put("id_promotion", "1");
                    Utils.object2.put("comment", comment.getText().toString());
                    Utils.object2.put("sauce", getsauce());
                    Utils.object2.put("veg", getVeg());
                    Utils.object2.put("extra",getExtra());
                    Utils.object2.put("path",products.getPath());

                    Utils.orderbean.setId_product(products.getId_product());
                    Utils.orderbean.setPrice(products.getPrice());
                    Utils.orderbean.setQty(qty.getText().toString());
                    Utils.orderbean.setTotal(String.valueOf(total));
                    Utils.orderbean.setId_promotion("1");
                    Utils.orderbean.setComment(comment.getText().toString());
                    Utils.orderbean.setSauce(getsauce());
                    Utils.orderbean.setVeg(getVeg());
                    Utils.orderbean.setExtra(getExtra());
                    Utils.orderbean.setPath(products.getPath());


                    Utils.orderbanlist.add(Utils.orderbean);

                    Utils.orderbean = new Order.OrderBean();

                    Log.d("TestJson", Utils.object2.toString());
                    Utils.toast(c, Utils.object2.toString());
                    Utils.array.put(Utils.arrayindex, Utils.object2);

                    Utils.object.put("id_member", Utils.user.getChecklogin().getId_member());
                    Utils.object.putOpt("order", Utils.array);

                    Utils.arrayindex++;
                    Utils.object2 = new JSONObject();
                    Log.d("TestJson", "burger: " + Utils.object);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_cancel:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }

    public String getsauce() {
        if (r1.isChecked()) {
            sauce = r1.getText().toString();
        }
        if (r2.isChecked()) {
            sauce = r2.getText().toString();
        }
        if (r3.isChecked()) {
            sauce = r3.getText().toString();
        }
        if (r4.isChecked()) {
            sauce = r4.getText().toString();
        }
        return sauce;
    }

    public String getVeg() {
        StringBuffer add = new StringBuffer();
        boolean f =true;
        if (c1.isChecked()) {
            if (f){
                add.append(c1.getText().toString());
                f = false;
            }else {
                add.append("|" + c1.getText().toString());
            }
        }

        if (c2.isChecked()) {
            if (f){
                add.append(c2.getText().toString());
                f = false;
            }else {
                add.append("|" + c2.getText().toString());
            }
        }

        if (c3.isChecked()) {
            if (f){
                add.append(c3.getText().toString());
                f = false;
            }else {
                add.append("|" + c3.getText().toString());
            }
        }

        if (c4.isChecked()) {
            if (f){
                add.append(c4.getText().toString());
                f = false;
            }else {
                add.append("|" + c4.getText().toString());
            }
        }

        veg = add.toString();
        Log.d("Veg", "getVeg: "+veg);
        return veg;
    }

    public String getExtra() {
        StringBuffer add = new StringBuffer();
        boolean f =true;
        if (ex1.isChecked()) {
            if (f){
                add.append(ex1.getText().toString());
                f = false;
            }else {
                add.append("|" + ex1.getText().toString());
            }
        }

        if (ex2.isChecked()) {
            if (f){
                add.append(ex2.getText().toString());
                f = false;
            }else {
                add.append("|" + ex2.getText().toString());
            }
        }

        if (ex3.isChecked()) {
            if (f){
                add.append(ex3.getText().toString());
                f = false;
            }else {
                add.append("|" + ex3.getText().toString());
            }
        }

        extra = add.toString();
        Log.d("Veg", "getVeg: "+veg);
        return extra.replace(" 10฿","");
    }
    public int getexp(){
        if (ex1.isChecked()||ex2.isChecked()||ex3.isChecked()){
            if (ex1.isChecked()) {
                exp = 10;
            }

            if (ex2.isChecked()) {
                exp= 10;
            }

            if (ex3.isChecked()) {
                exp= 10;
            }

            if (ex1.isChecked()&&ex2.isChecked()) {
                exp = 20;
            }

            if (ex1.isChecked()&&ex3.isChecked()) {
                exp = 20;
            }

            if (ex2.isChecked()&&ex3.isChecked()) {
                exp = 20;
            }

            if (ex1.isChecked()&&ex2.isChecked()&&ex3.isChecked()) {
                exp = 30;
            }
        }else {
            exp =0;
        }




        return exp;
    }
}