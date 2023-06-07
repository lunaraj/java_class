import java.util.Random;
/**
 * class for the player
 */
public class Player {
    private int threePointShooting; 
    private int dribbling; 
    private int passing;
    private int layup;
    private int defense;
    private String name;
    private int team;
    
    /**
     * empty constructor
     */
    public Player() {
        threePointShooting = 60;
        dribbling = 60;
        passing = 60;
        layup = 60;
        defense = 60;
    }

    /**
     * overloaded constructor
     * @param threePointShooting
     * @param layup
     * @param dribbling
     * @param passing
     * @param defense
     */
    public Player(int threePointShooting, int layup, int dribbling, int passing, int defense) {
        this.threePointShooting = threePointShooting;
        this.layup = layup;
        this.dribbling = dribbling;
        this.passing = passing;
        this.defense = defense;
    }

    /**
     * setter for player team
     * @param n
     */
    public void setTeam(int n) {
        this.team = n;
    }

    /**
     * gets the team of the player
     * @return the team
     */

    public int getTeam() {
        return this.team;
    }

    /**
     * set name for player
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets name for player
     * @return name of player
     */
    public String getName() {
        return name;
    }

    /**
     * getter for outside shooting
     * @return outside shooting
     */
    public int getThreePointShooting() {
        return threePointShooting;
    }
    /**
     * getter for dribbling
     * @return dribbling
     */
    public int getDribbling() {
        return dribbling;
    }
    /**
     * getter for passing
     * @return passing
     */
    public int getPassing() {
        return passing;
    }
    /**
     * getter for inside shooting
     * @return inside shooting
     */
    public int getLayup() {
        return layup;
    }
    /**
     * getter for defense
     * @return defense
     */
    public int getDefense() {
        return defense;
    }
    /**
     * incrementter for outside shooting
     * @param i
     */
    public void incrementThreePointShooting(int i) {
        if (threePointShooting < 99){
        threePointShooting += i;
        }
    }
    /**
     * incrementter for dribbling
     * @param i
     */
    public void incrementDribbling(int i) {
        if (dribbling < 99){
        dribbling += i;
        }
    }
    /**
     * incrementter for passing
     * @param i
     */
    public void incrementPassing(int i) {
        if (passing < 99){
        passing += i;
        }
    }
    /**
     * incrementter for inside shooting
     * @param i
     */
    public void incrementLayup(int i) {
        if (layup < 99){
        layup += i;
        }
    }
    /**
     * incrementter for defense
     * @param i
     */
    public void incrementDefense(int i) {
        if (defense < 99){
        defense += i;
        }
    }
    

    /**
     * determines whether a three pointer goes in or not
     * @param defender
     * @return true or false, if the three goes in or not
     */
    public boolean threePointer(Player defender) {
        Random rnd = new Random();
        int difference = threePointShooting - defender.getDefense();
        int chance = Math.abs(difference + 40);
        if (rnd.nextInt(100) < chance) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * simulates layup 
     * @param defender
     * @return if layup goes in
     */
    public boolean twoPointer(Player defender) {
        Random rnd = new Random();
        int difference = layup - defender.getDefense();
        int chance = Math.abs(difference + 61);
        if (rnd.nextInt(100) < chance) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * simulates player drive to the basket
     * @param defender
     * @return if the drive was succesfull
     */
    public boolean drive(Player defender) {
        Random rnd = new Random();
        int difference = dribbling - defender.getDribbling();
        int chance = Math.abs(difference + 80);
        if (rnd.nextInt(100) < chance) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * simulates pass to teammate for a three pointer
     * @param defender
     * @param teammate
     * @param multiplier
     * @return if the shot goes in
     */
    public boolean pass(Player defender, Player teammate, int multiplier) {
        Random rnd = new Random();
        int difference = (passing + teammate.getThreePointShooting()) - (defender.getPassing() + defender.getDefense());
        int chance = Math.abs(difference + multiplier);
        if (rnd.nextInt(100) < chance) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * simualtes pass to teammate for 2 pointer
     * @param defender
     * @param teammate
     * @param multiplier
     * @return if the shot goes in or not
     */
    public boolean passTwo(Player defender, Player teammate, int multiplier) {
        Random rnd = new Random();
        int difference = (passing + teammate.getLayup()) - (defender.getPassing() + defender.getDefense());
        int chance = Math.abs(difference + multiplier);
        if (rnd.nextInt(100) < chance) {
            return true;
        } else {
            return false;
        }
    }
}

