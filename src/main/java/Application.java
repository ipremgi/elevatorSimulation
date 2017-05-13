import simulator.EvelatorSimulator;
import simulator.ISimulator;

import java.util.Random;

/**
 * Created by IPREMGI on 02/05/2017.
 */
public class Application {


    /**
     * MAIN CLASS - PLACEHOLDER
     * @param args
     */
    public static void main(String[] args) {
        ISimulator simulator = new EvelatorSimulator(10,10,20000,10,4,0.005,10);

        simulator.simulate();
    }
}
