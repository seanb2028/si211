/**
 * This class handles the matching logic for the game.
 * 
 * @author Sean Beckford
 */
import java.util.*;

public class Match implements StateListener {
    private List<Tile> tiles = new ArrayList<>();

    // State listener method
    public void activated(Tile t) {
        tiles.add(t);
        t.disable();
        if (tiles.size() == 2) checkMatch();
    }

    // Checks the two tiles to see if they match and prints out the result
    private void checkMatch() {
        boolean matched = (tiles.get(0).getKindID() == tiles.get(1).getKindID() && tiles.get(0).getPos() != tiles.get(1).getPos());

        System.out.print("Tile " + tiles.get(0).getPosString() + " and Tile " + tiles.get(1).getPosString() + " colors ");
        System.out.println((matched) ? "match" : "don't match");
        
        if (matched) {
            for (Tile t : tiles)
                t.permanentlyDisable();
        }
        else {
            for (Tile t : tiles) {
                t.enable();
                t.setActivatedFalse();
            }
        }
        
        tiles.clear();
    }
}
