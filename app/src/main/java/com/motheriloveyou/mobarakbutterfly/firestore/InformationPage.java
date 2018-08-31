package com.motheriloveyou.mobarakbutterfly.firestore;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class InformationPage extends AppCompatActivity {

    private TextView viewtextid01,viewtextid02,viewtextid03,viewtextid04,viewtextid05;

    private FirebaseFirestore db;

    private Product product;

    private ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page);

        product = (Product) getIntent().getSerializableExtra("product");
        db = FirebaseFirestore.getInstance();

        viewtextid01 = findViewById(R.id.txtview01);
        viewtextid02 = findViewById(R.id.txtview02);
        viewtextid03 = findViewById(R.id.txtview03);
        viewtextid04 = findViewById(R.id.txtview04);
        viewtextid05 = findViewById(R.id.txtview05);

        progressBar = findViewById(R.id.progressbar);

        ImageView imageView = findViewById(R.id.image_view);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(product.getName());


        viewtextid01.setText(product.getName());
        viewtextid02.setText(product.getBrand());
        viewtextid03.setText(product.getDescription());
        viewtextid04.setText(String.valueOf(product.getPrice()));
        viewtextid05.setText(String.valueOf(product.getQty()));


        Picasso.get().load(product.getName()).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {

            }
        });


    }




}
