package sample;

import java.util.Stack;

public class District{
    //Instance variables
    private final String districtName;
    private Region.Rcc region;
    public Stack<PollingStation> pollingStations = new Stack<>();

    District(String districtName, Region.Rcc region) {
        this.districtName = districtName;
        this.region = region;
        this.region.districts.add(this);
    }

    public String getDistrictName() {
        return districtName;
    }

    public Region.Rcc getRegion() {
        return region;
    }

   public int getNppResults() {
        int results = 0;
        for (PollingStation each : pollingStations) {
            results += each.getNppResults();
        }
        return results;
    }
   public int getNdcResults() {
        int results = 0;
        for (PollingStation each : pollingStations) {
            results += each.getNdcResults();
        }
        return results;
   }
   public int getGumResults() {
        int results = 0;
        for (PollingStation each : pollingStations) {
            results += each.getGumResults();
        }
        return results;
   }
    public int getCppResults() {
        int results = 0;
        for (PollingStation each : pollingStations) {
            results += each.getCppResults();
        }
        return results;
    }
    public int getPppResults() {
        int results = 0;
        for (PollingStation each : pollingStations) {
            results += each.getPppResults();
        }
        return results;
    }
   /* public int getGcppResults() {
        int results = 0;
        for (PollingStation each : pollingStations) {
            results += each.getGcppResults();
        }
        return results;
    }
    public int getApcResults() {
        int results = 0;
        for (PollingStation each : pollingStations) {
            results += each.getApcResults();
        }
        return results;
    }
    public int getLpgResults() {
        int results = 0;
        for (PollingStation each : pollingStations) {
            results += each.getLpgResults();
        }
        return results;
    }
    public int getPncResults() {
        int results = 0;
        for (PollingStation each : pollingStations) {
            results += each.getPncResults();
        }
        return results;
    }
    public int getPppResults() {
        int results = 0;
        for (PollingStation each : pollingStations) {
            results += each.getPppResults();
        }
        return results;
    }
    public int getNdpResults() {
        int results = 0;
        for (PollingStation each : pollingStations) {
            results += each.getNdpResults();
        }
        return results;
    }
    public int getIndpResults() {
        int results = 0;
        for (PollingStation each : pollingStations) {
            results += each.getIndpResults();
        }
        return results;
    }*/

    /**
     * The method returns a summary of all votes for the respective political parties.
     * @return the summary of the voting process and some relevant details as a string.
     */
    public String toString() {
        return districtName;
    }

}
