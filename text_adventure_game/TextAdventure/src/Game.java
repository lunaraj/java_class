import java.util.Random;
import java.util.Scanner;
public class Game {
    /**
     * class representing an NBA game
     */
    private int playerScore;
    private int defenderScore;
    private Scanner sc;
    private Player myPlayer;
    private Player defender;
    private Player teammate;
    private Random rnd;
    private String opposingTeam;
    private static String[] allTeams = {"Knicks", "Lakers", "Warriors", "Celtics", "Heat", "Nets", "Magic", "Kings", "Cavaliers", "Suns", "Timberwolves", 
    "Rockets", "Spurs", "Hawks", "Hornets", "Pistons", "Pelicans", "Clippers", "Bucks", "Grizzlies", "Nuggets", "Wizards", "Mavericks", "Bulls", "76ers", "Pacers", "Raptors",
    "Trail-Blazers", "Thunder", "Jazz"};

    /**
     * Custom Constructor for regular season game
     * @param myPlayer
     * @param sc
     */
    public Game(Player myPlayer, Scanner sc) {
        rnd = new Random();
        this.myPlayer = myPlayer;
        this.defender = new Player(rnd.nextInt(60, 87), rnd.nextInt(60, 89), rnd.nextInt(60, 84), rnd.nextInt(60, 84), rnd.nextInt(60, 99) );
        this.teammate = new Player(rnd.nextInt(60, 100), rnd.nextInt(60, 100), rnd.nextInt(60, 100), rnd.nextInt(60, 100), rnd.nextInt(60, 100) );
        this.sc = sc;
        playerScore = 0;
        defenderScore = 0;
        while (true) {
            int num = rnd.nextInt(30);
            if (num != myPlayer.getTeam()) {
                opposingTeam = allTeams[num];
                break;
            }
        }
    }

    /**
     * constructor for playoff game
     * @param myPlayer
     * @param defender
     * @param sc
     */
    public Game(Player myPlayer, Player defender, Scanner sc) {
        rnd = new Random();
        this.myPlayer = myPlayer;
        this.defender = defender;
        this.teammate = new Player(rnd.nextInt(60, 100), rnd.nextInt(60, 100), rnd.nextInt(60, 100), rnd.nextInt(60, 100), rnd.nextInt(60, 100) );
        this.sc = sc;
        playerScore = 0;
        defenderScore = 0;
        while (true) {
            int num = rnd.nextInt(30);
            if (num != myPlayer.getTeam()) {
                opposingTeam = allTeams[num];
                break;
            }
        }
    }

    /**
     * runs through a game of basketball
     * @return if the player won the game
     */
    public boolean actualGame() {
        System.out.println("Tonight on TNT the " + allTeams[myPlayer.getTeam()] + " will play the " + opposingTeam);
        System.out.println("\nYour opponents stats are :\n3 point shooting: " + defender.getThreePointShooting() + "\nLayup: " + defender.getLayup() + "\nDribbling: " + defender.getDribbling() + "\nPassing: " + defender.getPassing() + "\nDefense: " + defender.getDefense());
        System.out.println("\nYour teammates stats are :\n3 point shooting: " + teammate.getThreePointShooting() + "\nLayup: " + teammate.getLayup() + "\nDribbling: " + teammate.getDribbling() + "\nPassing: " + teammate.getPassing() + "\nDefense: " + teammate.getDefense());
        System.out.println("\nThe first quarter will start now!");
        System.out.println("You have the ball");
        offensivePossession();
        defensivePossession();
        offensivePossession();
        defensivePossession();
        offensivePossession();
        defensivePossession();
        offensivePossession();
        defensivePossession();

        System.out.println("And thats the end of the first quarter");
        System.out.println("The Score is " + playerScore + "-" + defenderScore);
        System.out.println("The second quarter will commence shortly");
        waitForUser();
        UI.clearConsole();

        offensivePossession();
        defensivePossession();
        offensivePossession();
        defensivePossession();
        offensivePossession();
        defensivePossession();
        offensivePossession();
        defensivePossession();

        System.out.println("And thats the end of the first half");
        System.out.println("The Score is " + playerScore + "-" + defenderScore);
        System.out.println("The third quarter will commence shortly");
        waitForUser();
        UI.clearConsole();

        offensivePossession();
        defensivePossession();
        offensivePossession();
        defensivePossession();
        offensivePossession();
        defensivePossession();
        offensivePossession();
        defensivePossession();

        System.out.println("And thats the end of the third quarter");
        System.out.println("The Score is " + playerScore + "-" + defenderScore);
        System.out.println("The fourth quarter will commence shortly");
        waitForUser();
        UI.clearConsole();

        offensivePossession();
        defensivePossession();
        offensivePossession();
        defensivePossession();
        offensivePossession();
        defensivePossession();
        offensivePossession();
        defensivePossession();
        System.out.println("You have the last shot to decide the game!");
        offensivePossession();

        while (playerScore == defenderScore) {
            System.out.println("Its time for overtime");
            offensivePossession();
            defensivePossession();
            offensivePossession();
            defensivePossession();
            offensivePossession();
            defensivePossession();
            offensivePossession();
            defensivePossession();
            System.out.println("You have the last shot to decide the game!");
            offensivePossession();
        }

        if (playerScore > defenderScore) {
            System.out.println("You Won the Game!");
            waitForUser();
            UI.clearConsole();
            return true;
        } else {
            System.out.println("You lost the game");
            waitForUser();
            UI.clearConsole();
            return false;
        
        }
    }

