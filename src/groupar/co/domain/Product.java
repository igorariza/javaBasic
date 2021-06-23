package groupar.co.domain;

public class Product {
    private String nombre;
    
    
    public Product(){
        
    }
    public Product(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
