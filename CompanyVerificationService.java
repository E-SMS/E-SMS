package com.example.smsservice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class CompanyVerificationService {

    private static final String BASE_URL = "https://api.example.com/";
    private VerificationApi verificationApi;
    private Context context;

    public CompanyVerificationService(Context context) {
        this.context = context;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        verificationApi = retrofit.create(VerificationApi.class);
    }

    public void verifyCompany(String companyId) {
        verificationApi.verifyCompany(companyId).enqueue(new Callback<VerificationResponse>() {
            @Override
            public void onResponse(Call<VerificationResponse> call, Response<VerificationResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    VerificationResponse verificationResponse = response.body();
                    if (verificationResponse.isVerified()) {
                        Toast.makeText(context, "Company verified!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Company not verified.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Verification failed.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<VerificationResponse> call, Throwable t) {
                Toast.makeText(context, "API call failed.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    interface VerificationApi {
        @GET("verifyCompany")
        Call<VerificationResponse> verifyCompany(@Query("companyId") String companyId);
    }

    class VerificationResponse {
        private boolean verified;

        public boolean isVerified() {
            return verified;
        }
    }
}
