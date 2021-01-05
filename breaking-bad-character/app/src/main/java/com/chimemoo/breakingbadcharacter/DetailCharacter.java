package com.chimemoo.breakingbadcharacter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailCharacter extends AppCompatActivity {

    ImageView imageView;
    TextView tvName, tvBirthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_character);

        Intent intent = getIntent();

        String imageUrl = intent.getStringExtra("PICTURE");
        String name = intent.getStringExtra("NAME");
        String birthday = intent.getStringExtra("BIRTHDAY");

        imageView = findViewById(R.id.imageView);
        tvName = findViewById(R.id.tvName);
        tvBirthday = findViewById(R.id.tvBirthday);

        Glide.with(getBaseContext())
                .load(imageUrl)
                .apply(new RequestOptions().override(350,555))
                .into(imageView);

        tvName.setText(name);
        tvBirthday.setText("Birthday : "+ birthday);

    }
}