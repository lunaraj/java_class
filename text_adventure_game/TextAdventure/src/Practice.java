import java.util.Random;
/**
 * class represnting a practice
 */
public class Practice {
    private Random rnd;
    private int drillsLeft;
    
    /**
     * empty constructor
     */
    public Practice() {
        drillsLeft = 3;
        rnd = new Random();
    }

    /**
     * determines if training drill was succesfull
     * @return
     */
    public boolean train() {
        UI.pause(650);
        if (drillsLeft < 1) {
            System.out.println("Out of Drills");
            return false;
        } else { drillsLeft -= 1; }
        if (rnd.nextInt(100) > 50) {
            return true;
        } else { return false; }
    }

    public int getDrillsLeft() {
        return drillsLeft;
    }

}
