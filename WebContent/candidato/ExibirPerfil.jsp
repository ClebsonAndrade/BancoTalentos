<%@page import="br.edu.ifs.dao.CandidatoDAOPostgres"%>
<%@page import="br.edu.ifs.dao.FabricaConexoesPostgres"%>
<%@page import="br.edu.ifs.dao.ICandidatoDAO"%>
<%@page import="br.edu.ifs.dao.IFabricaConexoes"%>
<%@page import="br.edu.ifs.modelo.Candidato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<hr>
			<%
				int id = Integer.parseInt(request.getParameter("id").toString());	
				Candidato usuario = new Candidato();
					
				try{
					IFabricaConexoes fabrica = new FabricaConexoesPostgres();
					ICandidatoDAO usuarioDao = new CandidatoDAOPostgres(fabrica.obterConexao());
					usuario = usuarioDao.recuperar(id);
				} catch (Exception e){
					request.getSession().setAttribute("erro", e.getMessage().toString());
					response.sendRedirect("../erro/ExibirErro.jsp");
				}
			%>
			<p>Nome do candidato: <%=usuario.getNome()%></p>
			<br>
			<p>Email do candidato: <%=usuario.getEmail()%></p>
	</body>
</html>