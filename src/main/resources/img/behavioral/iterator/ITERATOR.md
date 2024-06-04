Pros
Principio de responsabilidad única. Puedes limpiar el código cliente y las colecciones extrayendo algoritmos de recorrido voluminosos y colocándolos en clases independientes.
Principio de abierto/cerrado. Puedes implementar nuevos tipos de colecciones e iteradores y pasarlos al código existente sin descomponer nada.
Puedes recorrer la misma colección en paralelo porque cada objeto iterador contiene su propio estado de iteración.
Por la misma razón, puedes retrasar una iteración y continuar cuando sea necesario.


Contras
Aplicar el patrón puede resultar excesivo si tu aplicación funciona únicamente con colecciones sencillas.
Utilizar un iterador puede ser menos eficiente que recorrer directamente los elementos de algunas colecciones especializadas.


Relaciones con otros patrones
Puedes utilizar Iteradores para recorrer árboles Composite.
Puedes utilizar el patrón Factory Method junto con el Iterator para permitir que las subclases de la colección devuelvan distintos tipos de iteradores que sean compatibles con las colecciones.
Puedes usar Memento junto con Iterator para capturar el estado de la iteración actual y reanudarla si fuera necesario.
Puedes utilizar Visitor junto con Iterator para recorrer una estructura de datos compleja y ejecutar alguna operación sobre sus elementos, incluso aunque todos tengan clases distintas.
