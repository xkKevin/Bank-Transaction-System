package com.XK.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.XK.DBUtil.DBUtil;

//import db.DBUtil;

public class UserDao {
    public boolean login(String username,String password)
    {
        Connection conn = DBUtil.getConn();//这里就是从DBUtil类里面得到连接
        Statement state =null;
        ResultSet rs = null;
        boolean flag=false;
        try
        {
            String sql = "select * from user where username = '"+username+"'";//SQL语句,
            state = conn.createStatement();
            
            rs=state.executeQuery(sql);
            if(rs.next())
            {
                if(rs.getString("password").equals(password))
                {
                    flag=true;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        finally
        {
            DBUtil.close(rs, state, conn);
        }
        return flag;
    }
    
    public boolean register(String username,String password)
    {
        Connection conn = DBUtil.getConn();//这里就是从DBUtil类里面得到连接
        Statement state =null;
        boolean flag=false;
        try
        {
            String sql = "insert into user values('" + username + "','"+password+"')";//SQL语句,
            state = conn.createStatement();
            state.execute(sql);
            flag = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        finally
        {
            DBUtil.close(state, conn);
        }
        return flag;
    }
    

}