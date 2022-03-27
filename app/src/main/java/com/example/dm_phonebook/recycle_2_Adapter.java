package com.example.dm_phonebook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycle_2_Adapter extends RecyclerView.Adapter<recycle_2_Adapter.ViewHolder> {
    ArrayList<recycle_2_data> recycle_2_dataList;
    Context context;
    private recycle_2_Adapter.RecyclerViewClickListener listener2;
    public recycle_2_Adapter(ArrayList<recycle_2_data> recycle_2_data, Sub_Activity activity, recycle_2_Adapter.RecyclerViewClickListener listener2){
        this.recycle_2_dataList = recycle_2_data;
        this.context = activity;
        this.listener2 = listener2;
    }
    @NonNull
    @Override
    public recycle_2_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_layout_2,parent,false);
        recycle_2_Adapter.ViewHolder viewHolder = new recycle_2_Adapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull recycle_2_Adapter.ViewHolder holder, int position) {
        final  recycle_2_data recycle_2_data_list = recycle_2_dataList.get(position);
        holder.contact_text_view_2.setText(recycle_2_data_list.getContact_name_2());
        holder.contact_image_view_2.setImageResource(recycle_2_data_list.getContact_image_2());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context,recycle_2_data_list.getContact_name_2(),Toast.LENGTH_SHORT).show();
////                Intent intent = new Intent(context,Sub_Activity.class);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return recycle_2_dataList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v,int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView contact_image_view_2;
        TextView contact_text_view_2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contact_text_view_2 = itemView.findViewById(R.id.contact_text_2);
            contact_image_view_2 = itemView.findViewById(R.id.contact_image_view_2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener2.onClick(view,getAdapterPosition());
        }
    }
}
