<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
  </tr>     <tr>    <td>id    </td>  <td>          ${item.id}</td>
       </tr>     <tr>              <td>breweryId</td>    <td>   ${item.breweryId}</td>
   </tr>     <tr>                  <td>name</td>  <td>   ${item.name}</td>
  </tr>     <tr>                   <td>catId</td>  <td>   ${item.catId}</td>
   </tr>     <tr>                  <td>styleId</td>  <td>   ${item.styleId}</td>
  </tr>     <tr>                   <td>abv</td>  <td>   ${item.abv}</td>
   </tr>     <tr>                  <td>description</td>  <td>   ${item.description}</td>
   </tr>     <tr>                  <td>lastMod</td>  <td>   ${item.lastMod}</td>
    </tr>     <tr>                 <td>buyPrice</td>  <td>   <fmt:formatNumber type="currency" maxFractionDigits="2" value="${item.buyPrice}" /></td>
    </tr>     <tr>                 <td>sellPrice</td>  <td>   <fmt:formatNumber type="currency" maxFractionDigits="2" value="${item.sellPrice}" /></td>
 
               
                    <td>

       </tr>     <tr>                 <a href="/mvcCRUD/home/delete?id=${item.id}">delete</a>
       </tr>     <tr>                  <spring:url value="/home/edit?id=${item.id}" var="editURL"/>
                        <a href="/mvcCRUD/beer/view?id=${item.id}">edit</a>
                   
                    </td>

                </tr>
            </c:forEach>
        </table>
    </body>
</html>