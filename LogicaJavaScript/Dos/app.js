// Esta variable es de alcance global
let numeroSecreto = 0;
let intentos = 0;
let numeroSorteados = [];
let numeroMaximo = 10;

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
    asignarTexto('p',`Escoge un número del 1 al ${numeroMaximo}`);
    intentos = 1;
    numeroSecreto = generarNumeroAleatorio();
}

function limpiarCaja(){
    document.getElementById('valorUsuario').value = '';
}

function generarNumeroAleatorio(){
    // Esta variable es de alcance de bloque
    let numeroGenerado = Math.floor(Math.random()*numeroMaximo)+1;
    console.log(numeroGenerado);
    console.log(numeroSorteados);
    if(numeroSorteados.length == numeroMaximo){
        document.getElementById('intentar').setAttribute('disabled', true);
        return asignarTexto('p','Ya se sortearon todos los números posibles');
    }
    if(numeroSorteados.includes(numeroGenerado)){
        return generarNumeroAleatorio();
    }
    else {
        numeroSorteados.push(numeroGenerado);
        return numeroGenerado;
    }
}

condicionesIniciales();