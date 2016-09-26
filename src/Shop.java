
import java.util.ArrayList;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author isaac
 */
public class Shop {
    int ID;
    boolean flag;
    int x;
    int y;
    double DistanceFromDepot;

    public Shop(int ID, int x, int y) {
        this.ID = ID;
        this.flag = false;
        this.x = x;
        this.y = y;
    }
    
    public Shop(){
        this.flag = false;
        this.x = 0;
        this.y = 0;
        this.ID = 0;
    }

    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getDistanceFromDepot() {
        return DistanceFromDepot;
    }

    public void setDistanceFromDepot(int x, int y) {
      //  this.DistanceFromDepot = DistanceFromDepot;
        this.DistanceFromDepot = (Math.sqrt(Math.pow(this.x-x, 2)+Math.pow(this.y - y, 2)));
        
    }
    
    public double DistanciaEntreNodos(int i, ArrayList<Shop> shops){
        double distance;
        distance = (Math.sqrt(Math.pow(this.x-shops.get(i).getX(), 2)+Math.pow(this.y - shops.get(i).getY(), 2)));
        return distance;
    }
    
    
}
