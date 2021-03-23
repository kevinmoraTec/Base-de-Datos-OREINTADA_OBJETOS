/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplobd4o;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin Mora
 */
public class Controlador extends Conexion {
    
    public Controlador(){
        
    }
    
    public boolean InsertarPersona(int id, String Nombre, String Apellido){
        Persona persona = new Persona(id, Nombre, Apellido);
        return InsertarPersona(persona);
    }
    
    public boolean ActualizarPersona(int id, String Nombre, String Apellido){
        Persona PersonaActualizada = new Persona(id, Nombre, Apellido);
        return Editar(PersonaActualizada);
    }
    
    public boolean EliminarPersona(int id){
        if(id > 0){
            Persona persona = new Persona(id, null, null);
            return Eliminar(persona);
        }else{
            return false;
        }
    }

    public DefaultTableModel mostrarpersonas() {
        String titulos[] = {"NOMBRE", "APELLIDO", "ID"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        Persona persona = null;
        Persona[] p = BuscarPersonas(persona);
        if (p != null) {
            for (Persona per : p) {
                Object[] cli = new Object[3];
                cli[0] = per.getNOMBRE();
                cli[1] = per.getAPELLIDOS();
                cli[2] = per.getID();
                dtm.addRow(cli);
            }
        }
        return dtm;
    }
    
}
