package entities;

public class Product {
    private String name;
    private double price;
    private int unity;

    public Product() {

    }
    public Product(String name, double price, int unity) {
        this.name = name;
        this.price = price;
        this.unity = unity;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getUnity() {
        return unity;
    }
    public void setUnity(int unity) {
        this.unity = unity;
    }


    public double totalPrice(){
        return price * unity;
    }




    @Override
    public String toString() {
        return name + "," + String.format("%.2f",price) + "," + unity;
    }





}
