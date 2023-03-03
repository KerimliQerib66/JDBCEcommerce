package org.example;

import Bean.Connectionclass;
import Bean.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
 static  Products p = new Products();
    static Connectionclass cl=new Connectionclass();
    public static void main(String[] args) throws Exception {
//GetAllElements();
//System.out.println(GetbyId(2));
       // AddElement();
        removefield(6);
    System.out.println(GetAllElements());
    }
    public static List GetAllElements()  throws Exception{

        List<Products> list = new ArrayList<>();
        Statement stmt=cl.connection().createStatement();
        stmt.execute("SELECT * from products");
        ResultSet rs=stmt.getResultSet();
        while(rs.next()){
            int id=rs.getInt("ID");
            String name=rs.getString("name");
            int price=rs.getInt("price");
            String description=rs.getString("description");
            list.add(new Products(id,name,description,price));
        }

       return list;
 }
    public static Products GetbyId(int productid) throws Exception {
        Products p1 = null;
        String sql = "SELECT * from products where id = " + productid;
        PreparedStatement stmt = cl.connection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(); // executeQuery kullanıldı
        while (rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            String description = rs.getString("description");
            p1 = new Products(id, name, description, price);
        }
        return p1;
    }
    public static void AddElement()throws Exception{
        p.setID(6);
        p.setName("Soyuducu");
        p.setDescription("keyfiyyetli");
        p.setPrice(4100);
        PreparedStatement stmt=cl.connection().prepareStatement("INSERT INTO Products (ID,name,description,price) values (?,?,?,?)");
        stmt.setInt(1,p.getID());
        stmt.setString(2,p.getName());
        stmt.setString(3,p.getDescription());
        stmt.setInt(4,p.getPrice());
        stmt.executeUpdate();
    }
    public static void removefield(int deletedfield)throws Exception{
        PreparedStatement stmt=cl.connection().prepareStatement("DELETE FROM products WHERE id ="+deletedfield);
        stmt.executeUpdate();
    }
}