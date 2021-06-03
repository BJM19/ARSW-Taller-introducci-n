package edu.escuelaing.ARSW.ASE.app;
import java.util.Scanner;
import java.io.*;


/**
 * Esta clase Lee el archivo que obtiene de la clase principal y cuenta el número de líneas si el tipo de conteo es LOC o PHY
 */
public class LeerLineas {
    private static String cadena;

    /**
     * Clase principal de leerLineas, recibe el archivo y cuenta el número de líneas que dependen de su tipo de recuento
     * @param tipo
     * @param archivo
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static int muestraContenido( String tipo,File archivo) throws FileNotFoundException, IOException {
        int cantidad = 0;
        Scanner scanner = new Scanner(archivo);
        FileReader file = new FileReader(archivo);
        BufferedReader buffer = new BufferedReader(file);
        if(tipo.equals("phy")) {
            while(scanner.hasNextLine()) {
                scanner.nextLine();
                cantidad=cantidad+1;
            }
        }
        else if (tipo.equals("loc")){
            while((cadena = buffer.readLine())!=null) {
                if (!(cadena.startsWith("/") || (cadena.isEmpty()) || (cadena.startsWith("*") ))){
                    cantidad=cantidad+1;
                }
            }
        }
        buffer.close();
        return cantidad;
    }
}