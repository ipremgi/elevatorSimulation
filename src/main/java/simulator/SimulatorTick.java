package simulator;

/**
 * Created by HWILKHU on 06/05/2017.
 */
public class SimulatorTick {

    private int tick = 0;

    public int getTick() {
        return tick;
    }

    public void nextTick() {
        tick++;
    }
}
