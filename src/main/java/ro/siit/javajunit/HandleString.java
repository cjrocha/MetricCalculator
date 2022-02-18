package ro.siit.javajunit;

import java.util.*;


/**
 * Java class that take's the expression inserted by user
 * and split's it into values(List) to be added and values(list) to be subtracted.
 * Also take's care of operations to be done and returns the final value in mm.
 * Here we are also handling the discovery of 'Highest' & 'Lowest' metric from
 * the input expression.
 */
public class HandleString {
    static List<String> add = new ArrayList<>();
    static List<String> substract = new ArrayList<>();

    /**
     * Method that splits initial expression into add & substract lists.
     * Uses methods to clean up list values and perform the operations.
     * @param exp is the initial expression that user sends.
     * @return result of operations in mm metric.
     */
    public double DataValue(String exp) {
        int check = 0;
        int limit = exp.length();
        for (int i = exp.length(); i > 0; i--) {
            String s = exp.substring(i-1, i);
            if (s.equals("-")) {
                check = i;
                substract.add(exp.substring(check, limit));
                limit = i - 1;
            }
            if (s.equals("+")) {
                check = i;
                add.add(exp.substring(check, limit));
                limit = i - 1;
            }
        }
        //adding first metric value if exists
        if (exp.substring(0, 1).equals("-") || exp.substring(0, 1).equals("+")) {
        } else {
            add.add(exp.substring(0, limit));
        }

        MetricValues c = new MetricValues();
        MetricValues d = new MetricValues();
        List<String> toAdd = c.MetricValue(add);
        List<String> toSubstract = d.MetricValue(substract);

        double sumAddition = sumList(toAdd);
        double sumSubstraction = sumList(toSubstract);
        double result = sumAddition - sumSubstraction;
        return result;
    }

    /**
     * Method to perform the addition of elements in each list
     * @param data is the List parameter that get's imported
     * @return sum of parameters from a list
     */
    public static double sumList(List<String> data) {
        double sum = 0;
        for (String s : data) {
            sum = sum + Double.parseDouble(s);
        }
        return sum;
    }

    /**
     * Find the max metric from initial expression.
     * Use Lists generate in DataValue method.
     * @return maxMetric parameter as String.
     */
    public String MaxMetric(){
        String[] metrics = new String[]{"mm", "cm", "dm", "m", "km"};
        List<String> values = new ArrayList<>(add);
        values.addAll(substract);
        Integer[] indexes = new Integer[values.size()];
        for (String value : values){
            int j = values.indexOf(value);
            String st1 = value.replaceAll("[^A-Za-z]", "");
            for (int i = 0; i<5; i++){
                if (st1.equals(metrics[i])){
                    indexes[j] = i;
                }
            }
        }
        //Using Collection seemed to be the easiest way to get min. & max.
        int max = Collections.max(Arrays.asList(indexes));
        String maxMetric = metrics[max];
        return maxMetric;
    }

    /**
     * Find the min metric from initial expression.
     * Use Lists generate in DataValue method.
     * @return minMetric parameter as String.
     */
    public String MinMetric(){
        String[] metrics = new String[]{"mm", "cm", "dm", "m", "km"};
        List<String> values = new ArrayList<String>(add);
        values.addAll(substract);
        Integer[] indexes = new Integer[values.size()];
        for (String value : values){
            int j = values.indexOf(value);
            String st1 = value.replaceAll("[^A-Za-z]", "");
            for (int i = 0; i<5; i++){
                if (st1.equals(metrics[i])){
                    indexes[j] = i;
                }
            }
        }
        //Using Collection seemed to be the easiest way to get min. & max.
        int min = Collections.min(Arrays.asList(indexes));
        String minMetric = metrics[min];
        return minMetric;
    }
}
