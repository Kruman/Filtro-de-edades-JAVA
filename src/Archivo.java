
import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Archivo {

    static String fileContents = "";
    static String strAux = null;
    static List<Integer> datosUtiles = new ArrayList<>();
    static int ninos = 0;
    static int adolecentes = 0;
    static int adultos = 0;
    static int adultosMayores = 0;
    static int poblacion = 0;

   
    static double edad;
    static double edad2;
    static double edad3;
    static double edad4;
    
   private static DecimalFormat ok=new DecimalFormat("0.00");

    public static void muestraContenido(String path_archivo) throws FileNotFoundException, IOException, NumberFormatException {
        String cadena;

        //ArrayList<String> listaStringEdades = new ArrayList<>();

        FileReader f = new FileReader(path_archivo);

        try (BufferedReader b = new BufferedReader(f)) {
            while ((cadena = b.readLine()) != null) {
                datosUtiles.add(Integer.parseInt(cadena.trim().replaceAll(" ", "")));
            }
        }
        for (int indx = 0; indx < datosUtiles.size(); indx++) {
            System.out.print(datosUtiles.get(indx) + "\t");
        }
    }

    public static void datos(List<Integer> myArrayList) {
        // let us print all the elements available in list
        for (Integer number : myArrayList) {
            System.out.println("edades: " + number);
        }

    }

    public static void clasificaEdades(List<Integer> myArrayList) {

        int LIMITE_INFERIOR_NINOS = 1;
        int LIMITE_SUPERIOR_NINOS = 12;

        int LIMITE_INFERIOR_ADOLECENTES = 13;
        int LIMITE_SUPERIOR_ADOLECENTES = 22;

        int LIMITE_INFERIOR_ADULTOS = 23;
        int LIMITE_SUPERIOR_ADULTOS = 50;

        int LIMITE_INFERIOR_ADULTOS_MAYORES = 51;
        int LIMITE_SUPERIOR_ADULTOS_MAYORES = 99;

        poblacion = myArrayList.size();
        
        for (int i = 0; i < myArrayList.size(); i++) {

            if ((myArrayList.get(i) >= LIMITE_INFERIOR_NINOS) && (myArrayList.get(i) <= LIMITE_SUPERIOR_NINOS)) {
                ninos++;
                edad=myArrayList.get(i)+ninos;
            }

            if ((myArrayList.get(i) >= LIMITE_INFERIOR_ADOLECENTES) && (myArrayList.get(i) <= LIMITE_SUPERIOR_ADOLECENTES)) {
                adolecentes++;
                 edad2=myArrayList.get(i)+adolecentes;
            }

            if ((myArrayList.get(i) >= LIMITE_INFERIOR_ADULTOS) && (myArrayList.get(i) <= LIMITE_SUPERIOR_ADULTOS)) {
                adultos++;
                 edad3=myArrayList.get(i)+adultos;
            }

            if ((myArrayList.get(i) >= LIMITE_INFERIOR_ADULTOS_MAYORES) && (myArrayList.get(i) <= LIMITE_SUPERIOR_ADULTOS_MAYORES)) {
                adultosMayores++;
                 edad4=myArrayList.get(i)+adultosMayores;
            }

        }
        
     
        }
     

    public static void imprimeMedia(){
        
     
         System.out.print("el promedio de ni�os es: " + ok.format((edad)/ninos)+ "\n");
        System.out.print("el promedio de adolecentes es: " + ok.format((edad2)/ninos)+ "\n");
        System.out.print("el promedio de adultos es: " + ok.format((edad3)/ninos)+ "\n");
        System.out.print("el promedio de adultos mayores es: " + ok.format((edad4)/ninos)+ "\n");
        System.out.print("//////////////////////////////////////////////////////////////"+"\n");
    }

    public static void imprimePoblacion() {
        System.out.print("La poblacion de ninos:" + ninos + "\n");
        System.out.print("La poblacion de adolecentes:" + adolecentes + "\n");
        System.out.print("La poblacion de adultos:" + adultos + "\n");
        System.out.print("La poblaci0n de adultos mayores:" + adultosMayores + "\n");
        System.out.print("//////////////////////////////////////////////////////////////"+"\n");
        System.out.print("La poblacion total:" + poblacion + "\n");
        System.out.print("//////////////////////////////////////////////////////////////"+"\n");
        System.out.print("Si se pudo profe =^.^= "+"\n");
        System.out.print("//////////////////////////////////////////////////////////////"+"\n");
       
    }

   
    public static void main(String[] args) throws IOException {

                //C:\Users\Usuario\Documents\JavaApplication229
        String pathEdades = "C:\\Users\\PZ\\Documents\\ArchivoLectura.txt";

        muestraContenido(pathEdades); // 
        System.out.print("\n");
        //imprimeDatos(datosUtiles);
        System.out.print("\n");
        clasificaEdades(datosUtiles);
        System.out.print("\n");
        imprimePoblacion();
        System.out.print("\n");
        imprimeMedia();
        System.out.print("\n");
       
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            //  archivo = new File(pathEdades);
            // fr = new FileReader(archivo);
            //br = new BufferedReader(fr);

            // Lectura del fichero
            // String linea;
            //while ((linea = br.readLine()) != null) {
            //  System.out.println(linea);
            //}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}