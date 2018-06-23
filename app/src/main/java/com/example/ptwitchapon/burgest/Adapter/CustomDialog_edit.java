package com.example.ptwitchapon.burgest.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
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

/**
 * Created by Killy77 on 27/4/2561.
 */

public class CustomDialog_edit extends Dialog implements View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;
    int position;
    String sauce;
    CheckBox c1, c2, c3, c4;
    String veg;
    TextView name, price;
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

        name.setText(getname(orderBean.getId_product()));
        price.setText(orderBean.getPrice() + " ฿");
        qty.setText(orderBean.getQty());


        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
                int total = Integer.valueOf(qty.getText().toString()) * Integer.valueOf(orderBean.getPrice());
                Utils.orderbean.setTotal(String.valueOf(total));
                Utils.orderbean.setId_promotion("1");
                Utils.orderbean.setComment(comment.getText().toString());
                Utils.orderbean.setSauce(getsauce());
                Utils.orderbean.setVeg(getVeg());
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

        if (c1.isChecked()) {
            add.append(c1.getText().toString());
        }
        if (c2.isChecked()) {
            add.append(" " + c2.getText().toString());
        }
        if (c3.isChecked()) {
            add.append(" " + c3.getText().toString());
        }
        if (c4.isChecked()) {
            add.append(" " + c4.getText().toString());
        }
        veg = add.toString();
        return veg;
    }

    public String getname(String name) {
        String productname = null;

        switch (name) {
            case "1":
                productname = "CHICKEN";
                break;
            case "2":
                productname = "CHICKEN EGG";
                break;
            case "3":
                productname = "CHICKEN CHEESE";
                break;
            case "4":
                productname = "CHICKEN CHEESE BACON";
                break;
            case "5":
                productname = "CHICKEN CHEESE BACON EGG";
                break;
            case "6":
                productname = "FISH";
                break;
            case "7":
                productname = "FISH EGG";
                break;
            case "8":
                productname = "FISH CHEESE";
                break;
            case "9":
                productname = "FISH CHEESE EGG";
                break;
            case "10":
                productname = "FISH CHEESE BACON";
                break;
            case "11":
                productname = "BEEF LARGE";
                break;
            case "12":
                productname = "BEEF LARGE CHEESE";
                break;
            case "13":
                productname = "BEEF LARGE BACON";
                break;
            case "14":
                productname = "BEEF LARGE DOUBLE CHEESE";
                break;
            case "15":
                productname = "BEEF LARGE CHEESE BACON";
                break;
            case "16":
                productname = "BEEF LARGE CHEESE BACON EGG";
                break;
            case "17":
                productname = "DUBLE BEEF";
                break;
            case "18":
                productname = "DUBLE BEEF DUBLE CHEESE";
                break;
            case "19":
                productname = "DUBLE BEEF DUBLE CHEESE BACON";
                break;
            case "20":
                productname = "BEEF";
                break;
            case "21":
                productname = "BEEF CHEESE";
                break;
            case "22":
                productname = "BEEF CHEESE BACON";
                break;
            case "23":
                productname = "PORK";
                break;
            case "24":
                productname = "PORK EGG";
                break;
            case "25":
                productname = "PORK CHEESE";
                break;
            case "26":
                productname = "PORK BACON";
                break;
            case "27":
                productname = "PORK CHEESE EGG";
                break;
            case "28":
                productname = "PORK CHEESE BACON";
                break;
            case "29":
                productname = "DUBLE PORK";
                break;
            case "30":
                productname = "PORK CHEESE BACON EGG";
                break;
            case "31":
                productname = "DUBLE PORK DUBLE CHEESE";
                break;
            case "32":
                productname = "DUBLE PORK DUBLE CHEESE BACON";
                break;
            case "33":
                productname = "SPICY";
                break;
            case "34":
                productname = "SPICY CHEESE";
                break;
            case "35":
                productname = "FRENFRIED SMALL";
                break;
            case "36":
                productname = "FRENFRIED MEDIUM";
                break;
            case "37":
                productname = "FRENFRIED LARGE";
                break;
            case "38":
                productname = "KARA-AGE";
                break;
            case "39":
                productname = "CHEESE BALL";
                break;
            case "40":
                productname = "COKE MEDIUM";
                break;
            case "41":
                productname = "COKE SMALL";
                break;
            case "42":
                productname = "SPRITE MEDIUM";
                break;
            case "43":
                productname = "SPRITE SMALL";
                break;
            case "44":
                productname = "WATER MEDIUM";
                break;
            case "45":
                productname = "WATER SMALL";
                break;
            case "46":
                productname = "SET A BEEF LARGE CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "47":
                productname = "SET B PORK CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "48":
                productname = "SET C CHICKEN CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "49":
                productname = "SET D SPICY CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "50":
                productname = "SET E FISH CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
        }

        return productname;
    }
}