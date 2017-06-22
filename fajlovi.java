
import android.content.ContextWrapper;

import java.io.File;

public class fajlovi {

    public static boolean bazaPostoji(ContextWrapper context, String _path) {
        // "/data/data/bou.dnf/databases/DNFDB.db";
        File dbFile = context.getDatabasePath(_path);
        return dbFile.exists();
    }

}
