package simulator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by HWILKHU on 18/05/2017.
 */
public class SimulatorTickTest {
    private SimulatorTick simulatorTick;

    @Before
    public void setup(){
        simulatorTick = new SimulatorTick();
    }

    @Test
    public void tick(){
        Assert.assertEquals(0,simulatorTick.getTick());
        simulatorTick.nextTick();
        Assert.assertEquals(1,simulatorTick.getTick());
    }
}
