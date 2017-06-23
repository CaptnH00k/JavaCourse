package onedgame;

/**
 * Algorithm to check if the 1D-Array Game is winnable with the given arguments.
 * The algorithm will return true in case it is winnable and false otherwise.
 */
public class Main {
	public static boolean DEBUG = false; // set to true if you want to enable printPosition()
	
    public static void main(String[] args) {
        boolean[] game = {false, false, false, false};
        System.out.println(isWinnable(1, game));
    }

    public static boolean isWinnable(int m, boolean[] game) {
    	// Validate arguments
        if (game.length  == 0) {
            throw new IllegalArgumentException(" int m > 0, game.length > 0");
        }
        if (m <= 0) {
            throw new IllegalArgumentException("False input. Expected: int m > 0, game.length > 0");        	
        }
        if(game[0] == true) {
            throw new IllegalArgumentException("First element has to be false");
        }

        // Init Variables
        int pos = 0; // current position of our "player"
        SizedStack<Integer> last_pos = new SizedStack<Integer>(3); // holds last 3 positions
        int length_game = game.length;
        int[] possible_steps = {m, 1, -1}; // all possibilities for moving (minus jumping back which is an extra case) 


        int new_pos;
        int possible_new_pos;
        while(true) {
            printPosition(game, pos); // print position for debug reasons
            new_pos = -1;

            // with this for loop we try all moving possibilities
            for(int steps : possible_steps) {
                possible_new_pos = pos + steps;

                if (possible_new_pos <= 0) {
                    // we can't go behind 0
                	continue;
                } else if (possible_new_pos >= length_game - 1) {
                	// we reached the gaol!
                    printPosition(game, length_game - 1);
                    return true;
                } else if (game[possible_new_pos] == false &&
                           last_pos.contains(possible_new_pos) == false) {
                	// we found a way to walk, so go this one and don't try
                	// any other possibility
                    new_pos = pos + steps;
                    break;
                }
            }
            
            // If we didn't found a new position (possibility),
            // we can maybe jump back, if we already were on that
            // position. The reason for this is, that we maybe went
            // a bad way, with this we can revert that and will very
            // likely try another approach, because the already did
            // movements are saved in last_pos and we won't redo any
            // movement which results in a position in which we already
            // were.
            if (new_pos == -1 &&
            	pos - m >= 1 &&
            	game[pos - m] == false &&
            	last_pos.contains(pos -m) == true) {
                    new_pos = pos - m;
            }
            
            if(new_pos != -1) {
            	// We found a new pos, so save current pos
            	// to last pos and update current pos
                last_pos.push(pos);
                pos = new_pos;
            } else {
            	// we didn't find a new pos, so this game
            	// seems not to be winnable
                return false;
            }
        }
    }

    /**
     * Simple helper function which tries to visualize the game map
     * and the current position of the player.
     * [#] => position of player
     * [ ] => Field on which player can move
     * [X] => Field on which player can NOT move
     * @param game
     * @param pos
     */
    public static void printPosition(boolean[] game, int pos) {
    	if(DEBUG == false) return; // only do this if we're in debug mode
        String toPrint = "";
        int i = 0;
        for (boolean b : game) {
            if(i == pos) {
                toPrint += "[#]";
            } else if(b == false) {
                toPrint += "[ ]";
            } else if(b == true) {
                toPrint += "[X]";
            }
            i++;
        }

        System.out.println(toPrint);
    }

}
