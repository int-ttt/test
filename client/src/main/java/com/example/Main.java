package com.example;

import com.example.Threads.AbstractThread;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    private static boolean stop = true;

    public static AbstractThread thread1;
    public static AbstractThread thread2;

    public static void main(String[] args) throws IOException {
//        Socket socket = null;
        Scanner cscn = new Scanner(System.in);
//        while (stop) {
//            System.out.print("Ip address: ");
//            try {
//                socket = new Socket(cscn.next(), 56077);
//                System.out.println("login please");
//                stop = false;
//            } catch (IOException e) {
//                System.out.println("ip is not appends");
//            }
//        }
//        thread1 = new InputThread(socket, cscn);
//        thread2 = new BoundThread(socket);
//        thread2.start();
        while (true) {
            String arg;
            System.out.print("> ");
            try {
                arg = YahooFinance.get(cscn.next()).getQuote().getPrice().toString();
            } catch (Exception e) {
                arg = null;
            }
            System.out.println(arg);
        }
    }
}