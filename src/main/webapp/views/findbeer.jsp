<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
    <head>
    </head>



    <form method="POST" action1="/mvcCRUD/beer/findbeer" modelAttribute="name">>
    <form method="POST" action2="/mvcCRUD/beer/findbeerpart" modelAttribute="name">>

        <table>
         <tr>   <label for="price">price</label></tr>
         <tr>  <input type="text" id="name" name="name"></tr>
        </table>
     <button type="submit" formaction="/mvcCRUD/beer/findbeer">search</button>
     <button type="submit" formaction="/mvcCRUD/beer/findbeerpart">search partial</button  
    </form>

</html>