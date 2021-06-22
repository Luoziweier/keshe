package xyq;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author JD
 */
public class ChatWindow extends JFrame {
    
    private JPanel c1 = new JPanel();
    private JPanel c2 = new JPanel();
    private JPanel c3 = new JPanel();
    private JTextArea jf1 = new JTextArea(10,40);
    private JTextArea jf2 = new JTextArea(50,40);
    private JButton jb1 = new JButton("关闭");
    private ArrayList<ClintConn> ccList = new ArrayList<ClintConn>();
    private Boolean turn = false;
    ServerSocket ss;
    Socket s;

    public ChatWindow() {
        setTitle("服务器");
        setLayout(new BorderLayout());
        setBounds(0, 0, 500, 800);

        add(c1,BorderLayout.NORTH);
        add(c2,BorderLayout.CENTER);
        add(c3,BorderLayout.SOUTH);
        c1.add(jf1);
        c2.add(jf2);
        c3.add(jb1);

        jf1.append("启动服务器");

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ss.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                turn = false;
            }
        });
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go(jf1);
    }
    
    public void go(JTextArea jf1) {
        try {
            turn = true;
            ss = new ServerSocket(6969);
            System.out.println("等待客户端连接");
            jf1.append("等待客户端连接");
            while(turn) {
                s = ss.accept();
                ccList.add(new ClintConn(s));
                System.out.println("客户端"+s.getInetAddress()+"连接");
                jf1.append("客户端"+s.getInetAddress()+"连接");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    class ClintConn {
        Socket s;
        ClintConn(Socket s) {
            this.s = s;
            receive();
        }
        public void receive() {
            Connect cn = new Connect(s,jf2,ccList);
            cn.start();
        }
        public void send(String content) {
            OutputStream os;
            try {
                os = s.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
                bw.write(content);
                bw.newLine();
                bw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }    
    }
}
