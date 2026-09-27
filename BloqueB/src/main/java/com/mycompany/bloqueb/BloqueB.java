/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bloqueb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author samah
 */
public class BloqueB {

    public static void main(String[] args) {
        
        ejercicio4();
        ejercicio5();
        ejercicio6();
    }
    
      public static void ejercicio4(){
        
         try(FileInputStream in = new FileInputStream("logo.png");
            FileOutputStream ou = new FileOutputStream("copia_logo.png")) {
             
            int byteLeido;

            //esto va a leer byte por byte hasta que ya no quede ninguno
            while ((byteLeido = in.read()) != -1) {
                ou.write(byteLeido);
            }

            System.out.println("Copia realizada con exito: copia_logo.png");

        }catch (IOException e){
            
            System.out.println("error: " + e.getMessage());
        }
    
    
    
    }
      
      public static void ejercicio5(){
      
        int totalLineas = 0;
        int totalQuijote = 0;

        try (
            FileReader fr = new FileReader("qijote.txt");
            BufferedReader br = new BufferedReader(fr)
        ) {
            String linea;

            // leemos linea a linea hasta que no queden mas (null significa fin de archivo)
            while ((linea = br.readLine()) != null) {
                totalLineas++;

                // contamos cuantas veces aparece Quijote en esta línea
                String[] palabras = linea.split("\\s+");
                for(String palabra : palabras) {
                    if(palabra.equalsIgnoreCase("Quijote") || palabra.contains("Quijote")) {
                        totalQuijote++;
                    }
                }
            }

            System.out.println("Total de líneas: " + totalLineas);
            System.out.println("Veces que aparece 'Quijote': " + totalQuijote);

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
      
      }
      
      
      public static void ejercicio6(){
      
      Scanner datos = new Scanner(System.in);

        // el true en FileWriter indica añadir al final, no sobrescribir
        try(FileWriter fw = new FileWriter("calificaciones.txt", true);
            BufferedWriter bw = new BufferedWriter(fw)) {
            
            for(int i = 1; i<=3; i++){
                System.out.print("Introduce el nombre del alumno " + i + ": ");
                String nombre = datos.nextLine();

                System.out.print("Introduce la nota de " + nombre + ": ");
                String nota = datos.nextLine();

                bw.write("Nombre: " +nombre + " Calificacion: " + nota);
                bw.newLine(); // salta a la siguiente linea en el archivo
            }

            System.out.println("Datos guardados correctamente en calificaciones.txt");

        } catch(IOException e){
            
            System.out.println("error: " + e.getMessage());
        }

        datos.close();
      
      }
      
}
