package com.astonhack.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by misha on 07/11/15.
 *
 * Opens server up for connections
 */
public class Server {
    private ServerSocket serverSocket;

    public Server() {
        setupSocket();
        listen();
    }

    private void listen() {
        try {
            System.out.println("Listening...");
            Socket connection = serverSocket.accept();

            System.out.printf("Creating in/out streams");
            PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            System.out.printf("Writing to out...");
            out.write("Tricksy rowan");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupSocket() {
        try {
            serverSocket = new ServerSocket(3000);

            System.out.println("Setup the socket");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
