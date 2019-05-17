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
        Scanner input = new Scanner(System.in);// crea el scanner
        System.out.println("ingrese donde se localiza el archivo con las ciudades: ");// bufferReader codigo basado de los ejemplos encontrados en la pagina : https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
        String fileName = input.next();// se pide el ingreso de la direccion del file con el texto ejemplo: C:\Users\ticoa\OneDrive\Desktop\Cosas\EstructuraDeDatos\Tarea8\Pacientes.txt
        File file = new File(fileName);// crea el file
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int a = 1;
        while ((line = br.readLine()) != null) { //crea while donde se agregan las ciudades a un hash map
            //process the line
            String[] parts = line.split(",");// se separa el string que da el buffer reader
            if (!Mapa.containsKey( parts[0])){
                Mapa.put(parts[0],a);// se guarda en el mapa con su key y value adecuado
                a =+1;
            }
            if (Mapa.containsKey(parts[1])) {
                Mapa.put(parts[0],a);
                a = +1;
            }
            int distancia = Integer.parseInt(parts[2]);
            grafo[Mapa.get(parts[0])][Mapa.get(parts[1])]= distancia;
        }
        FloydWarshall Adyacente = new FloydWarshall(a);
        Adyacente.floydwarshall(grafo);
    }

}

