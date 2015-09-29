package com.hjd.mybatis;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class StudentDao {
	public void add1(){
		SqlSession sqlSession = null;
		
		try{
			//�õ�SqlSession
			sqlSession = MyBatisUtils.getSession();
			/**
			 * ִ����Ӧ��insert���
			 * studentNamespace.add1:
			 * ȥ�ҵ�studentNamespace�е���Ϊadd1��sql���
			 * 
			 */
			int i = sqlSession.insert("studentNamespace.add1");
			//�ύ����
			sqlSession.commit();
			System.out.println("------>i: " + i);
		}catch(Exception e){
			//��������쳣,���лع�
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//�ر�SqlSession
			MyBatisUtils.closeSession();
		}
	}
	
	public void add2(Student student){
		SqlSession sqlSession = null;
		
		
		try{
			//�õ�SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			
			/**
			 * ִ����Ӧ��insert���
			 * ��һ������:�ҵ���һ��SQL���,������namespace.sql����ID
			 * studentNamespace.add1:
			 * ȥ�ҵ�studentNamespace�е���Ϊadd1��sql���
			 * 
			 */
			int i = sqlSession.insert( Student.class.getName() + ".add2",student);
			//�ύ����
			sqlSession.commit();
			System.out.println("------>i: " + i);
		}catch(Exception e){
			//��������쳣,���лع�
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//�ر�SqlSession
			MyBatisUtils.closeSession();
		}
	}
	
	/**
	 * ���²���
	 * @param student
	 */
	public void update1(Student student){
		SqlSession sqlSession = null;
		
		
		try{
			//�õ�SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			
			/**
			 * ִ����Ӧ��insert���
			 * ��һ������:�ҵ���һ��SQL���,������namespace.sql����ID
			 * studentNamespace.add1:
			 * ȥ�ҵ�studentNamespace�е���Ϊadd1��sql���
			 * 
			 */
			int i = sqlSession.update( Student.class.getName() + ".update1",student);
			//�ύ����
			sqlSession.commit();
			System.out.println("------>i: " + i);
		}catch(Exception e){
			//��������쳣,���лع�
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//�ر�SqlSession
			MyBatisUtils.closeSession();
		}
	}
	
	
	/**
	 * ��ѯ����������id����ѯ
	 * @param student
	 */
	public Student findById(int id){
		SqlSession sqlSession = null;
		
		
		try{
			//�õ�SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			
			/**
			 * ִ����Ӧ��insert���
			 * ��һ������:�ҵ���һ��SQL���,������namespace.sql����ID
			 * studentNamespace.add1:
			 * ȥ�ҵ�studentNamespace�е���Ϊadd1��sql���
			 * 
			 */
			Student student = sqlSession.selectOne( Student.class.getName() + ".findById",id);
			//�ύ����(�����ݿ�����ݵ�ʱ�򲢲���Ҫ�ύ����)
//			sqlSession.commit();
//			System.out.println("------>i: " + i);
			
			return student;
		}catch(Exception e){
			//��������쳣,���лع�
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//�ر�SqlSession
			MyBatisUtils.closeSession();
		}
		
		return null;
	}
	
	
	/**
	 * ��ѯ����������id����ѯ
	 * @param student
	 */
	public List<Student> findAll(){
		SqlSession sqlSession = null;
		
		
		try{
			//�õ�SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			
			
			List<Student> students = sqlSession.selectList( Student.class.getName() + ".findAll");
			//�ύ����(�����ݿ�����ݵ�ʱ�򲢲���Ҫ�ύ����)
//			sqlSession.commit();
//			System.out.println("------>i: " + i);
			
			return students;
		}catch(Exception e){
			//��������쳣,���лع�
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//�ر�SqlSession
			MyBatisUtils.closeSession();
		}
		
		return null;
	}
	
	
	public List<Student> findAllByPage(int startIndex,int pageSize){
		SqlSession sqlSession = null;
		
		
		try{
			//�õ�SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("start", startIndex);
			map.put("size", pageSize);
			
			List<Student> students = sqlSession.selectList( Student.class.getName() + ".findAllByPage",map);
			//�ύ����(�����ݿ�����ݵ�ʱ�򲢲���Ҫ�ύ����)
//			sqlSession.commit();
//			System.out.println("------>i: " + i);
			
			return students;
		}catch(Exception e){
			//��������쳣,���лع�
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//�ر�SqlSession
			MyBatisUtils.closeSession();
		}
		
		return null;
	}
	
	
	/**
	 * ��̬SQL��������
	 */
	public void dynamicInsert(Student student){
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtils.getSession();
			sqlSession.insert(Student.class.getName()+".dynamicinsert", student);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			MyBatisUtils.closeSession();
		}
	}
	
	/**
	 *ɾ������
	 */
	public void deleteById(int id){
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtils.getSession();
			sqlSession.insert(Student.class.getName()+".deleteById", id);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			MyBatisUtils.closeSession();
		}
	}
	
	
	
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
//		dao.update1(student);
//		Student student1 = dao.findById(2);
//		System.out.println(student1);
		
		
//		int i;
//		for(i = 0 ; i < 10 ; ++i){
//			dao.add2(new Student(i+4,"hjd" + (i+4),70000.0));
//		}
//		System.out.println(dao.findAllByPage(5,5));
//		System.out.println(dao.findAll());
		
//		dao.dynamicInsert(new Student(19,null,null));
//		dao.dynamicInsert(new Student(20,"name",null));
		dao.deleteById(20);
	}
}
