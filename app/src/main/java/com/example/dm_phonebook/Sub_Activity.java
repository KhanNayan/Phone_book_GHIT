package com.example.dm_phonebook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Sub_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_acitvity);


        ImageView home_icon ;

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();



        RecyclerView recycle_2 =findViewById(R.id.recycle_2);
        recycle_2.setHasFixedSize(true);
        recycle_2.setLayoutManager(new LinearLayoutManager(this));

        TextView sub_text1 = findViewById(R.id.sub_text_2);
        home_icon = findViewById(R.id.home_icon);
        String name = "Temp";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            name = extras.getString("Name");
        }
        sub_text1.setText(name);


        recycle_2_data[] recycle_2_data = new recycle_2_data[]{
                new recycle_2_data("Arsenal", R.drawable.mancity),
                new recycle_2_data("Arsenal_young", R.drawable.mancity),
                new recycle_2_data("Arsenal_OLD", R.drawable.mancity),
                new recycle_2_data("Arsenal_derby", R.drawable.ars),
                new recycle_2_data("Arsenal_1", R.drawable.mancity),
                new recycle_2_data("Arsenal_4", R.drawable.ars),
                new recycle_2_data("Arsenal_looser", R.drawable.mancity),
                new recycle_2_data("Arsenal_joker", R.drawable.ars),
                new recycle_2_data("Arsenal_arsen", R.drawable.mancity),
                new recycle_2_data("Arsenal_wenger", R.drawable.ars),
                new recycle_2_data("Arsenal_Hello", R.drawable.mancity),
                new recycle_2_data("Arsenal_lord", R.drawable.ars),
                new recycle_2_data("Arsenal", R.drawable.ars),
                new recycle_2_data("Arsenal", R.drawable.ars),
                new recycle_2_data("Arsenal", R.drawable.ars),
                new recycle_2_data("Arsenal", R.drawable.ars)
        };
        recycle_2_Adapter recycle_2_adapter = new recycle_2_Adapter(recycle_2_data, Sub_Activity.this);
        recycle_2.setAdapter(recycle_2_adapter);

        home_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sub_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}