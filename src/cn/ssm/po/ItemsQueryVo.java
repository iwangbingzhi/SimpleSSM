package cn.ssm.po;

import java.util.List;

/**
 * @Title: ItemsQueryVo.java
 * @Description:商品的包装对象
 * @Author 王炳智
 * @Date 2018/3/1 17:45
 */
public class ItemsQueryVo {
    //商品信息
    private Items items;

    //为了系统的可扩展性，对原始生成的po进行扩展，创建类ItemsCustomer
    private ItemsCustomer itemsCustomer;



    public void setItemsCustomerList(List<ItemsCustomer> itemsCustomerList) {
        this.itemsCustomerList = itemsCustomerList;
    }

    //批量商品
    private List<ItemsCustomer> itemsCustomerList;

    public List<ItemsCustomer> getItemsCustomerList() {
        return itemsCustomerList;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsCustomer getItemsCustomer() {
        return itemsCustomer;
    }

    public void setItemsCustomer(ItemsCustomer itemsCustomer) {
        this.itemsCustomer = itemsCustomer;
    }
}
