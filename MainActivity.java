package com.example.smsservice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText companyIdEditText;
    private Button verifyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        companyIdEditText = findViewById(R.id.companyId);
        verifyButton = findViewById(R.id.verifyButton);

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String companyId = companyIdEditText.getText().toString();
                CompanyVerificationService verificationService = new CompanyVerificationService(MainActivity.this);
                verificationService.verifyCompany(companyId);
            }
        });
    }
}
