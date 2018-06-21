package com.example.ptwitchapon.burgest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.API.ConnectManager;

import com.example.ptwitchapon.burgest.Model.TopupModel;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Killy77 on 21/4/2561.
 */

public class TopupStatusAdapter extends RecyclerView.Adapter<TopupStatusAdapter.FollowViewHolder> {

    String TAG = "Listview";

    TopupStatusAdapter.OnItemClickListener listener;
    List<TopupModel.ItemsBean> item = new ArrayList<>();

    private Context context;
    ConnectManager connectManager = new ConnectManager();
    private static int currentPosition = 0;

    public TopupStatusAdapter(Context context, List<TopupModel.ItemsBean> item, TopupStatusAdapter.OnItemClickListener listener) {
        this.item = item;
        this.context = context;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(List<TopupModel.ItemsBean> item, int position);
    }

    @Override
    public FollowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.topup_list, parent, false);
        return new FollowViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FollowViewHolder holder, final int position) {
        TopupModel.ItemsBean items = item.get(position);
        holder.textAmount.setText(items.getCash());
        holder.textDate.setText(items.getDate());
        holder.status.setText(getStatus(items.getId_topupstatus()));
        holder.status.setBackgroundResource(getcolor(items.getId_topupstatus()));
        Picasso.with(context).load(Utils.ipTopupPic + items.getPicture()).into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    class FollowViewHolder extends RecyclerView.ViewHolder {
        TextView textAmount, textDate, status;
        ImageView pic;

        FollowViewHolder(View itemView) {
            super(itemView);
            pic = (ImageView) itemView.findViewById(R.id.pic);
            textAmount = (TextView) itemView.findViewById(R.id.amount);
            textDate = (TextView) itemView.findViewById(R.id.date);
            status = (TextView) itemView.findViewById(R.id.status);
        }
    }

    public String getStatus(String status) {
        String name = null;

        switch (status) {
            case "1":
                name = "รอการอนุมัติ";
                break;
            case "2":
                name = "ดำเนินการเสร็จสิ้น";
                break;
            case "3":
                name = "ไม่อนุมัติการเติมเงิน";
                break;
        }
        return name;
    }

    public int getcolor(String status) {
//        int colorres = 0;
//
//        switch (status){
//            case "รอการอนุมัติ":
//                colorres = R.color.colorS1;
//                break;
//            case "ยืนยันการสั่งวื้อ":
//                colorres = R.color.colorS2;
//                break;
//        }
//
//        return colorres;
//    }
        int colorres = 0;
        switch (status) {
            case "1":
                colorres = R.color.colorS2;
                break;
            case "2":
                colorres = R.color.colorS1;
                break;
            case "3":
                colorres = R.color.colorS4;
                break;
        }
        return colorres;
    }
}