package sample;

import java.util.Stack;

/**
 * This class is responsible for collating results of the respective political parties from the polling station
 */
public class District implements Collation{
    //Instance variables
    private String districtName;    //The name of the district
    private final Region.Rcc region;     //Assigned region of the district
    public Stack<PollingStation> pollingStations = new Stack<>();  //Keeps polling stations under the district

    /**
     * @param districtName represents the name of the district
     * @param region represents the region the district belongs to
     */
    District(String districtName, Region.Rcc region) {
        this.districtName = districtName;
        this.region = region;
        this.region.districts.add(this);
    }

    /**
     * @return the name of the district as a string
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * @param districtName represents the new name of the district
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * @return the region to which the district belongs
     */
    public Region.Rcc getRegion() {
        return region;
    }

    //Results collation
    /**
     * @return the total votes of NPP as an integer
     */
   public int getNppResults() {
        int results = 0;
        for (PollingStation each : pollingStations) {  //loops through polling stations to get NPP results from each
            results += each.getNppResults();
        }
        return results;
    }

    /**
     * @return the total votes of NDC as an integer
     */
   public int getNdcResults() {
        int results = 0;
        for (PollingStation each : pollingStations) { //loops through polling stations to get NDC results from each
            results += each.getNdcResults();
        }
        return results;
   }

    /**
     * @return the total votes of GUM as an integer
     */
   public int getGumResults() {
        int results = 0;
        for (PollingStation each : pollingStations) { //loops through polling stations to get GUM results from each
            results += each.getGumResults();
        }
        return results;
   }

    /**
     * @return the total votes of CPP as an integer
     */
    public int getCppResults() {
        int results = 0;
        for (PollingStation each : pollingStations) { //loops through polling stations to get CPP results from each
            results += each.getCppResults();
        }
        return results;
    }

    /**
     * @return the total votes of PPP as an integer
     */
    public int getPppResults() {
        int results = 0;
        for (PollingStation each : pollingStations) { //loops through polling stations to get PPP results from each
            results += each.getPppResults();
        }
        return results;
    }

    /**
     * @return the total votes of APC as an integer
     */
    public int getApcResults() {
        int results = 0;
        for (PollingStation each : pollingStations) { //loops through polling stations to get APC results from each
            results += each.getApcResults();
        }
        return results;
    }
}
