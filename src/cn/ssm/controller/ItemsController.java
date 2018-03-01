package cn.ssm.controller;

import cn.ssm.po.Items;
import cn.ssm.po.ItemsCustomer;
import cn.ssm.service.impl.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: ItemsController.java
 * @Description:商品的controller
 * @Author 王炳智
 * @Date 2018/3/1 19:52
 */
@Controller
//窄化请求路径，为了对url进行分类管理，可以在这里定义根路径，最终访问url是根路径加子路径 如/items/queryItems
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
  /*  //商品查询列表
    @RequestMapping("/queryItems")
    public ModelAndView queryItems(HttpServletRequest request) throws Exception {
        System.out.println(request.getParameter("id"));

        //调用service查找数据库，查询商品列表
        List<ItemsCustomer> itemsList = itemsService.findItemsList(null);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("itemsList");

        return modelAndView;
    }
*/

    //商品查询列表
    @RequestMapping("/queryItems")
    public String queryItems(Model model,HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        System.out.println(id);
        //调用service查找数据库，查询商品列表
        List<ItemsCustomer> itemsList = itemsService.findItemsList(null);

        //通过形参中的model将model数据传到页面，相当于modelandview.addattribute方法
        model.addAttribute("itemsList",itemsList);

        return "itemsList";
    }



    //商品信息修改页面显示
    //@RequestMapping("/editItems")
    //限制http,可以post可以get
    @RequestMapping(value = "/editItems",method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView editItems() throws Exception{
        ItemsCustomer itemsCustomer = itemsService.findItemsByid(1);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("itemsCustomer",itemsCustomer);
        modelAndView.setViewName("editItems");

        return modelAndView;
    }

/*
    //商品信息修改提交
    @RequestMapping("/editItemsSubmit")
    public ModelAndView editItemsSubmit() throws Exception{

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }*/
    //商品信息修改提交 使用redirect重定向
    @RequestMapping("/editItemsSubmit")
    public String editItemsSubmit() throws Exception{

        return "redirect:queryItems.action";
}
    /*//商品信息修改提交 使用forward转发,request可以共享
    @RequestMapping("/editItemsSubmit")
    public String editItemsSubmit(HttpServletRequest request) throws Exception{

        return "forward:queryItems.action";
    }*/

}
