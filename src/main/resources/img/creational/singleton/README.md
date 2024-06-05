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
