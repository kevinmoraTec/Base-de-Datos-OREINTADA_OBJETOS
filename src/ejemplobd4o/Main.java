/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplobd4o;

import com.db4o.ObjectSet;

/**
 *
 * @author Kevin Mora
 */
public class Main {
    
    public static void main(String[] args) {
        Persona persona = new Persona(1,"Brayan", "Chamico");
        Conexion c = new Conexion();
        boolean v; 
        ObjectSet resultad = null;
//        c.Insertar(persona);
//        c.Eliminar(persona);
        System.out.println(c.buscarp(persona));
        
    }
}
