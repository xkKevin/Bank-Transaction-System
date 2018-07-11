package com.XK.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.XK.Dao.AccountDao;

public class AccountServlet extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
        req.setCharacterEncoding("utf-8");//设置字符集，避免乱码
        //获取jsp界面需要进行的操作，
        String method = req.getParameter("method");
        String username = req.getParameter("username");
        String info = req.getParameter("info");
        double money = 0;
        if(info!=null&&!info.equals("")){
        	try {
        		money = Double.parseDouble(info);
        	}catch(Exception e){
        		req.setAttribute("bank_info", "请输入正确的金额！");
        		req.getRequestDispatcher("Navigation.jsp").forward(req, resp);
        		return;
        	}
        }
        System.out.println("money: "+money);
        //String username = (String)req.getAttribute("username");
        //login(req,resp);
        AccountDao accountdao = new AccountDao();
        if(method.equals("openAccount"))//转到login函数
        {
        	accountdao.openAccount(username);
        }else if(method.equals("checkBalance")){
        	double balance = accountdao.checkBalance(username);  
        	System.out.println(balance);
        	req.setAttribute("balance",username+"的用户余额为" + balance);
        	req.getRequestDispatcher("Navigation.jsp").forward(req, resp);
        }else if(method.equals("deposit")){
        	if(money>0 && accountdao.deposit(username, money)){
        		req.setAttribute("bank_info", "存款成功！");
        	}else{
        		req.setAttribute("bank_info", "存款失败！");
        	}
        	req.getRequestDispatcher("Navigation.jsp").forward(req, resp);
        }else if(method.equals("withdraw")){
        	if(money>0 && accountdao.withdraw(username, money)){
        		req.setAttribute("bank_info", "取款成功！");
        	}else{
        		req.setAttribute("bank_info", "取款失败！");
        	}
        	req.getRequestDispatcher("Navigation.jsp").forward(req, resp);
        }
        //req.getRequestDispatcher("Navigation.jsp").forward(req, resp);
    }
}
