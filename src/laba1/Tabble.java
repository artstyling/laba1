package laba1;

/**
 * Created by bystr on 15/03/17.
 */
public class Tabble {
    private String pervoe;
    private String vtoroe;


    public Tabble(String pervoe,String vtoroe){

        this.pervoe = pervoe;
        this.vtoroe = vtoroe;


    }



    public Tabble(String pervoe){
        this.pervoe = pervoe;
    }

    public Tabble(){
        this.pervoe = "";
        this.vtoroe = "";

    }

    public String getPervoe() {
        return pervoe;
    }

    public void setPervoe(String pervoe) {
        this.pervoe = pervoe;
    }

    public String getVtoroe() {
        return vtoroe;
    }

    public void setVtoroe(String vtoroe) {
        this.vtoroe = vtoroe;

    }


}
