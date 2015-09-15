package syncClasses;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.priyasindkar.syncadapterdemo.LoginActivity;
import com.example.priyasindkar.syncadapterdemo.RegisterActivity;
import com.parse.Parse;

/**
 * Created by priyasindkar on 14-09-2015.
 */
public class SimpleInit extends AsyncTask<Void,Void,Void> {

    String TAG = "AsyncInitSetup";
    final String APPLICATION_ID = "Mgz87aMjsM83cUqd4UnER72Z6L1rW98VxHvfiuUH";
    final String CLIENT_KEY = "TvzpuMelK0LUwuGyap0MlZXAfLjFturfnTUzT47Y";
    private Context ctx;
    public SimpleInit(Context ctx){
        this.ctx = ctx;
    }
    @Override
    protected Void doInBackground(Void... params) {

        try{
            Parse.initialize(ctx, APPLICATION_ID, CLIENT_KEY);

            SyncUtil syncUtils = new SyncUtil(ctx);
            String email = syncUtils.getGmailAccount();
            String pwd = "1234567890";

            if(syncUtils.isSyncAccountExists()){
                Log.e(TAG, "SyncAdapter is already exist");

            }
            else{
                Intent intent = new Intent(ctx, RegisterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP );
                ctx.startActivity(intent);
               // syncUtils.createSyncAccount(email,pwd,email);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
