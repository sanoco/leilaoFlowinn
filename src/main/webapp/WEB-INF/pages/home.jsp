<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html lang="pt">
<META http-equiv="Pragma" content="no-cache">
<meta http-equiv="Content-Language" content="pt-br">

<link href="/css/estrutura.css"" type="text/css" rel="stylesheet" />
<link href="/css/menu.css" type="text/css" rel="stylesheet" />
<link href="/css/mensagens.css" type="text/css" rel="stylesheet" />

<title>Leilão Virtual - Flowinn</title>

<body>

	<c:import url="header.jsp"></c:import>    
	
	<table width="100%">
		<tr>
			<td>
				<c:import url="menu.jsp"></c:import>
			</td>
			<td class="texto_red_bold">
				Bem-vindo ao Leilão Virtual Flowinn.<br/><br/>
				Escolha uma das opções no menu ao lado.
			</td>
		</tr>	
	</table>
	<hr/>
	<center>
		<div>
		@Developed by Samuel Coutinho
		</div>
	</center>
</body>

</html>