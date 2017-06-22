package bou.dnf.pomocneklase;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import bou.dnf.R;

public class jmbg {
    Context cont;
    String unesenJmbg;
    int broj_cifara = 0;
    String dan;
    String mesec;
    String godina;

    String region;
    int pol;
    String slucajniBroj;//kontrolni broj

    int brUnesenihCifara = 0;
    public  String nazivZaPol;
    public  String nazivZaRegion;



    public jmbg(Context _cont,String _jmbg) {

        cont=_cont;
        if(_jmbg.length()<13){
            return;
        }
        unesenJmbg = _jmbg;
        brUnesenihCifara = unesenJmbg.length();

        proveriKolikoBrojeva();
        proveriKaraktere();
        izdvojDanRodjenja();
        izdvojMesecRodjenja();
        izdvojGodinuRodjenja();
        izdvojRegion();
        izdvojPol();
        izdvojSlucajniBroj();


    }

    private void proveriKolikoBrojeva() {
        if (unesenJmbg.length() > 13) {
           infoPoruka.newInstance(cont,cont.getString(R.string.poruka_unosa_podatka),cont.getString(R.string.poruka_unosa_podatka_11));
            //poruka.prikazi();

            return;

        } else if (unesenJmbg.length() < 13) {
           infoPoruka.newInstance(cont,cont.getString(R.string.poruka_unosa_podatka),cont.getString(R.string.poruka_unosa_podatka_12));
            //poruka.prikazi();

            return;
        }
    }

    private void proveriKaraktere() {
        String[] krit={"0","1","2","3","4","5","6","7","8","9"};
        String rez=unesenJmbg;

            for (int i=0;i<rez.length();i++) {
                for (String stavka : krit) {
                    if(stavka==rez.substring(i)){
                       infoPoruka.newInstance(cont,cont.getString(R.string.poruka_unosa_podatka),cont.getString(R.string.poruka_unosa_podatka_10));
                        //poruka.prikazi();

                        return;
                    }
                }

            }

    }


    private void izdvojPol() {
        //1604976830020
        int rezInt=0;

        String rez=unesenJmbg.substring(9,11);
        rezInt=Integer.valueOf(rez);

        if (rezInt != 0) {
            setPol(rezInt);

        }

        if(getPol()>0 | getPol()< 500){
            nazivZaPol="M";
        }else{
            nazivZaPol="Z";
        }

    }


    private void izdvojSlucajniBroj(){
        String rez=unesenJmbg.substring(12);
        setSlucajniBroj(rez);

    }

    private void izdvojRegion() {
        String rez=unesenJmbg.substring(7,9);
        setRegion(rez);

        for (String stavka : ucitajRegione() ) {
            final mojtoken token=new mojtoken(stavka,"|",3);
            if(rez.contentEquals(token.rezultat()[0].toString().trim())){
                nazivZaRegion=token.rezultat()[1] + "-" + token.rezultat()[2];

            }
        }
    }

    private void izdvojGodinuRodjenja() {
        String rez=unesenJmbg.substring(4,7);
        Integer rezInt=Integer.valueOf(rez);

        if(rezInt < 1000) {
            setGodina("1" + rez);
        }else{
            setGodina("2" + rez);
        }

    }

    private void izdvojMesecRodjenja() {

        String rez=unesenJmbg.substring(2,4);
        setMesec(rez);


    }

    private void izdvojDanRodjenja() {
        String rez=unesenJmbg.substring(0,2);
        setDan(rez);

    }

    public String getDan() {
        return dan;
    }


    public void setDan(String dan) {
        this.dan = dan;
    }


    public String getMesec() {
        return mesec;
    }


    public void setMesec(String mesec) {
        this.mesec = mesec;
    }


    public String getGodina() {
        return godina;
    }


    public void setGodina(String godina) {
        this.godina = godina;
    }


    public String getRegion() {
        return region;
    }


    public void setRegion(String region) {
        this.region = region;
    }

    public int getPol() {
        return pol;
    }

    public void setPol(int pol) {
        this.pol = pol;
    }

    public String getSlucajniBroj() {
        return slucajniBroj;
    }

    public void setSlucajniBroj(String slucajniBroj) {
        this.slucajniBroj = slucajniBroj;
    }

    private List<String> ucitajRegione(){

        List<String> stav=new ArrayList<String>();
            String[] instReg=cont.getResources().getStringArray(R.array.regioni);

        for (String stavka : instReg ) {
            stav.add(stavka);
        }

        return stav;
    }


    public String getDatumRodjenja(){

        if(getDan()==null || getDan()==""){
            return "Jmbg nije ispravan.";
        }else if(getMesec()==null || getMesec()=="") {
            return "Jmbg nije ispravan.";
        }else if(getGodina()==null || getGodina()==""){
            return "Jmbg nije ispravan.";
        }else{
            return getDan() + "-" + getMesec() + "-" + getGodina();
        }


    }

    public String getOkrug(){
        if(getDan()==null){
            return "Jmbg nije ispravan.";
        }else if(getMesec()==null) {
            return "Jmbg nije ispravan.";
        }else if(getGodina()==null){
            return "Jmbg nije ispravan.";
        }else{
            return nazivZaRegion;
        }


    }

}
