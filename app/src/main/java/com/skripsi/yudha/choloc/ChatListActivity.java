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

public class ChatListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatlist);

        ImageButton imageButtonFriendlist = (ImageButton)findViewById(R.id.friendlist_button);
        imageButtonFriendlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Berpindah ke menu Friendlist", Toast.LENGTH_SHORT).show();
                Intent i;
                i = new Intent(ChatListActivity.this,FriendListActivity.class);
                startActivity(i);
            }
        });

        ImageButton imageButtonMaps = (ImageButton)findViewById(R.id.maps_button);
        imageButtonMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Berpindah ke menu Maps", Toast.LENGTH_SHORT).show();
                Intent i;
                i = new Intent(ChatListActivity.this,MapsActivity.class);
                startActivity(i);
            }
        });

        ImageButton imageButtonProfile = (ImageButton)findViewById(R.id.profile_button);
        imageButtonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Berpindah ke menu Profile", Toast.LENGTH_SHORT).show();
                Intent i;
                i = new Intent(ChatListActivity.this,ProfileActivity.class);
                startActivity(i);
            }
        });

    }

}
