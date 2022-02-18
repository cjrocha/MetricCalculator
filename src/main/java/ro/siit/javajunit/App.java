package ro.siit.javajunit;

import java.util.Scanner;


/**
 * Java class to calculate metrics based on input expression,
 * returning the result as user requests.
 * Scanner lib is used for communications with user.
 * @author Andrei Chirila (cjrocha)
 */
public class App 
{
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Please add the expression you want to calculate");
        System.out.println("Allowed metrics are mm, cm, dm, m, km and\nAllowed operators are +, -");
        String expression = read.nextLine();
        System.out.println("In witch metric you want result to be calculated?");
        System.out.println("Allowed values are:\n" +
                "Highest metric(from expression);\nLowest metric(from expression);\n" +
                "or mm, cm, dm, m, km");
        String resultType = read.nextLine();
        //end of scanner
        //Handling the expression and returning result
        HandleString val = new HandleString();
        double res = val.DataValue(expression);
        ReturnResponse response = new ReturnResponse();
        System.out.println(response.ReturnData(res, resultType));
    }
}
