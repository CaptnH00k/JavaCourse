package unittests;

import org.junit.Test;

import static org.junit.Assert.*;

import unittests.Functions;

public class FunctionsTest {
    @Test
    public void turbineControl() throws Exception {
    	String turbineControl = Functions.turbineControl(100);
    	assertEquals(turbineControl, "DISCONNECT");
    	turbineControl = Functions.turbineControl(49);
    	assertEquals(turbineControl, "DISCONNECT");
    	
    	turbineControl = Functions.turbineControl(50.5);
    	assertEquals(turbineControl, "LESS_WATER");
    	
      	turbineControl = Functions.turbineControl(49.1);
    	assertEquals(turbineControl, "MORE_WATER");
     	
    	turbineControl = Functions.turbineControl(49.9999);
    	assertEquals(turbineControl, "STEADY");
    }

}
