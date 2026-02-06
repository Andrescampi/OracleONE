# Guía de Uso Rápido - Conversor de Monedas

## Pasos para Ejecutar el Proyecto

### 1. Preparación Inicial

Asegúrate de tener:
- ✅ Java 17 o superior instalado
- ✅ La librería Gson descargada en la carpeta `lib/`

Para verificar tu versión de Java:
```bash
java -version
```

### 2. Descargar Gson

**Opción más simple**: Ve a este enlace y descarga el archivo:
https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar

Coloca el archivo descargado en la carpeta `lib/` del proyecto.

### 3. Compilar

**En Windows:**
- Doble clic en `compilar.bat`
- O ejecuta en CMD: `compilar.bat`

**En Linux/Mac:**
```bash
./compilar.sh
```

**Manual (cualquier sistema):**
```bash
# Windows
javac -cp "lib/gson-2.10.1.jar" -d bin src/modelo/*.java src/servicio/*.java src/principal/*.java

# Linux/Mac
javac -cp "lib/gson-2.10.1.jar" -d bin src/modelo/*.java src/servicio/*.java src/principal/*.java
```

### 4. Ejecutar

**Windows:**
```bash
java -cp "bin;lib/gson-2.10.1.jar" principal.ConversorMonedas
```

**Linux/Mac:**
```bash
java -cp "bin:lib/gson-2.10.1.jar" principal.ConversorMonedas
```

## Ejemplos de Uso

### Ejemplo 1: Convertir USD a Peso Argentino
```
Elija una opción válida: 1
Ingrese el valor que desea convertir: 100
El valor 100.00 [USD] corresponde al valor final de =>>> 10250.50 [ARS]
```

### Ejemplo 2: Convertir Real Brasileño a USD
```
Elija una opción válida: 4
Ingrese el valor que desea convertir: 500
El valor 500.00 [BRL] corresponde al valor final de =>>> 95.50 [USD]
```

### Ejemplo 3: Convertir USD a Peso Colombiano
```
Elija una opción válida: 5
Ingrese el valor que desea convertir: 50
El valor 50.00 [USD] corresponde al valor final de =>>> 196250.00 [COP]
```

## Solución de Problemas

### Error: "Could not find or load main class"
- ✅ Verifica que hayas compilado el proyecto
- ✅ Asegúrate de estar en la carpeta raíz del proyecto
- ✅ Verifica que la ruta al classpath sea correcta (`;` en Windows, `:` en Linux/Mac)

### Error: "NoClassDefFoundError: com/google/gson/Gson"
- ✅ Verifica que `gson-2.10.1.jar` esté en la carpeta `lib/`
- ✅ Asegúrate de incluir `lib/gson-2.10.1.jar` en el classpath al ejecutar

### Error de compilación
- ✅ Verifica que estés usando Java 17 o superior
- ✅ Asegúrate de que todos los archivos `.java` estén en sus carpetas correctas

### Error: "IOException" o "Could not connect to API"
- ✅ Verifica tu conexión a Internet
- ✅ Verifica que la API esté disponible (la URL debe funcionar en el navegador)
- ✅ Verifica que no haya un firewall bloqueando la conexión

## Estructura del Menú

```
************************************************
Sea bienvenido/a al Conversor de Monedas =]
************************************************

1) Dólar >>> Peso argentino        (USD → ARS)
2) Peso argentino >>> Dólar        (ARS → USD)
3) Dólar >>> Real brasileño        (USD → BRL)
4) Real brasileño >>> Dólar        (BRL → USD)
5) Dólar >>> Peso colombiano       (USD → COP)
6) Peso colombiano >>> Dólar       (COP → USD)
7) Salir
```

## Características del Conversor

✨ **Conversiones en tiempo real**: Las tasas se obtienen de la API en cada conversión
✨ **Validación de entrada**: No acepta valores negativos ni entradas inválidas
✨ **Formato claro**: Muestra los resultados con 2 decimales
✨ **Manejo de errores**: Gestiona errores de red, API y entrada del usuario
✨ **Interfaz intuitiva**: Menú simple y fácil de usar

## API Utilizada

El conversor consume datos de ExchangeRate-API:
- **Endpoint**: https://v6.exchangerate-api.com/v6/b8526fe5bd4810c1013a8338/latest/USD
- **Formato**: JSON
- **Actualización**: En tiempo real
- **Moneda base**: USD (Dólar estadounidense)

## Códigos de Moneda

| Código | Moneda                | País        |
|--------|-----------------------|-------------|
| USD    | Dólar estadounidense  | Estados Unidos |
| ARS    | Peso argentino        | Argentina   |
| BRL    | Real brasileño        | Brasil      |
| COP    | Peso colombiano       | Colombia    |

## Próximas Mejoras (Opcionales)

- 🔄 Agregar más monedas
- 📊 Historial de conversiones
- 💾 Guardar conversiones en archivo
- 🌐 Interfaz gráfica
- 📈 Gráficos de tendencias de cambio
