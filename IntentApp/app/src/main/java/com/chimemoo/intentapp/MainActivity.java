package com.chimemoo.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMoveActivity;
    private Button btnMoveActivityWithData;
    private Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveActivityWithData = findViewById(R.id.btn_move_activity_data);
        btnMoveActivityWithData.setOnClickListener(this);

        btnCall = findViewById(R.id.btn_call_number);
        btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_activity_data:
                Intent moveIntentWithData = new Intent(MainActivity.this, MoveActivityWithData.class);
                moveIntentWithData.putExtra(MoveActivityWithData.EXTRA_NAME, "Chimemoo");
                moveIntentWithData.putExtra(MoveActivityWithData.EXTRA_AGE, 25);
                startActivity(moveIntentWithData);
                break;
            case R.id.btn_call_number:
                String phoneNumber = "088811112222";
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(callIntent);
        }
    }
}
