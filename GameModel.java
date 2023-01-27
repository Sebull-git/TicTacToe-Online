package tiktaktoe;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

import static tiktaktoe.GameModel.Mark.*;

public class GameModel {

    int DIMENTION = 3;

    public enum Mark  {X, O, E}

    public Mark[][] board2 = new Mark[DIMENTION][DIMENTION];
    int [] koordinaten = new int[2];

    int a = 0;
    void setupBoard() throws IOException {
        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2.length; j++) {
                board2[i][j] = E;
            }
        }
        Connections connections = new Connections();
        String derString = connections.BoardToString(board2);
        System.out.println(derString);




    }

    private boolean isGameover() {
        if ((board2[0][0] == board2[0][1] && board2[0][1] == board2[0][2] && board2[0][0] != E) ||
                (board2[1][0] == board2[1][1] && board2[1][1] == board2[1][2] && board2[1][0] != E) ||
                (board2[2][0] == board2[2][1] && board2[2][1] == board2[2][2] && board2[2][0] != E) ||
                (board2[0][0] == board2[1][0] && board2[1][0] == board2[2][0] && board2[0][0] != E) ||
                (board2[0][1] == board2[1][1] && board2[1][1] == board2[2][1] && board2[0][1] != E) ||
                (board2[0][2] == board2[1][2] && board2[1][2] == board2[2][2] && board2[0][2] != E) ||
                (board2[0][0] == board2[1][1] && board2[1][1] == board2[2][2] && board2[0][0] != E) ||
                (board2[0][2] == board2[1][1] && board2[1][1] == board2[2][0] && board2[0][2] != E)) {
            return true;
        } else return false;

    }

    public boolean validateAndMove( int zeile, int spalte, Mark spieler) {
        if (board2[zeile][spalte] == Mark.E) {
            board2[zeile][spalte] = spieler;
        }
        else {
              System.out.println("Dieses Feld ist bereits belegt!");
              enterMove(spieler);
        }
        return true;
    }


    public int checkGameState(Mark spieler) {
        int cgs = 3;
        a++;
        //System.out.println("a:"+ a);
        if (isGameover() == true) {
            switch (spieler) {
                case X: cgs = 0;
                break;
                case O: cgs = 1;
                break;
            }
        }else if (isGameover() == false && a > 16){
                cgs = 2;
        }else cgs = -1;

        return cgs;
    }

   public int[] enterMove(Mark spieler) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Wähle Dein nächstes Feld, Spieler " + spieler);
       System.out.print("Zeile > ");
       koordinaten [0] = sc.nextInt();
       while ((koordinaten [0] != 1) && (koordinaten [0] != 2) && (koordinaten [0] != 0)) {
           System.out.println("Falsche Eingabe!");
           System.out.print("Zeile > ");
           koordinaten [0] = sc.nextInt(); //Zeile
       }
       System.out.print("Spalte > ");
       koordinaten [1] = sc.nextInt();
       while ((koordinaten [1] != 1) && (koordinaten [1] != 2) && (koordinaten [1] != 0)) {
           System.out.println("Falsche Eingabe!");
           System.out.print("Spalte > ");
           koordinaten [1] = sc.nextInt(); //Spalte
       }

    return koordinaten;
   }


}
