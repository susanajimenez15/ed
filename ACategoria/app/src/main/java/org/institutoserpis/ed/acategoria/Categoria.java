package org.institutoserpis.ed.acategoria;

/**
 * Created by mati on 31/05/16.
 */
public class Categoria {
    public long id;
    public String nombre;


    public Categoria(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return String.format("[%d] %s", id, nombre);
    }

}
