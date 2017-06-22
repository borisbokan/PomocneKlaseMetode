

import android.content.Context;

/**
 * Created by User on 16.6.2016.
 */
public class datumIzString  {
    Context context;
    private int dan=0;
    private int mesec=0;
    private int godina=0;
    private long datumLong=0l;


    public datumIzString(Context _cont,String _datum){
        context=_cont;
        srediDatum(_datum);
    }

		
/**
* Datum mora bit unesen u formatu dan-mes-godina npr 12-3-2017 (mesec krece od 0 - jan)
* [0]-dan
* [1]-mes
* [2]-god	
*
*/
    private void srediDatum(String _datum) {


        mojtoken token=new mojtoken(_datum,"-",3);
        dan=Integer.valueOf(token.rezultat()[0]);
        mesec=Integer.valueOf(token.rezultat()[1]);
        godina=Integer.valueOf(token.rezultat()[2]);

        datumi dat=new datumi();
        datumLong= dat.uMiliSekunde(godina,mesec,dan);


    }


    public long getDatumLong() {
        return datumLong;
    }

    public void setDatumLong(long datumLong) {
        this.datumLong = datumLong;
    }

    public int getDan() {
        return dan;
    }

    public void setDan(int dan) {
        this.dan = dan;
    }

    public int getMesec() {
        return mesec;
    }

    public void setMesec(int mesec) {
        this.mesec = mesec;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }




}
