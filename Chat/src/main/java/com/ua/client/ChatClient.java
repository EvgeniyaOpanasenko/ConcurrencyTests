package com.ua.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by User on 11/8/2017.
 */
public class ChatClient {

    private InputStreamReader streamReader;
    private BufferedReader reader;

    public static void main(String[] args) throws InterruptedException {
        new ChatClient().go();
    }

    private void go() throws InterruptedException {

        try {
            Socket socket = new Socket("192.168.0.106", 5050);

            System.out.println("You are in!");
            System.out.println("Enter your message ");

            Scanner scanner = new Scanner(System.in);
            String out = scanner.next();

            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println(out);
            writer.flush();
            Thread.sleep(1000);
            //writer.close();
            //socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
