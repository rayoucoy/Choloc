package com.skripsi.yudha.choloc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageButton imageButtonChatList = (ImageButton)findViewById(R.id.chatlist_button);
        imageButtonChatList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(ProfileActivity.this,ChatListActivity.class);
                startActivity(i);
            }
        });

        ImageButton imageButtonFriendList = (ImageButton)findViewById(R.id.friendlist_button);
        imageButtonFriendList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(ProfileActivity.this, FriendListActivity.class);
                startActivity(i);
            }
        });

        ImageButton imageButtonMaps = (ImageButton)findViewById(R.id.maps_button);
        imageButtonMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(ProfileActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });
        /**
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
         **/
    }

}
