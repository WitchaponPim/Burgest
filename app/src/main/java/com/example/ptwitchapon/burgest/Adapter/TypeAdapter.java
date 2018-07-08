package com.example.ptwitchapon.burgest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Witchapon on 9/4/2561.
 */

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.MenuViewHolder> {


    TypeAdapter.OnItemClickListener listener;
    List<String> menu = new ArrayList<>();
    Context context;
    public interface OnItemClickListener {
        void onItemClick(int position, String menu);
    }

    @Override
    public TypeAdapter.MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_row, parent, false);
        return new TypeAdapter.MenuViewHolder(v);
    }

    public TypeAdapter(Context context, TypeAdapter.OnItemClickListener listener) {
        menu.add("Member");
        menu.add("Driver");
        menu.add("Manager");
        this.context = context;
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(TypeAdapter.MenuViewHolder holder, int position) {
        holder.setMenu(menu,position);
        holder.setIsRecyclable(false);
    }


    @Override
    public int getItemCount() {
        return menu.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        public Button name;
        public MenuViewHolder(View itemView) {
            super(itemView);
            name = (Button) itemView.findViewById(R.id.name) ;
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(getAdapterPosition(),menu.get(getAdapterPosition()));
                }
            });

        }

        public void setMenu(final List<String> menu,int position){
            name.setText(menu.get(position));
        }
    }
}
