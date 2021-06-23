
package groupar.co.product.service;

import groupar.co.data.AccesDataFileImpl;
import groupar.co.data.InAccessData;
import groupar.co.domain.Product;
import static groupar.co.product.service.InProductAll.NAME_SRC;
import groupar.co.productos.exceptions.*;

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
        try {
            var products = this.data.toList(NAME_SRC);
            for(var product: products){
                System.out.println("Product= "+ product);
            }
        } catch (AccessDataExt ex) {
            System.out.println("Erro acceso a los datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void searchProduct(String search) {
        String result = null;
        try {
            result = this.data.searchProduct(NAME_SRC, search);
        } catch (AccessDataExt ex) {
            System.out.println("Error acceso a datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("Resultado: "+ result);
    }

    @Override
    public void initProductAll() {
        try {
            if(this.data.exist(NAME_SRC)){
                data.deleteSc(NAME_SRC);
                data.createSrc(NAME_SRC);                
            }
            else{
                data.createSrc(NAME_SRC);
            }
        } catch (AccessDataExt ex) {
            System.out.println("Error al iniciar todos los productos");
            ex.printStackTrace(System.out);
        }
    }
    
}
