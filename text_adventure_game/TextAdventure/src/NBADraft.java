import java.util.Scanner;
/**
 * simulates NBA Draft
 */
public class NBADraft {
    private Scanner sc;
    /**
     * constructor
     * @param sc
     */
    public NBADraft(Scanner sc) {
        this.sc = sc;
    }
    
    /**
     * chooses name for player
     * @return name for player
     */
    public String chooseName() {
        System.out.println("What is the name of your player?");
        String name = sc.nextLine();
        return name;
    }

    /**
     * chooses team for player
     * @return team that player chose
     */
    public String chooseTeam() {
        System.out.println("\nWhat team would you like to get drafted to?\nPress:\n1 for the Knicks\n2 for the Lakers\n3 for the Warriors\n4 for the Celtics\n5 for the Heat");
        int choice = sc.nextInt();
        if (choice == 1){return "Knicks";} else if (choice == 2) {return "Lakers";} else if (choice == 3) {return "Warriors";} else if (choice == 4) {return "Celtics";} else {return "Heat";}
    }

    /**
     * method to choose stats for player
     * @return the new player with stats
     */
    public Player chooseStats() {
        Player myPlayer = new Player();
        
        int pointsLeft = 40;
        int allocated = 0;
        String howMany = "How many points would you like to allocate to this stat?";
        System.out.println("\nYou have 40 points to spend on stats. Your stats start at 60 for each category and max out at 99\nYou can only upgrade to 90 in a stat to start\nThe 5 categories are 3 point shooting, layup, Passing, Dribbling, Defense");
        while (pointsLeft > 0) {
            System.out.println("Choose a stat to allocate points to. Press:\n1 for 3 point shooting \n2 for layup \n3 for dribbling \n4 for passing \n5 for defense");
            int choice = sc.nextInt();
            if (choice == 1){ 
                System.out.println(howMany);
                allocated = sc.nextInt();
                if ((allocated > pointsLeft) || (myPlayer.getThreePointShooting() + allocated > 90)) {
                    System.out.println("not enough points or points exceed limit of 90");
                } else {
                    myPlayer.incrementThreePointShooting(allocated);
                    pointsLeft -= allocated;
                }
                
            } else if (choice == 2) { 
                System.out.println(howMany);
                allocated = sc.nextInt();
                if ((allocated > pointsLeft) || (myPlayer.getLayup() + allocated > 90)) {
                    System.out.println("not enough points or points exceed limit of 90");
                } else {
                    myPlayer.incrementLayup(allocated);
                    pointsLeft -= allocated;
                }

            } else if (choice == 3) { 
                System.out.println(howMany);
                allocated = sc.nextInt();
                if ((allocated > pointsLeft) || (myPlayer.getDribbling() + allocated > 90)) {
                    System.out.println("not enough points or points exceed limit of 90");
                } else {
                    myPlayer.incrementDribbling(allocated);
                    pointsLeft -= allocated;
                }
            } else if (choice == 4) { 
                System.out.println(howMany);
                allocated = sc.nextInt();
                if ((allocated > pointsLeft) || (myPlayer.getPassing() + allocated > 90)) {
                    System.out.println("not enough points or points exceed limit of 90");
                } else {
                    myPlayer.incrementPassing(allocated);
                    pointsLeft -= allocated;
                }
            } else if (choice == 5){ 
                System.out.println(howMany);
                allocated = sc.nextInt();
                if ((allocated > pointsLeft) || (myPlayer.getDefense() + allocated > 90)) {
                    System.out.println("not enough points or points exceed limit of 90");
                } else {
                    myPlayer.incrementDefense(allocated);
                    pointsLeft -= allocated;
                }
            }
            System.out.println("\nyou have " + pointsLeft + " points Left");
        }
        return myPlayer;
        
    }

    
}
