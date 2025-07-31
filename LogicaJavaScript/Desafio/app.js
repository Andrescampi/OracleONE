let titulo = document.querySelector('h1');
titulo.innerHTML = "Hora del desafío";

function actividadConsole(){
    alert('el boton fue clicado');
}

function actividadPrompt(){
    let ciudad = prompt("Digite el nombre de una ciudad en Brasil");
    alert(`La ciudad de Brasil escogida por el usuario fue.... ${ciudad}`);
}

function actividadAlert(){
    alert('Amo JS');
}

function actividadSuma(){
    let numeroUno = parseInt(prompt("Digite un número por favor: "));
    let numeroDos = parseInt(prompt("Digite un segundo número por favor: "));
    suma = numeroDos + numeroUno;
    alert(`La suma entre los dos números es: ${suma}`);
}