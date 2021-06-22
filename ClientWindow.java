package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

/**
 * @author 沉睡的芭芭拉
 */
public class ClientWindow extends JFrame {
    JPanel jp0 = new JPanel();
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JTextField jt0 = new JTextField(20);
    JTextArea jt1 = new JTextArea(48,45);
    JTextField jt2 = new JTextField(38);
    JTextField jt3 = new JTextField(7);
    JButton jb1 = new JButton("发送");
    Socket socket;
    String userName;

    ClientWindow(String userName) {

        this.userName = userName;
    }

    public void clWindow() {
        setTitle("客户端");
        setLayout(new BorderLayout());
        setBounds(500, 0, 500, 746);
        setResizable(false);
        jt1.setEditable(false);
        jt0.setEditable(false);
        jt3.setEditable(false);

        add(jp0,BorderLayout.NORTH);
        add(jp1,BorderLayout.CENTER);
        add(jp2,BorderLayout.SOUTH);
        jp0.add(jt3);
        jp0.add(jt0);
        jp1.add(jt1);
        jp2.add(jt2);
        jp2.add(jb1);

        ImageIcon icon1=new ImageIcon("C:/Users/JD/Desktop/项目x/img/2.jpg" );
        JLabel label1=new JLabel(icon1);
        label1.setBounds(0,0,icon1.getIconWidth(),icon1.getIconHeight());
        getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel)this.getContentPane();
        j.setOpaque(false);
        jp2.setOpaque(false);
        jp0.setOpaque(false);
        jp1.setOpaque(false);
        jt3.setOpaque(false);
        jt0.setOpaque(false);
        jt2.setOpaque(false);
        jt1.setOpaque(false);

        try {
            jt0.setText("服务器连接失败");
            socket = new Socket("localhost", 6969);
            jt0.setText("服务器连接成功");
            jt3.setText(userName);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        jt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inform = jt2.getText();
                Send cn = new Send(socket,inform,jt3);
                cn.send(inform);
                jt2.setText("");
            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((jt2.getText() != null)) {
                    Send sn = new Send(socket,jt2.getText(),jt3);
                    sn.send(jt2.getText());
                    jt2.setText("");
                }
            }
        });
        Receive re = new Receive(socket,jt1,jt3);
        re.start();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
