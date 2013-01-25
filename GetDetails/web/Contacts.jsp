<%-- 
    Document   : Contacts
    Created on : Nov 29, 2012, 6:47:57 PM
    Author     : j1013563
--%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Phone Book</title>
        <style type="text/css">
            <!--
            @import url("css/bootstrap.min.css");
            -->
        </style>
    </head>
    <body align="center">
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/phanindhar"
                           user="root"  password="root"/>
        <sql:query dataSource="${snapshot}" var="result">
            SELECT * from records
        </sql:query>

        <table id="dataTable" align="center"  width="50%">
            <tr align="left">
                <th><h3>ID              </h3></th>
        <th><h3>Name            </h3></th>
    <th><h3>Mobile          </h3></th>
</tr >
<c:forEach var="row" items="${result.row}">
    <tr align="left">
        <td><h4><c:out value="${row.Id}"/></h4></td>
        <td><h4><c:out value="${row.Name}"/></h4></td>
        <td><h4><c:out value="${row.Mobile}"/></h4></td>
    </tr>
</c:forEach>
</table>
<br>
</body>
</html>
