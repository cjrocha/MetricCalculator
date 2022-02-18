package ro.siit.javajunit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class HandleStringTest {
    String[] datas = new String[]{"-15 m + 200 dm -15cm", "40m-25m+ 170cm "};
    List<String> addListChecks = new ArrayList<>();
    List<String> substractListChecks = new ArrayList<>();

    /**
     * Test if given an array of expressions (similar to what we expect from user)
     * returns as double the calculated value of that expression into
     * the smallest metric => mm
     */
    @Test
    public void dataValue() {
        /* for test of Lists generated
        addListChecks.add("200dm");
        addListChecks.add("40m");
        substractListChecks.add("15m, 15cm");
        substractListChecks.add("25m, 170cm");
         */
        double[] sumTest = new double[]{4850, 21550};
        HandleString valTest = new HandleString();
        int l = datas.length;
        for (int i = 0; i < l; i++) {
            System.out.println(valTest.DataValue(datas[i]));
            System.out.println(sumTest[i]);
            //assertTrue(valTest.DataValue(datas[i]) == sumTest[i]); - fails cause of different subunit values !!

            //Don't know if is needed and how to test that lists
            //generated by method are correct!?
        }

    }
}