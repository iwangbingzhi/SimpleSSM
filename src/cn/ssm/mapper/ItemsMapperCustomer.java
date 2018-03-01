package cn.ssm.mapper;

import cn.ssm.po.ItemsCustomer;
import cn.ssm.po.ItemsQueryVo;

import java.util.List;

public interface ItemsMapperCustomer {
    //商品查询列表
    public List<ItemsCustomer> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

}
