package edu.escuelaing.ARSW.ASE.app;
import org.slf4j.LoggerFactory;
import java.io.File;
import org.slf4j.Logger;



/**
 * Programa para contar líneas en archivos de código fuente
 * se usa tipo phy para líneas físicas
 * se usa tipo loc para todas las líneas de código
 *
 */

public class ContarLineas
{
    /**
     * Main de ContarLineas
     * @param args
     */
    public static void main(String [] args)  {
        Logger log = LoggerFactory.getLogger(ContarLineas.class);
        if (args.length!=0 ){
            String tipo  = args[0];
            File archivo = new File(args[1]);
            try {
                int cantidad = LeerLineas.muestraContenido(tipo, archivo);
                if (tipo.equals("loc")) {
                    System.out.println("El número de lineas de codigo son: " + cantidad+".");
                }
                else if (tipo.equals("phy")) {
                    System.out.println("El número de lineas físicas son: " + cantidad+".");
                }
            }catch(Exception e) {
                log.error("Error con contar la lineas o el archivo", e);
            }
        }
    }
}