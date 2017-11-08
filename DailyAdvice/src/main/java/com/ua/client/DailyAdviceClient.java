package com.ua.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by User on 11/8/2017.
 */
public class DailyAdviceClient {


    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }

    private void go() {
        try {
            Socket clientSocket = new Socket("192.168.0.106", 5050);

            InputStreamReader streamReader =
                    new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String advice = reader.readLine();

            System.out.println("Today you should " + advice);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
