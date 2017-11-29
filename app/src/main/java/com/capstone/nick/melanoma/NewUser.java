package com.capstone.nick.melanoma;

import android.os.Bundle;

public class NewUser extends NavigatingActivity {

    private boolean loggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        loggedIn = getIntent().getExtras().getBoolean("LOGGEDIN");
        boolean logMeOut = getIntent().getExtras().getBoolean("LOGMEOUT");


        super.onCreateDrawer(loggedIn);
    }
}