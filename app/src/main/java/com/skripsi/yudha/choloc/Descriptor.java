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

    SessionManagement session;
    TextView title,desc;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descriptor);
        session = new SessionManagement(getApplicationContext());
        session.checkLogin();
        
        desc=(TextView)findViewById(R.id.textView2);
        title=(TextView)findViewById(R.id.textView);
        img=(ImageView)findViewById(R.id.imageView);
        Intent i=getIntent();
        String a=i.getStringExtra("value");
        if (a.equalsIgnoreCase("1")){
            img.setImageResource(R.drawable.kawah_putih_ciwidey);
            title.setText("Kampung Wisata Taman Lele");
            desc.setText(R.string.desc_kawahputih);
        }else if (a.equalsIgnoreCase("2")) {
            img.setImageResource(R.drawable.tsb);
            title.setText("Wisata Bahari Morosari");
            desc.setText(R.string.desc_tsm);
        }else if (a.equalsIgnoreCase("3")) {
            img.setImageResource(R.drawable.gedungsate);
            title.setText("Wisata Goa Kreo");
        }else if (a.equalsIgnoreCase("4")) {
            title.setText("Wisata Alam Wana Wisata Penggaron");
        }else if (a.equalsIgnoreCase("5")) {
            title.setText("Umbul Sidomukti");
        }else if (a.equalsIgnoreCase("6")) {
            title.setText("Vanaprastha Gedongsongo Park");
        }else if (a.equalsIgnoreCase("7")) {
            title.setText("Desa Wisata Lembah Kalipancur");
        }else if (a.equalsIgnoreCase("8")) {
            title.setText("Air Terjun Kalipancur Nogosaren");
        }else if (a.equalsIgnoreCase("9")) {
            title.setText("Watu Gunung");
        }else if (a.equalsIgnoreCase("10")) {
            title.setText("Candi Gedong Songo");
        }else if (a.equalsIgnoreCase("11")) {
            title.setText("Curug Lawe Benowo Kalisidi");
        }else if (a.equalsIgnoreCase("12")) {
            title.setText("Bukit Cinta Rawa Pening");
        }else if (a.equalsIgnoreCase("13")) {
            title.setText("Kolam Renang Tirto Agung Siwarak");
        }else if (a.equalsIgnoreCase("14")) {
            title.setText("Basecamp Mawar");
        }else if (a.equalsIgnoreCase("15")) {
            title.setText("Simpang Lima Semarang");
        }else if (a.equalsIgnoreCase("16")) {
            title.setText("Lawang Sewu");
        }else if (a.equalsIgnoreCase("17")) {
            title.setText("Tugu Muda");
        }else if (a.equalsIgnoreCase("18")) {
            title.setText("Universitas Diponegoro, Kampus Tembalang Semarang");
        }else if (a.equalsIgnoreCase("19")) {
            title.setText("Universitas Diponegoro, Kampus Pleburan Semarang");
        }else if (a.equalsIgnoreCase("20")) {
            title.setText("Universitas Negeri Semarang");
        }else if (a.equalsIgnoreCase("21")) {
            title.setText("Gunung Ungaran");
        }else if (a.equalsIgnoreCase("22")) {
            title.setText("Candi Gedong Songo");
        }else if (a.equalsIgnoreCase("23")) {
            title.setText("Bukit Paralayang");
        }else if (a.equalsIgnoreCase("24")) {
            title.setText("Pondok Kopi Umbul Sidomukti");
        }else if (a.equalsIgnoreCase("25")) {
            title.setText("RAGENTAR Outbound dan Olah Nyali");
        }else if (a.equalsIgnoreCase("26")) {
            title.setText("Browncanyon Semarang");
        }else if (a.equalsIgnoreCase("27")) {
            title.setText("Water Blaster");
        }else if (a.equalsIgnoreCase("28")) {
            title.setText("Masjid Agung Jawa Tengah");
        }

    }

}
