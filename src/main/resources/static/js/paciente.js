var DNI = JSON.parse(sessionStorage.getItem("data"));
var recurso = "http://localhost:8080/citasPaciente";
var data = {
	dni : DNI,

};
data = JSON.stringify(data);
setTimeout($.ajax({
	url : recurso,
	type : "POST",
	data : data,
	xhrFields : {
		withCredentials : true
	},
	headers : {
		'Content-Type' : 'application/json'
	},
}).done(function(data, textStatus, jqXHR) {

	if (data.type == "OK") {
		console.log("FUNCIONA");

		var datos = [];
		for (var i = 0; i < (data.numero); i++) {

			datos[i] = data['cita' + i].fecha;
		}
		mostrarContenido(datos);
	}

}), 10000);

/*
 * var datos = [cita1 :{ "fecha": "12/05/19", "hora": "15:01", "centroDeSalud":
 * "LA SOLANA", "especialidad": " ONCOLOGÍA", }, { "fecha": "12/12/19", "hora":
 * "15:41", "centroDeSalud": "MANZANARES", "especialidad": " ONCOLOGÍA", }, {
 * "fecha": "11/05/19", "hora": "05:01", "centroDeSalud": "TOLEDO",
 * "especialidad": " ONCOLOGÍA", }, { "fecha": "12/05/29", "hora": "12:01",
 * "centroDeSalud": "CIUDAD REAL", "especialidad": " ONCOLOGÍA", } ];
 */

function mostrarContenido(datos) {
	var cuerpo = "";
	var cabecera = '<tr>' + '<th>FECHA</th>' + '<th>DNI PACIENTE</th>'
			+ '<th>ESPECIALIDAD</th>' + '</tr>';

	for (var i = 0; i < datos.length; i++) {
		var contenido = (datos[i])['fecha'];
		cuerpo += '<tr>' + '<td>' + datos[i] + '</td>' + '<td>'
				+ datos[i].dniPaciente + '</td>' + '<td>' + datos[i].dniMedico
				+ '</td>' + '</tr>';
	}
	$("#tablaCabecera").append(cabecera);
	$("#tablaCuerpo").append(cuerpo);
}