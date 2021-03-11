package sample;

import java.util.Collections;
import java.util.LinkedList;

/**
 *This class contains the collections for each of the relevant entities in the election process and is responsible for
 *keeping track of all instances of these entities that are created in the main class.
 */
public class Admin {
    //Keeps the combination of each voter's Id and password as a string.
    static LinkedList<String> voterCredentials = new LinkedList<>();

    //Keeps track of all instances of Voter that are created in the main class and added appropriately
    static LinkedList<Voter> votersRegister = new LinkedList<>();

    //Keeps track of all instances of PollingStation that are created in the main class and added appropriately
    static LinkedList<PollingStation> pollingStations = new LinkedList<>();

    //Keeps track of all instance of District that are created in the main class and added appropriately
    static LinkedList<District> districts = new LinkedList<>();

    //Keeps track of regions in which voting will be taking place
    static LinkedList<Region.Rcc> regions = new LinkedList<>();

    /**
     * Called to populate the lists with the credentials of each voter added to the voter's register
     * @param v represents an instance of a Voter implying a valid voter
     */
    public void addVoter(Voter... v){
        for(Voter voter: v){
            Admin.voterCredentials.add(voter.credentials());
            Admin.votersRegister.add(voter);
        }
    }

    /**
     * Called to populate the list with polling stations created by the administrator(EC)
     * @param pollingStations represents an instance of PollingStation implying a valid polling station
     */
    public void addPollingStation(PollingStation... pollingStations){
        Collections.addAll(Admin.pollingStations, pollingStations);
    }

    /**
     * Called to populate the list with districts created by the administrator(EC)
     * @param districts represents an instance of District implying a valid district collation center
     */
    public void addDistrict(District... districts){
        Collections.addAll(Admin.districts, districts);
    }

    /**
     * Called to populate the list with districts created by the administrator(EC)
     * @param region represents an instance of Region.Rcc implying a valid regional collation center
     */
    public void addRegion(Region.Rcc... region){
        Collections.addAll(Admin.regions, region);
    }
}
