<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="include/header.jsp" %>
<%@ include file="include/menu.jsp" %>
<!-- ======================= INICIO BODY =========================== -->

<div class="pcoded-content">
    <div class="pcoded-inner-content">
		<div class="main-body">
			<div class="page-wrapper">
				<!-- Begin page content -->
				<div class="card">
			    	<main role="main" class="container">
						<table class="table table-hover">
							<thead>
								<tr>
								<th scope="col">#</th>
								<th scope="col">HOST</th>
								<th scope="col">MASCARA</th>
								<th scope="col">IP1</th>
								<th scope="col">#</th>
								<th scope="col">#</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="equipamento" items="${listEquipamento}">
									<tr>
										<th scope="row"><c:out value="${equipamento.id}" /></th>
										<td><c:out value="${equipamento.hostname}" /></td>
										<td><c:out value="${equipamento.mascara}" /></td>
										<td><c:out value="${equipamento.ip1}" /></td>

										<td>
											<a href="equipamento?op=edit&id=<c:out value='${equipamento.id}' />">Edit</a>
										</td> 
										<td>
											<a href="#" onclick="confirmExclusao(<c:out value='${equipamento.id}' />)">Delete</a>
											<!-- <a href="equipamento?op=delete&id=<c:out value='${equipamento.id}' />">Delete</a>   -->       
										</td>
										<!-- <form action="" method="post"> 
										     	<input type="hidden" value="Excluir" onclick="confirmExclusao()" /> 
										 		<input type="button" value="Excluir" class="FormBotao" onclick="confirmExclusao()" /> 
										</form> -->

									</tr>
								</c:forEach>
							</tbody>
						</table>
			    	</main>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- ======================= FIM BODY =========================== -->
<%@ include file="include/footer.jsp" %>
