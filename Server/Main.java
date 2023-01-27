package tiktaktoe.Server;

import socketio.ServerSocket;
import socketio.Socket;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
     ArrayList<Socket> clients=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Main main=new Main();
        main.runServer();
    }


    public void runServer() throws IOException {
        ServerSocket ss=new ServerSocket(5000);
        while(true){
            Socket socket=ss.accept();
            clients.add(socket);
            if(clients.size() == 2){
                break;
            }
        }
        //Beide Sockets in clients gespeichert
        // Erstem Client schreiben Start
        clients.get(0).write("START\n");
        clients.get(0).write("Your Name X\n");

        // Socket lesen nach Board

        //To-Do: schleife außenrum, Denkfehler drinne??
        String board = clients.get(0).readLine();
        clients.get(1).write(board+"\n");

        String board1 = clients.get(1).readLine();
        clients.get(0).write(board1+"\n");


    }

    public void sendMessage(String message,Socket sender) throws IOException {
        for (int i = 0; i < clients.size(); i++) {
            if (!sender.equals(clients.get(i))) {
                sender.write(message + "\n");
            }
        }
    }
 }

