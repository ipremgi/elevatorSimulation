package model.user;

/**
 * Created by Aishwarya on 05/05/2017.
 */
public class Client extends ElevatorUser{

    private int duration;



    public void fileComplaint(){

    }



    public void leaveBuilding() {
        setDestFloor(0);
    }

    public void moveFloor() {
        //will enter the building and go to one of the floors in the bottom half of the building
        // (which may include the ground floor). After they complete their business, they will return to the ground floor and leave.

    }

    public void shouldILeave(){
      if (duration >= 10 && duration <= 90){
          setDestFloor(0);
      }
      else
    }
}


    public void shouldIFileComplaint(){
        if (duration <= 60 ){
        setDestFloor(0);
        else{
            fileComplaint();
            }

        //figure out how many ticks for that number of time


    }

}

1 tick is 10 sec
 6 tick is 60 sec
        60 tick is 10 min
        90 tick is 30 min

 */

/*
* sets the move floor using probabilty
* */

