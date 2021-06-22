package xyq;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextArea;

/**
 * @author JD
 */
public class Connect extends Thread {
    JTextArea jf2;
    Socket s;
    ServerSocket ss;
    ArrayList<ChatWindow.ClintConn> ccList;
    public Connect(Socket s, JTextArea jf2, ArrayList<ChatWindow.ClintConn> ccList) {
        this.jf2 = jf2;
        this.s = s;
        this.ccList = ccList;
    }
    @Override
    public void run() {
        try {
            while(true) {
                InputStream is = s.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String content = br.readLine();
                jf2.append(content + "\n");
                System.out.println(content);

                Iterator<ChatWindow.ClintConn> iterator = ccList.iterator();
                while (iterator.hasNext()) {
                    ChatWindow.ClintConn clientCoon = iterator.next();
                    clientCoon.send(content);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
