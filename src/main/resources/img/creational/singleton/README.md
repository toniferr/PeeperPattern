### Propósito
Singleton es un patrón de diseño creacional que nos permite asegurarnos de que una clase tenga una única instancia, a la vez que proporciona un punto de acceso global a dicha instancia.

### Problema
El patrón Singleton resuelve dos problemas al mismo tiempo, vulnerando el Principio de responsabilidad única:

1. Garantizar que una clase tenga una única instancia. ¿Por qué querría alguien controlar cuántas instancias tiene una clase? El motivo más habitual es controlar el acceso a algún recurso compartido, por ejemplo, una base de datos o un archivo.
Funciona así: imagina que has creado un objeto y al cabo de un tiempo decides crear otro nuevo. En lugar de recibir un objeto nuevo, obtendrás el que ya habías creado.
Ten en cuenta que este comportamiento es imposible de implementar con un constructor normal, ya que una llamada al constructor siempre debe devolver un nuevo objeto por diseño.
2. Proporcionar un punto de acceso global a dicha instancia. ¿Recuerdas esas variables globales que utilizaste (bueno, sí, fui yo) para almacenar objetos esenciales? Aunque son muy útiles, también son poco seguras, ya que cualquier código podría sobrescribir el contenido de esas variables y descomponer la aplicación.
Al igual que una variable global, el patrón Singleton nos permite acceder a un objeto desde cualquier parte del programa. No obstante, también evita que otro código sobreescriba esa instancia.
Este problema tiene otra cara: no queremos que el código que resuelve el primer problema se encuentre disperso por todo el programa. Es mucho más conveniente tenerlo dentro de una clase, sobre todo si el resto del código ya depende de ella.

Hoy en día el patrón Singleton se ha popularizado tanto que la gente suele llamar singleton a cualquier patrón, incluso si solo resuelve uno de los problemas antes mencionados.

### Solución
Todas las implementaciones del patrón Singleton tienen estos dos pasos en común:
- Hacer privado el constructor por defecto para evitar que otros objetos utilicen el operador new con la clase Singleton.
- Crear un método de creación estático que actúe como constructor. Tras bambalinas, este método invoca al constructor privado para crear un objeto y lo guarda en un campo estático. Las siguientes llamadas a este método devuelven el objeto almacenado en caché.
Si tu código tiene acceso a la clase Singleton, podrá invocar su método estático. De esta manera, cada vez que se invoque este método, siempre se devolverá el mismo objeto.

### Analogía en el mundo real
El gobierno es un ejemplo excelente del patrón Singleton. Un país sólo puede tener un gobierno oficial. Independientemente de las identidades personales de los individuos que forman el gobierno, el título “Gobierno de X” es un punto de acceso global que identifica al grupo de personas a cargo.

### Cómo implementarlo
1. Añade un campo estático privado a la clase para almacenar la instancia Singleton.
2. Declara un método de creación estático público para obtener la instancia Singleton.
3. Implementa una inicialización diferida dentro del método estático. Debe crear un nuevo objeto en su primera llamada y colocarlo dentro del campo estático. El método deberá devolver siempre esa instancia en todas las llamadas siguientes.
4. Declara el constructor de clase como privado. El método estático de la clase seguirá siendo capaz de invocar al constructor, pero no a los otros objetos.
5. Repasa el código cliente y sustituye todas las llamadas directas al constructor de la instancia Singleton por llamadas a su método de creación estático.

### Pros
- Puedes tener la certeza de que una clase tiene una única instancia.
- Obtienes un punto de acceso global a dicha instancia.
- El objeto Singleton solo se inicializa cuando se requiere por primera vez.

### Contras
- Vulnera el Principio de responsabilidad única. El patrón resuelve dos problemas al mismo tiempo.
- El patrón Singleton puede enmascarar un mal diseño, por ejemplo, cuando los componentes del programa saben demasiado los unos sobre los otros.
- El patrón requiere de un tratamiento especial en un entorno con múltiples hilos de ejecución, para que varios hilos no creen un objeto Singleton varias veces.
- Puede resultar complicado realizar la prueba unitaria del código cliente del Singleton porque muchos frameworks de prueba dependen de la herencia a la hora de crear objetos simulados (mock objects). Debido a que la clase Singleton es privada y en la mayoría de los lenguajes resulta imposible sobrescribir métodos estáticos, tendrás que pensar en una manera original de simular el Singleton. O, simplemente, no escribas las pruebas. O no utilices el patrón Singleton.

### Relaciones con otros patrones
- Una clase fachada a menudo puede transformarse en una Singleton, ya que un único objeto fachada es suficiente en la mayoría de los casos.
- Flyweight podría asemejarse a Singleton si de algún modo pudieras reducir todos los estados compartidos de los objetos a un único objeto flyweight. Pero existen dos diferencias fundamentales entre estos patrones:
  - Solo debe haber una instancia Singleton, mientras que una clase Flyweight puede tener varias instancias con distintos estados intrínsecos.
  - El objeto Singleton puede ser mutable. Los objetos flyweight son inmutables.
- Los patrones Abstract Factory, Builder y Prototype pueden todos ellos implementarse como Singletons.


### SINGLETON EN SPRING

#### En resumen:
- Beans de aplicación: Se crea una sola instancia por aplicación y se comparte entre todos los componentes.
- Beans de sesión: Se crea una sola instancia por sesión de usuario y se comparte entre todos los componentes de la sesión.
- Beans de infraestructura: Se crea una sola instancia para proporcionar servicios esenciales a la aplicación.
- Beans personalizados: Puede definir el alcance como "singleton" para beans que representan recursos compartidos o que tienen un estado que debe mantenerse entre diferentes solicitudes.

#### Ventajas:
- Simplifica el desarrollo: No tiene que preocuparse por crear y destruir instancias de beans manualmente.
- Mejora el rendimiento: Evita la sobrecarga de crear y destruir instancias repetidamente.
- Reduce el uso de memoria: Comparte instancias de beans entre diferentes componentes.

#### Desventajas:
- Problemas de concurrencia: Si no se diseña cuidadosamente, pueden provocar problemas de concurrencia si se accede a ellos desde varios subprocesos.
- Dificultad para probar: Puede ser más difícil probar beans Singleton que beans con un alcance más corto.
- Acoplamiento excesivo: El uso excesivo puede conducir a un acoplamiento excesivo entre diferentes componentes de la aplicación.

#### Prácticas recomendadas:
- Use el patrón Singleton solo cuando sea necesario: No lo use como configuración predeterminada para todos los beans.
- Diseñe cuidadosamente los beans Singleton para evitar problemas de concurrencia: Use bloqueos sincronizados o técnicas de acceso seguro para los datos compartidos.
- Pruebe cuidadosamente los beans Singleton: Use técnicas de prueba adecuadas para garantizar que funcionan correctamente en entornos concurridos.
- Considere usar alternativas al patrón Singleton: En algunos casos, puede ser mejor usar un patrón de diseño diferente, como un bean con un alcance de prototipo o un bean de ámbito de solicitud.
