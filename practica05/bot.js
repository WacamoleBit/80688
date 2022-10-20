var msj_bot = {
    saludo: "Hola",
    despedida: "Adios",
    preocupacion: "Cómo estás?",
    sorpresa: "Orale!"
}

var arr_msj = ["Hola", "Adios", "Cómo estás?", "Orale!"]

function test() {
    let mensajes = document.getElementById("msjs")
    mensajes.innerHTML = arr_msj
    mensajes.innerHTML = msj_bot
    mensajes.innerHTML = JSON.stringify(msj_bot)
}

function responder(){
    let valor = document.getElementById("msj").value
    console.log(woz(valor))
    let mensajes = document.getElementById("msjs")
    mensajes.innerHTML = msj_bot[woz(valor)]
}

function woz(params) {
    if (params == "hola") {
        return "saludo"
    }
    if (params == "me siento mal") {
        return "sorpresa"
    }
    if (params == "adios") {
        return "despedida"
    }
    if (params == "") {
        return "preocupacion"
    }
}