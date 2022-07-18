<%--
  Created by IntelliJ IDEA.
  User: hy
  Date: 2022/7/17
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">

    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>

    <script type="text/javascript">
        $(function () {
            $("#btn01").click(function () {
                $.ajax({
                    url:"send/array/one.html",
                    type:"get",
                    data:{
                        "array":[5,8,10],
                    },
                    dataType:"text",
                    success:function (result) {
                        alert(result)
                    },
                    error:function (result) {
                        alert(result)
                    }
                })
            })


            $("#btn02").click(function () {
                $.ajax({
                    url:"send/array/two.html",
                    type:"get",
                    data:{
                        "array[0]":5,
                        "array[1]":8,
                        "array[2]":10
                    },
                    dataType:"text",
                    success:function (result) {
                        alert(result)
                    },
                    error:function (result) {
                        alert(result)
                    }
                })
            })

            $("#btn03").click(function () {

                var array = [5,8,10]

                var arrayJson = JSON.stringify(array);

                $.ajax({
                    url:"send/array/three.html",
                    type:"post",
                    data:arrayJson,
                    contentType:"application/json;charset=UTF-8",
                    success:function (result) {
                        alert(result)
                    },
                    error:function (result) {
                        alert(result)
                    }
                })
            })
        })

    </script>

</head>
<body>
    <a href="getall.json">连接</a>
    <br/>
    <button type="button" id="btn01">发送数据1</button><br/>
    <button type="button" id="btn02">发送数据2</button><br/>
    <button type="button" id="btn03">发送数据3</button><br/>
</body>
</html>
