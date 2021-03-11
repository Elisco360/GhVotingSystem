package sample;

import java.io.*;
import java.util.*;

/**
 * This class is responsible for collating results of the respective political parties from the voters
 */
public class PollingStation implements Collation{
    //Represents the name of the polling station
    private final String pollingStationName;

    //Represents the district in which the polling station is situated
    private final District district;

    //Represents a digital pink sheet or results sheet at the polling station level
    private final File results;


    /**
     * @param pollingStationName represents the name of the polling station
     * @param district represents the district in which the polling station is situated
     * @param results represents a digital pink sheet or results sheet at the polling station level
     */
    PollingStation(String pollingStationName, District district, File results){
        this.pollingStationName = pollingStationName;
        this.district =  district;
        this.results = results;
        this.district.pollingStations.add(this);
        try { this.results.createNewFile(); }
        catch (IOException e) { e.printStackTrace(); }
        readResults(this.results);
    }

    /**
     * @return the results obtained from the polling station
     */
    public File getResults() {
        return results;
    }

    /**
     * Initialized votes of the respective political parties to zero
     */
    public void setResults(){
        try {
            FileWriter writer = new FileWriter(this.results);
            writer.write("0,0,0,0,0,0");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the district of the polling station
     */
    public District getDistrict() {
        return district;
    }

    /**
     * @return the total votes of NPP as an integer
     */
    public int getNppResults() {
        return readResults(this.results)[0];
    }
    /**
     * @return the total votes of NDC as an integer
     */
    public int getNdcResults() {
        return readResults(this.results)[1];
    }
    /**
     * @return the total votes of GUM as an integer
     */
    public int getGumResults() {
        return readResults(this.results)[2];
    }
    /**
     * @return the total votes of CPP as an integer
     */
    public int getCppResults() {
        return readResults(this.results)[3];
    }
    /**
     * @return the total votes of PPP as an integer
     */
    public int getPppResults() {
        return readResults(this.results)[4];
    }
    /**
     * @return the total votes of APC as an integer
     */
    public int getApcResults() {
        return readResults(this.results)[5];
    }

    /**
     * Called to read the results on the results sheet
     * @param file represents the results sheet of a particular polling station
     * @return the results obtained from the results sheet as an integer array
     */
    public int[] readResults(File file){
        int[] pinkSheet = new int[6];
        try{
            int i=0;
            Scanner reader = new Scanner(file);
            if(reader.hasNextLine()){
                for (String s : reader.nextLine().split(",")) {
                    pinkSheet[i] = Integer.parseInt(s);
                    i+=1;
                }
            }
            else { setResults(); }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pinkSheet;
    }

    /**
     * @return name of polling station
     */
    @Override
    public String toString() {
        return pollingStationName;
    }
}
