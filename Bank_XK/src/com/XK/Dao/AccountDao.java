package com.XK.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.XK.Bean.AccountBean;
import com.XK.DBUtil.DBUtil;

public class AccountDao {
	public int openAccount(String username)
    {
        Connection conn = DBUtil.getConn();//这里就是从DBUtil类里面得到连接
        Statement state =null;
        try
        {	
        	AccountBean.accountNum++;
            String sql ="insert into account values("+AccountBean.accountNum+",+'" + username + "',0)";//SQL语句
            state = conn.createStatement();
            
            state.execute(sql);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        finally
        {
            DBUtil.close(state, conn);
        }
        return AccountBean.accountNum;
    }
	
    public double checkBalance(String username)
    {
        Connection conn = DBUtil.getConn();//这里就是从DBUtil类里面得到连接
        Statement state =null;
        ResultSet rs = null;
        double balance = -1;
        try
        {
            String sql = "select balance from account where username = '"+username+"'";//SQL语句,
            state = conn.createStatement();
            System.out.println("haha:"+username);
            rs=state.executeQuery(sql);
            if(rs.next())
            {
                balance = rs.getDouble("balance");
                System.out.println("dao:"+balance);
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
        return balance;
    }
    
    public boolean deposit(String username,double money)
    {
        Connection conn = DBUtil.getConn();//这里就是从DBUtil类里面得到连接
        Statement state =null;
        double balance = checkBalance(username);
        balance += money;
        boolean flag = false;
        try
        {
            String sql = "update account set balance = " + balance + "  where username = '"+username+"'";//SQL语句,
            state = conn.createStatement();
            
            state.executeUpdate(sql);
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
    
    public boolean withdraw(String username,double money)
    {
        Connection conn = DBUtil.getConn();//这里就是从DBUtil类里面得到连接
        Statement state =null;
        double balance = checkBalance(username);
        boolean flag = false;
        if(balance < money){
        	return flag;
        }
        balance -= money;
        try
        {
            String sql = "update account set balance = " + balance + "  where username = '"+username+"'";//SQL语句,
            state = conn.createStatement();
            
            state.executeUpdate(sql);
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
