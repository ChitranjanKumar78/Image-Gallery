package com.chitranjank.co.imagegallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    List<Uri> uriList;
    Context context;

    public ImageAdapter(List<Uri> uriList, Context context) {
        this.uriList = uriList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return uriList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.image_itms,parent,false);

        ImageView imageView = convertView.findViewById(R.id.image_view);

        Glide.with(context).load(uriList.get(position)).centerCrop().into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Image.class);
                intent.putExtra("URI",uriList.get(position).toString());
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
