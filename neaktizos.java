package bou.dnf.pomocneklase;

/**
 * Created by User on 10.9.2016..
 */

public class neaktizos {


    private static final  String NP_OZNAKA="NP";
    private static final  String PB_OZNAKA="PB";
    private static final  String PP_OZNAKA="PP";
    private static final  String PNO_OZNAKA="PNO";
    private static final  String ZP_OZNAKA="ZP";
    private static final  String NZR_OZNAKA="NZR";
    private static final  String ODR_OZNAKA="ODR";
    private static final  String OST_OZNAKA="OST";

    private static final  String NP_OPIS="Nije prisutna/an";
    private static final  String PB_OPIS="Prisutna/an bolestan";
    private static final  String PP_OPIS="Prisutna/an povreda";
    private static final  String PNO_OPIS="Prisutna/an nema opremu";
    private static final  String ZP_OPIS="Zenska posteda";
    private static final  String NZR_OPIS="Neraspolozena/en za rad(privatan problem)";
    private static final  String ODR_OPIS="Odbija da radi";
    private static final  String OST_OPIS="Ostalo";

    public static final int TIP_OPIS_NA_OSNOVU_OZNAKE=0;
    public static final int TIP_OZNAKA_NA_OSNOVU_OPISA=1;
    private int tip;
    private  String tipIzostanka;
    private  String oznakaILIopis;


    private String rezultatOznaka=null;
    private String rezultatOpis=null;
    private String rezultatOznakaIOpis=null;




    public neaktizos(){



    }
    public void srediPodatak(){
        if(tip==1){
            srediOznakuNAOOpisa(oznakaILIopis);
        }else{
            srediOpisNAOOznake(oznakaILIopis);
        }
    }
    /**
     *
     * @param _tipIzostanak
     */
    public neaktizos(String _tipIzostanak){

        tipIzostanka=_tipIzostanak;

        if(!tipIzostanka.equals(null) || !tipIzostanka.contentEquals("-")){
            mojtoken tok=new mojtoken(tipIzostanka,"-",2);
            String ozn=tok.rezultat()[0];
            String opi=tok.rezultat()[1];

            rezultatOznaka=ozn;
            rezultatOpis=opi;
            rezultatOznakaIOpis=ozn+"-"+opi;
        }else{
            rezultatOznaka=null;
            rezultatOpis=null;
            rezultatOznakaIOpis=null;
        }

    }
    public neaktizos(String _oznakaILIopis,int _TIP){

        oznakaILIopis = _oznakaILIopis;
        tip=_TIP;

        if(oznakaILIopis.contentEquals("-"))return;

        if(tip== TIP_OPIS_NA_OSNOVU_OZNAKE) {
            srediOpisNAOOznake(oznakaILIopis);

        }else if(tip== TIP_OZNAKA_NA_OSNOVU_OPISA) {
            srediOznakuNAOOpisa(oznakaILIopis);

        }
    }

    public String dajOznakuIOpis(){
        return rezultatOznakaIOpis;
    }

    public String dajOpis(){
        return rezultatOpis;
    }

    public String dajOznaku(){
        return rezultatOznaka;
    }

    private void srediOznakuNAOOpisa(String _opisaIzos){

        if( _opisaIzos.contentEquals(NP_OPIS)) {
            rezultatOznaka="NP";

        }else  if(_opisaIzos.contentEquals(PB_OPIS)){
            rezultatOznaka="PB";

        }

        else if(_opisaIzos.contentEquals(PP_OPIS)){
            rezultatOznaka="PP";

        }
        else if(_opisaIzos.contentEquals(PNO_OPIS)){
            rezultatOznaka="PNO";

        }
        else if(_opisaIzos.contentEquals(ZP_OPIS)) {
            rezultatOznaka="ZP";

        }else if(_opisaIzos.contentEquals(NZR_OPIS)){
            rezultatOznaka="NZR";

        }else if(_opisaIzos.contentEquals(ODR_OPIS)){
            rezultatOznaka="ODR";

        }
        else if(_opisaIzos.contentEquals(OST_OPIS)){
            rezultatOznaka="OST";

        }else{
            rezultatOznaka=null;
        }

    }


    private void srediOpisNAOOznake(String _oznakaIzos) {
        

            if( _oznakaIzos.contentEquals(NP_OZNAKA)) {
                rezultatOpis = "Nije prisutna/an";

            }else  if(_oznakaIzos.contentEquals(PB_OZNAKA)){
                rezultatOpis="Prisutna/an bolestan";

            }

            else if(_oznakaIzos.contentEquals(PP_OZNAKA)){
                rezultatOpis="Prisutna/an povreda";

            }
            else if(_oznakaIzos.contentEquals(PNO_OZNAKA)){
                rezultatOpis="Prisutna/an nema opremu";

            }
            else if(_oznakaIzos.contentEquals(ZP_OZNAKA)) {
                rezultatOpis = "Zenska posteda";

            }else if(_oznakaIzos.contentEquals(NZR_OZNAKA)){
                rezultatOpis="Neraspolozena/en za rad(privatan problem)";

            }else if(_oznakaIzos.contentEquals(ODR_OZNAKA)){
                rezultatOpis="Odbija da radi";

            }
            else if(_oznakaIzos.contentEquals(OST_OZNAKA)){
                rezultatOpis="Ostalo";

            }else{
                rezultatOpis=null;
            }

        }


    public void setTip(int tip) {
        this.tip = tip;
    }

    public void setTipIzostanka(String tipIzostanka) {
        this.tipIzostanka = tipIzostanka;
    }

    public void setOznakaILIopis(String oznakaILIopis) {
        this.oznakaILIopis = oznakaILIopis;
    }
}

