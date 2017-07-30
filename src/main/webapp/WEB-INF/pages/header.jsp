<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<center><h1>Leilão Virtual - Flowinn</h1></center>
	<br/>
	<hr/>
	<br/>
	<c:if test="${fn:length(valErrors) > 0}">
		<div>
			<c:forEach var="valError" items="${valErrors}" varStatus="err">
				<c:if test="${err.index > 0}">
					<br />
				</c:if>
				<span class="texto_destaque"> - ERRO: <c:out value="${valError.defaultMessage}" escapeXml="false" /></span>
			</c:forEach>
		</div>
	</c:if>