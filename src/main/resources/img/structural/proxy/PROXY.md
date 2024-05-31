Pros
Puedes controlar el objeto de servicio sin que los clientes lo sepan.
Puedes gestionar el ciclo de vida del objeto de servicio cuando a los clientes no les importa.
El proxy funciona incluso si el objeto de servicio no está listo o no está disponible.
Principio de abierto/cerrado. Puedes introducir nuevos proxies sin cambiar el servicio o los clientes.


Contras
El código puede complicarse ya que debes introducir gran cantidad de clases nuevas.
La respuesta del servicio puede retrasarse.


Relaciones con otros patrones
Con Adapter se accede a un objeto existente a través de una interfaz diferente. Con Proxy, la interfaz sigue siendo la misma. Con Decorator se accede al objeto a través de una interfaz mejorada.
Facade es similar a Proxy en el sentido de que ambos pueden almacenar temporalmente una entidad compleja e inicializarla por su cuenta. Al contrario que Facade, Proxy tiene la misma interfaz que su objeto de servicio, lo que hace que sean intercambiables.
Decorator y Proxy tienen estructuras similares, pero propósitos muy distintos. Ambos patrones se basan en el principio de composición, por el que un objeto debe delegar parte del trabajo a otro. La diferencia es que, normalmente, un Proxy gestiona el ciclo de vida de su objeto de servicio por su cuenta, mientras que la composición de los Decoradores siempre está controlada por el cliente.
