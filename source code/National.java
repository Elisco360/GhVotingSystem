package sample;

import java.util.Stack;

abstract class National {

    //Class variable
    protected static Stack<Region.Rcc> regions = new Stack<>();

    public static int getNppResults() {
        int results = 0;
        for (Region.Rcc each : regions) {
            results += each.getNppResults();
        }
        return results;
    }
    public static int getNdcResults() {
        int results = 0;
        for (Region.Rcc each : regions) {
            results += each.getNdcResults();
        }
        return results;
    }
    public static int getGumResults() {
        int results = 0;
        for (Region.Rcc each : regions) {
            results += each.getGumResults();
        }
        return results;
    }
    public static int getCppResults() {
        int results = 0;
        for (Region.Rcc each : regions) {
            results += each.getCppResults();
        }
        return results;
    }
    public static int getPppResults() {
        int results = 0;
        for (Region.Rcc each : regions) {
            results += each.getPppResults();
        }
        return results;
    }
    /*private static int getGcppResults() {
        int results = 0;
        for (Region.Rcc each : regions) {
            results += each.getGcppResults();
        }
        PoliticalParties.GCPP.setNumberOfVotes(results);
        return PoliticalParties.GCPP.getNumberOfVotes();
    }
    private static int getApcResults() {
        int results = 0;
        for (Region.Rcc each : regions) {
            results += each.getApcResults();
        }
        PoliticalParties.APC.setNumberOfVotes(results);
        return PoliticalParties.APC.getNumberOfVotes();    }
    public static int getLpgResults() {
        int results = 0;
        for (Region.Rcc each : regions) {
            results += each.getLpgResults();
        }
        PoliticalParties.LPG.setNumberOfVotes(results);
        return PoliticalParties.LPG.getNumberOfVotes();
    }
    public static int getPncResults() {
        int results = 0;
        for (Region.Rcc each : regions) {
            results += each.getPncResults();
        }
        PoliticalParties.PNC.setNumberOfVotes(results);
        return PoliticalParties.PNC.getNumberOfVotes();
    }
    public static int getPppResults() {
        int results = 0;
        for (Region.Rcc each : regions) {
            results += each.getPppResults();
        }
        PoliticalParties.PPP.setNumberOfVotes(results);
        return PoliticalParties.PPP.getNumberOfVotes();
    }
    public static int getNdpResults() {
        int results = 0;
        for (Region.Rcc each : regions) {
            results += each.getNdpResults();
        }
        PoliticalParties.NDP.setNumberOfVotes(results);
        return PoliticalParties.NDP.getNumberOfVotes();    }
    public static int getIndpResults() {
        int results = 0;
        for (Region.Rcc each : regions) {
            results += each.getIndpResults();
        }
        PoliticalParties.INDEPENDENT.setNumberOfVotes(results);
        return PoliticalParties.INDEPENDENT.getNumberOfVotes();
    }*/
}
