package com.example.dm_phonebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    Button min_btn,dis_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        min_btn = findViewById(R.id.min_btn);
        dis_btn = findViewById(R.id.dis_btn);


        dis_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = dis_btn.getText().toString().trim();
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                intent.putExtra("key",str);
                startActivity(intent);
            }
        });
        min_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = min_btn.getText().toString().trim();
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                intent.putExtra("key",str);
                startActivity(intent);
            }
        });
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