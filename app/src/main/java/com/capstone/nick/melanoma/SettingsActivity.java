package com.capstone.nick.melanoma;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v13.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.preference.Preference;
import android.view.View;

public class SettingsActivity extends NavigatingActivity {
    private boolean loggedIn;
    private String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        loggedIn = getIntent().getExtras().getBoolean("LOGGEDIN");
        userEmail = getIntent().getExtras().getString("EMAIL");
        super.onCreateDrawer(loggedIn, userEmail);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.delAccount:
                deleteAccount();
        }
    }

    private void deleteAccount() {
        //confirm before deleting account
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);

        final Intent intent = new Intent(this, MainScreen.class);
        intent.putExtra("LOGGEDIN", loggedIn);
        intent.putExtra("LOGMEOUT", true);
        intent.putExtra("EMAIL", userEmail);

        builder.setTitle("Confirm Selection")
                .setMessage("Are you absolutely sure you want to delete your account and all associated files/images?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //go through with deletion
                        //delete firebase data
                        //delete local data
                        //upon deletion go to main screen
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

}
