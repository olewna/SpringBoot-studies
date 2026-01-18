package pl.edu.ug.olewna.lab01zad02;

public class Armstrong {
    public static boolean isArmstrongNumber(int n) {
        int len = String.valueOf(n).length();
        int result = 0;
        String a = "1";
        while (len > 0) {
            result += Math.pow(n/Integer.parseInt(a)%10, String.valueOf(n).length());
            len-=1;
            a+="0";
        }
        boolean x = result == n;
        return x;
    }

}
