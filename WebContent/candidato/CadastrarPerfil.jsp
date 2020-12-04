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
			<form action="<%=request.getContextPath()%>/CadastrarPerfil.do" method="post" >
				<label for="nome">Nome:</label>
				<input type="text" id="nome" name="nome">
				<br>
				<br>
				<label for="email">Email:</label>
				<input type="text" id="login" name="email">
				<br>
				<br>
				<label for="senha">Senha:</label>
				<input type="password" id="senha" name="senha">
				<br>
				<br>
				<label for="cpf">Cpf:</label>
				<input type="text" id="cpf" name="cpf">
				<br>
				<br>
				<label for="formacao_academica">Formação academica:</label>
				<input type="text" id="formacao_academica" name="formacao_academica">
				<br>
				<br>
				<label for="experiencia_prof">Experiência profissional:</label>
				<input type="text" id="experiencia_prof" name="experiencia_prof">
				<br>
				<br>
				<label for="aperfeicoamento">Aperfeicoamento:</label>
				<input type="text" id="aperfeicoamento" name="aperfeicoamento">
				<br>
				<br>
				<label for="telefone">Telefone:</label>
				<input type="text" id="telefone" name="telefone">
				<br>
				<br>
				<input type="submit" value="Cadastrar Perfil">
			</form>
	</body>
</html>