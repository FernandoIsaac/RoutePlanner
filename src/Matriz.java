
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
    //int i;
    //int j;
    int m;
    int n;
    double[][] MatrizCoeficiente = new double[m][n];
    double[] MenoresDeFila= new double[m];
    int contFila=0;
    double[] MenoresDeColumna = new double[n];
    int contColumna=0;
    double[] Origenes;
    int[] IDs;
    int[] IDsT;
    int ciudadesLlenadas=0;
    private static int N;
   private static int left;
   private static int right;
   private static int largest;
   private static int[] a;
   private static double[] b;
    
    Matriz(int m, int n){
        this.m=m;
        this.n=n;
        MatrizCoeficiente = new double[m][n];
        MenoresDeFila= new double[m];
        MenoresDeColumna = new double[n];
        Origenes = new double [m];
        IDs = new int[99999];
        IDsT = new int[99999];

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
    
    public void AsignarCiudades(ArrayList<Shop> shops, ArrayList<Truck> trucks){
        //for (int k = 0; k < IDs.length; k++) {
          //  System.out.println(IDs[k]);
        //}
        for (int k = 0; k < trucks.size(); k++) {
            trucks.get(k).setShops(shops.get(IDs[k]-1));
           // System.out.println("shops"+shops.get(IDs[k]-1).getID());
           // System.out.println("TRUCKS"+trucks.get(k).getShops()[0].getID());
            trucks.get(k).setDistanciaRecorrida(shops.get(IDs[k]-1).getDistanceFromDepot());
            shops.get(IDs[k]-1).setFlag(true);
            ciudadesLlenadas++;
        }
        for (int k = 0; k < trucks.size(); k++) {
                //System.out.println("trucks1"+trucks.get(k).getShops()[0].getID());
            
        }
        do{
           // System.out.println(ciudadesLlenadas+" ciudades llenadas");
           // System.out.println("vuelve al do while");
        for (int k = 0; k < IDs.length; k++) {
            IDs[k]=999;
        }
        double[] controlador = new double[999999];
        for (int k = 0; k < controlador.length; k++) {
            controlador[k]=999;
        }
            for (int k = 0; k < IDsT.length; k++) {
                IDsT[k]=999;
            }
            //System.out.println("phase 1 complete");
        int cont=0;
        int Disponibles=0;
        for (int k = 0; k < shops.size(); k++) {
           // System.out.println("phase 2");
            if(shops.get(k).isFlag()==false){
             //   System.out.println("phase 3");
                for (int l = 0; l < trucks.size(); l++) {
               //     System.out.println("phase 4");
                    if(trucks.get(l).isLleno()==false){
                 //       System.out.println("phase 5");
                        Disponibles++;
                   //     System.out.println("Disponibles"+Disponibles);
                        //System.out.println(MatrizCoeficiente[trucks.get(l).getShops()[trucks.get(l).getCont()-1].getID()-2][shops.get(k).getID()-1]);
                        for (int o = k+1; o < shops.size(); o++) {
                     //       System.out.println("phase 6");
                            if(shops.get(o).isFlag()==false){
                       //         System.out.println("phase 7");
                                System.out.println(MatrizCoeficiente[trucks.get(l).getShops()[trucks.get(l).getCont()-1].getID()-1][shops.get(o).getID()-1]);
                                if(MatrizCoeficiente[trucks.get(l).getShops()[trucks.get(l).getCont()-1].getID()-1][shops.get(k).getID()-1]<
                                   MatrizCoeficiente[trucks.get(l).getShops()[trucks.get(l).getCont()-1].getID()-1][shops.get(o).getID()-1]){
                         //           System.out.println("phase 8");
                                    controlador[cont]=MatrizCoeficiente[trucks.get(l).getShops()[trucks.get(l).getCont()-1].getID()-1][shops.get(k).getID()-1];
                                    cont++;
                                }else{
                           //         System.out.println("phase 9");
                                    controlador[cont]=MatrizCoeficiente[trucks.get(l).getShops()[trucks.get(l).getCont()-1].getID()-1][shops.get(o).getID()-1];
                                    cont++;
                                }
                                        //controlador[cont]=
                                  //      MatrizCoeficiente[trucks.get(l).getShops()[trucks.get(l).getCont()-1].getID()-2][shops.get(k).getID()-1]+
                                    //    MatrizCoeficiente[trucks.get(l).getShops()[trucks.get(l).getCont()-1].getID()-2][shops.get(o).getID()-1];
                                //cont++;
                            }
                        }
                    }
                }
            }
        }
            //.out.println("phase 1-9 complete");
        //for (int k = 0; k < controlador.length; k++) {
          //  System.out.println("controlador");
          //  System.out.println(controlador[k]);
        //}
        //Arrays.sort(controlador);
            int optimize=0;
            for (int i = 0; i < controlador.length; i++) {
                
                optimize++;
                if(controlador[i]==999){
                    break;
                }
            }
        double[] controladorCorto = new double[optimize];
            for (int i = 0; i < controladorCorto.length; i++) {
                controladorCorto[i]=controlador[i];
                System.out.println(controladorCorto[i]+"controloador corto"+i);
            }
            
        sort2(controladorCorto);
        for (int d = 0; d < controlador.length; d++) {
            for (int k = 0; k < shops.size(); k++) {
                if(shops.get(k).isFlag()==false){
                    for (int l = 0; l < trucks.size(); l++) {
                        if(trucks.get(l).isLleno()==false){
                            //System.out.println(MatrizCoeficiente[trucks.get(l).getShops()[trucks.get(l).getCont()-1].getID()-2][shops.get(k).getID()-1]);
                            for (int o = k+1; o < shops.size(); o++) {
                                if(shops.get(o).isFlag()==false){
                                    //System.out.println(MatrizCoeficiente[trucks.get(l).getShops()[trucks.get(l).getCont()-1].getID()-2][shops.get(o).getID()-1]);
                                    if(controlador[d]==
                                            MatrizCoeficiente[trucks.get(l).getShops()[trucks.get(l).getCont()-1].getID()-1][shops.get(k).getID()-1]||
                                            controlador[d]==
                                            MatrizCoeficiente[trucks.get(l).getShops()[trucks.get(l).getCont()-1].getID()-1][shops.get(o).getID()-1]){
                                        IDsT[d]=trucks.get(l).getID();
                                    }
                                    if(controlador[d]==
                                            MatrizCoeficiente[trucks.get(l).getShops()[trucks.get(l).getCont()-1].getID()-1][shops.get(k).getID()-1]
                                            &&d<cont){
                                        IDs[d]=shops.get(k).getID();
                                    }else if(controlador[d]==
                                            MatrizCoeficiente[trucks.get(l).getShops()[trucks.get(l).getCont()-1].getID()-1][shops.get(o).getID()-1]
                                            &&d<cont){
                                        IDs[d]=shops.get(o).getID();
                                    }
                                  
                                }
                            }
                        }
                    }
                }
            }  
        }
        int kk=0;
        int ll=0;
        //    System.out.println("Tal vez esta es la solucion");
            if(ciudadesLlenadas == shops.size()-1){
           //     System.out.println("entro a ciudadesLlenadas if");
                for (int k = 0; k < shops.size(); k++) {
                    if(shops.get(k).isFlag()==false){
              //          System.out.println("Entro a shops flag is false if");
                        for (int l = 0; l < trucks.size(); l++) {
                            if(trucks.get(l).isLleno()==false){
                                IDs[k]=shops.get(k).getID();
                                IDsT[l]=trucks.get(l).getID();
                                controlador[0]=MatrizCoeficiente[trucks.get(l).getShops()[trucks.get(l).getShops().length-2].getID()-1][shops.get(k).getID()-1];
                             //   System.out.println("IDsk: "+IDs[k]);
                                kk=k;
                             //   System.out.println("IDsTl"+IDsT[l]);
                                ll=l;
                                break;
                            }
                        }
                    }
                }
            }
        //for (int t = 0; t < trucks.size(); t++) {
          //  System.out.println(trucks.get(t).getShops()[0].getID());
        //}
    //    System.out.println("JAS");
      //  for (int k = 0; k < IDsT.length; k++) {
        //  System.out.println(IDsT[k]);
        //}
        //System.out.println("jas");
        //for (int k = 0; k < IDs.length; k++) {
          //  System.out.println(IDs[k]);
        //}
          //  System.out.println("kk"+kk);
            //System.out.println("ll"+ll);
        trucks.get(IDsT[ll]-1).setShops(shops.get(IDs[kk]-1));
        trucks.get(IDsT[ll]-1).setDistanciaRecorrida(controlador[0]);
        shops.get(IDs[kk]-1).setFlag(true);
            //System.out.println(trucks.get(IDsT[ll]-1).getShops()[0].getID()+""+trucks.get(IDsT[ll]-1).getShops()[1].getID()+""+trucks.get(IDsT[ll]-1).isLleno());
        ciudadesLlenadas++;
        }while(ciudadesLlenadas!=shops.size());
        
        //for (int k = 0; k < m-trucks.size(); k++) {
          //  for (int l = 0; l < n-trucks.size(); l++) {
                
            //}
        //}
    }
    
       public static void buildheap(int []a) {
      N = a.length-1;
      for(int i=N/2; i>=0; i--){
         maxheap(a,i);
      }
   }
 
   public static void maxheap(int[] a, int i) { 
      left = 2*i;
      right = 2*i+1;
 
      if(left <= N && a[left] > a[i]){
         largest=left;
      } else {
         largest=i;
      }
 
      if(right <= N && a[right] > a[largest]) {
         largest=right;
      }
      if(largest!=i) {
         exchange(i, largest);
         maxheap(a, largest);
      }
   }
 
   public static void exchange(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t; 
   }
   
   public static void exchange2(int i, int j) {
        double t = b[i];
        b[i] = b[j];
        b[j] = t; 
   }
 
   public static void sort(int[] myarray) {
      a = myarray;
      buildheap(a);
      for(int i=N; i>0; i--) {
         exchange(0, i);
         N=N-1;
         maxheap(a, 0);
      }
   }
   
    public static void buildheap2(double []b) {
      N = b.length-1;
      for(int i=N/2; i>=0; i--){
         maxheap2(b,i);
      }
   }
 
   public static void maxheap2(double[] b, int i) { 
      left = 2*i;
      right = 2*i+1;
 
      if(left <= N && b[left] > b[i]){
         largest=left;
      } else {
         largest=i;
      }
 
      if(right <= N && b[right] > b[largest]) {
         largest=right;
      }
      if(largest!=i) {
         exchange2(i, largest);
         maxheap2(b, largest);
      }
   }
   public static void sort2(double[] myarray) {
      b = myarray;
      buildheap2(b);
      for(int i=N; i>0; i--) {
         exchange2(0, i);
         N=N-1;
         maxheap2(b, 0);
      }
   }
    
    void Inicio(/*int num*/ ArrayList<Shop> shops){
        double [] arreglo = new double[shops.size()];
        for (int k = 0; k < shops.size(); k++) {
            arreglo[k]=shops.get(k).getDistanceFromDepot();
        }
        int[] ids = new int[arreglo.length];
        Arrays.sort(arreglo);
        for (int k = 0; k < arreglo.length; k++) {
            for (int l = 0; l < shops.size(); l++) {
                if (arreglo[k] == shops.get(l).getDistanceFromDepot()){
                    ids[k]=shops.get(l).getID();
                }
            }
        }
        for (int k = 0; k < ids.length; k++) {
            //System.out.println(ids[k]);
            IDs[k]=ids[k];
        }
        for (int k = 0; k < arreglo.length; k++) {
            Origenes[k]=arreglo[k];
        }
       /* for (int k = num; k < m; k++) {
            for (int l = 0; l < n; l++) {
                arreglo[l]=MatrizCoeficiente[k][l];
            }
            Arrays.sort(arreglo);
        }
        for (int k = 0; k < arreglo.length; k++) {
            Origenes[k]= arreglo[k];
        }*/
        
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
