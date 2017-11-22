<%@ include file = "cabecalho.jsp" %>
<%@ page import="java.util.List" %>
<%@page import="negocio.EquipamentoPGJ"%>
<%@page import="dao.EquipamentoPGJDao"%>
<script language="Javascript">
function confirmacao(codigo) {
     var resposta = confirm("Deseja realmente remover o registro?");

     if (resposta == true) {
          window.location.href = "ExcluiEquipamentoPGJ?id="+codigo;
     }
}
</script>   

	<div class="wrap">

		<%
			List<EquipamentoPGJ> equipamento = EquipamentoPGJDao.obterLista(Integer.valueOf(request.getParameter("parametro")));
		%>

		<form class="formulario-lista">
			<div align="center">
			<h2>Lista de equipamentos PGJ</h2>
			</div>
			<table class="table table-bordered table-hover">
				<tr>
					<th><a href="lista-equipamento.jsp?parametro=0">Tipo:</a></th>
					<th><a href="lista-equipamento.jsp?parametro=1">Modelo:</a></th>
					<th>Situação:</th>
					<th>Patrimônio:</th>
					<th>Nº de série:</th>
					<th>Comentário:</th>
					<th></th>
				</tr>
				<%
					for (EquipamentoPGJ listaEquipamento : equipamento) {
				%>
				<tr>
					<td><b><%=listaEquipamento.getTipo()%></b></td>
					<td><%=listaEquipamento.getModelo()%></td>
					<td><%=listaEquipamento.getSituacao()%></td>
					<td><%=listaEquipamento.getPn()%></td>
					<td><%=listaEquipamento.getSerial()%></td>
					<td><%=listaEquipamento.getComentario()%></td>

					<td><a class="btn btn-primary btn-sm" href="ObterEquipamentoPGJ?codigo=<%=listaEquipamento.getId()%>">Alterar</a>
						<a class="btn btn-danger btn-sm" href="javascript:func()" onclick="confirmacao(<%=listaEquipamento.getId()%>)">Excluir</a>
					</td>
				</tr>
				<%
					}
				%>
			</table>
		</form>
	</div>

	<hr>


<%@ include file = "rodape.jsp" %>