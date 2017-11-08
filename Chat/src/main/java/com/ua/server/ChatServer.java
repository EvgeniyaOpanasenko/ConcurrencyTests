package com.ua.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by User on 11/8/2017.
 */
public class ChatServer {


    private static final int DEFAULT_PORT_NUMBER = 5050;

    public static void main(String[] args) throws IOException {
        new ChatServer().go();
    }

    private void go() throws IOException {

        ServerSocket defaultSocket = new ServerSocket(DEFAULT_PORT_NUMBER);

        System.out.println("Listening on port: " + DEFAULT_PORT_NUMBER);
        Socket connectionSocket = defaultSocket.accept();
        BufferedReader fromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

        String msg = "";
        if (!(msg.equals("EXIT"))){
            msg = fromClient.readLine();
            System.out.println("Received: " + msg);
        } else {
            fromClient.close();
            connectionSocket.close();
            defaultSocket.close();
        }



        //msg = fromClient.readLine();




           /* while (true) {
                InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);

                String income = reader.readLine();

                System.out.println("Message: " + income);

                //reader.close();
            }*/

    }
}
