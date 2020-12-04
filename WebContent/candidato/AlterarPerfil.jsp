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
			<label for="email">email:</label>
			<input type="text" id="email" name="email" value="<%=candidato.getEmail()%>">
			<br>
			<br>
			<label for="aperfeicoamente">Aperfeiçoamento:</label>
			<input type="text" id="aperfeicoamento" name="aperfeicoamento" value="<%=candidato.getAperfeicoamento()%>">
			<br>
			<br>
			<label for="experiencia_prof">Experiência professional:</label>
			<input type="text" id="experiencia_prof" name="experiencia_prof" value="<%=candidato.getExperienciaProf()%>">
			<br>
			<br>
			<label for="formacao_academica">Formação Academica:</label>
			<input type="text" id="formacao_academica" name="formacao_academica" value="<%=candidato.getFormacaoAcademica()%>">
			<br>
			<br>
			<label for="senha">Senha:</label>
			<input type="text" id="senha" name="senha" value="">
			<br>
			<br>
			<label for="cpf">cpf:</label>
			<input type="text" id="cpf" name="cpf" value="">
			<br>
			<br>
			<label for="telefone">Telefone:</label>
			<input type="text" id="telefone" name="telefone" value="<%=candidato.getTelefone()%>">
			<br>
			<br>
			<input type="submit" value="Alterar Perfil"> 
			
		</form>
	</body>
</html>