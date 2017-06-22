package bou.dnf.pomocneklase;

public class prosekOcene {

    public static final String uspeh_odlican_num = "5";
    public static final String uspeh_vrdobar_num = "4";
    public static final String uspeh_dobar_num = "3";
    public static final String uspeh_dovoljan_num = "2";
    public static final String uspeh_nedovoljan_num = "1";
    public static final String uspeh_odlican_slo = "ODLICAN";
    public static final String uspeh_vrdobar_slo = "Vr DOBAR";
    public static final String uspeh_dobar_slo = "DOBAR";
    public static final String uspeh_dovoljan_slo = "DOVOLJAN";
    public static final String uspeh_nedovoljan_slo = "NEDOVOLJAN";
    public int brojOcena;
    public float sumaOcena;
    public float prosek;
    public String uspeh_slovno;
    public String uspeh_numericki;
    Integer[] ocene;


    public prosekOcene(Integer... oceneNiz) {
        ocene = oceneNiz;
        brojOcena = ocene.length;
        sumaOcena = sumiraj();
        izracunaj();
        dajUspeh(prosek);
    }

    private float sumiraj() {
        int br = 0;
        for (int i = 0; i < brojOcena; i++) {
            br += ocene[i];
        }
        return br;

    }

    private void izracunaj() {
        if (brojOcena <= 0) {
            prosek = 0.00f;
        } else if (sumaOcena < 0) {
            prosek = 0.00f;
        } else {
            prosek = Float.valueOf(sumaOcena / brojOcena);
        }

    }


    //izracunava uspeh i upisuje u promenjivu NUMERICKU i SLOVNU.
    private void dajUspeh(float _prosek) {

        if (_prosek < 1.50) {
            //1
            uspeh_slovno = uspeh_nedovoljan_slo;
            uspeh_numericki = uspeh_nedovoljan_num;

        } else if (_prosek > 1.49 && _prosek < 2.50) {
            //2
            uspeh_slovno = uspeh_dovoljan_slo;
            uspeh_numericki = uspeh_dovoljan_num;
        } else if (_prosek > 2.49 && _prosek < 3.50) {
            //3
            uspeh_slovno = uspeh_dobar_slo;
            uspeh_numericki = uspeh_dobar_num;
        } else if (_prosek > 3.49 && _prosek < 4.50) {
            //4
            uspeh_slovno = uspeh_vrdobar_slo;
            uspeh_numericki = uspeh_vrdobar_num;
        } else if (_prosek > 4.49 && _prosek < 5.00) {
            //5
            uspeh_slovno = uspeh_odlican_slo;
            uspeh_numericki = uspeh_odlican_num;
        } else {
            //greska
        }


    }

}
