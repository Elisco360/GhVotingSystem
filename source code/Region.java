package sample;

import java.util.Stack;

public class Region {
    public static Rcc Oti = new Rcc("OTI");
    public static Rcc BonoEast = new Rcc("BONO EAST");
    public static Rcc Ahafo = new Rcc("AHAFO");
    public static Rcc Bono = new Rcc("BONO");
    public static Rcc NorthEast = new Rcc("NORTH EAST");
    public static Rcc Savannah = new Rcc("SAVANNAH");
    public static Rcc WesternNorth = new Rcc("WESTERN NORTH");
    public static Rcc Western = new Rcc("WESTERN");
    public static Rcc Volta = new Rcc("VOLTA");
    public static Rcc GreaterAccra = new Rcc("GREATER ACCRA");
    public static Rcc Eastern = new Rcc("EASTERN");
    public static Rcc Ashanti = new Rcc("ASHANTI");
    public static Rcc Central = new Rcc("CENTRAL");
    public static Rcc Northern = new Rcc("NORTHERN");
    public static Rcc UpperEast = new Rcc("UPPER EAST");
    public static Rcc UpperWest = new Rcc("UPPER WEST");

    protected static class Rcc {
        protected Stack<District> districts = new Stack<>();
        private final String regionName;

        Rcc(String regionName) {
            this.regionName = regionName;
            National.regions.add(this);
        }

        public String getDistricts() {
            return districts.toString();
        }

        public String getRegionName() {
            return regionName;
        }


        public int getNppResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getNppResults();
            }
            return results;
        }

        public int getNdcResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getNdcResults();
            }
            return results;
        }

        public int getGumResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getGumResults();
            }
            return results;
        }

        public int getCppResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getCppResults();
            }
            return results;
        }

        public int getPppResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getPppResults();
            }
            return results;
        }

       /* public int getGcppResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getGcppResults();
            }
            return results;
        }

        public int getApcResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getApcResults();
            }
            return results;
        }

        public int getLpgResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getLpgResults();
            }
            return results;
        }

        public int getPncResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getPncResults();
            }
            return results;
        }

        public int getPppResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getPppResults();
            }
            return results;
        }

        public int getNdpResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getNdpResults();
            }
            return results;
        }

        public int getIndpResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getIndpResults();
            }
            return results;
        }*/

        public String Summary() {
            return  "\nTotal number of districts in the region: " + districts.size();
                    /*"\n\n\t\t\t\t"+regionName+" REGIONAL RESULTS:\n\t\t\t\t\t" +
                    PoliticalParties.NPP.name() + " : " + getNppResults() + " votes" + "\n\t\t\t\t\t" +
                    PoliticalParties.NDC.name() + " : " + getNdcResults() + " votes" + "\n\t\t\t\t\t" +
                    PoliticalParties.GUM.name() + " : " + getGumResults() + " votes" + "\n\t\t\t\t\t" +
                    PoliticalParties.CPP.name() + " : " + getCppResults() + " votes" + "\n\t\t\t\t\t" ;
                    /*PoliticalParties.GFP.name() + " : " + getGfpResults() + " votes" + "\n\t\t\t\t\t" +
                    PoliticalParties.GCPP.name() + " : " + getGcppResults() + " votes" + "\n\t\t\t\t\t" +
                    PoliticalParties.APC.name() + " : " + getApcResults() + " votes" + "\n\t\t\t\t\t" +
                    PoliticalParties.LPG.name() + " : " + getLpgResults() + " votes" + "\n\t\t\t\t\t" +
                    PoliticalParties.PNC.name() + " : " + getPncResults() + " votes" + "\n\t\t\t\t\t" +
                    PoliticalParties.PPP.name() + " : " + getPppResults() + " votes" + "\n\t\t\t\t\t" +
                    PoliticalParties.NDP.name() + " : " + getNdpResults() + " votes" + "\n\t\t\t" +
                    PoliticalParties.INDEPENDENT.name() + " : " + getIndpResults() + " votes" + "\n";*/
        }
    }
}
