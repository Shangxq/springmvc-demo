<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"/>
<html>
<head>
    <meta content="text/html" http-equiv="Content-Type"; charset="UTF-8">
    <title>title</title>
</head>
<body>
    <div id="msgFromPush">

    </div>
<script type="text/javascript" src="assets/jquery.min.js"></script>
<script type="text/javascript">
    var source=new EventSource("push");
    s="";
    source.addEventListener("message",function ( e ) {
      s+=e.data+"<br/>";
      $("#msgFromPush").html(s);
    });
    source.addEventListener("open",function ( e ) {
      console.log("连接打开");
    },false);
    source.addEventListener("error",function ( e ) {
      if(e.readyState== EventSource.CLOSED){
        console.log("连接关闭")
      }
    })
</script>
</body>
</html>
