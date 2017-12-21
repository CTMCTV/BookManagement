package cn.ctmctv.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.*;

public class BaseDao {

    private static DataSource ds;

    static {
        ds = new ComboPooledDataSource(); //缺省配置，默认使用配置文件中的default-config
    }

    public static DataSource getSource(){
        return ds;
    }

    //获取与某个数据库的连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    // 释放数据库资源
    public static void release(ResultSet resultSet, Statement statement, Connection connection){
        try {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            if (statement != null) {
                statement.close();
                statement = null;
            }
            if(connection != null){
                connection.close();
                connection = null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



    }


