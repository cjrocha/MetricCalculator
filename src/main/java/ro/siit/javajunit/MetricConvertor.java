package ro.siit.javajunit;

/**
 * Class to perform transformation of metrics to mm
 */
public class MetricConvertor {
    /**
     * Method that splits each value from generated list into
     * string data = metric + double data = actual value.
     * @param expression - each value from a list
     * @return string of actual value of expression transformed into mm
     * Method does not throw Exceptions if values from list are not conform
     * with requirements! It just notifies user about issue and stops.
     */
    public String Convertor(String expression) {
        String st1 = expression.replaceAll("[^A-Za-z]", "");
        double vl1 = Double.parseDouble(expression.replace(st1, ""));

        switch (st1) {
            case "mm":
                vl1 = vl1;
                break;
            case "cm":
                vl1 = vl1 * 10;
                break;
            case "dm":
                vl1 = vl1 * 100;
                break;
            case "m":
                vl1 = vl1 * 1000;
                break;
            case "km":
                vl1 = vl1 * 1000000;
                break;
            default:
                System.out.println("Something is wrong with your expression!\n"+
                        "Please follow rules provided in description\n"+
                        "Expression example: '15mm + 2.5cm -1km+400m'\n"+
                        "Try again!");
                System.exit(0);
        }
        return Double.toString(vl1);
    }
}
