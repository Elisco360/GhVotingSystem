package sample;

import java.io.*;
import java.time.LocalDate;

/**
 * This class provides the blueprint for a voter object
 */
public class Voter extends Person{
    private final long voterId;
    private final PollingStation pollingStation;
    private final String homeTown;
    private final String password;
    public int candidate;
    private final File votedList = new File("voted.txt");
    private String line;
    private PollingStation viewChoice;

    /**
     * @param homeTown represents the native origin of the voter.
     * @param VOTER_ID represents the unique identity of the voter.
     */
    public Voter(String homeTown, long VOTER_ID, PollingStation pollingStation, String password){
        super();
        this.pollingStation = pollingStation;
        this.voterId = VOTER_ID;
        this.homeTown = homeTown;
        this.password = password;
    }

    /**
     * @param person represents the relevant details of the voter as a person.
     * @param homeTown represents the native origin of the voter.
     * @param VOTER_ID represents the unique identity of the voter.
     */
    public Voter(Person person,String homeTown, long VOTER_ID, PollingStation pollingStation, String password){
        super(person.getName(), person.getDateOfBirth(), person.getGender().charAt(0));
        this.pollingStation = pollingStation;
        this.voterId = VOTER_ID;
        this.homeTown = homeTown;
        this.password = password;
    }

    /**
     * @param name represents the name of the voter.
     * @param dob represents the date of birth of the voter.
     * @param gender represents the gender of the the voter.
     * @param homeTown represents the native origin of the voter.
     * @param VOTER_ID represents the unique identity of the voter.
     */
    public Voter(String name, LocalDate dob, char gender, String homeTown, long VOTER_ID, PollingStation pollingStation, String password){
        super(name, dob, gender);
        this.pollingStation = pollingStation;
        this.voterId = VOTER_ID;
        this.homeTown = homeTown;
        this.password = password;
        try { votedList.createNewFile(); }
        catch (IOException ignored) { }
    }

    /**
     * @return the polling station name as a string
     */
    public PollingStation getPollingStation() {
        return pollingStation;
    }

    /**
     * @return the voter's identity number as a string
     */
    public long getVOTER_ID() {
        return voterId;
    }

    /**
     * @return the hometown of the voter as a string
     */
    public String getHomeTown() {
        return homeTown;
    }

    /**
     * To allow and track voters while they cast vote
     */
    public void castVote(int position){
        if(!this.hasVoted()){
            this.candidate = position;
        }
        else{ System.out.println("CANNOT VOTE TWICE!"); }
    }

    /**
     * @return the candidate who was voted for
     */
    public int getCandidate() {
        return candidate;
    }

    /**
     * @return the voter's relevant details to any user
     */
    @Override
    public String toString() {
        if(this.getGender().equals("Male")){
            return super.toString()+
                    "\nVotes at: "+pollingStation.toString()+
                    "\nVoter's ID: "+ voterId;
        }else{
            return super.toString()+
                    "\nVotes At: "+pollingStation.toString()+
                    "\nVoter's ID: "+ voterId;
        }

    }

    /**
     * @return the combination of the voter's Id and password
     */
    public String credentials(){
        return String.valueOf(voterId).concat(password);
    }

    /**
     * Called to check if the voter's Id is present in the list of voters who have voted
     * @return true if voter's Id is present in the text file and false if otherwise
     */
    public boolean hasVoted(){
        BufferedReader myReader = null;
        try {
            myReader = new BufferedReader(new FileReader(votedList));
            while((line = myReader.readLine()) != null){
                String[] voter = line.split(",");
                if(voter[0].equals(String.valueOf(DashboardController.trackVoter().getVOTER_ID()))){
                    return true;
                }
            }
        } catch (IOException e) { e.printStackTrace();}
        return false;
    }

    /**
     * Called to the position of the candidate who the voter voted for
     * @return the position of the candidate who was voted for as an integer
     */
    public int votedFor(){
        BufferedReader myReader = null;
        try {
            myReader = new BufferedReader(new FileReader(votedList));
            while((line = myReader.readLine()) != null){
                String[] voter = line.split(",");
                if(voter[0].equals(String.valueOf(DashboardController.trackVoter().getVOTER_ID()))){
                    return Integer.parseInt(voter[1]);
                }
            }
        } catch (IOException ignored) {  }
        return 0;
    }

    /**
     * Called in the results selection class to set the polling station where the voter wants to view results
     * @param p represents the polling station selected by the voter
     */
    public void setViewChoice(PollingStation p){
        viewChoice = p;
    }

    /**
     * @return the polling station selected by the voter as a PollingStation object
     */
    public PollingStation getViewChoice() {
        return viewChoice;
    }
}


