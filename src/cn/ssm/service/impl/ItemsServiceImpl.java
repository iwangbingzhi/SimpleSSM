package cn.ssm.service.impl;

import cn.ssm.mapper.ItemsMapper;
import cn.ssm.mapper.ItemsMapperCustomer;
import cn.ssm.po.Items;
import cn.ssm.po.ItemsCustomer;
import cn.ssm.po.ItemsQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapperCustomer itemsMapperCustomer;
    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<ItemsCustomer> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsMapperCustomer.findItemsList(itemsQueryVo);
    }

    @Override
    public ItemsCustomer findItemsByid(Integer id) throws Exception {
        //中间对商品进行业务处理
        Items items = itemsMapper.selectByPrimaryKey(id);
        //返回itemsCustomer
        ItemsCustomer itemsCustomer = new ItemsCustomer();
        //将items的属性值拷贝到itemscustomer
        BeanUtils.copyProperties(items,itemsCustomer);

        return itemsCustomer;
    }

    @Override
    public void updateItems(Integer id, ItemsCustomer itemsCustomer) throws Exception {
        //添加业务校验，通常service接口对关键参数进行校验
        //校验id是否为空，如果为空抛出异常

        //更新商品信息,updateByPrimaryKeyWithBLOBs要求必须传入id,是根据id更新items表中所有字段，包括大文本类型字段
        itemsCustomer.setId(id);
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustomer);
    }
}
