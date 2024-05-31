Pros
Puedes extender el comportamiento de un objeto sin crear una nueva subclase.
Puedes añadir o eliminar responsabilidades de un objeto durante el tiempo de ejecución.
Puedes combinar varios comportamientos envolviendo un objeto con varios decoradores.
Principio de responsabilidad única. Puedes dividir una clase monolítica que implementa muchas variantes posibles de comportamiento, en varias clases más pequeñas.


Contras
Resulta difícil eliminar un wrapper específico de la pila de wrappers.
Es difícil implementar un decorador de tal forma que su comportamiento no dependa del orden en la pila de decoradores.
El código de configuración inicial de las capas pueden tener un aspecto desagradable.


Relaciones con otros patrones
Adapter proporciona una interfaz completamente diferente para acceder a un objeto existente. Por otro lado, con el patrón Decorator la interfaz permanece igual o se amplía. Además, Decorator admite la composición recursiva, que no es posible cuando se utiliza Adapter.
Con Adapter se accede a un objeto existente a través de una interfaz diferente. Con Proxy, la interfaz sigue siendo la misma. Con Decorator se accede al objeto a través de una interfaz mejorada.
Chain of Responsibility y Decorator tienen estructuras de clase muy similares. Ambos patrones se basan en la composición recursiva para pasar la ejecución a través de una serie de objetos. Sin embargo, existen varias diferencias fundamentales:
Los manejadores de CoR pueden ejecutar operaciones arbitrarias con independencia entre sí. También pueden dejar de pasar la solicitud en cualquier momento. Por otro lado, varios decoradores pueden extender el comportamiento del objeto manteniendo su consistencia con la interfaz base. Además, los decoradores no pueden romper el flujo de la solicitud.
Composite y Decorator tienen diagramas de estructura similares ya que ambos se basan en la composición recursiva para organizar un número indefinido de objetos.
Un Decorator es como un Composite pero sólo tiene un componente hijo. Hay otra diferencia importante: Decorator añade responsabilidades adicionales al objeto envuelto, mientras que Composite se limita a “recapitular” los resultados de sus hijos.
No obstante, los patrones también pueden colaborar: puedes utilizar el Decorator para extender el comportamiento de un objeto específico del árbol Composite.
Los diseños que hacen un uso amplio de Composite y Decorator a menudo pueden beneficiarse del uso del Prototype. Aplicar el patrón te permite clonar estructuras complejas en lugar de reconstruirlas desde cero.
Decorator te permite cambiar la piel de un objeto, mientras que Strategy te permite cambiar sus entrañas.
Decorator y Proxy tienen estructuras similares, pero propósitos muy distintos. Ambos patrones se basan en el principio de composición, por el que un objeto debe delegar parte del trabajo a otro. La diferencia es que, normalmente, un Proxy gestiona el ciclo de vida de su objeto de servicio por su cuenta, mientras que la composición de los Decoradores siempre está controlada por el cliente.
