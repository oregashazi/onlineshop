package test;

/**
 * Base class for tests
 * @author Alfred Walther
 * @version 1.0
 */
public class TestBase {
    public static void assertEquals(Object expected, Object actual) {
        final String message = "expected '" + expected + "' is not equal to actual '" + actual + "'";

        if (expected instanceof String) {
            String strExpected = (String) expected;
            String strActual = (String) actual;
            if (!strExpected.equalsIgnoreCase(strActual))
                throw new RuntimeException("[String] " + message);

        } else if (expected instanceof Double) {
            Double epsilon = 0.01d;
            Double dExpected = (Double) expected;
            Double dActual = (Double) actual;
            if (Math.abs(dExpected - dActual) >= epsilon)
                throw new RuntimeException("[double] " + message);

        } else if (expected instanceof Integer) {
            Integer iExpected = (Integer) expected;
            Integer iActual = (Integer) actual;
            if (!iExpected.equals(iActual))
                throw new RuntimeException("[int] " + message);

        } else if (expected != actual)
            throw new RuntimeException(message);
    }
}
