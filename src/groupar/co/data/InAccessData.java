package groupar.co.data;

import groupar.co.domain.Product;
import groupar.co.productos.exceptions.*;
import java.util.List;


public interface InAccessData {
    
    boolean exist(String fileName) throws AccessDataExt;
    
    List<Product> toList(String srcName) throws ReadDataExt;
    
    void write(Product product, String srcName, boolean append) throws WriteData;
    
    String searchProduct(String srcName, String search) throws ReadDataExt;
    
    void createSrc(String srcName) throws AccessDataExt;
    
    void deleteSc(String srcName) throws AccessDataExt;
    
    
}
