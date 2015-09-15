package com.example.priyasindkar.syncadapterdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import syncClasses.SyncUtil;

public class RegisterActivity extends AppCompatActivity  {
    Button btnRegister;
    EditText edtUserName, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        final SyncUtil syncUtils = new SyncUtil(this);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    syncUtils.createSyncAccount(edtUserName.getText().toString(), edtPassword.getText().toString(), edtUserName.getText().toString());
                    Toast.makeText(RegisterActivity.this, "Register successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
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
