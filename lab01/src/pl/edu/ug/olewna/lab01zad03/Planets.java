package pl.edu.ug.olewna.lab01zad03;
public enum Planets {
    MERCURY(0.2408467),
    VENUS(0.61519726),
    MARS(1.8808158),
    EARTH(1),
    JUPYTER(11.862615),
    SATURN(29.447498 ),
    URANUS(84.016846),
    NEPTUNE(164.79132);

    private double year;
    Planets(double year) {
        this.year = year;
    }
    public double getYear(double ageInSeconds) {
        return (ageInSeconds / (this.year*365.0*24.0*60.0*60.0));
    }
}