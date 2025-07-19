<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
 Professor Darrell Payne
 Bellevue University
-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select Team MySQL</title>
    </head>
    <body>
        <h1>Select Team MySQL</h1>
        <div>
            
        <% 
            if(request.getMethod().equals("POST")){
        %>
        
        <%@ taglib uri="/QueryResultsTableMySQL" prefix="lotsOfData" %>   
        <% String selectedTeam = request.getParameter("Team"); %>
        <font color=blue size=+1>With a Table</font><br />
        <lotsOfData:tableMySQL selectTeam="<%= selectedTeam %>" />
        <p />

        
        <% 
            }
        %>
        
        
        <% 
            if(request.getMethod().equals("GET")){
        %>

        <form method='post' action='SelectTeamTableMySQL.jsp'>
            <label>Enter your favorite World Series Team</label>&nbsp;&nbsp;&nbsp;
            <input type='text' name='Team' size='40' maxlength='40'/>
            <input type='submit' />
        </form>
        
        <% 
            }
        %>

        </div>
    </body>
</html>
