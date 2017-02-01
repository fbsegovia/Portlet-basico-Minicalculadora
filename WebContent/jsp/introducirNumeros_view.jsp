<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<%
	Object error = request.getAttribute("error");
%>

<img src="/02_Ejercicio3_Calculadora/img/123.png"/>
<form style="border:1px;" action="<portlet:actionURL/>" method="post">
	Número 1:<input type="number" name="numero1" required="required"/><br/>
	Número 2:<input type="number" name="numero2" required="required"/><br/>
	<input type=image src="/02_Ejercicio3_Calculadora/img/suma.png" name="accion" value="sumar">
	<input type=image src="/02_Ejercicio3_Calculadora/img/resta.png" name="accion" value="restar">
	<input type=image src="/02_Ejercicio3_Calculadora/img/multiplicacion.png" name="accion" value="multiplicar">
	<input type=image src="/02_Ejercicio3_Calculadora/img/division.png" name="accion" value="dividir">
</form>

<%
	if(error != null){
%>

	<h3 style="color:red" ><%=error %></h3>

<%
	}
%>