package application;

import entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        String path = "C:\\Users\\DELL\\Documents\\2023\\Desenvolvedor\\" +
                "Estudos\\Java\\ûdemy\\JavaCompleto--Nelio_Alves\\aula220\\input.cvs";

        List<Product> productList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while (line != null){
                String[] vect = line.split(",");

                String name = vect[0];
                double price = Double.parseDouble(vect[1]);
                int unity = Integer.parseInt(vect[2]);

                Product product = new Product(name, price, unity);
                productList.add(product);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
        }
    }

}
