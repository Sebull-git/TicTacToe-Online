package tiktaktoe;

import java.io.IOException;

public class GameView {


    public void displayBoard( GameModel.Mark[][] feld) throws IOException {
        System.out.println(feld[0][0] + " | " + feld[0][1] + " | " + feld[0][2]);
        System.out.println("----------");
        System.out.println(feld[1][0] + " | " + feld[1][1] + " | " + feld[1][2]);
        System.out.println("----------");
        System.out.println(feld[2][0] + " | " + feld[2][1] + " | " + feld[2][2]);

        Connections connections = new Connections();
        String derString = connections.BoardToString(feld);
        displayBoard(connections.fromString(derString));
        System.out.println(derString);
    }
    public void displayGameState(int cgs) {
        //System.out.println(cgs);
        switch (cgs){
            case 0:
                System.out.println("Spieler X hat gewonnen!");
                break;
            case 1:
                System.out.println("Spieler O hat gewonnen!");
                break;
            case 2:
                System.out.println("Unendschieden!");
                break;
        }

    }
        public void displayMessage () {
            System.out.println("Willkommen bei TicTacToe! \n" +
                    "Zellen werden mit der Angabe von \n" +
                    "Zeilen- und Spaltenkoor- dinaten markiert.\n" +
                    " {0, 0} markiert die Zellen in\n" +
                    " der oberen linken Ecke.");
        }
}

