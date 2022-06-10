<%-- 
    Document   : test
    Created on : Jun 10, 2022, 8:00:24 PM
    Author     : Muhammad Ayoob Bugti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
         
         <script>
             
             $(document).ready(function (){
                 //alert('Ajax is running successfully');
                 
                 $("#btn").click(function (){
                     $.ajax({
                         url: "time",
                         success: function (data) {
                        $("#get_time").html(data);
                    }
                     });
                 });
             });
             
             
             
         </script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <button id="btn">Click</button>
        <h1 id="get_time"></h1>
    </body>
</html>
