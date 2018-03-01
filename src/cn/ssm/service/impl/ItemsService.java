package cn.ssm.service.impl;

import cn.ssm.po.ItemsCustomer;
import cn.ssm.po.ItemsQueryVo;

import java.util.List;

/**
 * @Title: ItemsService.java
 * @Description:商品管理的service
 * @Author 王炳智
 * @Date 2018/3/1 18:23
 */
public interface ItemsService {
    //商品查询列表
    public List<ItemsCustomer> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

    //根据id查询商品信息
    public ItemsCustomer findItemsByid(int id) throws Exception;

    //修改商品的信息
    public void updateItems(int id,ItemsCustomer itemsCustomer) throws Exception;


}
