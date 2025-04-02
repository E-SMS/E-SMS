package com.example.smsservice;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class CallService {

    private Context context;

    public CallService(Context context) {
        this.context = context;
    }

    public void makeCall(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            Toast.makeText(context, "This phone number is invalid", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        try {
            context.startActivity(callIntent);
        } catch (SecurityException e) {
            Toast.makeText(context, "The call permission not granted", Toast.LENGTH_SHORT).show();
        }
    }
}
