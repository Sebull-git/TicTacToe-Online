package tiktaktoe;


import socketio.Socket;

import java.io.IOException;

public class Connections {
    Socket socket;
    public Connections() throws IOException {
        this.socket=new Socket("localhost",5000);
        if(socket.connect()){
            socket.write("Client connected");
        }

    }
    public void sendBoard(GameModel.Mark[][] board) throws IOException {
        socket.write(BoardToString(board));
    }

    public GameModel.Mark[][] getBoard() throws IOException {
        return fromString(socket.readLine());

    }
    public GameModel.Mark[][] fromString(String s){
        GameModel.Mark[][] board = new GameModel.Mark[3][3];
        String[] rows = s.split("\\|");
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = toMark(rows[i].split("/")[j]);
            }
        }
        return board;
    }
    public GameModel.Mark toMark(String s){
        switch (s){
            case "E": return GameModel.Mark.E;
            case "0": return GameModel.Mark.O;
            case "X": return GameModel.Mark.X;
            default:return null;
        }
    }
    public String BoardToString(GameModel.Mark[][] board){
        String string = "";
        for (GameModel.Mark[] marklist : board) {
            for (GameModel.Mark marker : marklist) {
                String temp = marker.toString();
                string=string+temp+"/";
            }
            string = string + "|";
        }
        return string;
    }

}
