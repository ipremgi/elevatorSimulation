package simulator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by HWILKHU on 18/05/2017.
 */
public class IncrementCounterTest {
    private IncrementCounter simulatorTick;

    @Before
    public void setup(){
        simulatorTick = new IncrementCounter();
    }

    @Test
    public void count(){
        Assert.assertEquals(0,simulatorTick.getCount());
        simulatorTick.nextCount();
        Assert.assertEquals(1,simulatorTick.getCount());
    }

    @Test
    public void reset(){
        simulatorTick.nextCount();
        simulatorTick.resetCounter();
        Assert.assertEquals(0,simulatorTick.getCount());
    }
}
