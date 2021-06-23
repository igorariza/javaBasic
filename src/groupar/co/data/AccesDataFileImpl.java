package groupar.co.data;

import groupar.co.domain.Product;
import groupar.co.productos.exceptions.*;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class AccesDataFileImpl implements InAccessData {

    @Override
    public boolean exist(String fileName) throws AccessDataExt {
        var file = new File(fileName);
        return file.exists();
    }

    @Override
    public List<Product> toList(String srcName) throws ReadDataExt {
        var file = new File(srcName);
        List<Product> products = new ArrayList();
        try {
            var input = new BufferedReader(new FileReader(file));
            String line = null;
            line = input.readLine();
            while(line != null){
                var product = new Product(line);
                products.add(product);
                line = input.readLine();
            }
            input.close();
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new ReadDataExt("Exception al listar los productos: " + ex.getMessage());
        }catch (IOException ex) {
            ex.printStackTrace();
            throw new ReadDataExt("Exception al listar los productos: " + ex.getMessage());
        } 
        return products;
    }

    @Override
    public void write(Product product, String srcName, boolean append) throws WriteData {
    }

    @Override
    public String searchProduct(String srcName, String search) throws ReadDataExt {
    }

    @Override
    public void createSrc(String srcName) throws AccessDataExt {
    }

    @Override
    public void deleteSc(String srcName) throws AccessDataExt {
    }

}
