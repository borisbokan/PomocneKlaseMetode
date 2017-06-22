package bou.dnf.pomocneklase;

/**
 * Created by borcha on 10.1.2016..
 */
public class jedmere {
    public static final int METAR = 0;
    public static final int CENTI_METAR = 1;
    public static final int MILI_METAR = 2;
    public static final int DECI_METAR = 3;

    public static final int VREME = 4;

    public static final int BROJ_PONAVLJANJA = 6;

    public int merint;
    public float merflo;
    public String merstr;

    public int sat;
    public int min;
    public int sek;


    private String rezultat;



    public jedmere(float _vrednost, int _mera) {
        merflo = _vrednost;
        formatirajPoMeri(_mera,String.valueOf(_vrednost));

    }



    public jedmere(int _vrednost, int _mera) {
        merint = _vrednost;
        formatirajPoMeri(_mera,String.valueOf(_vrednost));


    }

    public jedmere(String _vrednost, int _mera) {
        merstr = _vrednost;
        formatirajPoMeri(_mera,String.valueOf(_vrednost));

    }


    public jedmere(int _sat,int _min,int _sek){
        int sat=0,min=0,sek=0;
        sat=_sat;min=_min;sek=_sek;

        if(sat==0){
            rezultat="00:" + min + ":" + sek;
        }
        else if(sat==0 && min==0){
            rezultat="00:00:" + sek;
        }

        else{
           return;
        }

    }

    public String dajRez(){
        return rezultat;
    }

    private void formatirajPoMeri(int mera, String vred) {

        switch (mera){
            case BROJ_PONAVLJANJA:
                rezultat=vred + " X";
                break;

            case METAR:
                rezultat=vred + " met";
                break;

            case DECI_METAR:
                rezultat=vred + " dcm";
                break;

            case CENTI_METAR:
                rezultat=vred + " cm";
                break;

            case MILI_METAR:
                rezultat=vred + " mm";
                break;


        }

    }

}