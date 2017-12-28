<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html" http-equiv="Content-Type" ; charset="UTF-8">
    <title>title</title>
</head>
<body>
    <div id="resp"></div><input type="button" onclick="req();" value="请求"/>
<script type="text/javascript" src="assets/jquery.min.js"></script>
<script>
    function req(  ) {
      $.ajax({
        url:"convert",
        data:"1-shang",
        type:"POST",
        contentType:"application/x-shang",
        success:function ( data ) {
          $("#resp").html(data)
        }
      })

    }
</script>
</body>
</html>
