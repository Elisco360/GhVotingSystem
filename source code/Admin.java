package sample;

import java.util.ArrayList;
import java.util.Collections;

public class Admin {
    static ArrayList<String> voterCredentials = new ArrayList<>();
    static ArrayList<Voter> votersRegister = new ArrayList<>();
    static ArrayList<PollingStation> pollingStations = new ArrayList<>();
    static ArrayList<District> districts = new ArrayList<>();
    static ArrayList<Region.Rcc> regions = new ArrayList<>();

    public void addVoter(Voter... v){
        for(Voter voter: v){
            Admin.voterCredentials.add(voter.credentials());
            Admin.votersRegister.add(voter);
        }
    }

    public void addPollingStation(PollingStation... pollingStations){
        Collections.addAll(Admin.pollingStations, pollingStations);
    }

    public void addDistrict(District... districts){
        Collections.addAll(Admin.districts, districts);
    }

    public void addRegion(Region.Rcc... region){
        Collections.addAll(Admin.regions, region);
    }
}
