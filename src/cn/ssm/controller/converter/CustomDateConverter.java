package cn.ssm.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Title: CustomDateConverter.java
 * @Description:日期转换器
 * @Author 王炳智
 * @Date 2018/3/2 16:40
 */
public class CustomDateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        //实现将日期串转换成日期类型(格式：yyyy-MM-dd HH:mm:ss)
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //转换成功直接返回
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //参数绑定失败返回null
        return null;
    }
}
