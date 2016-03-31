package com.skripsi.yudha.choloc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class FriendListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendlist);

        ImageButton imageButtonChatList = (ImageButton)findViewById(R.id.chatlist_button);
        imageButtonChatList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(FriendListActivity.this,ChatListActivity.class);
                startActivity(i);
            }
        });

        ImageButton imageButtonMaps = (ImageButton)findViewById(R.id.maps_button);
        imageButtonMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(FriendListActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });

        ImageButton imageButtonProfile = (ImageButton)findViewById(R.id.profile_button);
        imageButtonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(FriendListActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });

    }

}
