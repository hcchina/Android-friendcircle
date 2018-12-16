package com.example.hc.finshhomework;

import android.content.Intent;
import android.os.Looper;
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



public class DengluActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        Button button =(Button)findViewById(R.id.zhuce);
        button.setOnClickListener(new View.OnClickListener() {
            Bundle bundle = new Bundle();
            public void onClick(View v) {
                Intent intent = new Intent(DengluActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button button1=(Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run(){
                        try {
                           EditText editTextw =(EditText)findViewById(R.id.ninchen);
                            String name = editTextw.getText().toString();
                            String pass = ((EditText)findViewById(R.id.mimakuang)).getText().toString();
                            URL url = new URL("http://119.29.60.170/index.aspx?type=login&username="+name+"&password="+pass);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            httpURLConnection.setRequestMethod("GET");
                            InputStream inputStream = httpURLConnection.getInputStream();
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            StringBuffer stringBuffer = new StringBuffer();
                            String temp;
                            while ((temp = bufferedReader.readLine()) != null){
                                stringBuffer.append(temp);
                            }
                            Looper.prepare();
                            if(stringBuffer.toString().equals("login success")){

                                Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(DengluActivity.this, PengyouquanActivity.class);
                                Bundle bundle = new Bundle();
                                EditText userName=(EditText)findViewById(R.id.ninchen);
                                bundle.putString("name", userName.getText().toString());
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }
                            else if(stringBuffer.toString().equals("login failed")){
                                Toast.makeText(getApplicationContext(), "登陆失败，重新登陆", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "登陆失败，重新登陆", Toast.LENGTH_SHORT).show();
                            }
                            Looper.loop();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
    }


}


