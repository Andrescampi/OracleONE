// Esta variable es de alcance global
let numeroSecreto = 0;
let intentos = 0;

function asignarTexto(elemento, texto){
    let elementoHTML = document.querySelector(elemento);
    elementoHTML.innerHTML = texto;
    return;
}

function verificarIntento(){
    let numeroUsuario = parseInt(document.getElementById('valorUsuario').value);
    if(numeroSecreto === numeroUsuario){
        asignarTexto('p',`Felicitaciones, adivinaste el número secreto en ${intentos} ${(intentos === 1)? "intento" : "intentos"}`);
        document.getElementById('reiniciar').removeAttribute('disabled');
    }
    else{
        if(numeroSecreto > numeroUsuario){
        asignarTexto('p','El número secreto es mayor');
        }
        else{
        asignarTexto('p','El número secreto es menor');
        }
        intentos++;
        limpiarCaja();
        console.log(intentos); 
    }
    return;
}

function nuevoJuego(){
    limpiarCaja();
    condicionesIniciales()
    document.getElementById('reiniciar').setAttribute('disabled', true);
}

function condicionesIniciales(){
    asignarTexto('h1','Juego del número secreto');
    asignarTexto('p','Escoge un número del 1 al 10');
    intentos = 1;
    numeroSecreto = generarNumeroAleatorio();
}

function limpiarCaja(){
    document.getElementById('valorUsuario').value = '';
}

function generarNumeroAleatorio(){
    // Esta variable es de alcance de bloque
    return Math.floor(Math.random()*10)+1;;
}

condicionesIniciales();