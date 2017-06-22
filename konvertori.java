package bou.dnf.pomocneklase;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.StringTokenizer;

public class konvertori {

    /**
     * Vraca tj konvertuje bulovu u broj<br>
     * Ako je <b>TRUE onda je rezultat 1, Ukoliko je FALSE rezultat je 0..</b>
     *
     * @param bulVredZaKonv
     * @return int
     */
    public static int bool2numb(boolean bulVredZaKonv) {
        int rez;
        if (bulVredZaKonv) {
            rez = 1;
        } else {
            rez = 0;
        }

        return rez;
    }

    /**
     * Vraca tj konvertuje broj u bulovu _oznaka.<br>
     * Ako je <b>Ako je _oznaka 1 onda je rezultat TRUE , Ukoliko je 0 onda je
     * rezultat FALSE </b>
     *
     * @param intVredZaKonv
     * @return boolean
     */
    public static boolean numb2bool(int intVredZaKonv) {
        boolean rez;
        rez = intVredZaKonv == 1;

        return rez;
    }

    /**
     * Konvertuje tip blob (SQlite) u niz bajtova (byte[])
     *
     * @param _blobVred
     * @return byte[]
     * @throws SQLException
     */
    public static byte[] blobToByte(Blob _blobVred) {

        byte[] rez = null;

        try {
            int duzina = (int) _blobVred.length();
            rez = _blobVred.getBytes(1, duzina);
            _blobVred.free();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return rez;

    }

    public static String dveDecimale(float _broj) {
        String rez = String.format("%.2f", _broj);
        return rez;

    }

    // Uzima oznaku izostanka tj izdvaja ceo opis sa prefiksom i oznakom .Odvaja
    // oznaku od opisa.
    public static String oznakaIzostanka(String _ceoString) {

        StringTokenizer tok = new StringTokenizer(_ceoString, "-");

        String oznaka = "";
        String opis = "";

        while (!tok.hasMoreTokens()) {
            oznaka = String.valueOf(tok.nextToken());
            opis = String.valueOf(tok.nextToken());

        }

        return oznaka;
    }

    /**
     *  Vraca dva sloga od jednog texta podeljen oznakom npr. "-"...<br>
     *      npr. 100111-109229 podelje oznakm "-" daje dva sloga <br>
     *          [0] 1000111 <br>
     *          [1] 109229 <br>
     * @param _ceoText
     * @param _karakter
     * @return niz[2]
     */
    public static String[] getSlog_naDva(String _ceoText,String _karakter) {
        String[] slogovi=_ceoText.split(_karakter);
        int brSlo=slogovi.length;
        String rez[]=new String[2];

       for(int i=0;i < brSlo;i++){
           rez[0] = String.valueOf(slogovi[0].trim());
           rez[1] = String.valueOf(slogovi[1].trim());
       }

        return rez;
    }

    // Vraca opis oznke izostanka.
    public static String ceoOpisOznake(String _oznaka) {

        if (_oznaka == "") {
            return "Niste zadali kriterijum?";
        } else if (_oznaka == "NP") {
            return "(NP) Nije prisutna-an";
        } else if (_oznaka == "PB") {

            return "(PB) Prisutan bolestan";
        } else if (_oznaka == "PP") {

            return "(PP) Prisutna-an povreda";
        } else if (_oznaka == "PNO") {

            return "(PNO) Prisutna-an nema opremu";
        } else if (_oznaka == "ZP") {

            return "(ZP) Zenska posteda";
        } else if (_oznaka == "NZR") {

            return "(NZR) Neraspolozen za rad";
        } else if (_oznaka == "ODR") {

            return "(ODR) Odbija da radi";
        } else if (_oznaka == "OST") {

            return "(OST) Ostalo";
        } else if (_oznaka == "APO") {

            return "(APO) Absolutno oslobodjen";
        } else if (_oznaka == "DEO") {

            return "DEO-Delimicno oslobodjen";
        } else if (_oznaka == "") {
            return "Oznaka pogresna!";
        } else {
            return "Nije dobra oznaka!";
        }

    }


    //Ocisti String niz od null vrednosti
    public String[] ocistiNizOdNull(String... _niz) {
        int brPrec = 0;

        for (int i = 0; i < _niz.length; i++) {
            if (_niz[i] != null) {
                brPrec++;
            }
        }

        String[] prec = new String[brPrec];
        System.arraycopy(_niz, 0, prec, 0, brPrec);
        return prec;
    }


}
