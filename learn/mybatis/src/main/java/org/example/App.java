package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.pojo.Tmpuserinfo;
import org.example.pojo.TmpuserinfoMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();

        SqlSession sqlSession = factory.openSession();
        List<Tmpuserinfo> list = sqlSession.selectList("org.example.pojo.TmpuserinfoMapper.selectAll");

        list.forEach(x -> System.out.println(x.getUsername()));

        TmpuserinfoMapper mapper = sqlSession.getMapper(TmpuserinfoMapper.class);
        Tmpuserinfo info = mapper.selectById("1");

    }
}
