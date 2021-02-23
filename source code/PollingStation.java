package sample;

import java.io.*;
import java.util.*;

public class PollingStation {
    protected ArrayList<Voter> voted = new ArrayList<>(); //Class variable
    protected List<Integer> votes = new ArrayList<>(Collections.nCopies(5, 0));//Keep count of votes
    protected  int[] pinkSheet = new int[5];
    private final String pollingStationName;
    private final District district;
    private final File results;


    PollingStation(String pollingStationName, District district, File results){
        this.pollingStationName = pollingStationName;
        this.district =  district;
        this.results = results;
        this.district.pollingStations.add(this);
        try {
            this.results.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        readResults(this.results);
    }

    public File getResults() {
        return results;
    }

    public void setResults(){
        try {
            FileWriter writer = new FileWriter(this.results);
            writer.write("0,0,0,0,0");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public District getDistrict() {
        return district;
    }

    public String getPollingStationName() {
        return pollingStationName;
    }

    public int getNppResults() {
        readResults(this.results);
        return pinkSheet[0];
    }
    public int getNdcResults() {
        readResults(this.results);
        return pinkSheet[1];
    }
    public int getGumResults() {
        readResults(this.results);
        return pinkSheet[2];
    }
    public int getCppResults() {
        readResults(this.results);
        return pinkSheet[3];
    }
    public int getPppResults() {
        readResults(this.results);
        return pinkSheet[4];
    }
   /* public int getGcppResults() {
        PoliticalParties.GCPP.setNumberOfVotes(votes.get(5));
        return PoliticalParties.GCPP.getNumberOfVotes();
    }
    public int getApcResults() {
        PoliticalParties.APC.setNumberOfVotes(votes.get(6));
        return PoliticalParties.APC.getNumberOfVotes();
    }
    public int getLpgResults() {
        PoliticalParties.LPG.setNumberOfVotes(votes.get(7));
        return PoliticalParties.LPG.getNumberOfVotes();
    }
    public int getPncResults() {
        PoliticalParties.PNC.setNumberOfVotes(votes.get(8));
        return PoliticalParties.PNC.getNumberOfVotes();
    }
    public int getPppResults() {
        PoliticalParties.PPP.setNumberOfVotes(votes.get(9));
        return PoliticalParties.PPP.getNumberOfVotes();
    }
    public int getNdpResults() {
        PoliticalParties.NDP.setNumberOfVotes(votes.get(10));
        return PoliticalParties.NDP.getNumberOfVotes();
    }
    public int getIndpResults() {
        PoliticalParties.INDEPENDENT.setNumberOfVotes(votes.get(11));
        return PoliticalParties.INDEPENDENT.getNumberOfVotes();
    }*/

    @Override
    public String toString(){
        return pollingStationName;
    }


    public void readResults(File file){
        try{
            int i=0;
            Scanner reader = new Scanner(file);
            if(reader.hasNextLine()){
                for (String s : reader.nextLine().split(",")) {
                    pinkSheet[i] = Integer.parseInt(s);
                    i+=1;
                }
            }else { setResults(); }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
