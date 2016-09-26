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
    Shop[] shops = new Shop[n];
    double DistanciaRecorrida;
    double DistanciaARecorrer;

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

    public void setN(int n) {
        this.n = n;
    }

    public Shop[] getShops() {
        return shops;
    }

    public void setShops(Shop[] shops) {
        this.shops = shops;
    }

    public double getDistanciaRecorrida() {
        return DistanciaRecorrida;
    }

    public void setDistanciaRecorrida(double DistanciaRecorrida) {
        this.DistanciaRecorrida = this.DistanciaRecorrida + DistanciaRecorrida;
    }
    
    
    
}
