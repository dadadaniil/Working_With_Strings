import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.example.Runner.*;
import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class TestRunner {
    private final static String RESOURCES_PATH = "src/main/resources/";

    @Test
    public void testFirstScenario() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult(RESOURCES_PATH + "1.csv", result);
        assertEquals(5, errorLines);
        String expectedIn1 = RESULT_HEAD
                + "5.2" + PLUS + "2.7" + MINUS + "3.14"+PLUS+"5.0"
                + RESULT_TAIL + "9.76\nerror-lines = 5\n";
        assertEquals(expectedIn1, result.toString());
    }

    @Test
    public void testSecondScenario()throws FileNotFoundException{
        StringBuilder result = new StringBuilder();
        int errorLines = getResult(RESOURCES_PATH + "1.csv", result);
        assertEquals(5, errorLines);
        String expectedIn1 = RESULT_HEAD
                + "-3.1" + PLUS + "2.7" + MINUS + "1"+PLUS+"5.0"
                + RESULT_TAIL + "3.6\nerror-lines = 1\n";
        assertEquals(expectedIn1, result.toString());
    }

    @Test
    public void testThirdScenario()throws FileNotFoundException{
        StringBuilder result = new StringBuilder();
        int errorLines = getResult(RESOURCES_PATH + "1.csv", result);
        assertEquals(5, errorLines);
        String expectedIn1 = RESULT_HEAD
                + "0.75" + PLUS + "2.7" +
                 RESULT_TAIL + "3.45\nerror-lines = 0\n";
        assertEquals(expectedIn1, result.toString());
    }
    @Test
    public void testFourthScenario()throws FileNotFoundException{
        StringBuilder result = new StringBuilder();
        int errorLines = getResult(RESOURCES_PATH + "1.csv", result);
        assertEquals(5, errorLines);
        String expectedIn1 = RESULT_HEAD
                + RESULT_TAIL + "0.0\nerror-lines = 1\n";
        assertEquals(expectedIn1, result.toString());
    }
    @Test
    public void testFifthScenario()throws FileNotFoundException{
        StringBuilder result = new StringBuilder();
        int errorLines = getResult(RESOURCES_PATH + "1.csv", result);
        assertEquals(5, errorLines);
        String expectedIn1 = RESULT_HEAD+
                RESULT_TAIL + "0.0\nerror-lines = 1\n";
        assertEquals(expectedIn1, result.toString());
    }

    @Test
    public void testWrongCsvName() {
        assertThrows(FileNotFoundException.class, () -> {
            StringBuilder result = new StringBuilder();
            getResult(RESOURCES_PATH + "8.csv", result);
        });
    }
}
