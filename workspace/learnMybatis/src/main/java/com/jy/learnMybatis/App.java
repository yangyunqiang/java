package com.jy.learnMybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jy.mappers.UserinfoMapper;

/**
 * Hello world!
 *
 */
public class App 
{
	private SqlSessionFactory sqlSessionFactory;
	public void init() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void printUserInfoList(List<Userinfo> userInfoList) {
		for (Userinfo userInfo : userInfoList)	{
			System.out.printf("%d:%s:%s\n", userInfo.getUserid(), userInfo.getUsername(), userInfo.getUseradd());
		}
	}
	
	public void testSeletcAll() {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		List<Userinfo> userInfoList = sqlsession.selectList("selectAll");
		printUserInfoList(userInfoList);	
	}
	
	public void testSeletcById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserinfoMapper userInfoMapper = sqlSession.getMapper(UserinfoMapper.class);
		Userinfo userInfo = userInfoMapper.selectById((long) 3);
		System.out.printf("%d:%s:%s\n", userInfo.getUserid(), userInfo.getUsername(), userInfo.getUseradd());
	}
	
	public void testInsert() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserinfoMapper userInfoMapper = sqlSession.getMapper(UserinfoMapper.class);
		
		Userinfo userInfo = new Userinfo();
		userInfo.setUserid(3);
		userInfo.setUsername("3");
		userInfo.setUseradd("3");
		
		
		
		userInfoMapper.insert(userInfo);
		sqlSession.commit();
		System.out.printf("%d:%s:%s\n", userInfo.getUserid(), userInfo.getUsername(), userInfo.getUseradd());
	}
	
    public static void main( String[] args )
    {
    	App app = new App();
    	app.init();
    	
    	app.testInsert();
    	app.testSeletcAll();
    	app.testSeletcById();
    	
    }
}
