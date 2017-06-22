package bou.dnf.pomocneklase;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import bou.dnf.R;

/**
 * Created by borcha on 12.1.2017..
 */

public class sistemskiPodaci {

    private static Context context;

    public sistemskiPodaci(Context _context){
        context=_context;
    }

    public String getNalogTelefona() {
        Account[] nalozii= AccountManager.get(context).getAccounts();
        String nalozi="";
        String rezultat="";

        int brNaloga=nalozii.length;
        if(brNaloga>1){
            for (Account stavka : nalozii) {

                Log.i("nalozi",nalozi+=stavka.toString());

            }

        nalozi=nalozii[0].toString();
        rezultat = this.StripAcountMail(nalozi);

        }else if(brNaloga==1) {
            nalozi=nalozii[0].toString();
            rezultat = this.StripAcountMail(nalozi);
        }else{
           infoPoruka.newInstance(context,"Nalog telefona","Nemate registrovan nalog na telefonu!");
            //poruka.prikazi();
        }


        return rezultat;
    }

    public static String StripAcountMail(String _sadrzaj){

            mojtoken tok1 = new mojtoken(_sadrzaj, ",", 2);
            String rez = tok1.rezultat()[0];

            mojtoken tok2 = new mojtoken(rez, "=", 2);
            String rez2 = tok2.rezultat()[1];

            if (rez2.equals(null) || rez2.contentEquals("")) {
                String sadPoruke = context.getString(R.string.poruka_sistema_01).toString();

                infoPoruka.newInstance(context, "Upozorenje", sadPoruke);
                //poruka.prikazi();
            }
          return rez2.trim().toString();

    }

        public  String getPodaciUredjaja(){
            String podaci=null;
                    podaci+=Build.BOARD + "\n" +
                           "Device:" + Build.DEVICE + " \n " +
                           "Brand:" + Build.BRAND + " \n " +
                            "ID:" + Build.ID + " \n " +
                            "Model:"+ Build.MODEL + " \n " +
                            "User:"+ Build.USER + " \n " +
                            "Hardvare:"+ Build.HARDWARE + " \n " +
                            "Host:" + Build.HOST + " \n " +
                            "VERS: " + String.valueOf(Build.VERSION.SDK_INT) + " \n ";
            return podaci;
        }



    public String getBrojTelefonaUredjaja(){
        String brojTelefona=null;

        TelephonyManager tMgr = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        brojTelefona = tMgr.getLine1Number();

        if (brojTelefona.contentEquals("")) {

            brojTelefona="Broj telefona ne postoji u uredjaju";
        }

        return brojTelefona;
    }


    public void  proveriKriterijumAPI(){

        if(Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT > 25){
            infoPoruka.newInstance(context,context.getString(R.string.instalacija),context.getString(R.string.poruka_instalacije_01));
            //poruka.prikazi();
        }


    }

}
