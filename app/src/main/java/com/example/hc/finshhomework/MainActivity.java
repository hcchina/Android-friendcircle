package com.example.hc.finshhomework;

import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button3=(Button)findViewById(R.id.button2);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, DengluActivity.class);
                startActivity(intent1);
            }
        });
        Button button2 = (Button) findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            EditText editText = (EditText) findViewById(R.id.ninchen);
                            String name = editText.getText().toString();
                            String phone = ((EditText) findViewById(R.id.shoujikuang)).getText().toString();
                            String passwd = ((EditText) findViewById(R.id.mimakuang)).getText().toString();
                            String email = ((EditText) findViewById(R.id.emailkuang)).getText().toString();
                            URL url = new URL("http://119.29.60.170/index.aspx?type=regist&username=" + name + "&password=" + passwd + "&email=" + email + "&phone=" + phone);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.connect();
                            if (httpURLConnection.getResponseCode() == 200) {
                                InputStream inputStream = httpURLConnection.getInputStream();
                                InputStreamReader inputStreamReader = new InputStreamReader(inputStream,
                                        "utf-8");
                                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                                StringBuffer stringBuffer = new StringBuffer();
                                String temp;
                                while ((temp = bufferedReader.readLine()) != null) {
                                    stringBuffer.append(temp);
                                }
                                Message message = new Message();
                                message.obj = stringBuffer.toString();
                                Looper.prepare();
                                if (stringBuffer.toString().equals("regist success")) {
                                    Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this, DengluActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(getApplicationContext(), "注册失败，重新注册",
                                            Toast.LENGTH_SHORT).show();
                                }
                                Looper.loop();
                            }
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });}


}

