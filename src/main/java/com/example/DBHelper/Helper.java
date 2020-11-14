package com.example.DBHelper;

import java.sql.*;

public class Helper {
    public String name = "";
    public String lastname = "";
    public boolean checkExistUser(String login, String password) throws ClassNotFoundException, SQLException {
    Connection connection=null;

    Class.forName("org.postgresql.Driver");

    //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lrservlet?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC");
    connection = DriverManager.getConnection("jdbc:postgresql://ec2-54-246-115-40.eu-west-1.compute.amazonaws.com:5432/dup8k9l5i750f?ssl=true&sslmode=require",
            "otedgrtgkygbxq","aacc54e171cda6acbbd51c2ef19ab8ddc4495f66294d8e41d41a96517e635dad");
    Statement stat = connection.createStatement();
    ResultSet rs = stat.executeQuery("select id,_name,_lastname " +
            "from users " +
            "where _id_login = (select id from paswordss where logins='"+login+ "' and passwords='"+password+"');");
        connection.close();
            if(rs.next()){
                name = rs.getString("_name");
                lastname = rs.getString("_lastname");
                return true;
    }
            else
                return false;
    }
    public void insert(String login, String password, String name, String lastname) throws SQLException, ClassNotFoundException {
        Connection connection=null;

        Class.forName("org.postgresql.Driver");

        //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lrservlet?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC");
        connection = DriverManager.getConnection("jdbc:postgresql://ec2-54-246-115-40.eu-west-1.compute.amazonaws.com:5432/dup8k9l5i750f?ssl=true&sslmode=require",
                "otedgrtgkygbxq","aacc54e171cda6acbbd51c2ef19ab8ddc4495f66294d8e41d41a96517e635dad");Statement stat = connection.createStatement();
        Statement statSelectId = connection.createStatement();
        Statement statCreateUser = connection.createStatement();
        stat.executeUpdate("insert into paswordss(logins, passwords) values('"+login+"','"+password+"')");
        ResultSet rs = statSelectId.executeQuery("select id from paswordss where logins='"+login+ "' and passwords='"+password+"';");
        rs.next();
        statCreateUser.executeUpdate("insert into users(_name,_lastname,_id_login)" +
                "values ('"+name+"','"+lastname+"','"+rs.getString("id")+"')");
        connection.close();

    }
}
