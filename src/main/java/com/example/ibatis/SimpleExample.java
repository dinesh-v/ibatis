package com.example.ibatis;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

/**
 * This is not a best practices class.  It's just an example
 * to give you an idea of how iBATIS works.  For a more complete
 * example, see JPetStore 5.0 at http://www.ibatis.com.
 */
public class SimpleExample {

  /**
   * SqlMapClient instances are thread safe, so you only need one.
   * In this case, we'll use a static singleton.  So sue me.  ;-)
   */
  private static SqlMapClient sqlMapper;

  /**
   * It's not a good idea to put code that can fail in a class initializer,
   * but for sake of argument, here's how you configure an SQL Map.
   */
  static {
    try {
      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close(); 
    } catch (IOException e) {
      // Fail fast.
      throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
    }
  }

  public static List selectAllEmployees () throws SQLException {
    return sqlMapper.queryForList("selectAllEmployees");
  }

  public static Employee selectEmployeeById  (int id) throws SQLException {
    return (Employee) sqlMapper.queryForObject("selectEmployeeById", id);
  }

  public static void insertEmployee (Employee Employee) throws SQLException {
    sqlMapper.insert("insertEmployee", Employee);
  }

  public static void updateEmployee (Employee Employee) throws SQLException {
    sqlMapper.update("updateEmployee", Employee);
  }

  public static void deleteEmployee (int id) throws SQLException {
    sqlMapper.delete("deleteEmployee", id);
  }

}
