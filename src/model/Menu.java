/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gekyumeu
 */
public class Menu {
    private int menu_id;
    private String menu_name;
    private int purchased_quantity;
    private float price;
}

class Meals extends Menu {

    private String Tapsilog;
    private String Sisig;
    private String CrispyPata;
    
    public String getTapsilog() {
        return Tapsilog;
    }

    public void setTapsilog(String Tapsilog) {
        this.Tapsilog = Tapsilog;
    }

    public String getSisig() {
        return Sisig;
    }

    public void setSisig(String Sisig) {
        this.Sisig = Sisig;
    }

    public String getCrispyPata() {
        return CrispyPata;
    }

    public void setCrispyPata(String CrispyPata) {
        this.CrispyPata = CrispyPata;
    }
}

class Beverages extends Menu {

    private String Water;
    private String Juice;
    private String Coke;
    
    public String getWater() {
        return Water;
    }

    public void setWater(String Water) {
        this.Water = Water;
    }

    public String getJuice() {
        return Juice;
    }

    public void setJuice(String Juice) {
        this.Juice = Juice;
    }

    public String getCoke() {
        return Coke;
    }

    public void setCoke(String Coke) {
        this.Coke = Coke;
    }
}

class Desserts extends Menu {

    private String MangoGrahams;
    private String LecheFlan;
    private String MacaroniSalad;
    
    public String getMangoGrahams() {
        return MangoGrahams;
    }

    public void setMangoGrahams(String MangoGrahams) {
        this.MangoGrahams = MangoGrahams;
    }

    public String getLecheFlan() {
        return LecheFlan;
    }

    public void setLecheFlan(String LecheFlan) {
        this.LecheFlan = LecheFlan;
    }

    public String getMacaroniSalad() {
        return MacaroniSalad;
    }

    public void setMacaroniSalad(String MacaroniSalad) {
        this.MacaroniSalad = MacaroniSalad;
    }
}
