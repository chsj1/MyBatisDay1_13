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
 * �����ࡣ
 * ��Ҫ��ɻ�ȡ���ӣ��͹ر�����
 * @author huangjundong
 *
 */
public class MyBatisUtils {
	public static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	public static SqlSessionFactory sessionFactory;
	
	static{
		try {
			//��ȡ���ݿ�������Ϣ�������ļ�mybatis.xml
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			//������������ļ�������sqlSessionFactory
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡsession
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
	 * �ر�session
	 */
	public static void closeSession(){
		SqlSession session = threadLocal.get();
		if(session != null){
			session.close();
			threadLocal.remove();
		}
	}
	
	/**
	 * ����
	 * @param args
	 */
	public static void main(String[] args) {
		//�õ������ݿ������
		Connection connection = MyBatisUtils.getSession().getConnection();
		System.out.println(connection != null ? "���ӳɹ�---->" : "----->���Ӳ��ɹ�");
	}
}
