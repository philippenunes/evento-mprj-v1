<%@ include file = "cabecalho.jsp" %>
<%@ page import="java.util.List" %>
<%@page import="negocio.Evento"%>
<%@page import="dao.EventoDao"%>
<script language="Javascript">
function confirmacao(codigo) {
     var resposta = confirm("Deseja realmente remover o registro?");

     if (resposta == true) {
          window.location.href = "ExcluiEvento?id="+codigo;
     }
}
</script>   

	<div class="wrap">

		<%
			List<Evento> evento = EventoDao.obterLista(Integer.valueOf(request.getParameter("parametro")));
		%>

		<form class="formulario-lista">
			<div align="center">
			<h2>Lista de eventos GMI</h2>
			</div>
			<table class="table table-bordered table-hover">
				<tr>
					<th><a href="lista-evento.jsp?parametro=1">Evento:</a></th>
					<th>Solicitante:</th>
					<th>Telefone:</th>
					<th><a href="lista-evento.jsp?parametro=3">Data evento:</a></th>
					<th>Local do evento:</th>
					<th>Hor�rio de inicio:</th>
					<th>Hor�rio de t�rmino:</th>
					<th>Presen�a do t�cnico:</th>
					<th><a href="lista-evento.jsp?parametro=2">Registro:</a></th>
					<th>Observa��o:</th>
					<th></th>
				</tr>
				<%
					for (Evento listaEvento : evento) {
				%>
				<tr>
					<td><b><%=listaEvento.getNomeEvento()%></b></td>
					<td><%=listaEvento.getSolicitante()%></td>
					<td><%=listaEvento.getTelefone()%></td>
					<td><b style="color: #FD0303"><%=listaEvento.getDataEvento()%></b></td>
					<td><%=listaEvento.getLocalEvento()%></td>
					<td><%=listaEvento.getHoraInicio()%></td>
					<td><%=listaEvento.getHoraTermino()%></td>
					<td><%=listaEvento.getPresencaTecnico()%></td>
					<td><b style="color: #013ADF"><%=listaEvento.getRegistro()%></b></td>
					<td><%=listaEvento.getObservacao()%></td>

					<td><a class="btn btn-primary btn-sm" href="ObterEvento?codigo=<%=listaEvento.getId()%>">Alterar</a></td>
					<td><a class="btn btn-danger btn-sm" href="javascript:func()" onclick="confirmacao(<%=listaEvento.getId()%>)">Excluir</a></td>
				</tr>
				<%
					}
				%>
			</table>
		</form>
	</div>

	<hr>


<%@ include file = "rodape.jsp" %>