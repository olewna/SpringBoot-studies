package pl.edu.ug.olewna.lab01zad04;
public class Pattern {
    public static String createPattern(int n) {
        return createPattern(n , "x");
    }
    public static String createPattern(int n, String s) {
        StringBuilder pattern = new StringBuilder("");
        for (int i = 1; i <= n; i += 1) pattern.append(s.repeat(i)+"\n");
        for (int i = n; i > 0; i -= 1) pattern.append(s.repeat(i)+"\n");
        for (int i = 0; i < n; i += 1) pattern.append(" ".repeat(i) + s.repeat(n-i)+"\n");
        for (int i = n - 1; i >= 0; i -= 1) pattern.append(" ".repeat(i) + s.repeat(n-i)+"\n");
        return pattern.toString();
    }
}
