package syncClasses;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by priyasindkar on 14-09-2015.
 */
public class SimpleSyncAdapterService extends Service {

    private String TAG = "SimpleSyncAdapterService";
    @Override
    public IBinder onBind(Intent intent) {
        SimpleSyncAdapter ssa = new SimpleSyncAdapter(getApplicationContext(),true);
        return ssa.getSyncAdapterBinder();
    }
}
