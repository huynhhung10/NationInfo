package com.example.NationInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;

import NationInfo.R;

public class InfoActivity extends AppCompatActivity {
    TextView txtName, txtArea, txtPop, txtCapital;
    Button btnBack;

    ImageView flagImage;
    ImageView mapImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Mapping();

        castIntent();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Mapping(){
        txtName = findViewById(R.id.info_name);
        txtArea = findViewById(R.id.info_area);
        txtPop = findViewById(R.id.info_population);
        txtCapital = findViewById(R.id.info_capital);
        btnBack = findViewById(R.id.btnBack);
        flagImage = findViewById(R.id.info_image);
        mapImage = findViewById(R.id.info_Map);
    }

    private void castIntent(){


        Intent intent = getIntent();
        txtPop.setText("Population: " + intent.getIntExtra("Population", 0) + "");
        txtArea.setText("Area in Square Km: " + intent.getFloatExtra("Area", 0.0f) + " km^2");
        txtName.setText(intent.getStringExtra("Name"));
        txtCapital.setText("Capital: " + intent.getStringExtra("Capital") + "");
        new ImageFromUrlHandler().execute(intent.getStringExtra("Image"));
        new ImageFromUrlHandler().execute(intent.getStringExtra("Map"));


    }

    private class ImageFromUrlHandler extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls) {

            return GetImageFromUrl(urls[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

            flagImage.setImageBitmap(bitmap);
        }
    }

    protected Bitmap GetImageFromUrl(String url) {
        Bitmap image = null;

        try {
            Log.d("image path", url);
            URL path = new URL(url);
            InputStream in = path.openConnection().getInputStream();
            
            // get the Image bounds
            BitmapFactory.Options options=new BitmapFactory.Options();
            options.outWidth = 200;
            options.outHeight = 200;


            image = BitmapFactory.decodeStream(in,null,options);

            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}