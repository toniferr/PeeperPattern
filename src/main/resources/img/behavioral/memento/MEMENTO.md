Pros
Puedes producir instantáneas del estado del objeto sin violar su encapsulación.
Puedes simplificar el código de la originadora permitiendo que la cuidadora mantenga el historial del estado de la originadora.


Ccontras
La aplicación puede consumir mucha memoria RAM si los clientes crean mementos muy a menudo.
Las cuidadoras deben rastrear el ciclo de vida de la originadora para poder destruir mementos obsoletos.
La mayoría de los lenguajes de programación dinámicos, como PHP, Python y JavaScript, no pueden garantizar que el estado dentro del memento se mantenga intacto.


Relaciones con otros patrones
Puedes utilizar Command y Memento juntos cuando implementes “deshacer”. En este caso, los comandos son responsables de realizar varias operaciones sobre un objeto destino, mientras que los mementos guardan el estado de ese objeto justo antes de que se ejecute el comando.
Puedes usar Memento junto con Iterator para capturar el estado de la iteración actual y reanudarla si fuera necesario.
En ocasiones, Prototype puede ser una alternativa más simple al patrón Memento. Esto funciona si el objeto cuyo estado quieres almacenar en el historial es suficientemente sencillo y no tiene enlaces a recursos externos, o estos son fáciles de restablecer.
