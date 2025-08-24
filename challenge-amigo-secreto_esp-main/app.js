// El principal objetivo de este desafío es fortalecer tus habilidades en lógica de programación. Aquí deberás desarrollar la lógica para resolver el problema.
let nombres = [];
let amigos = [];
let nombre;
let listaNombres;
let amigo;
let resultado;
let repetidos = [];
let sorteoTerminado = false;

function agregarNombres(){
    if(sorteoTerminado){
        alert("El sorteo ya finalizó. No puedes agregar más nombres.");
        return;
    }
    nombre = document.getElementById("amigo").value;
   if(onlyString(nombre) == false){
        alert("Debes introducir un valor valido");
        limpiarCaja();
    }
    else{
        nombres.push(nombre);
        mostrarNombre();
        limpiarCaja();        
    }
    console.log(nombres);
}

function onlyString(valor){
    const regex = /^[a-zA-Z]+$/;
    return regex.test(valor);
}

function limpiarCaja(){
    document.getElementById("amigo").value = "";
}

function mostrarNombre(){
    listaNombres = document.querySelector("#listaAmigos");
    listaNombres.innerHTML ="";
    for(amigo of nombres){
        crearElementLi();
    }
}

function crearElementLi(){
    let li = document.createElement("li");
    li.textContent = amigo;
    listaNombres.appendChild(li);
}

function sortearAmigo(){
    if(sorteoTerminado){
        alert("El sorteo finalizó");
        return;
    }
    if(nombres.length === 0){
        alert("Ya no quedan amigos por srotear");
        acabarSorteo();
        return;
    }
    let indice = Math.floor(Math.random()*nombres.length);
    resultado = nombres[indice];
    repetidos.push(resultado);
    nombres.splice(indice, 1)
    mostrarSorteado();
    console.log(resultado);
    console.log(indice);
}

function acabarSorteo(){
    sorteoTerminado = true;
    document.getElementById('btnSorteo').setAttribute('disabled', true);
    document.getElementById('btnAdd').setAttribute('disabled', true);
    let texto = document.getElementById("titulo");
    texto.innerHTML ='Ya se sortearon a todos tus amigos';
}

function mostrarSorteado(){
    listaNombres = document.querySelector("#listaAmigos");
    listaNombres.innerHTML ="";
    let ganador = document.querySelector("#resultado");
    ganador.innerHTML = `Tu amigo secreto es ${resultado}`;
    if(nombres.length === 0){
        acabarSorteo();
    }
}

