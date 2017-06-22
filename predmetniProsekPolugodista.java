package bou.dnf.pomocneklase;

public class predmetniProsekPolugodista {

    public Float prosek1_2pg_numericki;
    public Float prosek2_2pg_numericki;
    public String prosek1_2pg_slovno;
    public String prosek2_2pg_slovno;
    int brOcena = 0;
    String[][] ocene;
    long poSkGo;
    long krPrPoGo;
    long poDrPoGo;
    long krSkGo;
    int br1_2Pred = 0;
    int br2_2Pred = 0;
    Integer[] tr1_2Pred;
    Integer[] tr2_2Pred;
    prosekOcene proOcePred_1_2;
    prosekOcene proOcePred_2_2;

    public predmetniProsekPolugodista(long  _pocSkGo, long  _krPrPoGo, long _poDrPoGo, long _krSkGo, String[]... _ocene) {
        ocene = _ocene;

        poSkGo = _pocSkGo;
        krPrPoGo = _krPrPoGo;
        poDrPoGo = _poDrPoGo;
        krSkGo = _krSkGo;

        tr1_2Pred = new Integer[50];
        tr2_2Pred = new Integer[50];

        racunaj();
    }


    private void racunaj() {

        for (int i = 0; i < ocene[0].length; i++) {

            if (datumi.datumUOpsegu(poSkGo, krPrPoGo, Long.parseLong(ocene[1][i]))) {

                tr1_2Pred[br1_2Pred] = Integer.valueOf(ocene[0][i]);
                br1_2Pred++;
            } else if (datumi.datumUOpsegu(poDrPoGo, krSkGo, Long.parseLong(ocene[1][i]))) {

                tr2_2Pred[br2_2Pred] = Integer.valueOf(ocene[0][i]);
                br2_2Pred++;
            }
        }

        proOcePred_1_2 = new prosekOcene(ocistiNizOdNull_int(tr1_2Pred));
        proOcePred_2_2 = new prosekOcene(ocistiNizOdNull_int(tr2_2Pred));

        prosek1_2pg_numericki = proOcePred_1_2.prosek;
        prosek2_2pg_numericki = proOcePred_2_2.prosek;

        prosek1_2pg_slovno = proOcePred_1_2.uspeh_slovno;
        prosek2_2pg_slovno = proOcePred_2_2.uspeh_slovno;

    }

    //ciscenje niza od null Integer object
    public Integer[] ocistiNizOdNull_int(Integer... _niz) {
        int br = 0;
        for (Integer i : _niz) {
            if (i != null) {
                br++;
            }
        }

        Integer[] ociscen = new Integer[br];
        for (int i = 0; i < br; i++) {
            ociscen[i] = _niz[i];
        }
        return ociscen;

    }

    //ciscenje niza od null String object
    public String[] ocistiNizOdNull_int(String... _niz) {
        int br = 0;
        for (String i : _niz) {
            if (i != null) {
                br++;
            }
        }

        String[] ociscen = new String[br];
        System.arraycopy(_niz, 0, ociscen, 0, br);
        return ociscen;

    }


}
