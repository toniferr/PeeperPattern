Pros
Principio de abierto/cerrado. Puedes introducir un nuevo comportamiento que puede funcionar con objetos de clases diferentes sin cambiar esas clases.
Principio de responsabilidad única. Puedes tomar varias versiones del mismo comportamiento y ponerlas en la misma clase.
Un objeto visitante puede acumular cierta información útil mientras trabaja con varios objetos. Esto puede resultar útil cuando quieras atravesar una compleja estructura de objetos, como un árbol de objetos, y aplicar el visitante a cada objeto de esa estructura.


Contras
Debes actualizar todos los visitantes cada vez que una clase se añada o elimine de la jerarquía de elementos.
Los visitantes pueden carecer del acceso necesario a los campos y métodos privados de los elementos con los que se supone que deben trabajar.


Relaciones con otros patrones
Puedes tratar a Visitor como una versión potente del patrón Command. Sus objetos pueden ejecutar operaciones sobre varios objetos de distintas clases.
Puedes utilizar el patrón Visitor para ejecutar una operación sobre un árbol Composite entero.
Puedes utilizar Visitor junto con Iterator para recorrer una estructura de datos compleja y ejecutar alguna operación sobre sus elementos, incluso aunque todos tengan clases distintas.