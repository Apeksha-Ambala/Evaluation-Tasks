import org.example.Task2;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

/**
 * Class to test Task2
 *
 * @author Apeksha Ambala
 * @since 1.0
 * @version 1.0
 */
@PrepareForTest
public class TestTask2 {
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  public void testReadFileAndProcess() throws Exception {
    Task2 task2 = PowerMockito.spy(new Task2());
    HashMap<Integer, Double> expectedResult1 = new HashMap<>();
    expectedResult1.put(1, 0.5);
    expectedResult1.put(2, 33.0);
    expectedResult1.put(3, 72.0);
    expectedResult1.put(4, 33.5);
    expectedResult1.put(5, 35.0);
    expectedResult1.put(6, 10.0);
    expectedResult1.put(7, 33.0);
    expectedResult1.put(8, 43.0);

    HashMap<Integer, Double> result =
        Whitebox.invokeMethod(task2, "readFileAndProcess", "File.csv");

    Whitebox.invokeMethod(task2, "getResults", result);
    Assertions.assertEquals(expectedResult1, result);

    Assertions.assertEquals("3, 43.0", outputStreamCaptor.toString().trim());
  }
}
