
package groupar.co.product.service;

import groupar.co.data.AccesDataFileImpl;
import groupar.co.data.InAccessData;
import groupar.co.domain.Product;
import groupar.co.productos.exceptions.AccessDataExt;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductAllImpl implements InProductAll{
    private final InAccessData data;

    public ProductAllImpl() {
        this.data = new AccesDataFileImpl();
    }
    

    @Override
    public void addProduct(String name) {
        Product product = new Product(name);
        boolean append = false;
        try {
            append = data.exist(NAME_SRC);
            data.write(product, NAME_SRC, append);
        } catch (AccessDataExt ex) {
            System.out.println("Error Acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void tolistProduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void searchProduct(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initProductAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
