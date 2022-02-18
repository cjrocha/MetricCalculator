package ro.siit.javajunit;

/**
 * Java class that handles the way result is being returned to user.
 * There are multiple options of returning the result by:
 * "Highest metric"; "Lowest metric" or specific: mm; cm; dm; m and km.
 * Haven't used Exceptions if something is not right with the way data
 * needs to be returned! Program will just let user know that the 'return'
 * type is not allowed and will stop.
 */
public class ReturnResponse {
    /**
     * Actual return method.
     * @param res is the value of calculated expression in mm
     * @param resultType is the type requested by user
     * @return the res value translated into the type requested.
     */
    public String ReturnData(double res, String resultType){
        String result = "";
        if (resultType.equals("Highest metric")){
            HandleString hm = new HandleString();
            resultType = hm.MaxMetric();
        } else if(resultType.equals("Lowest metric")){
            HandleString lm = new HandleString();
            resultType = lm.MinMetric();
        }
        switch (resultType){
            case "mm" :
                result = "Your result is: " + res + " mm";
                break;
            case "cm" :
                result = "Your result is: " + res/10 + " cm";
                break;
            case "dm" :
                result = "Your result is: " + res/100 + " dm";
                break;
            case "m" :
                result = "Your result is: " + res/1000 + " m";
                break;
            case "km" :
                result = "Your result is: " + res/1000000 + " km";
                break;
            default:
                System.out.println("Wrong metric chosen!\nBe aware only mm, cm, dm, m and km are allowed!\nPlease Try again!");
                System.exit(0);
        }
        return result;
    }
}
