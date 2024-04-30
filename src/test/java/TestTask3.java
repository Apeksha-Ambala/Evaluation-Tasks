import org.example.Task3;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

/**
 * Class to test Task3
 *
 * @author Apeksha Ambala
 * @since 1.0
 * @version 1.0
 */
@PrepareForTest
public class TestTask3 {

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testProcessInput() throws Exception {
    Task3 task3 = PowerMockito.spy(new Task3());
    String input =
        "[[0, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 0], [0, 0, 0, 0, 0, 0], [0, 1, 1, 1, 1, 1], [0, 1, 1, 1, 1, 1], [0, 0, 0, 0, 0, 0]]";

    int result1 =
        Whitebox.invokeMethod(
            task3, "getShortestPath", (Object) Whitebox.invokeMethod(task3, "processInput", input));

    Assertions.assertEquals(11, result1);
  }
}
