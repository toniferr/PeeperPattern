Pros
Puedes intercambiar algoritmos usados dentro de un objeto durante el tiempo de ejecución.
Puedes aislar los detalles de implementación de un algoritmo del código que lo utiliza.
Puedes sustituir la herencia por composición.
Principio de abierto/cerrado. Puedes introducir nuevas estrategias sin tener que cambiar el contexto.


Contras
Si sólo tienes un par de algoritmos que raramente cambian, no hay una razón real para complicar el programa en exceso con nuevas clases e interfaces que vengan con el patrón.
Los clientes deben conocer las diferencias entre estrategias para poder seleccionar la adecuada.
Muchos lenguajes de programación modernos tienen un soporte de tipo funcional que te permite implementar distintas versiones de un algoritmo dentro de un grupo de funciones anónimas. Entonces puedes utilizar estas funciones exactamente como habrías utilizado los objetos de estrategia, pero sin saturar tu código con clases e interfaces adicionales.


Relaciones con otros patrones
Bridge, State, Strategy (y, hasta cierto punto, Adapter) tienen estructuras muy similares. De hecho, todos estos patrones se basan en la composición, que consiste en delegar trabajo a otros objetos. Sin embargo, todos ellos solucionan problemas diferentes. Un patrón no es simplemente una receta para estructurar tu código de una forma específica. También puede comunicar a otros desarrolladores el problema que resuelve.
Command y Strategy pueden resultar similares porque puedes usar ambos para parametrizar un objeto con cierta acción. No obstante, tienen propósitos muy diferentes.
    Puedes utilizar Command para convertir cualquier operación en un objeto. Los parámetros de la operación se convierten en campos de ese objeto. La conversión te permite aplazar la ejecución de la operación, ponerla en cola, almacenar el historial de comandos, enviar comandos a servicios remotos, etc.
    Por su parte, Strategy normalmente describe distintas formas de hacer lo mismo, permitiéndote intercambiar estos algoritmos dentro de una única clase contexto.
Decorator te permite cambiar la piel de un objeto, mientras que Strategy te permite cambiar sus entrañas.
Template Method se basa en la herencia: te permite alterar partes de un algoritmo extendiendo esas partes en subclases. Strategy se basa en la composición: puedes alterar partes del comportamiento del objeto suministrándole distintas estrategias que se correspondan con ese comportamiento. Template Method trabaja al nivel de la clase, por lo que es estático. Strategy trabaja al nivel del objeto, permitiéndote cambiar los comportamientos durante el tiempo de ejecución.
State puede considerarse una extensión de Strategy. Ambos patrones se basan en la composición: cambian el comportamiento del contexto delegando parte del trabajo a objetos ayudantes. Strategy hace que estos objetos sean completamente independientes y no se conozcan entre sí. Sin embargo, State no restringe las dependencias entre estados concretos, permitiéndoles alterar el estado del contexto a voluntad.
