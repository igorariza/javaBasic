package groupar.co.data;

import groupar.co.domain.Product;
import groupar.co.productos.exceptions.*;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class AccesDataFileImpl implements InAccessData {

    @Override
    public boolean exist(String fileName) {
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
        var file = new File(srcName);
        try {
            var output = new PrintWriter(new FileWriter(file, append));
            output.println(product.toString());
            output.close();
            System.out.println("Ecritura correcta: "+ product);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new WriteData("Exception al escribir  productos: " + ex.getMessage());
        }
    }

    @Override
    public String searchProduct(String srcName, String search) throws ReadDataExt {
        var file = new File(srcName);
        String result = null;
        try {
            var input = new BufferedReader(new FileReader(file));
            String line = null;
            line = input.readLine();
            var index = 1;
            while(line != null){
                if(search != null && search.equalsIgnoreCase(line)){
                    result = "Product " + line + " Indice " + index;
                }
                line = input.readLine();
                index++;
            }
            input.close();
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
            throw new ReadDataExt("Exception al buscar producto: " + ex.getMessage());
        }catch (IOException ex) {
            ex.printStackTrace();
            throw new ReadDataExt("Exception al buscar producto: " + ex.getMessage());
        } 
        return result;
    }

    @Override
    public void createSrc(String srcName) throws AccessDataExt {
        var file = new File(srcName);
        try {
            var output = new PrintWriter(new FileWriter(file));
            output.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccessDataExt("Exception al crear archivo: " + ex.getMessage());
        }
    }

    @Override
    public void deleteSc(String srcName){
        var file = new File(srcName);
        if(file.exists())
            file.delete();
        System.out.println("Archivo Borrado");
    }

}
