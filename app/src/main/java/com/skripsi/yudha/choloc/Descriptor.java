package com.skripsi.yudha.choloc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yudha on 29/05/16.
 */
public class Descriptor extends AppCompatActivity {


    TextView title,desc;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descriptor);
        desc=(TextView)findViewById(R.id.textView2);
        title=(TextView)findViewById(R.id.textView);
        img=(ImageView)findViewById(R.id.imageView);
        Intent i=getIntent();
        String a=i.getStringExtra("value");
        if (a.equalsIgnoreCase("1")){
            img.setImageResource(R.drawable.kawah_putih_ciwidey);
            title.setText("Kawah Putih");
            desc.setText(R.string.desc_kawahputih);
        }else if (a.equalsIgnoreCase("2")) {
            img.setImageResource(R.drawable.tsb);
            title.setText("Trans Studio Bandung");
            desc.setText(R.string.desc_tsm);
        }else if (a.equalsIgnoreCase("3")) {
            img.setImageResource(R.drawable.gedungsate);
            title.setText("Gedung Sate");
            desc.setText(R.string.desc_gedungsate);
        }else if (a.equalsIgnoreCase("4")) {
            img.setImageResource(R.drawable.situ_patenggang);
            title.setText("Situ Patenggang / Situ Patengan");
            desc.setText(R.string.desc_situpatengan);
        }
    }

}
