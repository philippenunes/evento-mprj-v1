<%@ include file="cabecalho.jsp"%>

<%
	Evento evento = null;
	String msg = null;
	String className = null;
	
	evento = (Evento)request.getAttribute("objEvento");
	
	if(evento != null){
		msg = "Evento cadastrado com successo!";
		className = "alert-success";
	}else{
		msg = "Evento não foi cadastrado!";
		className = "alert-danger";
	}
%>

<div class="wrap">
	
	<p align="center" class="<%=className%>"><%=msg%></p>
	<br>
	<div class="area-formulario">
		<div class="container-formulario">
			<form class="formulario-de-evento" action="InsereEvento"
				method="post">
				<table class="table">
					<caption>Formulário de evento</caption>
					<tr>
						<td>Nome Solicitante</td>
						<td><input required="required" class="form-control"
							type="text" placeholder="Solicitante" name="solicitante"></td>
					</tr>
					<tr>
						<td>Telefone de contato</td>
						<td><input value="(55)-5555-5555" class="form-control"
							type="tel" name="telefone"></td>
					</tr>
					<tr>
						<td>Nome do evento</td>
						<td><input required="required" class="form-control"
							type="text" placeholder="Nome do evento" name="nome"></td>
					</tr>
					<tr>
						<td>Data</td>
						<td><input required="required" class="form-control"
							type="date" placeholder="Data" name="data"></td>
					</tr>
					<tr>
						<td>Local</td>
						<td><input required="required" class="form-control"
							type="text" placeholder="Local" name="local"></td>
					</tr>
					<tr>
						<td>Horario inicio</td>
						<td><input required="required" class="form-control"
							type="text" placeholder="Inicio" name="horaInicio"></td>
					</tr>
					<tr>
						<td>Horario término</td>
						<td><input class="form-control" type="text"
							placeholder="Término" name="horaTermino"></td>
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
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="2">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option>
								<option value="22">22</option>
								<option value="23">23</option>
								<option value="24">24</option>
								<option value="25">25</option>
								<option value="26">26</option>
								<option value="27">27</option>
								<option value="27">28</option>
								<option value="27">29</option>
								<option value="27">30</option>
						</select></td>
						<td>&emsp;Impressora&emsp; <select name="impressora">
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="2">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
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
						<td><input type="number" placeholder="Nº do registro" name="registro"></td>
					</tr>
					<tr>
						<td>Observações:</td>
						<td><textarea placeholder="Informações adicionais" name="observacao"></textarea></td>
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
				<h2>Cadastro de eventos - GMI</h2>
			</div>
		</div>

		<p></p>
	</div>
</div>

<%@ include file="rodape.jsp"%>