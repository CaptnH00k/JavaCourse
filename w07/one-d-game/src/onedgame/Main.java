package onedgame;

/**
 * Algorithm to check if the 1D-Array Game is winnable with the given arguments.
 * The algorithm will return true in case it is winnable and false otherwise.
 */
public class Main {
    public static void main(String[] args) {
        boolean[] game = {false, false, false, false};
        System.out.println(isWinnable(1, game));
    }

    public static boolean isWinnable(int m, boolean[] game) {
        if (game.length  == 0 || m <= 0) {
            throw new IllegalArgumentException("False input. Expected: int m > 0, game.length > 0");
        }
        if(game[0] == true) {
            throw new IllegalArgumentException("First element has to be false");
        }

        int pos = 0;
        SizedStack<Integer> last_pos = new SizedStack<Integer>(3);
        int length_game = game.length;
        int[] possible_steps = {m, 1, -1};


        int new_pos;
        int possible_new_pos;
        while(true) {
            printPosition(game, pos);
            new_pos = -1;

            for(int steps : possible_steps) {
                possible_new_pos = pos + steps;

                // we can't go behind 0
                if (possible_new_pos <= 0) {
                } else if (possible_new_pos >= length_game - 1) {
                    printPosition(game, length_game - 1);
                    return true;
                } else if (game[possible_new_pos] == false &&
                        last_pos.contains(possible_new_pos) == false) {
                    new_pos = pos + steps;
                    break;
                } else if (pos - m >= 1 &&
                        game[pos - m] == false &&
                        last_pos.contains(possible_new_pos) == true) {
                    new_pos = pos - m;
                    break;
                }
            }
            if(new_pos != -1) {
                last_pos.push(pos);
                pos = new_pos;
            } else {
                return false;
            }
        }
    }

    public static void printPosition(boolean[] game, int pos) {
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
