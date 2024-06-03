Pros
Puedes ahorrar mucha RAM, siempre que tu programa tenga toneladas de objetos similares.


Contras
Puede que estés cambiando RAM por ciclos CPU cuando deba calcularse de nuevo parte de la información de contexto cada vez que alguien invoque un método flyweight.
El código se complica mucho. Los nuevos miembros del equipo siempre estarán preguntándose por qué el estado de una entidad se separó de tal manera.


Relaciones con otros patrones
Puedes implementar nodos de hoja compartidos del árbol Composite como Flyweights para ahorrar memoria RAM.
Flyweight muestra cómo crear muchos pequeños objetos, mientras que Facade muestra cómo crear un único objeto que represente un subsistema completo.
Flyweight podría asemejarse a Singleton si de algún modo pudieras reducir todos los estados compartidos de los objetos a un único objeto flyweight. Pero existen dos diferencias fundamentales entre estos patrones:
    Solo debe haber una instancia Singleton, mientras que una clase Flyweight puede tener varias instancias con distintos estados intrínsecos.
    El objeto Singleton puede ser mutable. Los objetos flyweight son inmutables.