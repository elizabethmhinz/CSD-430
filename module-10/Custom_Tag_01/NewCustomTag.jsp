<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
 Professor Darrell Payne
 Bellevue University
-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Custom Tag #1</title>
    </head>
    <body>
        <h1>New Custom Tag #1</h1>
        
        <%@ taglib uri="/newCustomTag" prefix="easy1" %>    
        <easy1:newCustomTag />
        <br />
        <%@ taglib uri="/customTagThree" prefix="easy2" %>
        <easy2:customTagThree />
</body>
</html>
