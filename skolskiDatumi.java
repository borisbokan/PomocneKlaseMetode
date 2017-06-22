package bou.dnf.pomocneklase;

import android.content.Context;
import bou.dnf.Main;
import bou.dnf.R;

/**
 * Created by borcha on 19.1.2016..
 */
public class skolskiDatumi extends datumi{

   public static  boolean jelDatumUOpseguSkolGodine(Context _context, long _datum) {

       boolean rezZa1_2 = datumi.datumUOpsegu(Main.pocQv1, Main.kraQv2, _datum);
       boolean rezZa2_2 = datumi.datumUOpsegu(Main.pocQv3, Main.kraQv4, _datum);


        if (rezZa1_2 == true || rezZa2_2 == true) {

            return true;

        } else {
           infoPoruka.newInstance(_context,_context.getString(R.string.poruka_unosa_podatka),_context.getString(R.string.poruka_unosa_podatka_02));
            //poruka.prikazi();

            return false;
        }

    }

}
