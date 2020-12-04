<%@page import="br.edu.ifs.dao.ICandidatoDAO"%>
<%@page import="br.edu.ifs.dao.CandidatoDAOPostgres"%>
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
				%><h2>Deseja realmente excluir esse usuário? Se sim clique em excluir</h2>
		
		<form action="<%=request.getContextPath() %>/ExcluirPerfil.do" method="get">
			<input type="hidden" name="id" value="<%=candidato.getId()%>">
			Nome: <input disabled="disabled" type="text" name="nome" value="<%=candidato.getNome()%>">
			Email: <input disabled="disabled" type="text" name="email" value="<%=candidato.getEmail()%>">
			<input type="submit" value="Excluir">
		</form>
</body>
</html>