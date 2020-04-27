<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>spring </title>
    </head>
    <body>
        <table style="width:100%">
            <tr>
                <th align="left">id </th>
                <th align="left">name </th>
                <th align="left">address1  </th>
                <th align="left">address2 </th>
                <th align="left">city</th>
                <th align="left">state</th>
                <th align="left">code </th>
                <th align="left">country</th>
                <th align="left">phone</th>
                <th align="left">website</th>
                <th align="left">description</th>
                <th align="left">add User</th>
                <th align="left">last_mod</th>
                <th align="left">credit_limit</th>
                <th align="left">email</th>
            </tr>
 <c:forEach items="${breweriesList}" var="item">                
     <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.address1}</td>
                    <td>${item.address2}</td>
                    <td>${item.city}</td>
                    <td>${item.state}</td>
                    <td>${item.code}</td>
                    <td>${item.country}</td>
                    <td>${item.phone}</td>
                    <td>${item.website}</td>
                    <td>${item.state}</td>
                    <td>${item.description}</td>
                    <td>${item.addUser}</td>
                    <td>${item.lastMod}</td>
                    <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${item.creditLimit}" /></td>
                    <td>${item.email}</td>
               
                    <td>

                       <a href="/mvcCRUD/home/delete?id=${item.id}">delete</a>
                        <spring:url value="/home/edit?id=${item.id}" var="editURL"/>
                        <a href="${editURL}"z>edit</a>
    #                    
                    </td>

                </tr>
            </c:forEach>
        </table>
    </body>
</html>