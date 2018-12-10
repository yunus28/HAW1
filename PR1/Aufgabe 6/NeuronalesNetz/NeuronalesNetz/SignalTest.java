

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SignalTest
{
    @Test
    public void test()
    {
        Signal signal = new Signal("Hal--LO");
        assertEquals("Hal--LO", signal.getAusgangswert());
        signal = new Signal("");
        assertEquals("", signal.getAusgangswert());
        signal = new Signal("haha haha haha");
        assertEquals("haha haha haha", signal.getAusgangswert());
        signal = new Signal(null);
        assertEquals(null, signal.getAusgangswert());
    }
}
