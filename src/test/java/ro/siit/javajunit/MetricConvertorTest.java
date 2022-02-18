package ro.siit.javajunit;

import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class MetricConvertorTest {
    /**
     * Test's that given an array(string) of different metrics
     * return's, as array of strings, only the value of each metric
     * transformed into double and into lowest metric => mm
     */
    @Test
    public void convertor() {
        String[] datas = new String[]{"34mm", "74cm", "88dm", "0.5m", "0.08km"};
        String[] checks = new String[]{"34.0", "740.0", "8800.0", "500.0", "80000.0"};
        int l = datas.length;
        for (int i = 0; i < l; i++){
            MetricConvertor c = new MetricConvertor();
            assertTrue(c.Convertor(datas[i]).equals(checks[i]));
        }

    }
}