    /**
     * simulates an offensive possesion
     */
    public void offensivePossession() {
        System.out.println("Press:\n1 to shoot a three pointer\n2 to drive by defender\n3 to pass");
        int choice = sc.nextInt();
        UI.pause(1000);
        if (choice == 1) {
            if (myPlayer.threePointer(defender)) {
                playerScore += 3; 
                System.out.println("BANGG!!! What a shot from " + myPlayer.getName());
            } else {
                System.out.println("You Missed!");
            }
        } else if (choice == 2) {
            if (myPlayer.drive(defender)) {
                System.out.println("Press:\n1 to shoot a layup\n2 to kick out");
                int newChoice = sc.nextInt();
                if (newChoice == 1) {
                    if (myPlayer.twoPointer(defender)) {
                        playerScore += 2;
                        System.out.println("What a layup!!");
                    } else {
                        System.out.println("You missed bozo. Get Back on Defense");
                    }
                } else {
                    if (myPlayer.pass(defender, teammate, 45)) {
                        playerScore += 3;
                        System.out.println("Your teammate hit the three!!");
                    } else {
                        System.out.println("Your teammate bricked the shot");
                    }
                }
            } else {
                System.out.println("The Defender Stole the Ball!!");
            }
        } else if (choice == 3) {
            if (rnd.nextInt(30) > 15) {
                if (myPlayer.pass(defender, teammate, 36)) {
                    playerScore += 3;
                    System.out.println("Your teammate hit the three!!");
                } else {
                    System.out.println("Your teammate bricked the shot");
                }
            } else {
                if (myPlayer.passTwo(defender, teammate, 47)) {
                    playerScore += 2;
                    System.out.println("Your teammate made the layup!");
                } else {
                    System.out.println("Your teammate missed the shot");
                }
            }
        }
        System.out.println("The Score is " + playerScore + "-" + defenderScore + "\n");
        
    }

    /**
     * simulates a defensive possession
     */
    public void defensivePossession() {
        UI.pause(1000);
        if (defender.drive(myPlayer)) {
            if (rnd.nextInt(10) > 6) {
                if (defender.twoPointer(myPlayer)) {
                    System.out.println("The other team scored a layup");
                    defenderScore += 2;
                } else {
                    System.out.println("The other team missed");
                }
            } else {
                if (defender.threePointer(myPlayer)) {
                    System.out.println("The other team hit a three!");
                    defenderScore += 3;
                } else {
                    System.out.println("The other team missed");
                }
            }
        }  else {
            System.out.println("You stole the ball!!");
        }
        System.out.println("The Score is " + playerScore + "-" + defenderScore + "\n");
    }

    /**
     * wait for user to give an input1
     */
    public void waitForUser() {
        System.out.println("Press anything to continue");
        if (sc.next() == "jaxsonsucks") {
            sc.close();
        }
    }

    
}

