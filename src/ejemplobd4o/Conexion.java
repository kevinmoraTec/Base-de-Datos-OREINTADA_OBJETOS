/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplobd4o;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author¡ Kevin Mora
 */
public class Conexion {

    public ObjectContainer oc;

    private void open() {
        //Creamos la conexion y el archivo que almacenara los datos
        this.oc = Db4o.openFile("Registro_de_Personas .yap");
    }

    public boolean InsertarPersona(Persona objeto) {
        try {
            //Buscamos si existe el objeto, si no insertamos el objeto recibido en la base de datos
            this.open();
            oc.set(objeto);
            this.oc.close();
            return true;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.InsertarPersona() : " + e);
            return false;
        }
    }

    public boolean Editar(Persona persona) {
        try {
            open();
            ObjectSet resultados = oc.get(new Persona(persona.getID(), null, null));
            if (resultados.size() > 0) {
                Persona resultado = (Persona) resultados.next();
                resultado.setNOMBRE(persona.getNOMBRE());
                resultado.setAPELLIDOS(persona.getAPELLIDOS());
                oc.set(resultado);
                oc.close();
                return true;
            } else {
                oc.close();
                return false;
            }
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("Error al Editar persona");
            return false;
        }
    }

    public Persona[] BuscarPersonas(Persona persona) {
        try {
            Persona[] personas = null;
            this.open();
            ObjectSet resultados = this.oc.get(persona);
            int i = 0;
            if (resultados.hasNext()) {
                personas = new Persona[resultados.size()];
                while (resultados.hasNext()) {  
                    personas[i] = (Persona) resultados.next();
                    i++;
                }
            }
            this.oc.close();
            return personas;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.controlador.buscar()" + e);
            return null;
        }
    }
    
    public Persona buscarp(Persona persona){
        open();
        Persona encontrado = null;
        ObjectSet resultados = oc.get(persona);
        if(resultados.hasNext()){
            encontrado = (Persona) resultados.next();
            
        }
        oc.close();
        return encontrado;
    }
    
    public boolean Eliminar(Persona pbjeto){
        try{
        open();
        ObjectSet resultados = oc.get(pbjeto);
        if(resultados.size() > 0 ){
            Persona persona = (Persona) resultados.next();
            oc.delete(persona);
            oc.close();
            return true;
        }else{
        oc.close();
        return false;
    }   
    } catch (DatabaseClosedException | DatabaseReadOnlyException e){
            System.out.println("Hubo error al eliminar");
            return false;
    }
    }

    

}
