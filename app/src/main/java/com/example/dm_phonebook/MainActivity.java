package com.example.dm_phonebook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  recycle_1_Adapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        TextView top_content = findViewById(R.id.top_content);
        Intent intent = getIntent();
        String str = intent.getStringExtra("key");
        top_content.setText(str);


        RecyclerView recycle_1 = findViewById(R.id.recycle_1);
        recycle_1.setHasFixedSize(true);
        recycle_1.setLayoutManager(new LinearLayoutManager(this));
        recycle_1_data[] recycle_1_data;
        if (str.equals("অধিদপ্তর বাতায়ন")){
            recycle_1_data = new recycle_1_data[]{
                    new recycle_1_data("দুর্যোগ ব্যবস্থাপনা অধিদপ্তর", R.drawable.bd_logo),

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
        else if(str.equals("মন্ত্রণালয়/বিভাগ")){
            recycle_1_data = new recycle_1_data[]{
                    new recycle_1_data("প্রধান কার্যালয়", R.drawable.bd_logo),
                    new recycle_1_data("প্রকল্প", R.drawable.bd_logo),
                    new recycle_1_data("জেলা ত্রাণ ও পুনর্বাসন কর্মকর্তা", R.drawable.bd_logo),
                    new recycle_1_data("উপজেলা প্রকল্প বাস্তবায়ন কর্মকর্তাবৃন্দ", R.drawable.bd_logo),

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
}