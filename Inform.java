package com;

import javax.swing.*;

/**
 * @author 沉睡的芭芭拉
 */
public class Inform {
    String user;
    JTextField jt0;
    Inform(String user, JTextField jt0) {
        if(user != null) {
            this.user = user;
        }
        System.out.println(user);
        this.jt0 = jt0;
    }
    public void  getUsername() {
        jt0.setText(user);
        System.out.println(user);
    }
}
