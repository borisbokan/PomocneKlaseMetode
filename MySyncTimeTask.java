package rs.aleph.android.example23.activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
/**
 * Created by borcha on 21.06.17..
 */

public class MySyncTimeTask {

    private AlarmManager manager;
    private PendingIntent pendingIntent;

    /**
     *
     * @param _context
     * @param req_code
     * @param _intent
     * @param _minOdlaganja   minuti odlaganja tj period nakon pokretanja Intenta
     */
    public MySyncTimeTask(Context _context,int req_code,Intent _intent,int _minOdlaganja){
        pendingIntent = PendingIntent.getService(_context, req_code, _intent, 0);
        manager = (AlarmManager)_context.getSystemService(Context.ALARM_SERVICE);
    }

    //Zaustavlja proces ponavljanja
    public void startRepeating(){
        manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),  calculateTimeTillNextSync(1), pendingIntent);
    }

    //Postavlja vrednsot null na referencu manager
    public void stopRepeating(){
        if(manager!=null){
            manager=null;

        }
    }
    public static int calculateTimeTillNextSync(int minutes){
        return 1000 * 60 * minutes;
    }

}
