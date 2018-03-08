package cn.ssm.controller;

import cn.ssm.po.ItemsCustomer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Title: JsonTest.java
 * @Description:json交互测试
 * @Author 王炳智
 * @Date 2018/3/7 23:03
 */
@Controller
public class JsonTest {
    //请求json串(商品信息),输出json(商品信息)
    //@RequestBody请求的商品信息json串转成itemsCustomer
    //@ResponseBody将itemsCustomer转成json输出
    @RequestMapping("/requestJson")
    public @ResponseBody ItemsCustomer requestJson(@RequestBody ItemsCustomer itemsCustomer){


        //@ResponseBody将itemsCustomer转成json输出
        return itemsCustomer;
    }
}
