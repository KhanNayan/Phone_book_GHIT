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

public class recycle_1_Adapter  extends RecyclerView.Adapter<recycle_1_Adapter.ViewHolder>{
    recycle_1_data[] recycle_1_data;
    Context context;
    private RecyclerViewClickListener listener;

    public recycle_1_Adapter(recycle_1_data[] recycle_1_data,MainActivity activity, RecyclerViewClickListener listener){
        this.recycle_1_data = recycle_1_data;
        this.context = activity;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_layout_1,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final  recycle_1_data recycle_1_data_list = recycle_1_data[position];
        holder.contact_text_view_1.setText(recycle_1_data_list.getContact_name());
        holder.contact_image_view_1.setImageResource(recycle_1_data_list.getContact_image());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context,recycle_1_data_list.getContact_name(),Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context,Sub_Activity.class);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return recycle_1_data.length;
    }

    public interface RecyclerViewClickListener{
        void onClick(View v,int position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView contact_image_view_1;
        TextView contact_text_view_1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contact_text_view_1 = itemView.findViewById(R.id.contact_text_1);
            contact_image_view_1 = itemView.findViewById(R.id.contact_image_view_1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
        }
    }
}
