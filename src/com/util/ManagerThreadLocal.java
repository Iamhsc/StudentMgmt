package com.util;

import java.sql.Connection;
import java.sql.SQLException;

public class ManagerThreadLocal {
private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	//得到一个连接
	public static Connection getConnection(){
		Connection conn = tl.get();//从当前线程中取出一个连接
		if(conn==null){
			conn = C3P0Util.getConnection();//从池中取出一个
			tl.set(conn);//把conn对象放入到当前线程对象中
		}
		return conn;
	}
	
	//开始事务
	public static void startTransacation(){
		try {
			Connection conn = getConnection();
			conn.setAutoCommit(false);//从当前线程对象中取出的连接，并开始事务
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(){
		try {
			getConnection().commit();//提交事务
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(){
		try {
			getConnection().rollback();//回滚事务
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(){
		try {
			getConnection().close();//把连接放回池中
			tl.remove();//把当前线程对象中的conn移除
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
