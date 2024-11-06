package com.example.myapplication;

public class Pytanie {
    private String trescPytania;
    private String[] odpowiedz= new String[3];
    private int poprawnaOdpowiedz;
    private boolean czyUdzielonoPoprawnaOdpowiedz;

    public Pytanie(String trescPytania, String odpowiedzA,String odpowiedzB,String odpowiedzC, int poprawnaOdpowiedz) {
        this.trescPytania = trescPytania;
        this.odpowiedz = new String[]{odpowiedzA, odpowiedzB, odpowiedzC};
        this.poprawnaOdpowiedz = poprawnaOdpowiedz;
        czyUdzielonoPoprawnaOdpowiedz=false;
    }
    public void sprawdzOdpowiedz(int udzielona){
        if(udzielona==poprawnaOdpowiedz){
            czyUdzielonoPoprawnaOdpowiedz=true;
        }else{
            czyUdzielonoPoprawnaOdpowiedz=false;
        }
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public String[] getOdpowiedz() {
        return odpowiedz;
    }

    public int getPoprawnaOdpowiedz() {
        return poprawnaOdpowiedz;
    }

    public boolean isCzyUdzielonoPoprawnaOdpowiedz() {
        return czyUdzielonoPoprawnaOdpowiedz;
    }

    public void setCzyUdzielonoPoprawnaOdpowiedz(boolean czyUdzielonoPoprawnaOdpowiedz) {
        this.czyUdzielonoPoprawnaOdpowiedz = czyUdzielonoPoprawnaOdpowiedz;
    }
}
