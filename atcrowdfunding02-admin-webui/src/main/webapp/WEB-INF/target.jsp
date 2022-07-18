<%--
  Created by IntelliJ IDEA.
  User: hy
  Date: 2022/7/17
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
到这里了
    <%=request.getAttribute("list")%>
    ${requestScope.list}
</body>
</html>
