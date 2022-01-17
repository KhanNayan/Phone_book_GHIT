package com.example.dm_phonebook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private  recycle_1_Adapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        RecyclerView recycle_1 =findViewById(R.id.recycle_1);
        recycle_1.setHasFixedSize(true);
        recycle_1.setLayoutManager(new LinearLayoutManager(this));



        recycle_1_data[] recycle_1_data = new recycle_1_data[]{
                new recycle_1_data("Arsenal", R.drawable.ars),
                new recycle_1_data("Arsenal_young", R.drawable.ars),
                new recycle_1_data("Arsenal_OLD", R.drawable.ars),
                new recycle_1_data("Arsenal_derby", R.drawable.ars),
                new recycle_1_data("Arsenal_1", R.drawable.ars),
                new recycle_1_data("Arsenal_4", R.drawable.ars),
                new recycle_1_data("Arsenal_looser", R.drawable.ars),
                new recycle_1_data("Arsenal_joker", R.drawable.ars),
                new recycle_1_data("Arsenal_arsen", R.drawable.ars),
                new recycle_1_data("Arsenal_wenger", R.drawable.ars),
                new recycle_1_data("Arsenal_Hello", R.drawable.ars),
                new recycle_1_data("Arsenal_lord", R.drawable.ars),
                new recycle_1_data("Arsenal", R.drawable.ars),
                new recycle_1_data("Arsenal", R.drawable.ars),
                new recycle_1_data("Arsenal", R.drawable.ars),
                new recycle_1_data("Arsenal", R.drawable.ars)
        };
        listener = new recycle_1_Adapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),Sub_Activity.class);
                intent.putExtra("Name",recycle_1_data[position].getContact_name());
                startActivity(intent);
            }
        } ;

        recycle_1_Adapter recycle_1_adapter = new recycle_1_Adapter(recycle_1_data, MainActivity.this,listener);
        recycle_1.setAdapter(recycle_1_adapter);


    }
}