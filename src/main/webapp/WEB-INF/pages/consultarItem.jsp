<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<html lang="pt">
<META http-equiv="Pragma" content="no-cache">
<meta http-equiv="Content-Language" content="pt-br">

<link href="/css/estrutura.css"" type="text/css" rel="stylesheet" />
<link href="/css/menu.css" type="text/css" rel="stylesheet" />
<link href="/css/mensagens.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="/js/funcoes.js"></script>
<title>Leilão Virtual - Flowinn</title>

<spring:url value="/actionGetItem" var="action" />

<body>

	<c:import url="header.jsp"></c:import>    
	
	<form:form action="${action}" method="POST" modelAttribute="itemBean" id="formGetItem">
	<table width="100%">
		<tr>
			<td width="20%">
				<c:import url="menu.jsp"></c:import>
			</td>
			<td width="80%">
				<table class="tabela">
					<tr>
						<td colspan="2"><span class="texto_destaque">Buscar Item:</span></td>
					</tr>
					<tr>
						<td>Nome:</td><td><form:input type="text" path="nome" id="nome" size="30" maxlength="30" onkeyup="caixaAlta('formGetItem','nome')" />	</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit" class="submitBtn" /></td>
					</tr>
				</table>
			</td>
		</tr>	
	</table>
	</form:form>
	<hr/>
	<br/>
	<c:if test="${flagSearch}">
	
		<c:if test="${!empty(respItemVO)}">
			<table width="100%">
				<tr>
					<td width="20%">
					 
					</td>
					<td width="80%">
						<table class="tabela">
							<tr>
								<td colspan="2"><span class="texto_destaque">Item recuperado com sucesso!</span></td>
							</tr>
							<tr>
								<td>Nome:</td><td><c:out value="${respItemVO.nome}"/></td>
							</tr>
							<tr>	
								<td>Valor Base ($):</td><td><fmt:formatNumber  value="${respItemVO.valorBase}" type="number" minFractionDigits="2" maxFractionDigits="2"  /></td>
							</tr>
							<tr>	
								<td>Valor Atual ($):</td><td><fmt:formatNumber  value="${respItemVO.valorAtual}" type="number" minFractionDigits="2" maxFractionDigits="2"  /></td>
							</tr>
							<tr>	
								<td>Valor Final ($):</td><td><fmt:formatNumber  value="${respItemVO.valorFinal}" type="number" minFractionDigits="2" maxFractionDigits="2"  /></td>
							</tr>
							<tr>	
								<td>Valor Incremento ($):</td><td><fmt:formatNumber  value="${respItemVO.incremento}" type="number" minFractionDigits="2" maxFractionDigits="2"  /></td>
							</tr>
							<tr>	
								<td>Data Limite:</td><td><fmt:formatDate pattern="dd/MM/yyyy" value="${respItemVO.dataLimite}"/></td>
							</tr>
							<tr>	
								<td>Horário Limite:</td><td><fmt:formatDate pattern="HH:mm:ss" value="${respItemVO.horarioLimite}"/></td>
							</tr>
							<tr>
								<td>Status:</td><td><c:out value="${respItemVO.status}"/></td>
							</tr>
							<tr>
								<td>Usuário (último lance):</td><td><c:out value="${respItemVO.usuario}"/></td>
							</tr>
							
						</table>
					</td>
				</tr>
			</table>			
			
		</c:if>
		<c:if test="${empty(respItemVO)}">
			<table width="100%">
				<tr>
					<td width="20%">
					 
					</td>
					<td width="80%">
						<table class="tabela">
							<tr>
								<td colspan="2"><span class="texto_destaque">Item inexistente.</span></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>			
			
		</c:if>
	</c:if>	
	<hr/>
	<br/>
	
	<center>
		<div>
		@Developed by Samuel Coutinho
		</div>
	</center>
</body>

</html>