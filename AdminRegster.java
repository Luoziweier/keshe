package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

/**
 * 管理员注册界面
 * @author 沉睡的芭芭拉
 */
public class AdminRegster extends JFrame{
	AdminRegster () {
		init();
	}
	void init() {
            JFrame frame = new JFrame("注册管理员账号");
            frame.setLayout(null);
            
            JLabel nameStr = new JLabel("用户名:");
            nameStr.setBounds(250, 150, 100, 25);
            frame.add(nameStr);
        
            JLabel idStr = new JLabel("确认用户名");
            idStr.setBounds(250, 200, 100, 25);
            frame.add(idStr);

            JLabel passwordStr = new JLabel("密码:");
            passwordStr.setBounds(250, 250, 100, 25);
            frame.add(passwordStr);  
               
            JLabel confrimStr = new JLabel("确认密码:");
            confrimStr.setBounds(250, 300, 100, 30);
            frame.add(confrimStr);
            
            JTextField userName = new JTextField();
            userName.setBounds(320, 150, 150, 25);
            frame.add(userName);

            JTextField userId = new JTextField();
            userId.setBounds(320, 200, 150, 25);
            frame.add(userId);

            JPasswordField password = new JPasswordField();
            password.setBounds(320, 250, 150, 25);
            frame.add(password);

            JPasswordField confrimPassword = new JPasswordField();
            confrimPassword.setBounds(320, 300, 150, 25);
            frame.add(confrimPassword);
            
            JButton buttonregister = new JButton("注册");
            buttonregister.setBounds(350, 350, 70, 25);
            frame.add(buttonregister);

            ImageIcon icon1=new ImageIcon("C:/Users/JD/Desktop/项目x/img/6.jpg" );
            JLabel label1=new JLabel(icon1);
            label1.setBounds(0,0,icon1.getIconWidth(),icon1.getIconHeight());
            frame.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));
            JPanel j=(JPanel)frame.getContentPane();
            j.setOpaque(false);
            frame.setResizable(false);

            frame.setBounds(400, 100, 800, 450);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        /**
         * 为注册按钮增加监听器
         */
        buttonregister.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = userName.getText();
                    String id = userId.getText();
                    String passwd = new String (password.getPassword());
                    String confrimpasswd = new String (confrimPassword.getPassword());

                    /**
                     * 创建Register类
                     */
                    Register register = new Register();
                    register.setId(id);
                    register.setName(name);
                    register.setPassword(passwd);
                    register.sectionalism(confrimpasswd);
                    /**
                     *如果注册成功，返回登录界面
                     */
                    try {
						if(register.judgeRegister()) {
						    frame.setVisible(false);
						    new LoginRegister();
                        }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            });
	}
}
