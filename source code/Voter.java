package sample;

import java.io.*;
import java.time.LocalDate;

public class Voter extends Person{
    //Instance variables
    private final long voterId;
    private final PollingStation pollingStation;
    private final String homeTown;
    private final String password;
    public int candidate;
    private final File votedList = new File("voted.txt");
    private String line;
    private PollingStation viewChoice;

    /**
     * Parametric constructor
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
     * Parametric construction
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
     * Parametric constructor
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
    }

    //Accessor methods
    /**
     * To access a voter's polling station
     * @return the polling station name as a string
     */
    public PollingStation getPollingStation() {
        return pollingStation;
    }

    /**
     * To access a voter's id
     * @return the voter's identity number as a string
     */
    public long getVOTER_ID() {
        return voterId;
    }

    /**
     * To get the voter's hometown
     * @return the hometown of the voter as a string
     */
    public String getHomeTown() {
        return homeTown;
    }

    //Auxiliary methods
    /**
     * To allow and track voters while they cast vote
     */
    public void castVote(int position){
        if(!this.hasVoted() /*&& !this.pollingStation.getPollingStationName().equals("Not registered")*/){
            this.pollingStation.voted.add(this);
            this.candidate = position;
            this.pollingStation.votes.set(position-1, this.pollingStation.votes.get(position-1)+1);
        }
        else{ System.out.println("CANNOT VOTE TWICE!"); }
    }

    public int getCandidate() {
        return candidate;
    }

    /**
     * toString method overridden from the Object class
     * @return the voter's relevant details to any user
     */
    @Override
    public String toString() {
        if(this.getGender().equals("Male")){
            return super.toString()+
                    "\nVotes at: "+pollingStation.getPollingStationName()+
                    "\nVoter's ID: "+ voterId;
        }else{
            return super.toString()+
                    "\nVotes At: "+pollingStation.getPollingStationName()+
                    "\nVoter's ID: "+ voterId;
        }

    }

    public String credentials(){
        return String.valueOf(voterId).concat(password);
    }

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
        } catch (IOException e) { }
        return false;
    }

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
        } catch (IOException e) {  }
        return 0;
    }

    public void setViewChoice(PollingStation p){
        viewChoice = p;
    }

    public PollingStation getViewChoice() {
        return viewChoice;
    }
}


