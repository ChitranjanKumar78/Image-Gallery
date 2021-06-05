package com.chitranjank.co.imagegallery;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.Objects;

public class Image extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Objects.requireNonNull(getSupportActionBar()).hide();

        PhotoView photoView = findViewById(R.id.photo);

        Intent intent = getIntent();
        String uri = intent.getStringExtra("URI");

        Glide.with(this).load(uri).into(photoView);
    }
}