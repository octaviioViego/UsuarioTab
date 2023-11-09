/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author octav
 */
public class NumeroDeEmpleado {
    public static String crearListaDeEnteros(String separador,String anio) {
        ArrayList<Object> numeros = new ArrayList<>();
        StringBuilder resultado = new StringBuilder();
        Random random = new Random();

        for (int j = 1; j <= 2; j++) {
            char randomizedCharacter = (char) (random.nextInt(26) + 'a');
            if (!numeros.contains(randomizedCharacter)) {
                numeros.add(String.valueOf(randomizedCharacter));
            } else {
                j--;
            } 
            for (int i = 1; i <= 2; i++) {
                int numero = (int) (Math.random() * 9);
                if (!numeros.contains(numero)) {
                    numeros.add(String.valueOf(numero));
                } else {
                    i--;
                }
            }
            
        }
        
        resultado.append(anio);
        
        for (int i = 0; i < numeros.size(); i++) {
            resultado.append(numeros.get(i));
         
        }
      resultado.append(separador);
        return resultado.toString();
    }
    
}
