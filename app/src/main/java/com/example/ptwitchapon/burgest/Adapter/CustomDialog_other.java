package com.example.ptwitchapon.burgest.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.Model.Order;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Killy77 on 27/4/2561.
 */

public class CustomDialog_other extends Dialog implements View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;
    TextView name,price;
    ImageView proImg;
    String sauce;
    EditText qty;
    RadioButton r1,r2,r3,r4;
    Product.ProductBean.BurgurBean products;
    public CustomDialog_other(Activity a, Product.ProductBean.BurgurBean products) {
        super(a);
        // TODO Auto-generated constructor stub
        this.products = products;
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.from_other);
        yes = (Button) findViewById(R.id.btn_ok);
        no = (Button) findViewById(R.id.btn_cancel);
        proImg = (ImageView) findViewById(R.id.proImg);
        name = (TextView) findViewById(R.id.name);
        price = (TextView) findViewById(R.id.price) ;
        qty = (EditText) findViewById(R.id.qty);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);
        name.setText(products.getProductName());
        price.setText(products.getPrice()+ " ฿");
        Picasso.with(c)
                .load(Utils.ipPic + products.getPath())
                .into(proImg);
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
                    int total = Integer.valueOf(qty.getText().toString())*Integer.valueOf(products.getPrice());
                    Utils.object2.put("total", String.valueOf(total));
                    Utils.object2.put("id_promotion", "1");
                    Utils.object2.put("sauce", getsauce());

                    Utils.orderbean.setId_product(products.getId_product());
                    Utils.orderbean.setPrice(products.getPrice());
                    Utils.orderbean.setQty(qty.getText().toString());
                    Utils.orderbean.setTotal(String.valueOf(total));
                    Utils.orderbean.setId_promotion("1");
                    Utils.orderbean.setSauce(getsauce());

                    Utils.orderbanlist.add(Utils.orderbean);

                    Utils.orderbean = new Order.OrderBean();

                    Log.d("TestJson", Utils.object2.toString());
                    Utils.toast(c, Utils.object2.toString());
                    Utils.array.put(Utils.arrayindex, Utils.object2);
                    Utils.object.put("id_member", Utils.user.getChecklogin().getId_member());
                    Utils.object.putOpt("order", Utils.array);

                    Utils.arrayindex++;
                    Utils.object2 = new JSONObject();
                    Log.d("TestJson", "other: " + Utils.object);
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
    public String getsauce(){
        if (r1.isChecked()){
            sauce = r1.getText().toString();
        }
        if (r2.isChecked()){
            sauce = r2.getText().toString();
        }
        if (r3.isChecked()){
            sauce = r3.getText().toString();
        }
        if (r4.isChecked()){
            sauce = r4.getText().toString();
        }
        return sauce;
    }
}