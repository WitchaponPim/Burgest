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

import com.example.ptwitchapon.burgest.BasketActivity;
import com.example.ptwitchapon.burgest.Model.Order;
import com.example.ptwitchapon.burgest.Model.Orderlist_item;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Killy77 on 27/4/2561.
 */

public class CustomDialog_edit extends Dialog implements View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no,add,del;
    String[] extraarray;
    String[] vegarray;
    int p, exp, qtyp, total,position;
    String sauce;
    CheckBox c1, c2, c3, c4, ex1, ex2, ex3;
    String veg, extra, q;
    TextView name, price, txtextra, txttotal;
    EditText qty, comment;
    RadioButton r1, r2, r3, r4;
    ImageView proImg;
    Order.OrderBean orderBean;

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

        name.setText(getname(orderBean.getId_product()));


        Picasso.with(c)
                .load(Utils.ipPic + orderBean.getPath())
                .into(proImg);

        if(!orderBean.getComment().isEmpty()){
            comment.setText(orderBean.getComment());
        }

        if (!orderBean.getSauce().isEmpty()){
            switch (orderBean.getSauce()){
                case "tomato sauce":
                    r1.setChecked(true);
                    break;
                case "mayonnaise sauce":
                    r2.setChecked(true);
                    break;
                case "blackpaper sauce":
                    r3.setChecked(true);
                    break;
                case "thousand sauce":
                    r4.setChecked(true);
                    break;
            }

        }

        if (!orderBean.getExtra().isEmpty()){
            extraarray = orderBean.getExtra().split("\\|");
            for (int i=0;i<extraarray.length;i++){
                Log.d("EditDialog", "onCreate: "+extraarray[i]);
                switch (extraarray[i]){
                    case "Egg":
                        ex1.setChecked(true);
                        break;
                    case "Cheese":
                        ex2.setChecked(true);
                        break;
                    case "Bacon":
                        ex3.setChecked(true);
                        break;
                    default:
                        break;
                }
            }
        }
        if (!orderBean.getVeg().isEmpty()){
            vegarray = orderBean.getVeg().split("\\|");
            for (int i=0;i<vegarray.length;i++){
                Log.d("EditDialog", "onCreate: "+vegarray[i]);
                switch (vegarray[i]){
                    case "Onion":
                        c1.setChecked(true);
                        break;
                    case "Lettus":
                        c2.setChecked(true);
                        break;
                    case "Tomato":
                        c3.setChecked(true);
                        break;
                    case "Cucumber":
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
    public static String getname(String name) {
        String productname = null;

        switch (name) {
            case "10001":
                productname = "CHICKEN";
                break;
            case "10002":
                productname = "CHICKEN EGG";
                break;
            case "10003":
                productname = "CHICKEN CHEESE";
                break;
            case "10004":
                productname = "CHICKEN CHEESE BACON";
                break;
            case "10005":
                productname = "CHICKEN CHEESE BACON EGG";
                break;
            case "10006":
                productname = "FISH";
                break;
            case "10007":
                productname = "FISH EGG";
                break;
            case "10008":
                productname = "FISH CHEESE";
                break;
            case "10009":
                productname = "FISH CHEESE EGG";
                break;
            case "10010":
                productname = "FISH CHEESE BACON";
                break;
            case "10011":
                productname = "BEEF LARGE";
                break;
            case "10012":
                productname = "BEEF LARGE CHEESE";
                break;
            case "10013":
                productname = "BEEF LARGE BACON";
                break;
            case "10014":
                productname = "BEEF LARGE DOUBLE CHEESE";
                break;
            case "10015":
                productname = "BEEF LARGE CHEESE BACON";
                break;
            case "10016":
                productname = "BEEF LARGE CHEESE BACON EGG";
                break;
            case "10017":
                productname = "DUBLE BEEF";
                break;
            case "10018":
                productname = "DUBLE BEEF DUBLE CHEESE";
                break;
            case "10019":
                productname = "DUBLE BEEF DUBLE CHEESE BACON";
                break;
            case "10020":
                productname = "BEEF";
                break;
            case "10021":
                productname = "BEEF CHEESE";
                break;
            case "10022":
                productname = "BEEF CHEESE BACON";
                break;
            case "10023":
                productname = "PORK";
                break;
            case "10024":
                productname = "PORK EGG";
                break;
            case "10025":
                productname = "PORK CHEESE";
                break;
            case "10026":
                productname = "PORK BACON";
                break;
            case "10027":
                productname = "PORK CHEESE EGG";
                break;
            case "10028":
                productname = "PORK CHEESE BACON";
                break;
            case "10029":
                productname = "DUBLE PORK";
                break;
            case "10030":
                productname = "PORK CHEESE BACON EGG";
                break;
            case "10031":
                productname = "DUBLE PORK DUBLE CHEESE";
                break;
            case "10032":
                productname = "DUBLE PORK DUBLE CHEESE BACON";
                break;
            case "10033":
                productname = "SPICY";
                break;
            case "10034":
                productname = "SPICY CHEESE";
                break;
            case "10035":
                productname = "FRENFRIED SMALL";
                break;
            case "10036":
                productname = "FRENFRIED MEDIUM";
                break;
            case "10037":
                productname = "FRENFRIED LARGE";
                break;
            case "10038":
                productname = "KARA-AGE";
                break;
            case "10039":
                productname = "CHEESE BALL";
                break;
            case "10040":
                productname = "COKE MEDIUM";
                break;
            case "10041":
                productname = "COKE SMALL";
                break;
            case "10042":
                productname = "SPRITE MEDIUM";
                break;
            case "10043":
                productname = "SPRITE SMALL";
                break;
            case "10044":
                productname = "WATER MEDIUM";
                break;
            case "10045":
                productname = "WATER SMALL";
                break;
            case "10046":
                productname = "SET A BEEF LARGE CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "10047":
                productname = "SET B PORK CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "10048":
                productname = "SET C CHICKEN CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "10049":
                productname = "SET D SPICY CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "10050":
                productname = "SET E FISH CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
        }

        return productname;
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