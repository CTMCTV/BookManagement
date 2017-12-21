package cn.ctmctv.dao;

import cn.ctmctv.po.Book;
import cn.ctmctv.po.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDao {

    QueryRunner qr = new QueryRunner(BaseDao.getSource());

    public int add(Book book)  {



        String sql = "insert into book values(?,?,?,?,?,?,?)";
        Object[] params = {0, book.getName(), book.getPrice(), book.getAuthor(), book.getDescription(), book.getDelete(), book.getBcn()};
        try {
            qr.update(sql, params);

        } catch (SQLException e) {
            e.printStackTrace();
            return  -1;
        }
        return 1;

    }

    public PageBean findAll(int currentPage, int perPage) {
        try {


        PageBean pageBean = new PageBean();
        pageBean.setPerPage(perPage);
        pageBean.setCurrentPage(currentPage);

        String sql = "select count(*) from book";
        Number number = (Number) qr.query(sql, new ScalarHandler());
        int totalRecords = number.intValue();
        System.out.println(totalRecords);
        pageBean.setTotalRecords(totalRecords);

        sql = "select * from book order by id limit ?,?";
        Object[] params = {(currentPage-1)*perPage, perPage};
        List<Book> beanList =  qr.query(sql, new BeanListHandler<Book>(Book.class), params);

        pageBean.setBeanList(beanList);
        return pageBean;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public int deleteById(int id){
        try {
            String sql = "delete from book where id = ?";
            Object[] params = {id};
            qr.update(sql, params);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }


        return 1;
    }

    public int update(int id, Book book){
        try {
            String sql = "update book set name=?,author=?,price=?,description=?,bcn=? where id = ?";
            Object[] params = {book.getName(), book.getAuthor(), book.getPrice(), book.getDescription(), book.getBcn(), id};
            qr.update(sql, params);
            return 1;
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }

    }

    public Book findById(int id){
        Book book= null;
        try {
            String sql = "select * from book where id=?";
            Object[] params = {id};
            book = qr.query(sql, new BeanHandler<Book>(Book.class), params);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return book;
    }


    public static void main(String[] args) {
        new BookDao().findAll(1,10);
    }





}
