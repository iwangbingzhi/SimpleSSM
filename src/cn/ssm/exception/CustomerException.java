package cn.ssm.exception;
/**
 * @Title: CustomerException.java
 * @Description:系统自定义异常类，针对预期的异常在程序中抛出此类异常
 * @Author 王炳智
 * @Date 2018/3/5 16:29
 */
public class CustomerException extends Exception {

    //异常信息
    public String message;


    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomerException(String message) {
        super(message);
        this.message = message;
    }
}
