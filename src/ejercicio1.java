/**
 * Created by IntelliJ IDEA.
 * User: saysrodriguez
 * Date: 30/03/12
 * Time: 10:03
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
import java.io.*;

public class ejercicio1 {
    public static Scanner scn = new Scanner(System.in);
    public static ArrayList listaObjetos = new ArrayList();
    public static ArrayList listaPalabras = new ArrayList();


    public static void main(String [] args){
        leerArchivo();
        pedirPalabras();
        madLibs();
    }

    public static void leerArchivo(){
        int indice = 0;
        String objeto = "";

        try{
        File archivo = new File("frase.txt");
        FileReader leer = new FileReader(archivo);
        BufferedReader br = new BufferedReader(leer);
            String linea;
            while ((linea = br.readLine()) != null){
                while (linea.length() > indice){

                    if (linea.charAt(indice) == '('){
                        indice++;
                        if (linea.charAt(indice) == '('){
                            indice++;
                            while (linea.charAt(indice) != ')'){
                                objeto += linea.charAt(indice);
                                indice++;
                            }
                            agregarObjetos(objeto);
                            objeto = "";
                        }

                    }

                    indice++;
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void agregarObjetos(String objeto){
        if (!compararObjetos(objeto)){
            listaObjetos.add(objeto);
        }
    }

    public static boolean compararObjetos(String objeto){
        int indiceLista;

        for (indiceLista = 0; indiceLista > listaObjetos.size();indiceLista++){
            if (objeto.equals(listaObjetos.get(indiceLista))){
                return true;
            }
        }
        return false;
    }


    public static void agregarPalabra(String palabra){
        listaPalabras.add(palabra);

    }

    public static void pedirPalabras(){
        int interacion;
        String palabra;

        for (interacion = 0; interacion < listaObjetos.size(); interacion++){
            System.out.println("Introduce un(a) "+listaObjetos.get(interacion).toString());
            palabra = scn.nextLine();
            agregarPalabra(palabra);
        }
    }

     public static void madLibs(){
        String libs="";
         String ob1;
         String ob2;
         int indice = 0;

         try{
             File archivo = new File("frase.txt");
             FileReader leer = new FileReader(archivo);
             BufferedReader br = new BufferedReader(leer);
             String linea;
             while ((linea = br.readLine()) != null){
                  while (listaObjetos.size() > indice){
                    // System.out.println(indice+" indice "+linea.length());
                     ob1 =  (String)listaObjetos.get(indice);
                     ob2 =  (String)listaPalabras.get(indice);
                     //System.out.println("Hola mamonsisimo "+ob1+" fdddf "+ob2);

                    libs = linea.replace(ob1, ob2);
                      linea = libs;

                      indice++;
                }

            }
             System.out.println(libs.toString());
         } catch (Exception e){
            e.printStackTrace();
        }
     }

}

