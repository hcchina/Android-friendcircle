package com.example.hc.finshhomework;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.network.zhouwei.http_network.Server;

import java.util.List;


public class FaBiaoActivity extends ActionBarActivity {
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_biao);
        Button button2=(Button)findViewById(R.id.quxiao);
        Button button3=(Button)findViewById(R.id.fabiaoshuoshuo);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(FaBiaoActivity.this, PengyouquanActivity.class);
                startActivity(intent1);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                String name=bundle.getString("username");
                EditText editText1 = (EditText) findViewById(R.id.shuoshuo);
                String context = editText1.getText().toString();
                Server server=new Server();
                server.setServer("119.29.60.170");
                Bitmap[] bitmaps =new Bitmap[0];
                server.imageFileDownload("hc");
                server.commnetResourcesUpload("hc", context, bitmaps);
                Intent intent = new Intent(FaBiaoActivity.this, PengyouquanActivity.class);
                startActivity(intent);
            }
        });

    }
}
