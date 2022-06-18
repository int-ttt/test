package com.example.Threads;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class InputThread extends AbstractThread {

    private Scanner scn;
    private PrintWriter pw;

    public InputThread(Socket socket, Scanner scn) throws IOException {
        this.scn = scn;
        this.pw = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void loop() {
        String arg;
        while (BoundThread.stop) {
            arg = scn.nextLine();
            String[] args = arg.split("\\s");
            if (args[0].equals("stop")) {
                BoundThread.stop = false;
                this.stop();
            } else pw.println(arg);
        }
        InputThread.setStop(false);
    }
}
