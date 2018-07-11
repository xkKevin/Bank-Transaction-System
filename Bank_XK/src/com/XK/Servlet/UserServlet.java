package com.XK.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.XK.Dao.AccountDao;
import com.XK.Dao.UserDao;


@SuppressWarnings("serial")
public class UserServlet extends HttpServlet
{
    //当从jsp跳转到servlet类时，首先执行service函数（这是定理）
    protected void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
        req.setCharacterEncoding("utf-8");//设置字符集，避免乱码
        //获取jsp界面需要进行的操作，
        String method = req.getParameter("method");
        //login(req,resp);
        if(method.equals("login"))//转到login函数
        {
            login(req,resp);
        }else if(method.equals("register")){
        	register(req,resp);
        }
    }
    
    protected void login(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");//获取jsp界面的username和password的值
        String password = req.getParameter("password");
        req.setAttribute("username", username);
        //System.out.println("psw: "+username+password);
        UserDao userdao = new UserDao();//创建Userdao的实例
        boolean flag = userdao.login(username, password);//用来判断是否登陆成功
        if(flag==true)
        {
            System.out.println("Success登录成功！");
            //resp.sendRedirect(req.getContextPath()+"/Navigation.jsp");
            req.setAttribute("prompt", "登录成功！");
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            req.getRequestDispatcher("Navigation.jsp").forward(req, resp);
        }
        else
        {
            System.out.println("failure登录失败！");
            req.setAttribute("prompt", "登录失败！");
            //resp.sendRedirect(req.getContextPath()+"/Login.jsp");
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }     
    }
    
    protected void register(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");//获取jsp界面的username和password的值
        String password = req.getParameter("password");
        UserDao userdao = new UserDao();//创建Userdao的实例
        boolean flag = userdao.register(username, password);//用来判断是否登陆成功
        if(flag==true)
        {
        	AccountDao accountdao = new AccountDao();
        	req.setAttribute("prompt", "注册成功！并为您生成了一个默认账户！");
        	accountdao.openAccount(username);
        	
        	req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
        else
        {
        	req.setAttribute("prompt", "注册失败！");
        	//resp.sendRedirect(req.getContextPath()+"/Register.jsp");
        	req.getRequestDispatcher("Register.jsp").forward(req, resp);
        }     
    }

}
