<%@ include file="cabecalho.jsp"%>

<%
	EquipamentoPGJ equipamento = null;
	String msg = null;
	String className = null;
	
	equipamento = (EquipamentoPGJ)request.getAttribute("objEquipamentoPGJ");
	
	if (equipamento != null){
		msg = "Equipamento cadastrado com sucesso!";
		className = "alert-success";
	}else{
		msg = "Equipamento n�o foi cadastrado!";
		className = "alert-danger";
	}
%>

<div class="wrap">

	<p align="center" class="<%=className%>"><%=msg%></p>
	<br>
	<div class="area-formulario">
		<div class="container-formulario">
			<form class="formulario-de-evento" name="f1"
				action="InsereEquipamentoPGJ" method="post">
				<table class="table">
					<caption>Formul�rio de equipamento</caption>
					<tr>
						<td>Tipo:</td>
						<td><select name=tipo onchange="muda_modelo()">
								<option value="0" selected>Selecione...
								<option value="1">Desktop
								<option value="2">Notebook
								<option value="3">Impressora
								<option value="4">Monitor
						</select></td>
					</tr>
					<tr>
						<td>Modelo:</td>
						<td><select name=modelo>
								<option value="-">-
						</select></td>
					</tr>
					<tr>
						<td>Situa��o:</td>
						<td><select name="situacao">
								<option value="0" selected>Selecione...
								<option value="1">Ativo
								<option value="2">Inativo
						</select></td>
					</tr>
					<tr>
						<td>P/N:</td>
						<td><input placeholder="Patrim�nio" required="required"
							class="form-control" type="number" name="pn" max="999999"></td>
					</tr>
					<tr>
						<td>S/N:</td>
						<td><input placeholder="N� de s�rie" class="form-control"
							type="text" name="sn" maxlength=30></td>
					</tr>
					<tr>
						<td>Coment�rios:</td>
						<td><textarea placeholder="Coment�rios" class="form-control"
								name="comentario" maxlength=200></textarea></td>
					</tr>
					<tr>
						<td><input type="submit" value="Cadastrar">
						<td>
					</tr>
				</table>
			</form>
		</div>

		<div class="container-logo">
			<img class="logo" src="imagens/logo_mp.png">
			<div class="titulo">
				<h2>Cadastro Equipamento - PGJ</h2>
			</div>
		</div>

		<p></p>
	</div>
</div>

<%@ include file="rodape.jsp"%>