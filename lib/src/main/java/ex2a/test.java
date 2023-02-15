package ex2a;

import java.util.ArrayList;

public class test{

    public static void main(String[] args) {


        AirPollutionAlert singaporeAlert = new AirPollutionAlert();

        ShouldBeDeleted shouldBeDeleted = new ShouldBeDeleted();

        Subscriber man = new Subscriber("man",singaporeAlert);

        Subscriber simon = new Subscriber("simon", singaporeAlert);

        singaporeAlert.setAirPollutionIndex(200);

        singaporeAlert.setAirPollutionIndex(50);

        singaporeAlert.setAirPollutionIndex(120);

        singaporeAlert.unregister(man);

        singaporeAlert.setAirPollutionIndex(300);

    }

}