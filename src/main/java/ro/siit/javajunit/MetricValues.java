package ro.siit.javajunit;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that performs cleaning of the values
 * from generated lists.
 */
public class MetricValues {
    List<String> newExpr = new ArrayList<>();

    /**
     * Removes whitespaces from the list values
     * @param expression is the list generated: add & substract
     * @return newExpr is the new, cleaned list.
     */
    public List<String> MetricValue(List<String> expression) {
        //remove whitespaces
        MetricConvertor c = new MetricConvertor();
        for (String val : expression) {
            if (val.contains(" ")) {
                val = val.replaceAll("\\s", "");
            } else {
                val = val;
            }
            String n = c.Convertor(val);
            newExpr.add(n);
        }
        return newExpr;
    }
}
