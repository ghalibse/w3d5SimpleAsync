package com.example.simpleasyncokhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private ListView mlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlistView = (ListView) findViewById(R.id.lst_view);

        doMagic();
    }

    protected String doMagic(String... strings) {

        String url = "http://www.mocky.io/v2/57a01bec0f0000c10d0f650f";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String JSONstring = response.body().string();
            return JSONstring;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
