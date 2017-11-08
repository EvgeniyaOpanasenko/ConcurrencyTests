package com.ua.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by User on 11/8/2017.
 */
public class DailyAdviceServer {

    String[] adviceList = {"Take smaller bites",
            "Go for the tight jeans. No they do NOT make you look fat.",
            "One word:inappropriate",
            "Just for today be honest. Tell your boss what you really think",
            "You might want to rethink that haircut."};

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }

    private void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(5050);

            while (true) {

                Socket socket = serverSocket.accept();
                String advice = getAdvice();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                writer.println(advice);
                //writer.close();
                writer.flush();
                System.out.println(advice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }
}
