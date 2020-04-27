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
              <th align="left">breweryId  </th>
                <th align="left">name  </th>
                <th align="left">cat_id </th>
                <th align="left">style_id</th>
                <th align="left">abv</th>
                <th align="left">description</th>
                <th align="left">last_mod</th>
                <th align="left">buy_price</th>
                <th align="left">sell_price</th>
              
            </tr> 
          
          <tr>      <th align="right">sell_price</th> 
                   <spring:url value="/home/sale" var="editURL"/></tr> 
 <c:forEach items="${beersList}" var="item">                
     <tr>
                    <td>${item.id}</td>
                    <td>${item.breweryId}</td>
                    <td>${item.name}</td>
                    <td>${item.catId}</td>
                    <td>${item.styleId}</td>
                    <td>${item.abv}</td>
                    <td>${item.description}</td>
                    <td>${item.lastMod}</td>
                    <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${item.buyPrice}" /></td>
                    <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${item.sellPrice}" /></td>

               
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