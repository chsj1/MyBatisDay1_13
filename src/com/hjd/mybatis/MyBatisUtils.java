package com.hjd.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sun.awt.windows.ThemeReader;

/**
 * 工具类。
 * 主要完成获取链接，和关闭链接
 * @author huangjundong
 *
 */
public class MyBatisUtils {
	public static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	public static SqlSessionFactory sessionFactory;
	
	static{
		try {
			//读取数据库连接信息的配置文件mybatis.xml
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			//根据这个配置文件来创建sqlSessionFactory
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取session
	 * @return
	 */
	public static SqlSession getSession(){
		SqlSession session = threadLocal.get();
		if(session == null){
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}
		return session;
	}
	
	/**
	 * 关闭session
	 */
	public static void closeSession(){
		SqlSession session = threadLocal.get();
		if(session != null){
			session.close();
			threadLocal.remove();
		}
	}
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		//拿到与数据库的链接
		Connection connection = MyBatisUtils.getSession().getConnection();
		System.out.println(connection != null ? "连接成功---->" : "----->连接不成功");
	}
}
