package com.test.util;

import java.sql.*;

public class JDBCUtil {
    private static final String URL="jdbc:mysql://127.0.0.1:3306/game?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    private static final String USER="root";//mysql用户名（默认root）
    private static final  String PASS="123456";//mysql密码
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASS);
    }

    public void close(PreparedStatement ps,Connection con){
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void close(ResultSet rs,PreparedStatement ps, Connection con){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(ps,con);
    }
}
