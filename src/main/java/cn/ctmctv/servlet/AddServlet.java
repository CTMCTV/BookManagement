package cn.ctmctv.servlet;

import cn.ctmctv.dao.BookDao;
import cn.ctmctv.po.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name =  req.getParameter("name");
        String author =  req.getParameter("author");
        String bcn =  req.getParameter("bcn");
        String price = req.getParameter("price");
        String description = req.getParameter("description");
        System.out.println(name);
        Book book = new Book(name,author,price,description, bcn, 0);
        System.out.println(book);
        int flag = new BookDao().add(book);
        String msg = "";
        if(flag> 0) {
            msg = "恭喜，图书插入成功。";
        }else{
            msg = "图书插入失败。";
        }
        req.setAttribute("msg",msg);
        req.getRequestDispatcher("/msg.jsp").forward(req,resp);



    }


}
