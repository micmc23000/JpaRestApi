<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
    <head>
    </head>



    <form method="POST" action1="/mvcCRUD/beer/increase">>
    <form method="POST" action2="/mvcCRUD/beer/decrease">>

        <table>
         <tr>   <label for="change">price percentage change</label></tr>
         <tr>  <input type="number" id="change" name="change"></tr>
        </table>
     <button type="submit" formaction="/mvcCRUD/beer/increase">increase</button>
     <button type="submit" formaction="/mvcCRUD/beer/decrease">decrease</button  
    </form>

</html>