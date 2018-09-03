package com.motheriloveyou.mobarakbutterfly.firestore;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import android.widget.MediaController;

public class InformationPage extends AppCompatActivity {

    private TextView viewtextid01,viewtextid02,viewtextid03,viewtextid04,viewtextid05;

    private FirebaseFirestore db;

    private Product product;

    private ProgressBar progressBar;
    ProgressDialog pd;
    VideoView view;
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;





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

        final VideoView view = findViewById(R.id.videoView1);

        progressBar = findViewById(R.id.progressbar);



        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(product.getName());


        viewtextid01.setText(product.getName());
        viewtextid02.setText(product.getBrand());
        viewtextid03.setText(product.getDescription());
        viewtextid04.setText(String.valueOf(product.getPrice()));
        viewtextid05.setText(String.valueOf(product.getQty()));

        String URL = product.getName();


        pd = new ProgressDialog(InformationPage.this);
        pd.setTitle("Video Streamming Demo");
        pd.setMessage("Buffering...");
        pd.setIndeterminate(false);
        pd.setCancelable(false);
        pd.show();

        try{

            MediaController controller = new MediaController(InformationPage.this);
            controller.setAnchorView(view);
            Uri vid = Uri.parse(URL);
            view.setMediaController(controller);
            view.setVideoURI(vid);
        }catch(Exception e){
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        view.requestFocus();
        view.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
// TODO Auto-generated method stub
                pd.dismiss();
                view.start();
            }
        });


    }


}