package be.pxl.ja.robbery;
//Product toestaan om producten te vergelijken met andere producten
public class Product implements Comparable<Product>{
    private String name;
    private double weigth;
    private double price;

    public Product(String name, double weigth, double price) {
        this.name = name;
        this.weigth = weigth;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", weigth=" + weigth +
                ", prize=" + price +
                '}';
    }

    @Override
    public int compareTo(Product product) {
        return Double.compare(this.price, product.price);
    }
    // output 1 parameter 1 groter dan parameter 2, output 0 parameters gelijk, output -1 parameter 1 kleiner dan parameter 2
}
