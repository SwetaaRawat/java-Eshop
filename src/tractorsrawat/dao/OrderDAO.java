/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tractorsrawat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import tractorsrawat.dbutil.DBConnection;
import tractorsrawat.pojo.ProductsPojo;
import tractorsrawat.pojo.UserProfile;

/**
 *
 * @author Shweta
 */
public class OrderDAO {
     public static String getNextOrderId()throws SQLException{
      Connection conn = DBConnection.getConnection();
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("Select max(order_id) from orders");
      rs.next();
      String ordId = rs.getString(1);
      if(ordId==null)
          return "o-101";
      int ordno = Integer.parseInt(ordId.substring(2));
      ordno++;
      return "O-"+ ordno;
}
     public static boolean addOrder(ArrayList<ProductsPojo> al,String ordId)throws SQLException{
          Connection conn = DBConnection.getConnection();
          PreparedStatement ps = conn.prepareStatement("Insert into orders values(?,?,?,?)");
          int count=0;
          for(ProductsPojo p:al)
          {
              ps.setString(1, ordId);
              ps.setString(2, p.getProductId());
              ps.setInt(3, p.getQuantity());
              ps.setString(4, UserProfile.getUserid());
              count=count+ps.executeUpdate();
          }
          return count==al.size();
          
     }
     

}
