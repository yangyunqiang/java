package org.example.pojo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

import static org.junit.Assert.*;

public class TmpuserinfoMapperTest {


    private static SqlSessionFactory factory;

    @BeforeClass
    public static void init() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SqlSession getSqlSession() {
        SqlSession sqlSession = factory.openSession();
        return sqlSession;
    }

    @Test
    public void insert() {
        Tmpuserinfo info = new Tmpuserinfo();
        info.setUsername("7");
        info.setAge(22);
        info.setAddr("sh");

        SqlSession sqlSession = getSqlSession();
        TmpuserinfoMapper mapper = sqlSession.getMapper(TmpuserinfoMapper.class);
        mapper.insert(info);

        sqlSession.commit();

    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectById() {
        SqlSession sqlSession = getSqlSession();
        TmpuserinfoMapper mapper = sqlSession.getMapper(TmpuserinfoMapper.class);
        Tmpuserinfo info = mapper.selectById("1");
    }
}