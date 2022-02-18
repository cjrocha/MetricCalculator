package ro.siit.javajunit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for the entire app.
 * Given an expression (string) and a metric to return the calculation of expression
 * returns/print's correct value and correct metric to user
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        String[][] datas = new String[][]{ {"1.4m + 75cm - 10dm", "cm"}, {"-800m + 1.3km - 400dm", "km"} };
        String[] checks = new String[]{"Your result is: 115.0 cm", "Your result is: 0.46115 km"};
        int s = datas.length;
        for (int i = 0; i < s; i++){
            HandleString val = new HandleString();
            double res = val.DataValue(datas[i][0]);
            ReturnResponse response = new ReturnResponse();
            assertTrue(response.ReturnData(res, datas[i][1]).equals(checks[i]));
        }
    }
}
