import ug.lab02zad02.Compute;

public class Main {
    public static void main(String[] args) {
        double[] values = new double[]{1.0,2.0,3.0,4.0,5.0};

        Compute compute = new Compute();
        double mean = compute.computeStats(values, Compute.TypesCompute.MEAN);
        double variance = compute.computeStats(values, Compute.TypesCompute.VARIANCE);
        double std_dev = compute.computeStats(values, Compute.TypesCompute.STANDARD_DEVIATION);
        System.out.println(mean + " " +  variance + " " + std_dev);
    }
}
