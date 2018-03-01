package cn.ssm.mapper;

import cn.ssm.po.Items;
import cn.ssm.po.ItemsExample;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class ItemsMapperTest {
    private ApplicationContext applicationContext;

    private ItemsMapper itemsMapper;

    //在setUp这个方法得到spring容器
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        itemsMapper = (ItemsMapper) applicationContext.getBean("itemsMapper");
    }

    @Test
    public void insert() {
        Items it = new Items();
        it.setName("macbook pro");
        it.setPrice(10000f);
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        it.setCreatetime(date);
        itemsMapper.insert(it);
    }

    //自定义条件查询
    @Test
    public void testSelectByExample() {
        ItemsExample itemsExample = new ItemsExample();
        //通过criteria构造查询条件
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andNameEqualTo("笔记本3");
        //可能返回多条记录
        List<Items> list = itemsMapper.selectByExample(itemsExample);

        System.out.println(list);

    }

    @Test
    public void selectByPrimaryKey() {
        Items items = itemsMapper.selectByPrimaryKey(4);
        System.out.println(items);

    }

    //更新数据
    @Test
    public void testUpdateByPrimaryKey() {

        //对所有字段进行更新，需要先查询出来再更新
        Items items = itemsMapper.selectByPrimaryKey(1);

        items.setName("imac pro");

        itemsMapper.updateByPrimaryKey(items);
        //如果传入字段不空为才更新，在批量更新中使用此方法，不需要先查询再更新
        //itemsMapper.updateByPrimaryKeySelective(record);

    }
}
