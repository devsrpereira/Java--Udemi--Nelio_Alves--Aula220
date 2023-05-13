package application;

import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\DELL\\Documents\\2023\\Desenvolvedor\\" +
                "Estudos\\Java\\ûdemy\\JavaCompleto--Nelio_Alves\\aula220\\input.csv";

        Locale.setDefault(Locale.US);
        List<Product> productList = new ArrayList<>();

        System.out.println();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while (line != null){
                String[] vect = line.split(", ");

                System.out.println("Input file:");
                System.out.println(line);

                line = br.readLine();

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

        File strPath = new File(path);
        boolean newFolder = new File(strPath.getParent() + "\\out").mkdir();
        boolean newFile = new File(strPath.getParent() + "\\out\\summary.csv").createNewFile();
        String fileAdress = strPath.getParent() + "\\out\\summary.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileAdress, true))){

            System.out.println();
            System.out.println("Output file (/out/summary.cvs):");

            for (Product product : productList) {
                bw.write(product.getName() + ", " + String.format("%.2f",product.totalPrice(product.getPrice(), product.getUnity())));
                System.out.println(product.getName() + ", " + String.format("%.2f",product.totalPrice(product.getPrice(), product.getUnity())));
                bw.newLine();
             }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
