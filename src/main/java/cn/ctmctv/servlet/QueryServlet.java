package cn.ctmctv.servlet;

import cn.ctmctv.dao.BookDao;
import cn.ctmctv.po.Book;
import cn.ctmctv.po.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int perPage = 3;
        int currentPage = 1;
        if(req.getParameter("currentpage")!=null && req.getParameter("currentpage").trim().length()!=0){
            currentPage = Integer.valueOf(req.getParameter("currentpage"));
        }
        BookDao bookDao = new BookDao();
        PageBean<Book> pageBean = bookDao.findAll(currentPage, perPage);
        for(int i=0;i<pageBean.getBeanList().size();i++){
            System.out.println(pageBean.getBeanList().get(i).getName());
        }
        req.setAttribute("pb", pageBean);
        req.getRequestDispatcher("/query.jsp").forward(req, resp);
    }

}
