package cn.ssm.exception;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * @Title: CustomerExceptionResolver.java
 * @Description:全局异常处理器
 * @Author 王炳智
 * @Date 2018/3/5 16:34
 */
public class CustomerExceptionResolver implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //handler就是处理器是配置要执行的handler对象(只有method方法)
  /*      String message = null;
        //如果是系统自定义异常，直接出去异常信息在错误页面显示
        if(e instanceof CustomerException){
            message = ((CustomerException)e).getMessage();
        }else {
         //该异常不是系统自定义的异常，构造一个自定义的异常类型
            message = "未知异常";
        }*/

        //上面代码变为:
        CustomerException customerException = null;
        if (e instanceof CustomerException){
            customerException = (CustomerException) e;
        }else {
            customerException = new CustomerException("未知错误信息");
        }

        //错误信息
        String message= customerException.getMessage();
        ModelAndView modelAndView = new ModelAndView();

        //将错误信息传到页面
        modelAndView.addObject("message",message);

        //指向错误页面
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
