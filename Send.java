package com;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author 沉睡的芭芭拉
 */
public class Send{
    Socket socket;
    String s;
    JTextField jt3;
    Send(Socket socket, String s, JTextField jt3) {
        this.s = s;
        this.socket = socket;
        this.jt3 = jt3;
    }
    public void send(String s) {
        try {
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write(jt3.getText() + "：" + s);
            bw.newLine();
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
