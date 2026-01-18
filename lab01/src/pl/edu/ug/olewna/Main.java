package pl.edu.ug.olewna;
import pl.edu.ug.olewna.lab01zad01.HelloWorld;
import pl.edu.ug.olewna.lab01zad02.Armstrong;
import pl.edu.ug.olewna.lab01zad03.Planets;
import pl.edu.ug.olewna.lab01zad04.Pattern;
import pl.edu.ug.olewna.lab01zad05.Zad05;

public class Main {
    public static void main(String[] args) {

        HelloWorld zad01 = new HelloWorld();
        String result = zad01.greeting();
        System.out.println(result);

        Armstrong zad02 = new Armstrong();
        boolean result2a = zad02.isArmstrongNumber(317);
        System.out.println("Powinno być false jest: " + result2a);
        boolean result2b = zad02.isArmstrongNumber(371);
        System.out.println("Powinno być true jest: " + result2b);

        Planets zad03 = Planets.EARTH;
        double result3 = zad03.getYear(1000000000);
        System.out.println(result3);

        Pattern zad04 = new Pattern();
        String result4 = zad04.createPattern(25);
        System.out.println(result4);

        Zad05 zad05 = new Zad05();
        zad05.test();
    }
}