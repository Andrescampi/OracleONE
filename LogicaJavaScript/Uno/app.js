// Variables - Así se puede comentar un codigo o /**/
// Definimos nuestra variable de número secreto y la del número del usuario

let nivel = parseInt(prompt("Que nivel de dificultad quisieras jugar? 1, 2 o 3: "));
if(nivel == 1){
    let numeroSecreto = Math.floor(Math.random()*10)+1;
    let numeroUsuario;
    let intentos = 0;
    while(numeroUsuario != numeroSecreto){
         numeroUsuario = parseInt(prompt("Me indicas un número entre 1 y 10 por favor?"));
        console.log(numeroUsuario);
        intentos++;

        if (numeroSecreto == numeroUsuario){
        alert(`Acertaste el número secreto: ${numeroUsuario}`);
        alert(`Lo hiciste en ${intentos} ${intentos == 1 ? "vez" : "veces"}`);
        }
        else{
            if(numeroUsuario > numeroSecreto) {
                alert(`El número secreto es menor`);
            }
            else{
                alert(`El número secreto es mayor`);
            }

            if(intentos >= 3){
                alert(`Ya superaste el número de intentos`);
                break;
            }
        };
    }
}
else if(nivel == 2){
    let numeroSecreto = Math.floor(Math.random()*100)+1;
    let numeroUsuario;
    let intentos = 0;
    while(numeroUsuario != numeroSecreto){
         numeroUsuario = parseInt(prompt("Me indicas un número entre 1 y 100 por favor?"));
        console.log(numeroUsuario);
        intentos++;

        if (numeroSecreto == numeroUsuario){
        alert(`Acertaste el número secreto: ${numeroUsuario}`);
        alert(`Lo hiciste en ${intentos} ${intentos == 1 ? "vez" : "veces"}`);
        }
        else{
            if(numeroUsuario > numeroSecreto) {
                alert(`El número secreto es menor`);
            }
            else{
                alert(`El número secreto es mayor`);
            }

            if(intentos >= 3){
                alert(`Ya superaste el número de intentos`);
                break;
            }
        };
    }
}
else if(nivel == 3){
    let numeroSecreto = Math.floor(Math.random()*1000)+1;
    let numeroUsuario;
    let intentos = 0;
    while(numeroUsuario != numeroSecreto){
         numeroUsuario = parseInt(prompt("Me indicas un número entre 1 y 1000 por favor?"));
        console.log(numeroUsuario);
        intentos++;

        if (numeroSecreto == numeroUsuario){
        alert(`Acertaste el número secreto: ${numeroUsuario}`);
        alert(`Lo hiciste en ${intentos} ${intentos == 1 ? "vez" : "veces"}`);
        }
        else{
            if(numeroUsuario > numeroSecreto) {
                alert(`El número secreto es menor`);
            }
            else{
                alert(`El número secreto es mayor`);
            }

            if(intentos >= 3){
                alert(`Ya superaste el número de intentos`);
                break;
            }
        };
    }
}
