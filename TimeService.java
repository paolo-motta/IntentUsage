package it.cnr.iit.intentusageexample;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.telephony.SmsManager;

import java.util.Timer;
import java.util.TimerTask;

public class TimeService extends Service {
        // constant
        public static final long NOTIFY_INTERVAL = 1 * 1000;

        // run on another Thread to avoid crash
        private Handler mHandler = new Handler();
        // timer handling
        private Timer mTimer = null;
        int timeOn=0;


        @Override
        public void onCreate() {
            // cancel if already existed
            if(mTimer != null) {
                mTimer.cancel();
            } else {
                // recreate new
                mTimer = new Timer();
            }
            // schedule task
            mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 0, NOTIFY_INTERVAL);
        }

        class TimeDisplayTimerTask extends TimerTask {

            @Override
            public void run() {
                // run on another thread
                mHandler.post(new Runnable() {

                    @Override
                    public void run() {
                        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
                        if(pm.isInteractive())
                            timeOn++;
                    }

                });
            }


        }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void sendSMS(String address, String message){
        SmsManager sm = SmsManager.getDefault();
        sm.sendTextMessage(address,null, message, null, null);
    }
}
