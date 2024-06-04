Pros
Puedes permitir a los clientes que sobrescriban tan solo ciertas partes de un algoritmo grande, para que les afecten menos los cambios que tienen lugar en otras partes del algoritmo.
Puedes colocar el código duplicado dentro de una superclase.


Contras
Algunos clientes pueden verse limitados por el esqueleto proporcionado de un algoritmo.
Puede que violes el principio de sustitución de Liskov suprimiendo una implementación por defecto de un paso a través de una subclase.
Los métodos plantilla tienden a ser más difíciles de mantener cuantos más pasos tengan.


Relaciones con otros patrones
Factory Method es una especialización del Template Method. Al mismo tiempo, un Factory Method puede servir como paso de un gran Template Method.
Template Method se basa en la herencia: te permite alterar partes de un algoritmo extendiendo esas partes en subclases. Strategy se basa en la composición: puedes alterar partes del comportamiento del objeto suministrándole distintas estrategias que se correspondan con ese comportamiento. Template Method trabaja al nivel de la clase, por lo que es estático. Strategy trabaja al nivel del objeto, permitiéndote cambiar los comportamientos durante el tiempo de ejecución.