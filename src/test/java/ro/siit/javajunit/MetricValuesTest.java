package ro.siit.javajunit;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MetricValuesTest {
    /**
     * Given a list of strings - value+metric+empty spaces, test's that it cleans
     * the strings and returns, as 'double' the values calculated
     * to the min. allowed metric => mm
     */

    @Test
    void metricValue() {
        List<String> datas = new ArrayList<>();
        datas.add(" 37 mm");
        datas.add("15mm");
        datas.add(" 0.05km");
        datas.add(" 1.9dm ");
        datas.add(" 15 cm ");
        List<String> checks = new ArrayList<>();
        checks.add("37.0");
        checks.add("15.0");
        checks.add("50000.0");
        checks.add("190.0");
        checks.add("150.0");
        MetricValues c = new MetricValues();
        assertTrue(c.MetricValue(datas).equals(checks));
    }
}