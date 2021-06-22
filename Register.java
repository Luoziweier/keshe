package com;

import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * @author 沉睡的芭芭拉
 */
public class Register {
    String name;
    String id;
    String password;
    String conformists;
    
    void setName(String name) {
        this.name = name;
    }
    void setId(String id) {
        this.id = id;
    }
    void setPassword(String password) {
        this.password = password;
    }
    void sectionalism(String confirmable) {
        this.conformists = confirmable;
    }


    /**
     * 判断注册的账号是否符合规则
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    boolean judgeRegister() throws SQLException, ClassNotFoundException {
        
        if(this.name.equals(null)) {
            JOptionPane.showMessageDialog(null, "用户名不能为空！", "用户名", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.id.equals(null)) {
            JOptionPane.showMessageDialog(null, "账号不能为空！", "账号为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.password.equals(null)) {
            JOptionPane.showMessageDialog(null, "密码不能为空！", "密码为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(!this.password.equals(this.conformists)) {
            JOptionPane.showMessageDialog(null, "两次输入的密码不一致!", "密码不一致", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!this.id.equals(this.name)) {
            JOptionPane.showMessageDialog(null, "两次输入的用户名不一致!", "密码不一致", JOptionPane.ERROR_MESSAGE);
            return  false;
        }

        /**
         * 符合规则，弹出注册成功的窗口，并将账号添加数据库
         */
        JOptionPane.showMessageDialog(null, "注册成功");
        Login re = new Login(this.id,this.name,this.password);
        re.register();
        return true;
    }
}



