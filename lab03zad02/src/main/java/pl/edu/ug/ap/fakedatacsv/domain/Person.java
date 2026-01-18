package pl.edu.ug.ap.fakedatacsv.domain;


public class Person {
    private String id;
    private String imie;
    private String nazwisko;
    private String email;
    private Integer rok_urodzenia;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRok_urodzenia() {
        return rok_urodzenia;
    }

    public void setRok_urodzenia(Integer rok_urodzenia) {
        this.rok_urodzenia = rok_urodzenia;
    }

    public Person() {

}
    public Person(String id, String imie, String nazwisko, String email, String rok_urodzenia) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.rok_urodzenia = Integer.valueOf(rok_urodzenia);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                ", rok_urodzenia=" + rok_urodzenia +
                '}';
    }
}
