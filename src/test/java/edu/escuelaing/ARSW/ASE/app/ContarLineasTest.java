package edu.escuelaing.ARSW.ASE.app;

import junit.framework.TestCase;
import java.io.*;


/**
 * Unit test for count lines app
 */
public class ContarLineasTest extends TestCase
{


    /**
     *Test para contar tipo loc
     * @throws IOException
     */
    public void testLoc() throws IOException {
        int resultado=8;
        File ruta = new File("./src/test/resource/p2.txt");
        int resultado2= LeerLineas.contenido("loc",ruta);
        assertEquals(resultado,resultado2);
    }
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ContarLineasTest(String testName )
    {
        super( testName );
    }

    /**
     * Test contar para tipo PHY
     * @throws IOException
     */
    public void testPhy() throws IOException {
        int resultadoEsperado=15;
        File ruta = new File("./src/test/resource/p1.txt");
        int resultado2= LeerLineas.contenido("phy",ruta);
        assertEquals(resultadoEsperado,resultado2);
    }
    /**
     *Test para cuando encuentra el archivo
     * @throws IOException
     */
    public void testNoArchivo2() throws IOException {
        boolean bool = true;
        try {
            File ruta = new File("./src/test/resource/p1.txt");
            int resultado= LeerLineas.contenido("loc",ruta);
        } catch (FileNotFoundException e) {
            bool = false;
        }
        assertTrue(bool);
    }

    /**
     *Test para cuando no se encuentra el archivo
     * @throws IOException
     */
    public void testNoArchivo1() throws IOException {
        boolean bool = false;
        try {
            File ruta = new File("./src/main/resources/noexiste.txt");
            int resultado= LeerLineas.contenido("loc",ruta);
        } catch (FileNotFoundException e) {
            bool = true;
        }
        assertTrue(bool);
    }
}