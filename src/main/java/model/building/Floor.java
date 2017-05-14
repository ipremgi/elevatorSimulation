package model.building;

import model.user.ElevatorUser;

import java.util.PriorityQueue;
/**
 * Created by IPREMGI on 02/05/2017.
 */
public class Floor {

    private PriorityQueue<ElevatorUser> waitingForLift;
    private boolean btnPressed;

    public Floor() {
        waitingForLift = new PriorityQueue<ElevatorUser>();
        btnPressed = false;
    }

    public void addUser(ElevatorUser person){
        waitingForLift.add(person);
    }

    public PriorityQueue<ElevatorUser> getWaitingForLift() {
        return waitingForLift;
    }

    public boolean isBtnPressed() {
        return btnPressed;
    }

    public void setBtnPressed(boolean btnPressed) {
        this.btnPressed = btnPressed;
    }

    public void removeUser(ElevatorUser user){
        waitingForLift.remove(user);
    }
}
