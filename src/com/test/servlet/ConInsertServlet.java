package com.test.servlet;

import com.test.bean.Conn;
import com.test.dao.ConDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/coninsert")
public class ConInsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端的输入内容
        Conn conn = new Conn(req.getParameter("title"),req.getParameter("content"));
        //将输入的内容放入数据库中
        ConDao conDao = new ConDao();
        int insertRsult = conDao.insertCon(conn);
        //返回给用户，插入成功|失败
        if(insertRsult == 0){
            req.setAttribute("err","无法插入，请联系程序猿！");
            //转发
            req.getRequestDispatcher("coninsert.jsp").forward(req,resp);
        }else{
            //重定向
            resp.sendRedirect("conlist");
        }
    }
}
