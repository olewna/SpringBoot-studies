package pl.edu.ug.olewna.lab01zad05;

public class Zad05 {
    protected enum Gender {
        MALE, FEMALE
    }
    public static void test() {
        Author a = new Author("oskar", "oskar@g.com", Gender.MALE);
        System.out.println(a+ "\n");
        System.out.println(a.getName());
        System.out.println(a.getEmail());
        a.setEmail("oskarlewna@g.com");
        System.out.println(a.getEmail());
        System.out.println(a.getGender());
        System.out.println("\n"+a+"\n");

        Book b = new Book("biblia", a, 12.99, 7);
        System.out.println("\n"+b+"\n");
        System.out.println(b.getName());
        System.out.println(b.getAuthor());
        System.out.println(b.getPrice());
        b.setPrice(19.49);
        System.out.println(b.getPrice());
        System.out.println(b.getQty());
        b.setQty(2);
        System.out.println(b.getQty());
        System.out.println("\n"+b+"\n");
    }
}
