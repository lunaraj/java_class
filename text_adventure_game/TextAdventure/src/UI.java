import java.util.Scanner;
/**
 * class that represents the User Interface
 */
public class UI {

    private Scanner sc;
    private Player myPlayer;

    /**
     * runs user interface
     */
    public void runUI(){
        sc = new Scanner(System.in);
        clearConsole();
        initiation();
        season();
        while (true) {
            System.out.println("Press:\n1: to continue your career\n2: to start a new career\n3: to exit");
            int choice = sc.nextInt();
            if (choice == 1) {season();} else if (choice == 2) {initiation(); season();} else {break;}
        }
        sc.close();
    } 

    /**
     * initializes game, sets up name, team, and stats for player
     */
    public void initiation() {
        System.out.println("Welcome to Basketball Stars!!!\n");
        NBADraft draft = new NBADraft(sc);
        String name = draft.chooseName();
        String team = draft.chooseTeam();
        myPlayer = draft.chooseStats();
        myPlayer.setName(name);

        clearConsole();
        System.out.println("Adam Silver:\nWith the first pick in the NBA draft the " + team + " select " + name + "!!!\n");
        System.out.println("Your Stats are: \n3 Point Shooting " + myPlayer.getThreePointShooting()
        + "\nLayups: " + myPlayer.getLayup() + "\nDribbling: " + myPlayer.getDribbling()+ "\nPassing: " + myPlayer.getPassing()
        + "\nDefense: " + myPlayer.getDefense()  );
        
        if (team.equals("Knicks")) {
            myPlayer.setTeam(0);
        } else if (team.equals("Lakers")) {
            myPlayer.setTeam(1);
        } else if (team.equals("Warriors")) {
            myPlayer.setTeam(2);
        } else if (team.equals("Celtics")) {
            myPlayer.setTeam(3);
        } else if (team.equals("Heat")) {
            myPlayer.setTeam(4);
        }

        int choice = 0;
        System.out.println("\n\nIts your rookie year and its time for your first practice. You have 3 practice drills to do. \nEvery time you train a drill you have a 50% chance to increase your stats");
        Practice practice = new Practice();
        while (practice.getDrillsLeft() > 0) {
            System.out.println("\nWhat would you like to train?\nPress:\n1 for 3 Point Shooting\n2 for Layups\n3 for Dribbling\n4 for Passing\n5 for Defense");
            choice = sc.nextInt();
            if (practice.train()) {System.out.println("training succesful!\nThe Stat you chose increased by 1");
                if (choice == 1) {myPlayer.incrementThreePointShooting(1);} else if (choice == 2) {myPlayer.incrementLayup(1);} else if (choice == 3) {myPlayer.incrementDribbling(1);} else if (choice == 4) {myPlayer.incrementPassing(1);} else if (choice == 5) {myPlayer.incrementDefense(1);}
            } else {System.out.println("You failed your training no stats were increased");}
            System.out.println("You have " + practice.getDrillsLeft() + " drills left.");
        }
        waitForUser();
        
        
    }

