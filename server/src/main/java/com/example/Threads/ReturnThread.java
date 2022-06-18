package com.example.Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ReturnThread extends Thread {

    private BufferedReader br;
    private PrintWriter pw;
    private String id = "idx";
    private String pwd = "idxpwd";
    private boolean login = true;

    public ReturnThread(Socket socket) throws IOException {
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void loop() {
        System.out.println("afdsadf");
        String arg;
        try {
            while ((arg = br.readLine()) != null) {
                String[] args = arg.split("\\s");
                System.out.println(arg);
                if (args[0].equals("login") && login) {
                    if (args[1].equals(id)) {
                        if (args[2].equals(pwd)) {
                            login = false;
                            pw.println(0);
                        } else pw.println(1);
                    } else pw.println(2);
                } else if (args[0].equals("finance")) {
                    
                } else {
                    pw.println(arg);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setStop(false);
    }
}
