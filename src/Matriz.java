
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author isaac
 */
public class Matriz {
    int i;
    int j;
    int m;
    int n;
    double[][] MatrizCoeficiente = new double[m][n];
    double[] MenoresDeFila= new double[m];
    int contFila=0;
    double[] MenoresDeColumna = new double[n];
    int contColumna=0;

    
    Matriz(int m, int n){
        this.m=m;
        this.n=n;
        MatrizCoeficiente = new double[m][n];
        MenoresDeFila= new double[m];
        MenoresDeColumna = new double[n];

    }
    
    public double[][] GenerarMatriz(ArrayList<Shop> shops){
      //  double[][] MatrizCoeficiente = new double[m][n];
        //Lennar Matriz con infinitos 
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                MatrizCoeficiente[k][l]= 999.0;
            }
        }
        for (int k = 0; k < shops.size(); k++) {
            for (int l = 0; l < n; l++) {
                MatrizCoeficiente[k][l]=shops.get(k).getDistanceFromDepot();
                MatrizCoeficiente[l][k]=shops.get(k).getDistanceFromDepot();
            }
        }
        return MatrizCoeficiente;

    }
    public double[][] PonerDistancias(ArrayList<Shop> shops){
        for (int k = shops.size()-1; k >=0; k--) {
            for (int l = shops.size()-1; l >=0; l--) {
                //System.out.println(shops.get(k).getX());
                //System.out.println(shops.get(k).getY());
                //System.out.println(shops.get(l).getX());
                //System.out.println(shops.get(l).getY());
                MatrizCoeficiente[k][l]= (Math.sqrt(Math.pow(shops.get(k).getX()-shops.get(l).getX(), 2)+Math.pow(shops.get(k).getY() - shops.get(l).getY(), 2)));
                if(MatrizCoeficiente[k][l]==0){
                    MatrizCoeficiente[k][l]=999.0;
                }
            }
        }
        return MatrizCoeficiente;
    }
    
    public void RestarFilas(){
        double[] arreglo = new double[m];
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                arreglo[l]=MatrizCoeficiente[k][l];
            }
            Arrays.sort(arreglo);
            MenoresDeFila[contFila] = arreglo[0];
            contFila++;
            for (int l = 0; l < 10; l++) {
                if (MatrizCoeficiente[k][l]!=999.0) {
                    MatrizCoeficiente[k][l]=MatrizCoeficiente[k][l]-arreglo[0];
                }
            }
        }
    }
    
    public void RestarColumnas(){
        double[] arreglo = new double[n];
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                arreglo[l]=MatrizCoeficiente[l][k];

            }
            Arrays.sort(arreglo);
            MenoresDeColumna[contColumna] = arreglo[0];
            contColumna++;
            for (int l = 0; l < n; l++) {
                if (MatrizCoeficiente[k][l]!=999.0) {
                    MatrizCoeficiente[l][k]=MatrizCoeficiente[l][k]-arreglo[0];
                }
            }
        }
    }
    
    public double SumarArreglos(){
        double total=0;
        for (int k = 0; k < contFila; k++) {
            total=total + MenoresDeFila[k];
        }
        for (int k = 0; k < contColumna; k++) {
            total=total + MenoresDeColumna[k];
        }
        return total;
    }
    
    void ConseguirCeros(int num){
        for (int k = 0; k < m-num; k++) {
            for (int l = 0; l < n-num; l++) {
                if(MatrizCoeficiente[k][l]==999.0){
                    System.out.println(k+""+j);
                }
            }
        }
    }
    
    void printMatriz(){
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                System.out.print("["+MatrizCoeficiente[k][l]+"]");
            }
            System.out.println("");
        }
    }
}
