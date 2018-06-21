package com.example.ptwitchapon.burgest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.picasso.Picasso;

/**
 * Created by Killy77 on 21/4/2561.
 */

public class Basket2Adapter extends RecyclerView.Adapter<Basket2Adapter.FollowViewHolder> {


    Product.ProductBean products;
    private Context context;

    private static int currentPosition = 0;

    public Basket2Adapter(Product.ProductBean products, Context context) {
        this.products = products;
        this.context = context;
    }

    @Override
    public FollowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.basket_detail, parent, false);
        return new FollowViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FollowViewHolder holder, final int position) {
        Product.ProductBean.BurgurBean burgurBean = products.getBurgur().get(position);
        holder.textViewName.setText(burgurBean.getProductName());
        holder.price.setText(burgurBean.getPrice());
        holder.Pname.setText(burgurBean.getTypeName());
//        holder.textViewRealName.setText(Follow.getRealName());
//        holder.textViewTeam.setText(Follow.getTeam());
//        holder.textViewFirstAppearance.setText(Follow.getFirstAppearance());
//        holder.textViewCreatedBy.setText(Follow.getCreatedBy());
//        holder.textViewPublisher.setText(Follow.getPublisher());
//        holder.textViewBio.setText(Follow.getBio().trim());
//
        Picasso.with(context).load(Utils.ipPic+products.getBurgur().get(position).getPath()).into(holder.imageView);
        holder.linearLayout.setVisibility(View.GONE);

        //if the position is equals to the item position which is to be expanded
        if (currentPosition == position) {
            //creating an animation
            Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.animation);

            //toggling visibility
            holder.linearLayout.setVisibility(View.VISIBLE);

            //adding sliding effect
            holder.linearLayout.startAnimation(slideDown);
        }

        holder.textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting the position of the item to expand it
                currentPosition = position;

                //reloding the list
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.getBurgur().size();
    }

    class FollowViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName,price,Pname;
        ImageView imageView;
        LinearLayout linearLayout;

        FollowViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.ordername);
            Pname = (TextView) itemView.findViewById(R.id.typename);
            price = (TextView) itemView.findViewById(R.id.price);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}