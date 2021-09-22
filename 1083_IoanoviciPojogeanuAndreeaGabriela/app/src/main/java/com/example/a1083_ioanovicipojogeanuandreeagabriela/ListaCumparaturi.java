package com.example.a1083_ioanovicipojogeanuandreeagabriela;

import java.io.Serializable;
import java.util.Date;

public class ListaCumparaturi implements Serializable {
    private int buget;
    private String magazin;
    private String genObiecte;
    private int oraCumparaturi;
    private int cantitate;

    public int getBuget() {
        return buget;
    }

    public void setBuget(int buget) {
        this.buget = buget;
    }

    public String getMagazin() {
        return magazin;
    }

    public void setMagazin(String magazin) {
        this.magazin = magazin;
    }

    public String getGenObiecte() {
        return genObiecte;
    }

    public void setGenObiecte(String genObiecte) {
        this.genObiecte = genObiecte;
    }

    public int getOraCumparaturi() {
        return oraCumparaturi;
    }

    public void setOraCumparaturi(int oraCumparaturi) {
        this.oraCumparaturi = oraCumparaturi;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public ListaCumparaturi(int buget, String magazin, String genObiecte, int oraCumparaturi, int cantitate) {
        this.buget = buget;
        this.magazin = magazin;
        this.genObiecte = genObiecte;
        this.oraCumparaturi = oraCumparaturi;
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        return "ListaCumparaturi{" +
                "buget=" + buget +
                ", magazin='" + magazin + '\'' +
                ", genObiecte='" + genObiecte + '\'' +
                ", oraCumparaturi=" + oraCumparaturi +
                ", cantitate=" + cantitate +
                '}';
    }
}
