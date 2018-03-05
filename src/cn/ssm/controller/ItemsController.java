package cn.ssm.controller;

import cn.ssm.po.Items;
import cn.ssm.po.ItemsCustomer;
import cn.ssm.po.ItemsQueryVo;
import cn.ssm.service.impl.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    //商品查询列表
    @RequestMapping("/queryItems")
    public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
        //System.out.println(request.getParameter("id"));

        //调用service查找数据库，查询商品列表
        List<ItemsCustomer> itemsList = itemsService.findItemsList(itemsQueryVo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("itemsList");

        return modelAndView;
    }

    //商品查询列表
   /* @RequestMapping("/queryItems")
    public String queryItems(Model model,HttpServletRequest request) throws Exception {
        System.out.println(request.getParameter("id"));
        //调用service查找数据库，查询商品列表
        List<ItemsCustomer> itemsList = itemsService.findItemsList(null);

        //通过形参中的model将model数据传到页面，相当于modelandview.addattribute方法
        model.addAttribute("itemsList",itemsList);

        return "itemsList";
    }*/



    //商品信息修改页面显示
    //@RequestMapping("/editItems")
    //限制http,可以post可以get
    @RequestMapping(value="/editItem",method={RequestMethod.POST,RequestMethod.GET})

    //通过@RequestParam可以使形式参数名字和实际参数的名字不同
    //required属性指定参数是否必须要传入，设置为true，没有传入参数，报错 "id is not present"
    //defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定
    public String editItem(Model model, @RequestParam(value = "id",required=true) Integer items_id) throws Exception{
        ItemsCustomer itemsCustomer = itemsService.findItemsByid(items_id);

        model.addAttribute("itemsCustomer",itemsCustomer);

        return "editItem";
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
    /*@RequestMapping("/editItemsSubmit")
    public String editItemsSubmit(HttpServletRequest request,ItemsCustomer itemsCustomer,int id) throws Exception{
        itemsService.updateItems(id, itemsCustomer);

        return "redirect:queryItems.action";


}*/
    //商品信息修改提交 使用forward转发,request可以共享
// 在需要校验的pojo前边添加@Validated，在需要校验的pojo后边添加BindingResult
// bindingResult接收校验出错信息
// 注意：@Validated和BindingResult bindingResult是配对出现，并且形参顺序是固定的（一前一后）。
// value={ValidGroup1.class}指定使用ValidGroup1分组的 校验
// @ModelAttribute可以指定pojo回显到页面在request中的key
    @RequestMapping("/editItemsSubmit")
    public String editItemsSubmit(Model model,HttpServletRequest request, Integer id, @Validated ItemsCustomer itemsCustomer, BindingResult bindingResult) throws Exception{
        //获取校验错误信息
        if(bindingResult.hasErrors()){
            //输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError:allErrors
                 ) {
                //输出错误信息System.out.println(objectError.getDefaultMessage());

            }
            //将错误信息传到页面
            model.addAttribute("allErrors",allErrors);
            //出错重新到商品的修改页面
            return "editItem";
        }
        itemsService.updateItems(id, itemsCustomer);

        return "forward:queryItems.action";
    }
    //批量删除商品信息
    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[] items_id) throws Exception{
        //调用service批量删除商品
        //....

    return "success";
    }

    //批量修改商品的页面,将商品信息查询出来，在页面中可以编辑商品信息
    @RequestMapping("/editItemsQuery")
    public String editItemsQuery(Model model,ItemsQueryVo itemsQueryVo) throws Exception{
        List<ItemsCustomer> itemsList = itemsService.findItemsList(itemsQueryVo);
        model.addAttribute("itemsList",itemsList);

        return "editItemsQuery";
    }

    //修改商品的提交方法editItemsAllSubmit
    //通过ItemsQueryVo接受批量提交的商品信息，将商品信息存储到ItemsQueryVo中的itemsCustomerList属性中
    @RequestMapping("/editItemsAllSubmit")
    public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo)throws Exception{


        return "success";
    }


}
