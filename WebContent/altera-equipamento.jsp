<%@ include file="cabecalho.jsp"%>


<%
	EquipamentoPGJ equipamento = (EquipamentoPGJ) request.getAttribute("objEquipamentoPGJ");

	int idEquipamento = equipamento.getId();
	String tipo = equipamento.getTipo();
	String modelo = equipamento.getModelo();
	String situacao = equipamento.getSituacao();
	int pn = equipamento.getPn();
	String sn = equipamento.getSerial();
	String comentario = equipamento.getComentario();
%>

<div class="wrap">

	<div class="area-formulario">
		<div class="container-formulario">
			<form class="formulario-de-evento" name="f1" action="AlteraEquipamentoPGJ" method="post">
				<table class="table">
					<caption>Formulário de equipamento</caption>
						<input class="form-control" type="hidden" name="id" value=<%=idEquipamento%>>
					<tr>
						<td>Tipo:</td>
						<td><select name=tipo onchange="muda_modelo()">
								<option value="0">Selecione...
								<option value="1" <% out.println(tipo.equals("Desktop") ? "Selected" : ""); %> >Desktop								
								<option value="2" <% out.println(tipo.equals("Notebook") ? "Selected" : ""); %> >Notebook
								<option value="3" <% out.println(tipo.equals("Impressora") ? "Selected" : ""); %> >Impressora
						</select>
						</td>
					</tr>
					<tr>
						<td>Modelo:</td>
						<td>
							<select name=modelo> 
								<option value="<%=modelo%>"><%=modelo%>
							</select>
						</td>
					</tr>
					<tr>
						<td>Situação:</td>
						<td>
							<select name="situacao">
								<option value="0">Selecione...
								<option value="1" <% out.println(situacao.equals("Ativo") ? "Selected" : ""); %>>Ativo
								<option value="2" <% out.println(situacao.equals("Inativo") ? "Selected" : ""); %>>Inativo
						</select>
						</td>
					</tr>
					<tr>
						<td>P/N:</td>
						<td><input placeholder="Patrimônio" required="required"
							class="form-control" type="number" name="pn" value=<%=pn%>></td>
					</tr>
					<tr>
						<td>S/N:</td>
						<td><input placeholder="Nº de série"
							class="form-control" type="text" name="sn" maxlength=30 value=<%=sn%>></td>
					</tr>
						<tr>
						<td>Comentários:</td>
						<td><textarea placeholder="Comentários" class="form-control"
								name="comentario" maxlength=200><%=comentario%></textarea></td>
					</tr>
					<tr>
						<td><input type="submit" value="Alterar"></td>
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