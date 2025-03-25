package com.example.smsservice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText phoneNumberEditText;
    private Button callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumberEditText = findViewById(R.id.phoneNumber);
        callButton = findViewById(R.id.callButton);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberEditText.getText().toString();
                CallService callService = new CallService(MainActivity.this);
                callService.makeCall(phoneNumber);
            }
        });
    }
}
