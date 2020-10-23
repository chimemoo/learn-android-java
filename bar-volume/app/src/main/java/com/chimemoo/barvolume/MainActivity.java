package com.chimemoo.barvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtWidth;
    private EditText edtLength;
    private EditText edtHeight;
    private Button btnCount;
    private TextView tvResult;

    private final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.et_width);
        edtLength = findViewById(R.id.et_length);
        edtHeight = findViewById(R.id.et_height);
        btnCount = findViewById(R.id.bt_count);
        tvResult = findViewById(R.id.tv_result);

        btnCount.setOnClickListener(this);

        if(savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_count) {
            String inputLength = edtLength.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();

            boolean isEmptyields = false;

            if(TextUtils.isEmpty(inputLength)){
                isEmptyields = true;
                edtLength.setError("Fields ini tidak boleh kosong");
            }

            if(TextUtils.isEmpty(inputWidth)){
                isEmptyields = true;
                edtWidth.setError("Fields ini tidak boleh kosong");
            }

            if(TextUtils.isEmpty(inputHeight)){
                isEmptyields = true;
                edtHeight.setError("Fields ini tidak boleh kosong");
            }

            if(!isEmptyields) {
                double volume = Double.valueOf(inputLength) * Double.valueOf(inputWidth) * Double.valueOf(inputHeight);
                tvResult.setVisibility(View.VISIBLE);
                tvResult.setText(String.valueOf(volume));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }

}
