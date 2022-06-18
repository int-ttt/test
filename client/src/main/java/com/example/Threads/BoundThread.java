package com.example.Threads;

import com.example.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class BoundThread extends AbstractThread {

    private final BufferedReader br;
    private boolean login = true;
    public static boolean stop = true;

    public BoundThread(Socket socket) throws IOException {
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }



    @Override
    public void loop() {
        Main.thread1.start();
        try {
            while (login) {
                System.out.print("\rlogin: ");
                String arg = br.readLine();
                System.out.println(arg);
                switch (arg) {
                    case "0":
                        login = false;
                        break;
                    case "1":
                        System.out.println();
                        break;
                    case "2":

                        break;
                }
            }
            while (stop) {
                System.out.print("input: ");
                String arg = br.readLine();
                System.out.println(arg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
