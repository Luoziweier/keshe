package com;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.*;

/**
 * @author JD
 */
public class Receive extends Thread {
    Socket socket;
    JTextArea jt1;
    JTextField jt3;
    Receive(Socket socket, JTextArea jt1, JTextField jt3) {
        this.socket = socket;
        this.jt1 = jt1;
        this.jt3 = jt3;
    }
    @Override
    public void run() {
        while(true) {
            try {
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String inform = br.readLine();
                jt1.append(inform + "\n");
                jt1.setLineWrap(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
