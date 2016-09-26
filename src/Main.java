
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import edu.uci.ics.jung.algorithms.layout.CircleLayout;
//import edu.uci.ics.jung.algorithms.layout.Layout;
//import edu.uci.ics.jung.visualization.BasicVisualizationServer;
//import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.awt.Dimension;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author isaac
 */

public class Main {
public static Depot depot = new Depot();
public static int contTiendas = 0;
public static int numTrucks = 0;
public static File actual;
public static int contLineas = 0;
public static ArrayList<Shop> shops = new ArrayList<Shop>();
public static ArrayList<Truck> trucks = new ArrayList<Truck>();
public static double rutaTotal = 0;
//public static UndirectedSparseMultigraph grafo = new UndirectedSparseMultigraph();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*try {
			File file = new File(actual.getAbsolutePath()+"/test1.txt");
			FileWriter fileWriter = new FileWriter(file);
			//fileWriter.write("This is\n ");
			//fileWriter.write("a test");
                        
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
                        try {
/*/home/isaac/NetBeansProjects/RoutePlanner*/
                   // File file = new File(actual.getAbsolutePath() + "/entrada.txt");
                    int contChar=0;
                    File file = new File("/home/isaac/NetBeansProjects/RoutePlanner/entrada.txt");
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        if(contLineas == 0){
                            numTrucks = Integer.parseInt(String.valueOf(line.charAt(0)));
                        }
                        if(contLineas == 1){
                            for (int i = 0; i < line.length(); i++) {
                                if (i == 0){
                                    if(line.charAt(i+1)!=','){
                                        String cadena = "";
                                        cadena = cadena + line.charAt(i) + line.charAt(i+1);
                                        depot.setX(Integer.parseInt(cadena));
                                        
                                        
                                    }
                                    else{
                                        depot.setX(Integer.parseInt(String.valueOf(line.charAt(0))));
                                    }
                                }
                                if(line.charAt(i)==','){
                                    if((i+2)!= line.length()){
                                        String cadena = "";
                                        cadena = cadena + line.charAt(i+1) + line.charAt(i+2);
                                        depot.setY(Integer.parseInt(cadena));
                                    }
                                    else{
                                        depot.setY(Integer.parseInt(String.valueOf(line.charAt(i+1))));
                                    }
                                }
                            }
                        }
                        if(contLineas > 1){
                            contTiendas++;
                            Shop shop = new Shop();
                            shop.setID(contTiendas);
                            for (int i = 0; i < line.length(); i++) {
                                if (i == 0){
                                    if(line.charAt(i+1)!=','){
                                        String cadena = "";
                                        cadena = cadena + line.charAt(i) + line.charAt(i+1);
                                        shop.setX(Integer.parseInt(cadena));
                                        
                                        
                                    }
                                    else{
                                        shop.setX(Integer.parseInt(String.valueOf(line.charAt(0))));
                                    }
                                }
                                if(line.charAt(i)==','){
                                    if((i+2)!= line.length()){
                                        String cadena = "";
                                        cadena = cadena + line.charAt(i+1) + line.charAt(i+2);
                                        shop.setY(Integer.parseInt(cadena));
                                    }
                                    else{
                                        shop.setY(Integer.parseInt(String.valueOf(line.charAt(i+1))));
                                    }
                                }
                            }
                            shop.setDistanceFromDepot(depot.getX(), depot.getY());
                            shops.add(shop);
                        }
                        stringBuffer.append(line);
                        stringBuffer.append("\n");
                        contLineas++;
                    }
                    fileReader.close();
                    System.out.println("Contents of file:");
                    System.out.println(stringBuffer.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
        
        for (int i = 1; i < shops.size(); i++) {
            
            rutaTotal = rutaTotal + 
                    (Math.sqrt(Math.pow(shops.get(i).getX()-shops.get(i-1).getX(), 2)+Math.pow(shops.get(i).getY() - shops.get(i-1).getY(), 2)))+
                    shops.get(0).getDistanceFromDepot();
        }
       for (int i = 0; i < numTrucks; i++) {
            Truck truck = new Truck(i+1);
            truck.setDistanciaARecorrer(rutaTotal/numTrucks);
            trucks.add(truck);
            
        }
        System.out.println(rutaTotal/numTrucks);
        //                System.out.println(numTrucks);
       /*                 System.out.println(depot.getX());
                        System.out.println(depot.getY());
                        for (int i = 0; i < shops.size(); i++) {
                            System.out.println(shops.get(i).getID());
                            System.out.println(shops.get(i).getX());
                            System.out.println(shops.get(i).getY());
                            System.out.println(shops.get(i).getDistanceFromDepot());
        }
        */
        
    /*    grafo.addVertex(1);
       
       Layout<Integer, String> layout = new CircleLayout(grafo);
        layout.setSize(new Dimension(550, 550));
        BasicVisualizationServer<Integer, String> visualization = new BasicVisualizationServer<Integer, String>(layout);
        visualization.setPreferredSize(new Dimension(600, 600));
        visualization.getRenderContext().setLabelOffset(20);
        visualization.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        visualization.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        JFrame frame = new JFrame();
        frame.getContentPane().add(visualization);
        //Mapa.getContentPane().add(visualization);
        
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
       
        frame.setVisible(true);
*/
        //Mapa.getContentPane().add(visualization);
        
                        Matriz matriz = new Matriz(contLineas+numTrucks-2,contLineas+numTrucks-2 );
                        matriz.GenerarMatriz(shops);
              //          matriz.printMatriz();
                //        System.out.println(" ");
                        matriz.PonerDistancias(shops);
                        matriz.printMatriz();
                        System.out.println("");
                        matriz.RestarFilas();
                        matriz.printMatriz();
                        matriz.RestarColumnas();
                        System.out.println("");
                        matriz.printMatriz();
                        System.out.println(matriz.SumarArreglos());
                        matriz.ConseguirCeros(numTrucks);
                        matriz.printMatriz();
    }
    
}
