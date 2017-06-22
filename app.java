package bou.dnf.pomocneklase;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.CalendarContract;

import bou.dnf.R;


/**
 * Created by borcha on 10.2.2016..
 */
public class  app {

    public  static void zatvoriAplikaciju(Context _context){

        final AlertDialog.Builder aldZatvaranje=new AlertDialog.Builder(_context);
        aldZatvaranje.setTitle(_context.getString(R.string.izlazak));
        aldZatvaranje.setMessage(_context.getString(R.string.jeste_sigurni_u_izlazak));
        aldZatvaranje.setIcon(R.drawable.question53);

        aldZatvaranje.setPositiveButton(_context.getString(R.string.izlaz), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        }).setNegativeButton(_context.getString(R.string.odustajem), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        }).show();

    }


}
