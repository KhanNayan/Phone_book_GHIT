package com.example.dm_phonebook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Profile_actvity extends AppCompatActivity {
    TextView phone_num,pos_name1,email,name;
    ImageView call_icon,sms_icon,mail_icon_id,contact_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_actvity);

        call_icon = findViewById(R.id.call_id);
        sms_icon = findViewById(R.id.sms_icon);
        phone_num = findViewById(R.id.phone_number);
        pos_name1 = findViewById(R.id.pos_name);
        name = findViewById(R.id.name);
        email = findViewById(R.id.mail_id);
        mail_icon_id = findViewById(R.id.mail_icon_id);
        contact_img = findViewById(R.id.contact_image);
        String pos_name = "Temp";

        int position = 0 ;
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            pos_name = extras.getString("Name");
            position = extras.getInt(" ");
            Log.e("msg",""+position);
        }
        pos_name1.setText(pos_name);
        String [] name_arr,phone_number_arr,mail_arr;

        name_arr = getResources().getStringArray(R.array.name);
        phone_number_arr = getResources().getStringArray(R.array.phone_number);
        mail_arr = getResources().getStringArray(R.array.mail);
//        img_arr = getResources().getStringArray(R.array.image);
//        if(toString(R.drawable.img).equals(img_arr[0])){
//
//        }
//        for(int i=0;i<=position;i++){

        String uri = "@drawable/img" + position;
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        contact_img.setImageDrawable(res);
        try {
            name.setText(name_arr[position]);
            phone_num.setText(phone_number_arr[position]);
            email.setText(mail_arr[position]);
        } catch (Exception e){
            e.printStackTrace();
            name.setText("Unavailable");
            phone_num.setText("World");
            email.setText("No Mail");
        }
        /*}
        else {
            name.setText("Hello");
            phone_num.setText("World");
            email.setText("No Mail");
            //eita k
        }*/


        String number=phone_num.getText().toString();
        String email_add =email.getText().toString();

        sms_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setData(Uri.fromParts("sms",number,null));
                smsIntent.putExtra("sms_body"," ");
                startActivity(smsIntent);
            }
        });

        call_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);
            }
        });

        mail_icon_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.fromParts("mailto",email_add,null));
//                emailIntent.putExtra("Subject");
                startActivity(emailIntent);
            }
        });
    }
}