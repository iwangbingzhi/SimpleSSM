package cn.ssm.po;

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
