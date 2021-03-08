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
					
					<form action="equipamento" method="post">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputHostname">Hostname</label>
								<input type="hidden" name="op" value="insert">
								<input type="text" class="form-control" name="inputHostname" value="ramon-pc" placeholder="Hostname">
							</div>
							<div class="form-group col-md-6">
								<label for="inputMascara">Mascara</label>
								<input type="text" class="form-control" name="inputMascara"  value="255.255.255.0" placeholder="Mascara">
							</div>
							<div class="form-group col-md-6">
								<label for="inputIp1">IP1</label>
								<input type="text" class="form-control" name="inputIp1" value="192.168.0.10" placeholder="IP1">
							</div>
							<div class="form-group col-md-6">
								<label for="inputIp2">IP2</label>
								<input type="text" class="form-control" name="inputIp2" value="192.168.0.10" placeholder="IP2">
							</div>
							
							<div class="form-group col-md-6">
								<label for="inputDescricao">Descrição</label>
								<textarea class="form-control" name="inputDescricao" rows="3">Meu PC</textarea>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputGateway">Gateway</label>
								<input type="text" class="form-control" name="inputGateway" value="192.168.0.1" placeholder="Gateway">
							</div>
							<div class="form-group col-md-6">
								<label for="inputTipo">Tipo</label>
								<input type="text" class="form-control" name="inputTipo" value="Fisica" placeholder="Tipo">
							</div>
							<div class="form-group col-md-6">
								<label for="inputBatismo">Batismo</label>
								<input type="text" class="form-control" name="inputBatismo" value="123456" placeholder="Batismo">
							</div>
							<div class="form-group col-md-6">
								<label for="inputSerialNumber">Serial Number</label>
								<input type="text" class="form-control" name="inputSerialNumber" value="12345679" placeholder="Serial Number">
							</div>
							<div class="form-group col-md-6">
								<label for="inputServico">Serviço</label>
								<input type="text" class="form-control" name="inputServico" value="Desktop" placeholder="Serviço">
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