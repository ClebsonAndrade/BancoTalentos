<%@page import="br.edu.ifs.dao.CandidatoDAOPostgres"%>
<%@page import="br.edu.ifs.dao.ICandidatoDAO"%>
<%@page import="br.edu.ifs.dao.FabricaConexoesPostgres"%>
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
		<%
					int id = Integer.parseInt(request.getParameter("id").toString());	
									Candidato candidato = new Candidato();
										
									try{
										IFabricaConexoes fabrica = new FabricaConexoesPostgres();
										ICandidatoDAO candidatoDao = new CandidatoDAOPostgres(fabrica.obterConexao());
										candidato = candidatoDao.recuperar(id);
									} catch (Exception e){
										request.getSession().setAttribute("erro", e.getMessage().toString());
										response.sendRedirect("../erro/ExibirErro.jsp");
									}
				%>
		
		<form action="<%=request.getContextPath()%>/AlterarPerfil.do" method="post" >
			<input type="hidden" name="id" value="<%=candidato.getId()%>">
			<label for="nome">Nome:</label>
			<input type="text" id="nome" name="nome" value="<%=candidato.getNome()%>">
			<br>
			<br>
			<label for="login">email:</label>
			<input type="text" id="email" name="email" value="<%=candidato.getEmail()%>">
			<br>
			<br>
			<label for="senha">Senha:</label>
			<input type="text" id="senha" name="senha" value="">
			<br>
			<br>
			<input type="submit" value="Alterar Usuário"> 
			
		</form>
	</body>
</html>