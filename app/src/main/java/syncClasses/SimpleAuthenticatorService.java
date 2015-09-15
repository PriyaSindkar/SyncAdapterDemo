package syncClasses;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by priyasindkar on 14-09-2015.
 */
public class SimpleAuthenticatorService extends Service {

    private String TAG = "SimpleAuthenticatorService";
    @Override
    public IBinder onBind(Intent intent) {
        SimpleAuthenticator sa = new SimpleAuthenticator(this);
        return sa.getIBinder();
    }
}
