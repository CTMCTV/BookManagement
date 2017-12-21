package cn.ctmctv.servlet;

import cn.ctmctv.dao.BaseDao;
import cn.ctmctv.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id =Integer.parseInt(req.getParameter("id"));
        BookDao bookDao = new BookDao();
        bookDao.deleteById(id);
        req.getRequestDispatcher("/getList.do").forward(req,resp);
    }
}
