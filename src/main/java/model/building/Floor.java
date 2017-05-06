package model.building;

import java.util.PriorityQueue;
/**
 * Created by IPREMGI on 02/05/2017.
 */
public class Floor {

    private PriorityQueue<Object> waitingForLift;
    private boolean btnPressed;

    public Floor() {
        waitingForLift = new PriorityQueue<Object>();
        btnPressed = false;
    }

    public void addUser(Object person){
        waitingForLift.add(person);
    }

    public PriorityQueue<Object> getWaitingForLift() {
        return waitingForLift;
    }

    public boolean isBtnPressed() {
        return btnPressed;
    }

    public void setBtnPressed(boolean btnPressed) {
        this.btnPressed = btnPressed;
    }
}
