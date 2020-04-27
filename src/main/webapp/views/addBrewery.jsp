<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
    <head>  
    <h3><addBreweryform</h3>
    </head>

    <form:form method="POST" action="/mvcCRUD/brew/addBrewery" modelAttribute="breweries">

        <table>
           <tr>
                <td>id</td>
                <td><form:input path="id"/></td>
                <td style="color:red"></td>
            </tr>
            <tr>
                <td>name</td>
                <td><form:input path="name"/></td>
                <td style="color:red"></td>
            </tr>
            <tr>
                <td>address1</td>
                <td><form:input path="address1"/></td>
                <td style="color:red"></td>
            </tr>
             <tr>
                <td>address2</td>
                <td><form:input path="address2"/></td>
                <td style="color:red"></td>
            </tr>
            <tr>
                <td>city</td>
                <td><form:input path="city"/></td>
                <td style="color:red"></td>
            </tr> 
              <tr>
                <td>state</td>
                <td><form:input path="state"/></td>
                <td style="color:red"></td>
            </tr>
            <tr>
                <td>code</td>
                <td><form:input path="code"/></td>
                <td style="color:red"></td>
            </tr>
             <tr>
                <td>country</td>
                <td><form:input path="country"/></td>
                <td style="color:red"></td>
            </tr>
            <tr>
                <td>phone</td>
                <td><form:input path="phone"/></td>
                <td style="color:red"></td>
            </tr>
            <tr>
                <td>website</td>
                <td><form:input path="website"/></td>
                <td style="color:red"></td>
            </tr>
            <tr>
                <td>state</td>
                <td><form:input path="state"/></td>
                <td style="color:red"></td>
            </tr>
             <tr>
                <td>description</td>
                <td><form:input path="description"/></td>
                <td style="color:red"></td>
            </tr>
            
         
            <tr>
                <td>addUser</td>
                <td><form:input path="addUser"/></td>
                <td style="color:red"></td>
            </tr>
             <tr>
                <td>lastMod</td>
                <td><form:input path="lastMod"/></td>
                <td style="color:red"></td>
            </tr>
            <tr>
                <td>email</td>
                <td><form:input path="email"/></td>
                <td style="color:red"></td>
            </tr>
           
            
            <tr>

                <td>creditLimit</td>
                <td><form:input type="currency" path="creditLimit"/></td>
                <td style="color:red">  </td>

            </tr>
             <tr>
                <td>email</td>
                <td><form:input path="email"/></td>
                <td style="color:red"></td>
            </tr>
            <tr>
                <spring:message code="submit.button" var="labelSubmit"></spring:message>
                <td><input type="submit" value="${labelSubmit}"/></td>
            </tr>
        </table>
    </form:form>


</html>