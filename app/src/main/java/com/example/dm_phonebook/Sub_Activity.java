package com.example.dm_phonebook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Sub_Activity extends AppCompatActivity {
    private  recycle_2_Adapter.RecyclerViewClickListener listener2;

   // public recycle_2_data[] recycle_2_data_1;
    public ArrayList<recycle_2_data> recycle_2_dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_acitvity);


        ImageView home_icon ;

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();





        TextView sub_text1 = findViewById(R.id.sub_text_2);
//        home_icon = findViewById(R.id.home_icon);
        String name = "Temp";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            name = extras.getString("Name");
        }
        sub_text1.setText(name);
        String [] officer_des;
        officer_des = getResources().getStringArray(R.array.officers_designation);
        Log.i("NumberGenerated", officer_des[0]);
//        recycle_2_data[] recycle_2_data = new recycle_2_data[0];
        if (name.equals("দুর্যোগ ব্যবস্থাপনা অধিদপ্তর")){
            for (int i =0;i< officer_des.length;i++){
               /* recycle_2_data_1[i]= new recycle_2_data(officer_des[i], R.drawable.bd_logo);
                recycle_fun(recycle_2_data_1);*/
                recycle_2_dataList.add( new recycle_2_data(officer_des[i], R.drawable.bd_logo));
            }
            recycle_fun(recycle_2_dataList);
            }
        else if(name.equals("প্রধান কার্যালয়")){
            for (int i =0;i< officer_des.length;i++){
                recycle_2_dataList.add( new recycle_2_data(officer_des[i], R.drawable.bd_logo));
            }
            recycle_fun(recycle_2_dataList);
        }
        else {
//            recycle_2_data_1 = new recycle_2_data[]{
//                    new recycle_2_data("রাস্ট্রপতির কার্যালয়", R.drawable.bd_logo),
//
//            };

        }


//        home_icon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Sub_Activity.this,HomeActivity.class);
//                startActivity(intent);
//            }
//        });


    }

    public void recycle_fun(ArrayList<recycle_2_data> recycle_2_data){
        RecyclerView recycle_2 =findViewById(R.id.recycle_2);
        recycle_2.setHasFixedSize(true);
        recycle_2.setLayoutManager(new LinearLayoutManager(this));
        listener2 = new recycle_2_Adapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),Profile_actvity.class);
                intent.putExtra("Name",recycle_2_data.get(position).getContact_name_2());
                intent.putExtra(" ",position);
                startActivity(intent);
            }
        } ;

        recycle_2_Adapter recycle_2_adapter = new recycle_2_Adapter(recycle_2_data, Sub_Activity.this,listener2);
        recycle_2.setAdapter(recycle_2_adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}