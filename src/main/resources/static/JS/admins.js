function taerAdmins() {
    $.ajax({
        url: "",
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            pintarAdmins(respuesta)
        },
        error: function (respuesta, xhr) {
            alert("Error de peticio");
        }

    });

}

function pintarAdmins(datos) {
    let html = "";
    html += "<thead>";
    html += "<tr>"
    html += "<th><Nombre</th>"
    html += "<th><Correo</th>"
    html += "<th><Accion</th>"
    html += "<tr>"
    html += "<thead>";

    html += "<tbody>"
    for (dato of datos) {
        html += "<tr>"
        html += "<td>" + dato.name + "</td>";
        html += "<td>" + dato.email + "</td>";
        html += "<td><button class= 'btn btn-danger' onclick= 'eliminarAdmin(" + dato.idAdmin + ")'>Eliminar </button></td>";
        html += "<tr>"
    }
    html += "</tbody>"

    $("#tablaAdmins").html(html);
}

function guardarAdmin() {
    let datos = {
        name: $("#nombre").val(),
        email: $("#email").val(),
        password: $("#password").val(),
    }

    let dataToSend = JSON.stringify(datos);
    $.ajax({
        url: "",
        type: 'GET',
        dataType: 'json',
        CcontentType: 'aplication/json',
        success: function (respuesta) {
            $("#nombre").val(),
                $("#email").val(),

                traerAdmins(respuesta)
        },
        error: function (respuesta, xhr) {
            alert("Error de peticio");
        }
    });
}

function eliminarAdmin(respuesta, xhr) {
    $.ajax({
        url: "",
        type: 'DELETE',
        success: function (respuesta) {
            traerAdmins();
        },
        error: function (respuesta, xhr) {
            alert("Error de peticio");
        }
    });
}