    /**
     * simumulates a season of basketball
     */
    public void season() {
        int dayCounter = 0;
        int choice;
        int practices = 1;
        int wins = 0;
        int losses = 0;
        clearConsole();
        System.out.println("There are 10 games in a season. Between each game you get one practice to upgrade your skills\n");
        while (dayCounter < 10) {
            System.out.println("\nWould you like to: \n1: Attend Practice\n2: See Stats\n3: Play your next game\n4: Quit");
            choice = sc.nextInt();
            if (choice == 1) {
                if (practices > 0) {
                    Practice practice = new Practice();
                    while (practice.getDrillsLeft() > 0) {
                        System.out.println("\nWhat would you like to train?\nPress:\n1 for 3 Point Shooting\n2 for Layups\n3 for Dribbling\n4 for Passing\n5 for Defense\n");
                        choice = sc.nextInt();
                        if (practice.train()) {System.out.println("training succesful!\nThe Stat you chose increased by 1");
                            if (choice == 1) {myPlayer.incrementThreePointShooting(1);} else if (choice == 2) {myPlayer.incrementLayup(1);} else if (choice == 3) {myPlayer.incrementDribbling(1);} else if (choice == 4) {myPlayer.incrementPassing(1);} else if (choice == 5) {myPlayer.incrementDefense(1);}
                        } else {System.out.println("You failed your training no stats were increased");}
                        System.out.println("You have " + practice.getDrillsLeft() + " drills left.\n");
                    }
                    practices = 0;
                } else {
                    System.out.println("No practices left. Play game to continue");
                }
            } else if (choice == 2) {
                clearConsole();
                System.out.println("\nYour Stats are: \n\n3 Point Shooting: " + myPlayer.getThreePointShooting()
                + "\nLayups: " + myPlayer.getLayup() + "\nDribbling: " + myPlayer.getDribbling()+ "\nPassing: " + myPlayer.getPassing()
                + "\nDefense: " + myPlayer.getDefense()  );
                System.out.println("\nYour record is " + wins + "-" + losses + "\n");
            } else if (choice == 3) {
                clearConsole();
                Game game = new Game(myPlayer, sc);
                if (game.actualGame()) {
                    wins += 1;
                } else {
                    losses += 1;
                }
                practices = 1;
                dayCounter += 1;
            } else if (choice == 4) {
                sc.close();
                break;
            } else {
                System.out.println("Please choose a 1, 2, 3, or 4");
            }
        }
        System.out.println("Its time for your last practice of the year before the playoffs");
        Practice practice = new Practice();
        while (practice.getDrillsLeft() > 0) {
            System.out.println("\nWhat would you like to train?\nPress:\n1 for 3 Point Shooting\n2 for Layups\n3 for Dribbling\n4 for Passing\n5 for Defense");
            choice = sc.nextInt();
            if (practice.train()) {System.out.println("training succesful!\nThe Stat you chose increased by 1");
                if (choice == 1) {myPlayer.incrementThreePointShooting(1);} else if (choice == 2) {myPlayer.incrementLayup(1);} else if (choice == 3) {myPlayer.incrementDribbling(1);} else if (choice == 4) {myPlayer.incrementPassing(1);} else if (choice == 5) {myPlayer.incrementDefense(1);}
            } else {System.out.println("You failed your training no stats were increased");}
            System.out.println("You have " + practice.getDrillsLeft() + " drills left.");
        }
        waitForUser();
        clearConsole();
        System.out.println("The Regular Season is Over");
        System.out.println("Your record was " + wins + "-" + losses + ".......");
        pause(1000);
        if (wins < losses) {
            System.out.println("You missed the playoffs");
        } else {
            System.out.println("You made the playoffs");
            Player defender = new Player(75, 75, 75, 75, 75);
            Game firstRound = new Game(myPlayer, defender, sc);
            if (!firstRound.actualGame()) {
                System.out.println("You lost in the first round. Try again next year.");
            } else {
                System.out.println("You made it to the second round!");
                Player betterDefender = new Player(80, 80, 80, 80, 80);
                Game secondRound = new Game(myPlayer, betterDefender, sc);
                if (!secondRound.actualGame()) {
                    System.out.println("You lost in the second round. Try again next year");
                } else {
                    System.out.println("You made it to the conference finals!");
                    Player conferenceDefender = new Player(87, 86, 86, 85, 85);
                    Game conferenceFinals = new Game(myPlayer, conferenceDefender, sc);
                    if (!conferenceFinals.actualGame()) {
                        System.out.println("You lost in the conference finals. Try again next year.");
                    } else {
                        System.out.println("You made it to the NBA finals!");
                        Player finalsDefender = new Player(93, 93, 93, 93, 93);
                        Game finals = new Game(myPlayer, finalsDefender, sc);
                        if (!finals.actualGame()) {
                            System.out.println("You lost in the NBA finals. Try again next year.");
                        } else {
                            System.out.println("You Won the NBA FINALS. Congratulations!");
                        }
                    } 
                }
            }
        }
        

        
    }
    /**
     * method that clears the console
     */
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    /**
     * method that pauses for x milliseconds
     * @param mseconds
     */
    public static void pause(int mseconds) {
        try {
            Thread.sleep(mseconds);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
    }

    /**
     * waits for player to give any input
     */
    public void waitForUser() {
        System.out.println("Press anything to continue");
        if (sc.next() == "jaxsonsucks") {
            sc.close();
        }
    }
}
