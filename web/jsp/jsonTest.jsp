<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.js">
        //请求的是json 输出的是json
        function requestJson(){
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath }/requestJson.action',
                contentType:'application/json;charset=utf-8',
                //数据格式是json串，商品信息
                data:'{"name":"手机","price":"999"}',
                success:function(data){//返回json结果
                    alert(data);
                }
            });
        }
        //请求的是key value 输出的是json
        function responseJson() {
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath }/responseJson.action',
                /* dataType: "json",*/
                //数据格式是json串，商品信息
                data:'name=手机&price=9999',
                success:function(data){//返回json结果
                    alert(data);
                }
            });
        }

    </script>
    <title>json交互测试</title>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求的是json 输出的是json" />
<input type="button" onclick="responseJson()" value="请求的是key value 输出的是json"/>
</body>
</html>
