package com.test.dao;

import com.test.bean.Conn;
import com.test.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConDao {
    public int insertCon(Conn conn){
        //执行insert sql
        //链接mysql
        try {
            Connection connection = JDBCUtil.getCon();
            PreparedStatement ps = connection.prepareStatement("insert into tab_con(title,content) value (?,?)");
            ps.setString(1,conn.getTitle());
            ps.setString(2,conn.getContent());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Conn> queryList(int page,String searchText){
        List<Conn> list = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getCon();
            PreparedStatement ps = connection.prepareStatement("select * from tab_con where title like ?  limit ?,2");
            ps.setString(1,"%" + searchText  + "%");
            ps.setInt(2,page);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                list.add(new Conn(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getDate("create_time")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
