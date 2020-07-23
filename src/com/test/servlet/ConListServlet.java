package com.test.servlet;

import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.xdevapi.JsonArray;
import com.test.bean.Conn;
import com.test.dao.ConDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/conlist")
public class ConListServlet extends HttpServlet {
    //跳转页面
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConDao conDao = new ConDao();
        List<Conn> conList = conDao.queryList(0,"");
        req.setAttribute("list",conList);
        req.getRequestDispatcher("conlist.jsp").forward(req,resp);
    }

    //获取对象
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConDao conDao = new ConDao();
        System.out.println(req.getParameter("aa"));
        List<Conn> conList = conDao.queryList(Integer.valueOf(req.getParameter("pageIndex")),req.getParameter("searchText"));
        PrintWriter out = resp.getWriter();
        out.print(JSONArray.toJSONString(conList));
    }
}
