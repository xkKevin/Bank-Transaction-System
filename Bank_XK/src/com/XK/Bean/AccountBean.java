package com.XK.Bean;

public class AccountBean {
	private int accountID;
	private String username;//用户名
    private double balance;//密码都是与数据库匹配的，下面是set和get函数
    public static int accountNum = 0;
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
    
}
