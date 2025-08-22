// El principal objetivo de este desafío es fortalecer tus habilidades en lógica de programación. Aquí deberás desarrollar la lógica para resolver el problema.
let nombres = [];
let amigos = [];
let nombre;

function agregarNombres(){
    nombre = document.getElementById("amigo").value;
    if(nombre.trim() === ""){
        alert("Debes introducir un valor");
    }
    else{
        nombres.push(nombre);
        limpiarCaja();        
    }
    limpiarCaja();
    console.log(nombres);
}

function limpiarCaja(){
    document.getElementById("amigo").value = "";
}

function mostrarNombre(){
}