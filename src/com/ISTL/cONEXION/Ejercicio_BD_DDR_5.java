package com.ISTL.cONEXION;

import com.ISTL.modelo.Persona;
import com.ISTL.vistas.GestionUsuario;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.File;

public class Ejercicio_BD_DDR_5 {

    public static void main(String[] args) {

        
        File f = new File("personas.db4o");
        f.delete();
        
        ObjectContainer db = Db4oEmbedded.openFile(f.getAbsolutePath());
        
       
        GestionUsuario rs = new  GestionUsuario();
        
        Persona p = new Persona(rs.Devolverpersona());
        ObjectSet<Persona> result = db.queryByExample(p);
        
        while(result.hasNext()){
            System.out.println(result.next());
        }
        
        db.close();
        
    }

}
