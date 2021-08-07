package org.example;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.pojo.Tmpuserinfo;
import org.example.pojo.TmpuserinfoMapper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

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
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();
        TmpuserinfoMapper mapper = sqlSession.getMapper(TmpuserinfoMapper.class);
        Tmpuserinfo info = mapper.selectById("1");
    }
}
