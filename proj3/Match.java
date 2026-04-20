/**
 * This is the class for the matching logic.
 * 
 * @author Sean Beckford
 */

public class Match {
    public Tile a, b;
    
    public Match(Tile a, Tile b) {
        this.a = a;
        this.b = b;
    }

    public boolean checkMatch() { 
        if (a.getKindID() == b.getKindID()) {
            System.out.println("Tile " + a.getPos().toString() + " matched");
            System.out.println("Tile " + b.getPos().toString() + " matched");
            return true;
        }
        return false;
    }

    
}
