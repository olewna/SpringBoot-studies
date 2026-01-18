package pl.edu.ug.olewna.lab01zad05;

public class Book {
    private String name;
    private Author author;
    private double price;
    private int qty;
    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = 0;
    }
    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }
    public String getName() { return this.name; }
    public Author getAuthor() { return this.author; }
    public double getPrice() { return this.price; }
    public void setPrice(double p) { this.price = p; }
    public int getQty() { return this.qty; }
    public void setQty(int q) { this.qty = q; }
    @Override
    public String toString() {
        return "Ksiazka:\ntytul: " + name + "\n'" + author.toString() + "'\ncena: " + price + "\nqty: " + qty;
    }

}

