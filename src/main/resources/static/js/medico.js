var DNI = JSON.parse(sessionStorage.getItem("data"));
var recurso = "http://localhost:8080/consultaEspecialidades";
var datosNombre = [];
var datosDuracion = [];
var datosHoraInicio = [];
var datosHoraFin = [];

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
        console.log(datosNombre[i]);
        for (var i = 0; i < (data.numero); i++) {
            datosNombre[i] = data['nombreEspecialidad' + i];
            datosDuracion[i] = data['duracionCita'+ i];
            datosHoraInicio[i] = data['horaInicio' + i];
            datosHoraFin[i] = data['horaFin' + i];
        }
        mostrarEspecialidades(datosNombre);
    }
}), 10000);

function mostrarEspecialidades(datosNombre) {
    var select_especialidades = "";

    for (var i = 0; i < datosNombre.length; i++) {
        select_especialidades += '<option>' + datosNombre[i] + '</option>';
    }
    $("#selectEspecialidad").append(select_especialidades);
}

function crearMedico() {
  var dni = document.getElementById("dni").value;
  var especialidad = document.getElementById("especialidad").value;
  var DNI = JSON.parse(sessionStorage.getItem("data"));

  var recurso = "http://localhost:8080/crearMedico";
  var data = {
      type: "medico",
      dni: dni,
      especialidad: especialidad
  };
  data = JSON.stringify(data);
  setTimeout($.ajax({
    url: recurso,
    type: "POST",
    data: data,
    xhrFields: {
        withCredentials: true
    },
    headers: {
        'Content-Type': 'application/json'
    },
  })
  .done(function(data, textStatus, jqXHR) {
    console.log(data.type);
    if (data.type == "OK") {
        setTimeout(location.href = 'http://localhost:8080/gestor', 10000);
    } else {
        if (data.type="error") {
            alert("Error al crear el médico, contacte con el servicio de soporte.");
        }
    }
  }), 10000);
}
