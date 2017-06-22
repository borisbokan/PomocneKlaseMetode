package bou.dnf.pomocneklase;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;


//TODO: Uraditi svoju classu za poruke snimanja!!!
/**
 * Created by borcha on 30.11.2015..
 */
public class potvrdaPreSnimanja extends AlertDialog.Builder{
    String naslov;
    String poruka;

    protected potvrdaPreSnimanja(Context context,String _naslov, String _Poruka) {
        super(context);
        naslov=_naslov;
        poruka=_Poruka;
    }

    @Override
    public AlertDialog create() {
        return super.create();
    }

    @Override
    public AlertDialog.Builder setIcon(Drawable icon) {
        return super.setIcon(icon);
    }

    @Override
    public AlertDialog.Builder setPositiveButton(CharSequence text, DialogInterface.OnClickListener listener) {
        new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        };

        return super.setPositiveButton(text, listener);
    }

    @Override
    public AlertDialog.Builder setTitle(CharSequence title) {
        return super.setTitle(title);

    }

    @Override
    public AlertDialog show() {
        return super.show();
    }

    @Override
    public AlertDialog.Builder setMessage(CharSequence message) {
        return super.setMessage(message);
    }

    @Override
    public AlertDialog.Builder setNegativeButton(CharSequence text, DialogInterface.OnClickListener listener) {
        return super.setNegativeButton(text, listener);
    }
}
