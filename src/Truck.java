/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author isaac
 */
public class Truck {
    int ID;
    int n;
    int cont = 0;
    Shop[] shops = new Shop[n];
    double DistanciaRecorrida;
    double DistanciaARecorrer;
    boolean lleno;

    public double getDistanciaARecorrer() {
        return DistanciaARecorrer;
    }

    public void setDistanciaARecorrer(double DistanciaARecorrer) {
        this.DistanciaARecorrer = DistanciaARecorrer;
    }
    
    
    

    public Truck(int ID) {
        this.ID = ID;
        this.DistanciaRecorrida = 0;
        this.n = 0;
        this.DistanciaARecorrer = 0;
        this.lleno = false;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getN() {
        return n;
    }

    public void setN() {
        this.n = n+1;
        this.shops= new Shop[this.n];
    }

    public Shop[] getShops() {
        return shops;
    }

    public boolean isLleno() {
        return lleno;
    }

    public int getCont() {
        return cont;
    }
    
    public void setShops(Shop shop) {
        this.shops[cont] = shop;
        cont++;
        if(cont==n){
            this.lleno=true;
            setDistanciaRecorrida(this.shops[cont-1].getDistanceFromDepot());
        }
    }

    public double getDistanciaRecorrida() {
        return DistanciaRecorrida;
    }

    public void setDistanciaRecorrida(double DistanciaRecorrida) {
        this.DistanciaRecorrida = this.DistanciaRecorrida + DistanciaRecorrida;
    }
    
    
    
}
