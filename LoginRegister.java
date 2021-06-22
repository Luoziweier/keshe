package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author 山酒
 */
public class LoginRegister {
    LoginRegister() {
		init();
	}

    /**
     * 登录界面初始化
     */
	public void init() {
	JFrame frame = new JFrame("登录");
        frame.setLayout(null);

        JLabel nameStr = new JLabel("用户名:");
        nameStr.setBounds(250, 200, 100, 25);
        frame.add(nameStr);
        
        JLabel passwordStr = new JLabel("密码:");
        passwordStr.setBounds(250, 250, 100, 25);
        frame.add(passwordStr);  
        
        JTextField userId = new JTextField();
        userId.setBounds(300, 200, 150, 25);
        frame.add(userId);
        
        JPasswordField password = new JPasswordField();
        password.setBounds(300, 250, 150, 25);
        frame.add(password);
        
        JButton buttonlogin = new JButton("登录");
        buttonlogin.setBounds(275, 300, 70, 25);
        frame.add(buttonlogin);
        
        JButton buttonregister = new JButton("注册");
        buttonregister.setBounds(375, 300, 70, 25);
        frame.add(buttonregister);  
        
        frame.setBounds(400, 100, 800, 523);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        ImageIcon icon1=new ImageIcon("C:/Users/JD/Desktop/项目x/img/4.jpeg" );
        JLabel label1=new JLabel(icon1);
        label1.setBounds(0,0,icon1.getIconWidth(),icon1.getIconHeight());
        frame.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel)frame.getContentPane();
        j.setOpaque(false);
        /**
         * 为登录按钮添加监听器
         */
        buttonlogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String id = userId.getText();
                String passwd = new String (password.getPassword());

                /**
                 * 创建一个用户，把输入框中的用户名密码和提出来
                 */
                Admin admin = new Admin();
                admin.setId(id);
                admin.setPassword(passwd);
                String user = userId.getText();
                /**
                 * 存储用户名
                 */

                /**
                 * 登录
                 */
                Login login = new Login(null,null,null);
                login.setAdmin(admin);
          
                if(login.judgeAdmin()==0) {
                    /**
                     * 弹出账号或密码错误的窗口
                     */
                	JOptionPane.showMessageDialog(null, "账号或密码错误", "账号或密码错误", JOptionPane.WARNING_MESSAGE);
                    /**
                     * 清除密码框中的信息
                     */
                	password.setText("");
                    /**
                     * 清除账号框中的信息
                     */
                	userId.setText("");

                } else {
                    /**
                     * 弹出登录成功的窗口
                     */
                	JOptionPane.showMessageDialog(null, "登陆成功", "登陆成功", JOptionPane.NO_OPTION);
                    /**
                     * 点击确定后会跳转到主窗口
                     */
                	frame.setVisible(false);
                    ClientWindow cn = new ClientWindow(user);
                    cn.clWindow();
                }
               
            }
        });

        /**
         * 为注册按钮添加监听器
         */
        buttonregister.addActionListener(new ActionListener() {
        	 @Override
             public void actionPerformed(ActionEvent e) {
                 /**
                  * 注册页面
                  */
                 frame.setVisible(false);
        		 new AdminRegster(); 
        	 }
         });
	}
	
    public static void main(String []args) {
        /**
         * 主程序
         * 登录窗口
         */
    	new LoginRegister();
    }
}
