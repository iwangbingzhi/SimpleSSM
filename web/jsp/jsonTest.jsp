<%--
  Created by IntelliJ IDEA.
  User: wangbingzhi
  Date: 2018/3/7
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js">
        //请求的是json 输出的是json
        function requestJson() {
            $.ajax({
               type:'post',
               url:'${pageContext.request.contextPath}/requestJson.action',
               contentType:'application/json;charset=utf-8',
                data:'{"name":"手机","price":9999}',
                success:function (data) {
                    alert(data);
                }
            });
        }
        //请求的是key value 输出的是json
        function responseJson() {


        }

    </script>
    <title>json交互测试</title>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求的是json 输出的是json"/>
<input type="button" onclick="responseJson()" value="请求的是key value 输出的是json"/>
</body>
</html>
