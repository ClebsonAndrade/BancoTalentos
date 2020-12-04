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
			<p>id: <%=candidato.getId()%></p>
			<br>
			<p>Nome: <%=candidato.getNome()%></p>
			<br>
			<p>Email: <%=candidato.getEmail()%></p>
			<br>
			<p>Formação academica: <%=candidato.getFormacaoAcademica() %></p>
			<br>
			<p>Experiência profissional: <%=candidato.getExperienciaProf()%></p>
			<br>
			<p>Aperfeicoamento: <%=candidato.getAperfeicoamento()%></p>
			<br>
			<p>Telefone: <%=candidato.getTelefone()%></p>
			<br>
			
			<a href="<%=request.getContextPath()%>/candidato/ExcluirPerfil.jsp?id=<%=candidato.getId()%>" role="button">Excluir</a>
			<br>
			<a href="<%=request.getContextPath()%>/candidato/AlterarPerfil.jsp?id=<%=candidato.getId()%>" role="button">Alterar</a>
			
	</body>
</html>