package cn.ssm.mapper;


import cn.ssm.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserMapperTest {
    private ApplicationContext applicationContext;

    //在setup这个方法中得到spring容器
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
    }

    @Test
    public void testfindUserById() throws Exception {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        User u = userMapper.findUserById(1);
        System.out.println(u);
    }
}
