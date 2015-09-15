package com.example.priyasindkar.syncadapterdemo;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.SyncStatusObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import db.DatabaseHelper;
import syncClasses.SimpleContentProvider;
import syncClasses.SimpleInit;
import syncClasses.SyncConstants;

public class LoginActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            /*Account newAccount = new Account(SyncConstants.ACCOUNT_NAME, SyncConstants.ACCOUNT_TYPE);

            Bundle extras = new Bundle();
            // SYNC_EXTRAS_MANUAL enforces manual sync despite automatic sync settings
            extras.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
            ContentResolver.requestSync(newAccount,SyncConstants.AUTHORITY,extras);*/
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
