package cn.ctmctv.servlet;

import cn.ctmctv.dao.BookDao;
import cn.ctmctv.po.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id =Integer.valueOf(req.getParameter("id"));
        BookDao bookDao = new BookDao();
        Book book = bookDao.findById(id);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/update.jsp").forward(req,resp);
    }

}
