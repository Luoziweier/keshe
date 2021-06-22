package com;

import java.sql.SQLException;

/**
 * @author 沉睡的芭芭拉
 */
public interface Idao {
    /**
     * 注册，将信息输入数据库
     */
    void register();
    /**
     * 判断
     * @param admin
     * @return 判断
     * @throws SQLException
     */
    boolean login(Admin admin) throws SQLException;

    /**
     * 判断
     * @return 数字
     */
    int judgeAdmin();
}