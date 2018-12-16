package com.example.hc.finshhomework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import com.network.zhouwei.http_network.*;

/**
 * Created by hc on 2018/12/14.
 */
public class ListViewAdapt extends ArrayAdapter {
    private int resourceId;

    public ListViewAdapt(Context context, int resource,  List objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {;
        Comment comment = (Comment)getItem(position);
        ListLayout listLayout = new ListLayout();
        Server server =new Server();
        server.setServer("119.29.60.170");
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            //listLayout.head=(ImageView)view.findViewById(R.id.touxiang);
            listLayout.imgView2 = (ImageView) view.findViewById(R.id.imageView);
            listLayout.textView = (TextView) view.findViewById(R.id.textView3);
            listLayout.editText = (EditText) view.findViewById(R.id.editText);
            listLayout.imageView1 = (ImageView) view.findViewById(R.id.touxiang);
            view.setTag(listLayout);
        } else {
            view = convertView;
            listLayout = (ListLayout) view.getTag();
        }
        //listLayout.head.setImageBitmap(server.imageFileDownload(comment.getUsername()));
        listLayout.textView.setText(comment.getUsername());
        listLayout.editText.setText(comment.getContext());
        listLayout.imageView1.setImageResource(R.drawable.second);
        listLayout.imgView2.setImageResource(R.drawable.beijing);
        return view;
    }

    class ListLayout {
        //private ImageView head;
        private ImageView imageView1;
        private TextView textView;
        private EditText editText;
        private ImageView imgView2;
    }
}
