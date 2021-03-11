package sample;

import java.util.Stack;

public class Region{
    //List of all regions in Ghana
    public static Rcc Oti = new Rcc("Oti Region");
    public static Rcc BonoEast = new Rcc("Bono East Region");
    public static Rcc Ahafo = new Rcc("Ahafo Region");
    public static Rcc Bono = new Rcc("Bono Region");
    public static Rcc NorthEast = new Rcc("North East Region");
    public static Rcc Savannah = new Rcc("Savannah Region");
    public static Rcc WesternNorth = new Rcc("Western North Region");
    public static Rcc Western = new Rcc("Western Region");
    public static Rcc Volta = new Rcc("Volta Region");
    public static Rcc GreaterAccra = new Rcc("Greater Accra Region");
    public static Rcc Eastern = new Rcc("Eastern Region");
    public static Rcc Ashanti = new Rcc("Ashanti Region");
    public static Rcc Central = new Rcc("Central Region");
    public static Rcc Northern = new Rcc("Northern Region");
    public static Rcc UpperEast = new Rcc("Upper East Region");
    public static Rcc UpperWest = new Rcc("Upper West Region");

    protected static class Rcc implements Collation{
        //Represents the districts under a region
        protected Stack<District> districts = new Stack<>();

        //Represents the name of the region
        private final String regionName;

        //Constructor
        /**
         * @param regionName represents the name of the region
         */
        Rcc(String regionName) {
            this.regionName = regionName;
            National.regions.add(this);
        }

        /**
         * @return the name of the region
         */
        public String getRegionName() {
            return regionName;
        }

        /**
         * @return the total votes of NPP as an integer
         */
        public int getNppResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getNppResults();
            }
            return results;
        }
        /**
         * @return the total votes of NDC as an integer
         */
        public int getNdcResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getNdcResults();
            }
            return results;
        }
        /**
         * @return the total votes of GUM as an integer
         */
        public int getGumResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getGumResults();
            }
            return results;
        }
        /**
         * @return the total votes of CPP as an integer
         */
        public int getCppResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getCppResults();
            }
            return results;
        }
        /**
         * @return the total votes of PPP as an integer
         */
        public int getPppResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getPppResults();
            }
            return results;
        }
        /**
         * @return the total votes of APC as an integer
         */
        public int getApcResults() {
            int results = 0;
            for (District dcc : districts) {
                results += dcc.getApcResults();
            }
            return results;
        }
    }
}
