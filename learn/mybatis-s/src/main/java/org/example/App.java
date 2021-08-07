package org.example;

import org.example.pojo.Tmpuserinfo;
import org.example.pojo.TmpuserinfoMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        TmpuserinfoMapper userMapper = (TmpuserinfoMapper)context.getBean("tmpuserinfoMapper");
        List<Tmpuserinfo> list = userMapper.selectAll("1");
        list.forEach(x->System.out.println(x.getUsername()));
    }
}
