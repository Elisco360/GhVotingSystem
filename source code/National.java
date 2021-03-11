package sample;

import java.util.Stack;

/**
 * This class is responsible for collating results of the respective political parties from the various regions
 */
abstract class National{

    //Keeps the regions who have submitted their results to the national collation center
    protected static Stack<Region.Rcc> regions = new Stack<>();

    //Results collation
    /**
     * @return the total votes of NPP as an integer
     */
    public static int getNppResults() {
        int results = 0;
        for (Region.Rcc each : regions) {   //loops through the regions to get NPP results from each
            results += each.getNppResults();
        }
        return results;
    }

    /**
     * @return the total votes of NDC as an integer
     */
    public static int getNdcResults() {
        int results = 0;
        for (Region.Rcc each : regions) {   //loops through the regions to get NDC results from each
            results += each.getNdcResults();
        }
        return results;
    }

    /**
     * @return the total votes of GUM as an integer
     */
    public static int getGumResults() {
        int results = 0;
        for (Region.Rcc each : regions) {    //loops through the regions to get GUM results from each
            results += each.getGumResults();
        }
        return results;
    }

    /**
     * @return the total votes of CPP as an integer
     */
    public static int getCppResults() {
        int results = 0;
        for (Region.Rcc each : regions) {    //loops through the regions to get CPP results from each
            results += each.getCppResults();
        }
        return results;
    }

    /**
     * @return the total votes of PPP as an integer
     */
    public static int getPppResults() {
        int results = 0;
        for (Region.Rcc each : regions) {    //loops through the regions to get PPP results from each
            results += each.getPppResults();
        }
        return results;
    }

    /**
     * @return the total votes of APC as an integer
     */
    public static int getApcResults() {
        int results = 0;
        for (Region.Rcc each : regions) {     //loops through the regions to get APC results from each
            results += each.getApcResults();
        }
        return results;
    }
}
