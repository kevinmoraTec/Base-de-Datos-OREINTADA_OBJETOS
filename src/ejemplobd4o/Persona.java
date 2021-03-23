package ejemplobd4o;

/**
 *
 * @author Kevin Mora
 */
public class Persona {
    private int ID;
    private String NOMBRE,APELLIDOS;

    public Persona(int ID, String NOMBRE, String APELLIDOS) {
        this.ID = ID;
        this.NOMBRE = NOMBRE;
        this.APELLIDOS = APELLIDOS;
    }

    public Persona() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    public void setAPELLIDOS(String APELLIDOS) {
        this.APELLIDOS = APELLIDOS;
    }
    
    
    @Override
   public String toString(){
       return NOMBRE + " " + APELLIDOS;
   }
}
