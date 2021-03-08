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
			    <main role="main" class="container">
					
					<form action="equipamento?op=update" method="post">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputHostname">Hostname</label>
								<input type="hidden" name="op" value="insert">
								<input type="hidden" name="inputId" value="<c:out value='${equipamento.id}' />" />
								<input type="text" class="form-control" name="inputHostname" value="<c:out value='${equipamento.hostname}' />" placeholder="Hostname">
							</div>
							<div class="form-group col-md-6">
								<label for="inputMascara">Mascara</label>
								<input type="text" class="form-control" name="inputMascara"  value="<c:out value='${equipamento.mascara}' />" placeholder="Mascara">
							</div>
							<div class="form-group col-md-6">
								<label for="inputIp1">IP1</label>
								<input type="text" class="form-control" name="inputIp1" value="<c:out value='${equipamento.ip1}' />" placeholder="IP1">
							</div>
							<div class="form-group col-md-6">
								<label for="inputIp2">IP2</label>
								<input type="text" class="form-control" name="inputIp2" value="<c:out value='${equipamento.ip2}' />" placeholder="IP2">
							</div>
							
							<div class="form-group col-md-6">
								<label for="inputDescricao">Descrição</label>
								<textarea class="form-control" name="inputDescricao" rows="3"><c:out value='${equipamento.descricao}' /></textarea>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputGateway">Gateway</label>
								<input type="text" class="form-control" name="inputGateway" value="<c:out value='${equipamento.gateway}' />" placeholder="Gateway">
							</div>
							<div class="form-group col-md-6">
								<label for="inputTipo">Tipo</label>
								<input type="text" class="form-control" name="inputTipo" value="<c:out value='${equipamento.tipo}' />" placeholder="Tipo">
							</div>
							<div class="form-group col-md-6">
								<label for="inputBatismo">Batismo</label>
								<input type="text" class="form-control" name="inputBatismo" value="<c:out value='${equipamento.batismo}' />" placeholder="Batismo">
							</div>
							<div class="form-group col-md-6">
								<label for="inputSerialNumber">Serial Number</label>
								<input type="text" class="form-control" name="inputSerialNumber" value="<c:out value='${equipamento.serialNumber}' />" placeholder="Serial Number">
							</div>
							<div class="form-group col-md-6">
								<label for="inputServico">Serviço</label>
								<input type="text" class="form-control" name="inputServico" value="<c:out value='${equipamento.servico}' />" placeholder="Serviço">
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Enviar</button>
					</form>
			    </main>
			</div>
		</div>
	</div>
</div>
<!-- ======================= FIM BODY =========================== -->
<%@ include file="include/footer.jsp" %>