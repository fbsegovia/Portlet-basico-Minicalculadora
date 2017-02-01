<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<%
	String numero3 = (String)request.getAttribute("numero3");
	String operacion = (String)request.getAttribute("operacion");
	Integer iNumero3 = Integer.parseInt(numero3);
%>

<h1>La operación utilizada ha sido: <%=operacion%></h1>
	<p>El resultado es : <%=iNumero3 %></p><br/>

<a href="<portlet:actionURL/>">Volver</a>
    
    
    