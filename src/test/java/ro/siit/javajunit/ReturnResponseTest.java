package ro.siit.javajunit;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ReturnResponseTest {
    /**
     * Given an array(string) of pairs of data (resulted from methods and user input),
     * composed of: The metric value calculated + metric requested by user.
     * Unit test's that each pair is being handled to return the data
     * organized for final printing to user.
     */
    @Test
    public void returnData() {
        String[][] datas = new String[][] { {"24", "mm"}, {"47", "cm"}, {"15", "dm"}, {"800", "m"}, {"8000", "km"} };
        String[] checks = new String[]{"Your result is: 24.0 mm", "Your result is: 4.7 cm", "Your result is: 0.15 dm",
                "Your result is: 0.8 m", "Your result is: 0.008 km"};
        int l = datas.length;
        for(int i = 0; i < l; i++){
            String[] data = datas[i];
            double val = Double.parseDouble(data[0]);
            String mt = data[1];
            String ch = checks[i];
            ReturnResponse response = new ReturnResponse();
            assertTrue(response.ReturnData(val, mt).equals(ch));
        }
    }

}