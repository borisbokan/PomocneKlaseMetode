package com.borcha.notifiservis.HelpClasses;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.borcha.notifiservis.Activity.R;

import java.util.Random;


/**
 * Helper class for showing and canceling notify me
 * notifications.
 * <p>
 * This class makes heavy use of the {@link NotificationCompat.Builder} helper
 * class to create notifications in a backward-compatible way.
 */
public class NotifyMe extends NotificationCompat.Builder{

     Context context;

    private  int NOTIFYME_ID=2001;
    private  String ticker;
    private  String title;
    private  String text;
    private  int icon;

    /**
     * NotifyMe bez PendingIntent
     * @param _conte
     * @param _idNotification
     * @param _ticker
     * @param _title
     * @param _text
     * @param _drawableIcon
     */
    public NotifyMe(Context _conte,int _idNotification,String _ticker,String _title,String _text,int _drawableIcon){
        super(_conte);
        context=_conte;
       NOTIFYME_ID=_idNotification;
        ticker=_ticker;
        title=_title;
        text=_text;       
        icon= _drawableIcon;

        setDefaults(Notification.DEFAULT_ALL);
        setSmallIcon(icon);
        setContentTitle(title);
        setContentText(text);
        setPriority(NotificationCompat.PRIORITY_DEFAULT);
        setAutoCancel(true);

    }

    /**
     * NotifiMy sa Action PendinIntent
     * @param _conte
     * @param _idNotification
     * @param _ticker
     * @param _title
     * @param _text
     * @param _drawableIcon
     * @param _Intent
     */
    public NotifyMe(Context _conte,int _idNotification,String _ticker,String _title,String _text,int _drawableIcon,Intent _Intent){
        super(_conte);
        context=_conte;
        NOTIFYME_ID=_idNotification;
        ticker=_ticker;
        title=_title;
        text=_text;
        icon= _drawableIcon;

        setDefaults(Notification.DEFAULT_ALL);
        Random random=new Random(1000);
         int bro=random.nextInt();
        PendingIntent penInte=PendingIntent.getActivity(context,bro,_Intent,0);

        // Set required fields, including the small icon, the
        // notification title, and text.
        setSmallIcon(icon);
        setContentTitle(title);
        setContentText(text);

        setPriority(NotificationCompat.PRIORITY_DEFAULT);
        addAction(R.drawable.ic_action_stat_share,"Akcija",penInte);
        setAutoCancel(true);


    }


    public  void  showMe(){
        NotificationManager notifMan=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notifMan.notify(NOTIFYME_ID,build());
    }

}
