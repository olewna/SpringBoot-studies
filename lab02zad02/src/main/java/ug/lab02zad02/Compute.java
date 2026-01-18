package ug.lab02zad02;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.ArrayList;

public class Compute {
    public enum TypesCompute{
        MEAN,
        VARIANCE,
        STANDARD_DEVIATION
    }
    public static double computeStats(double[] values, TypesCompute x) {
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        for (double v : values) {
            descriptiveStatistics.addValue(v);
        }

        switch (x){
            case MEAN:
                return descriptiveStatistics.getMean();
            case VARIANCE:
                return descriptiveStatistics.getVariance();
            case STANDARD_DEVIATION:
                return descriptiveStatistics.getStandardDeviation();
            default:
                return 0;
        }
    }
}
