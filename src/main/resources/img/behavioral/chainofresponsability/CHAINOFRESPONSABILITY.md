Pros
Puedes controlar el orden de control de solicitudes.
Principio de responsabilidad única. Puedes desacoplar las clases que invoquen operaciones de las que realicen operaciones.
Principio de abierto/cerrado. Puedes introducir nuevos manejadores en la aplicación sin descomponer el código cliente existente.


Contras
Algunas solicitudes pueden acabar sin ser gestionadas.


Relaciones con otros patrones
Chain of Responsibility, Command, Mediator y Observer abordan distintas formas de conectar emisores y receptores de solicitudes:
    Chain of Responsibility pasa una solicitud secuencialmente a lo largo de una cadena dinámica de receptores potenciales hasta que uno de ellos la gestiona.
    Command establece conexiones unidireccionales entre emisores y receptores.
    Mediator elimina las conexiones directas entre emisores y receptores, forzándolos a comunicarse indirectamente a través de un objeto mediador.
    Observer permite a los receptores suscribirse o darse de baja dinámicamente a la recepción de solicitudes.
    Chain of Responsibility se utiliza a menudo junto a Composite. En este caso, cuando un componente hoja recibe una solicitud, puede pasarla a lo largo de la cadena de todos los componentes padre hasta la raíz del árbol de objetos.
Los manejadores del Chain of Responsibility se pueden implementar como Comandos. En este caso, puedes ejecutar muchas operaciones diferentes sobre el mismo objeto de contexto, representado por una solicitud.
    Sin embargo, hay otra solución en la que la propia solicitud es un objeto Comando. En este caso, puedes ejecutar la misma operación en una serie de contextos diferentes vinculados en una cadena.
Chain of Responsibility y Decorator tienen estructuras de clase muy similares. Ambos patrones se basan en la composición recursiva para pasar la ejecución a través de una serie de objetos. Sin embargo, existen varias diferencias fundamentales:
Los manejadores de CoR pueden ejecutar operaciones arbitrarias con independencia entre sí. También pueden dejar de pasar la solicitud en cualquier momento. Por otro lado, varios decoradores pueden extender el comportamiento del objeto manteniendo su consistencia con la interfaz base. Además, los decoradores no pueden romper el flujo de la solicitud.
 