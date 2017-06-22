package bou.dnf.pomocneklase;

import android.content.Context;
import android.content.pm.PackageManager;


public class kamera  {

    public static boolean postojiKamera(Context context) {
      //Postoji li kamera na uredjaju
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }
}
