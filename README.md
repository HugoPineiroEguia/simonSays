# simonSays

En este proyecto se recreará el juego "Simon Dice"
en el IDE de AndroidStudio utilizando Kotlin.

En este proyecto aparecerán 5 botones, rojo, azul, amarillo y verde,
que, al pulsar el quinto, se irán iluminando y creando una secuencia
que se hará cada vez más larga en funcion de la ronda en la que
el jugador se encuentre.

Para ello se crean diferentes contadores, y Arrays.
Explicado muy brevemente, lo que hace el proyecto es:

+ Al pulsar el boton "START" se lanza un evento que inicia todo el juego,
crea una secuencia aleatoria de numeros entre 0 y 3, (la primera ronda la secuencia solo tiene un valor)
que se guarda en un Array para dos cosas, la primera que al pasar de ronda la secuancia sea la misma
y se le añada un nuevo valor, y poder comprobar si los botones pulsados son correctos.

+ A continuacion viene la comprobacion, para esto se le asigna a cada boton un numero, al rojo el 0
al azul el 1, al amarillo el 2 y al verde un 3, con esto cada vez que pulsemos
en un boton, el juego comprobará si el numero del boton pulsado coincide con el primer
valor del Array, si el resultado de la comprobacion es True se pasa a comprobar el siguiente valor del
Array hasta que ya no haya mas numeros guardados en la secuencia, aumentando el contador de Ronda,
si el resultado es false todos los valores se igualan a 0 y se reinicia la partida.

Aparte de lo aquí comentado existe un modelo de puntos que funciona en base a la cantidad
de botones pulsados correctamente, para diferenciar a dos jugadores que llegan
a rondas altas, por ejemplo piperden tras superar la ronda 14, pero uno fue capaz de repetir
toda la secuancia a excepcion del ultimo color, y el otro erra en el primero, pues con este sitema
el primer jugador quedar
