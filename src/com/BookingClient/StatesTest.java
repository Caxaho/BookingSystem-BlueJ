package src.com.BookingClient;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

/**
 * The test class StatesTest.
 *
 * @author  (Xavier Hoyle)
 * @version (1.0)
 */
public class StatesTest
{
    static Main.ProgramState testState;
    /**
     * Default constructor for test class StatesTest
     */
    public StatesTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        testState = Main.ProgramState.START;
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        
    }

    public void fakeInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);  
    }
    
    @Test
    public void testStartStateLogin() {
        fakeInput("l");
        int choice = CLI.start(); // Retrieve next state choice
        testState = choice >= 0 ? testState.nextState(choice) : testState.previousState(); // Move states according to choice
        assert(testState==Main.ProgramState.REQUEST_LOGIN);
    }
}
