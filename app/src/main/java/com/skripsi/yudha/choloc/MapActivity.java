package com.skripsi.yudha.choloc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MapActivity extends AppCompatActivity {

    // Session Management Class
    SessionManagement session;

    // Disable back button
    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Session class instance
        session = new SessionManagement(getApplicationContext());
        /**
         * This will redirect user to LoginActivity is he is n
         * Call this function whenever you want to check user loginot
         * logged in
         * */
        session.checkLogin();

        ImageButton imageButtonChatList = (ImageButton)findViewById(R.id.chatlist_button);
        imageButtonChatList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(MapActivity.this,ChatListActivity.class);
                startActivity(i);
            }
        });

        ImageButton imageButtonFriendList = (ImageButton)findViewById(R.id.friendlist_button);
        imageButtonFriendList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(MapActivity.this, FriendListActivity.class);
                startActivity(i);
            }
        });

    }

}