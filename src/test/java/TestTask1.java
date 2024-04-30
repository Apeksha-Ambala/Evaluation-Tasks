import org.example.Task1;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

/**
 * Class to test Task1
 *
 * @author Apeksha Ambala
 * @since 1.0
 * @version 1.0
 */

@PrepareForTest
public class TestTask1 {
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCheckCountToConvert() throws Exception {
        Task1 task1 = PowerMockito.spy(new Task1());
        int count  =
                Whitebox.invokeMethod(task1, "checkCountToConvert", 4);
        int expectedResult1 = 2;
        Assertions.assertEquals(expectedResult1, count);

        count  =
                Whitebox.invokeMethod(task1, "checkCountToConvert", 15);
        int expectedResult2 = 5;
        Assertions.assertEquals(expectedResult2, count);
    }
}
