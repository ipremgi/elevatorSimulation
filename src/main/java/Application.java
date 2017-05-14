import simulator.ElevatorSimulator;
import simulator.ISimulator;

/**
 * Created by IPREMGI on 02/05/2017.
 */
public class Application {


    /**
     * MAIN CLASS - PLACEHOLDER
     * @param args
     */
    public static void main(String[] args) {
        ISimulator simulator = new ElevatorSimulator(1,1,2880,10,4,0.1,0.01,10);

        simulator.simulate();
    }
}
