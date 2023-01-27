package tiktaktoe;

import java.io.IOException;

public class GameController {
    GameModel gm = new GameModel();
    GameView gv = new GameView();

    public void executeGame() throws IOException {

        gv.displayMessage();
        gm.setupBoard();
        gv.displayBoard(gm.board2);
        for (int i = 0; i < 9; i++) {
            if (i == 0 || i == 2 || i == 4 || i == 6 || i == 8) {
                gm.enterMove(GameModel.Mark.X);
                gm.validateAndMove(gm.koordinaten[0], gm.koordinaten[1], GameModel.Mark.X);
                //gm.checkGameState(GameModel.Mark.X);
                gv.displayGameState(gm.checkGameState(GameModel.Mark.X));
                gv.displayBoard(gm.board2);
                if (gm.checkGameState(GameModel.Mark.X) != -1){
                    break;
                }
            } else {
                gm.enterMove(GameModel.Mark.O);
                gm.validateAndMove(gm.koordinaten[0], gm.koordinaten[1], GameModel.Mark.O);
                //gm.checkGameState(GameModel.Mark.O);
                gv.displayGameState(gm.checkGameState(GameModel.Mark.O));
                gv.displayBoard(gm.board2);
                if (gm.checkGameState(GameModel.Mark.O) != -1){
                    break;
                }
            }


        }
    }
}

