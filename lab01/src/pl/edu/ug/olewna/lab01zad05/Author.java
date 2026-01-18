package pl.edu.ug.olewna.lab01zad05;

public class Author {
    private String name;
    private String email;
    private Zad05.Gender gender;
    public Author (String name, String email, Zad05.Gender gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
    public String getName() { return this.name; }
    public String getEmail(){ return this.email; }
    public void setEmail(String e) { this.email = e; }
    public Zad05.Gender getGender() { return this.gender; }
    @Override
    public String toString() {
        return "Autor:\nimię: " + name + "\nemail: " + email + "\npłeć: " + gender;
    };
}

