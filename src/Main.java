/*
*Andres Berthet 171504
* Hoja de Trabajo 9
* 17 de Mayo de 2019
* Algoritmos y estructura de deatos
* */
import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Scanner ;
import java.io.*;

public class Main {
    private static Object ArrayList;

    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> Mapa = new HashMap<>();
        int[][] grafo = new int[5][5];
        int a = 0;
        Scanner input = new Scanner(System.in);// crea el scanner
        System.out.println("ingrese donde se localiza el archivo con las ciudades: ");// bufferReader codigo basado de los ejemplos encontrados en la pagina : https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
        String fileName = input.next();// se pide el ingreso de la direccion del file
        File file = new File(fileName);// crea el file
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) { //crea while donde se agregan las ciudades a un hash map
            //process the line
            String[] parts = line.split(",");// se separa el string que da el buffer reader
            if (!Mapa.containsKey( parts[0])){
                Mapa.put(parts[0],a);// se guarda en el mapa con su key y value adecuado
                a =a+1;
            }
            if (!Mapa.containsKey(parts[1])) {
                Mapa.put(parts[1],a);
                a = a+1;
            }
            System.out.println(a);
            System.out.println(parts[0]+" "+Mapa.get(parts[0])+" "+parts[1]+" "+Mapa.get(parts[1]));
            Integer distancia = Integer.valueOf(parts[2]);
            grafo[Mapa.get(parts[0])][Mapa.get(parts[1])]= distancia;
        }
        System.out.println(grafo[0][0]+" "+grafo[0][1]+" "+grafo[0][2]+" "+grafo[0][3]+" "+grafo[0][4]);
        System.out.println(grafo[0][0]+" "+grafo[1][1]+" "+grafo[1][2]+" "+grafo[1][3]+" "+grafo[1][4]);
        System.out.println(grafo[0][0]+" "+grafo[2][1]+" "+grafo[2][2]+" "+grafo[2][3]+" "+grafo[2][4]);
        System.out.println(grafo[0][0]+" "+grafo[3][1]+" "+grafo[3][2]+" "+grafo[3][3]+" "+grafo[3][4]);
        System.out.println(grafo[0][0]+" "+grafo[4][1]+" "+grafo[4][2]+" "+grafo[4][3]+" "+grafo[4][4]);
        AllPairShortestPath Adyacente = new AllPairShortestPath();
        Adyacente.floydWarshall(grafo);
    }

}
//C:\Users\ticoa\OneDrive\Desktop\Cosas\EstructuraDeDatos\Hoja9\guategrafo.txt
