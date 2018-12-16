package com.example.hc.finshhomework;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.network.zhouwei.http_network.*;

import java.util.List;


public class PengyouquanActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengyouquan);
        Server server =new Server();
        server.setServer("119.29.60.170");
        List<Comment> comments=server.getComments(0,1000);
        ImageView imageView = (ImageView) findViewById(R.id.touxianga);
        server.imageFileUpload(imageView, "hc");
        ListViewAdapt listViewAdapt =new ListViewAdapt(this,R.layout.listview,comments);
        ListView listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(listViewAdapt);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ((TextView) view.findViewById(R.id.textView3)).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

  public void daofabiao(View v){
        Bundle bundle = getIntent().getExtras();
        Intent intent = new Intent(PengyouquanActivity.this, FaBiaoActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void fanhuidenglu(View v){
        Bundle bundle = getIntent().getExtras();
        Intent intent = new Intent(PengyouquanActivity.this, DengluActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
