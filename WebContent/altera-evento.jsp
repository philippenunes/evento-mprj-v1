<%@ include file="cabecalho.jsp"%>

<%
	Evento evento = (Evento) request.getAttribute("objEvento");

	int idevento = evento.getId();
	String solicitante = evento.getSolicitante();
	String telefone = evento.getTelefone();
	String nome = evento.getNomeEvento();
	String data = evento.getDataEvento();
	String local = evento.getLocalEvento();
	String inicio = evento.getHoraInicio();
	String termino = evento.getHoraTermino();
	String presencatecnico = evento.getPresencaTecnico();
	int notebook = evento.getEquipamento().getNotebook();
	int impressora = evento.getEquipamento().getImpressora();
	String acessorede = evento.getAcessoRede();
	int registro = evento.getRegistro();
	String observacao = evento.getObservacao();
%>

<div class="wrap">

	<div class="container-formulario">
		<section class="area-formulario">
			<form class="formulario-de-evento" action="AlteraEvento"
				method="post">
				<table class="table">
					<caption>Formulário de evento</caption>
					<input type="hidden" value=<%=idevento%> name="idevento">
					<tr>
						<td>Nome solicitante</td>
						<td><input required="required" class="form-control"
							type="text" name="solicitante" value="<%=solicitante%>"></td>
					</tr>
					<tr>
						<td>Telefone de contato</td>
						<td><input class="form-control" type="tel" name="telefone"
							value="<%=telefone%>"></td>
					</tr>
					<tr>
						<td>Nome do evento</td>
						<td><input required="required" class="form-control"
							type="text" name="nome" value="<%=nome%>"></td>
					</tr>
					<tr>
						<td>Data</td>
						<td><input required="required" class="form-control"
							type="date" name="data" value="<%=data%>"></td>
					</tr>
					<tr>
						<td>Local</td>
						<td><input required="required" class="form-control"
							type="text" name="local" value="<%=local%>"></td>
					</tr>
					<tr>
						<td>Horario inicio</td>
						<td><input required="required" class="form-control"
							type="text" name="horaInicio" value="<%=inicio%>"></td>
					</tr>
					<tr>
						<td>Horario término</td>
						<td><input class="form-control" type="text"
							name="horaTermino" value="<%=termino%>"></td>
					</tr>
					<tr>
						<td>Presença do técnico</td>
						<td><select name="presencaTecnico">
								<option value="Acionamento Telefone">Acionar por
									telefone</option>
								<option value="Parcial">Parcial/Inicio</option>
								<option value="Integral">Integral</option>
						</select></td>
					</tr>
					<tr>
						<td>&emsp;Notebook&emsp; <select name="notebook">
								<option value="0" <% out.print(notebook == 0 ? "selected" : ""); %>>0</option>
								<option value="1" <% out.print(notebook == 1 ? "selected" : ""); %>>1</option>
								<option value="2" <% out.print(notebook == 2 ? "selected" : ""); %>>2</option>
								<option value="2" <% out.print(notebook == 3 ? "selected" : ""); %>>3</option>
								<option value="4" <% out.print(notebook == 4 ? "selected" : ""); %>>4</option>
								<option value="5" <% out.print(notebook == 5 ? "selected" : ""); %>>5</option>
								<option value="6" <% out.print(notebook == 6 ? "selected" : ""); %>>6</option>
								<option value="7" <% out.print(notebook == 7 ? "selected" : ""); %>>7</option>
								<option value="8" <% out.print(notebook == 8 ? "selected" : ""); %>>8</option>
								<option value="9" <% out.print(notebook == 9 ? "selected" : ""); %>>9</option>
								<option value="10" <% out.print(notebook == 10 ? "selected" : ""); %>>10</option>
								<option value="11" <% out.print(notebook == 11 ? "selected" : ""); %>>11</option>
								<option value="12" <% out.print(notebook == 12 ? "selected" : ""); %>>12</option>
								<option value="13" <% out.print(notebook == 13 ? "selected" : ""); %>>13</option>
								<option value="14" <% out.print(notebook == 14 ? "selected" : ""); %>>14</option>
								<option value="15" <% out.print(notebook == 15 ? "selected" : ""); %>>15</option>
								<option value="16" <% out.print(notebook == 16 ? "selected" : ""); %>>16</option>
								<option value="17" <% out.print(notebook == 17 ? "selected" : ""); %>>17</option>
								<option value="18" <% out.print(notebook == 18 ? "selected" : ""); %>>18</option>
								<option value="19" <% out.print(notebook == 19 ? "selected" : ""); %>>19</option>
								<option value="20" <% out.print(notebook == 20 ? "selected" : ""); %>>20</option>
								<option value="21" <% out.print(notebook == 21 ? "selected" : ""); %>>21</option>
								<option value="22" <% out.print(notebook == 22 ? "selected" : ""); %>>22</option>
								<option value="23" <% out.print(notebook == 23 ? "selected" : ""); %>>23</option>
								<option value="24" <% out.print(notebook == 24 ? "selected" : ""); %>>24</option>
								<option value="25" <% out.print(notebook == 25 ? "selected" : ""); %>>25</option>
								<option value="26" <% out.print(notebook == 26 ? "selected" : ""); %>>26</option>
								<option value="27" <% out.print(notebook == 27 ? "selected" : ""); %>>27</option>
								<option value="28" <% out.print(notebook == 28 ? "selected" : ""); %>>28</option>
								<option value="29" <% out.print(notebook == 29 ? "selected" : ""); %>>29</option>
								<option value="30" <% out.print(notebook == 30 ? "selected" : ""); %>>30</option>
						</select></td>
						<td>&emsp;Impressora&emsp; <select name="impressora">
								<option value="0" <% out.print(impressora == 0 ? "selected" : ""); %>>0</option>
								<option value="1" <% out.print(impressora == 1 ? "selected" : ""); %>>1</option>
								<option value="2" <% out.print(impressora == 2 ? "selected" : ""); %>>2</option>
								<option value="2" <% out.print(impressora == 3 ? "selected" : ""); %>>3</option>
								<option value="4" <% out.print(impressora == 4 ? "selected" : ""); %>>4</option>
								<option value="5" <% out.print(impressora == 5 ? "selected" : ""); %>>5</option>
						</select></td>
					</tr>
					<tr>
						<td>Acesso a rede</td>
						<td><select name="acessoRede">
								<option value="sim">Sim</option>
								<option value="não">Não</option>
						</select></td>
					</tr>
					<tr>
						<td>Registro</td>
						<td><input type="number" name="registro"
							value="<%=registro%>"></td>
					</tr>
					<tr>
						<td>Observações:</td>
						<td><textarea name="observacao"><%=observacao%></textarea></td>
					</tr>
					<tr>
						<td><input type="submit" value="Alterar">
						<td>
					</tr>
				</table>
			</form>
		</section>


		<aside class="area-logo">

			<div class="container-logo">
				<img class="logo" src="imagens/logo_mp.png">
				<div class="titulo">
					<h2>Cadastro de eventos - GMI</h2>
				</div>
			</div>

			<p></p>

		</aside>
	</div>
</div>

<%@ include file="rodape.jsp"%>