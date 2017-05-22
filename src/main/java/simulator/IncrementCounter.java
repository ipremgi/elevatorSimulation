package simulator;

/**
 * Created by HWILKHU on 06/05/2017.
 */
public class IncrementCounter {

    private int count = 0;

    public int getCount() {
        return count;
    }

    public void nextCount() {
        count++;
    }

    public void resetCounter(){ count=0; }
}
