### Propósito
Builder es un patrón de diseño creacional que nos permite construir objetos complejos paso a paso. El patrón nos permite producir distintos tipos y representaciones de un objeto empleando el mismo código de construcción.

### Problema
Imagina un objeto complejo que requiere una inicialización laboriosa, paso a paso, de muchos campos y objetos anidados. Normalmente, este código de inicialización está sepultado dentro de un monstruoso constructor con una gran cantidad de parámetros. O, peor aún: disperso por todo el código cliente.

Por ejemplo, pensemos en cómo crear un objeto Casa. Para construir una casa sencilla, debemos construir cuatro paredes y un piso, así como instalar una puerta, colocar un par de ventanas y ponerle un tejado. Pero ¿qué pasa si quieres una casa más grande y luminosa, con un jardín y otros extras (como sistema de calefacción, instalación de fontanería y cableado eléctrico)?

La solución más sencilla es extender la clase base Casa y crear un grupo de subclases que cubran todas las combinaciones posibles de los parámetros. Pero, en cualquier caso, acabarás con una cantidad considerable de subclases. Cualquier parámetro nuevo, como el estilo del porche, exigirá que incrementes esta jerarquía aún más.

Existe otra posibilidad que no implica generar subclases. Puedes crear un enorme constructor dentro de la clase base Casa con todos los parámetros posibles para controlar el objeto casa. Aunque es cierto que esta solución elimina la necesidad de las subclases, genera otro problema.

En la mayoría de los casos, gran parte de los parámetros no se utilizará, lo que provocará que las llamadas al constructor sean bastante feas. Por ejemplo, solo una pequeña parte de las casas tiene piscina, por lo que los parámetros relacionados con piscinas serán inútiles en nueve de cada diez casos.

### Solución
El patrón Builder sugiere que saques el código de construcción del objeto de su propia clase y lo coloques dentro de objetos independientes llamados constructores.

El patrón organiza la construcción de objetos en una serie de pasos (construirParedes, construirPuerta, etc.). Para crear un objeto, se ejecuta una serie de estos pasos en un objeto constructor. Lo importante es que no necesitas invocar todos los pasos. Puedes invocar sólo aquellos que sean necesarios para producir una configuración particular de un objeto.

Puede ser que algunos pasos de la construcción necesiten una implementación diferente cuando tengamos que construir distintas representaciones del producto. Por ejemplo, las paredes de una cabaña pueden ser de madera, pero las paredes de un castillo tienen que ser de piedra.

En este caso, podemos crear varias clases constructoras distintas que implementen la misma serie de pasos de construcción, pero de forma diferente. Entonces podemos utilizar estos constructores en el proceso de construcción (por ejemplo, una serie ordenada de llamadas a los pasos de construcción) para producir distintos tipos de objetos.

Por ejemplo, imagina un constructor que construye todo de madera y vidrio, otro que construye todo con piedra y hierro y un tercero que utiliza oro y diamantes. Al invocar la misma serie de pasos, obtenemos una casa normal del primer constructor, un pequeño castillo del segundo y un palacio del tercero. Sin embargo, esto sólo funcionaría si el código cliente que invoca los pasos de construcción es capaz de interactuar con los constructores mediante una interfaz común.

***Clase directora***

Puedes ir más lejos y extraer una serie de llamadas a los pasos del constructor que utilizas para construir un producto y ponerlas en una clase independiente llamada directora. La clase directora define el orden en el que se deben ejecutar los pasos de construcción, mientras que el constructor proporciona la implementación de dichos pasos.

No es estrictamente necesario tener una clase directora en el programa, ya que se pueden invocar los pasos de construcción en un orden específico directamente desde el código cliente. No obstante, la clase directora puede ser un buen lugar donde colocar distintas rutinas de construcción para poder reutilizarlas a lo largo del programa.

Además, la clase directora esconde por completo los detalles de la construcción del producto al código cliente. El cliente sólo necesita asociar un objeto constructor con una clase directora, utilizarla para iniciar la construcción, y obtener el resultado del objeto constructor.

### Aplicabilidad
***Utiliza el patrón Builder para evitar un “constructor telescópico”.***

Digamos que tenemos un constructor con diez parámetros opcionales. Invocar a semejante bestia es poco práctico, por lo que sobrecargamos el constructor y creamos varias versiones más cortas con menos parámetros. Estos constructores siguen recurriendo al principal, pasando algunos valores por defecto a cualquier parámetro omitido.

```
class Pizza {
Pizza(int size) { ... }
Pizza(int size, boolean cheese) { ... }
Pizza(int size, boolean cheese, boolean pepperoni) { ... }
// ...
```

El patrón Builder permite construir objetos paso a paso, utilizando tan solo aquellos pasos que realmente necesitamos. Una vez implementado el patrón, ya no hará falta apiñar decenas de parámetros dentro de los constructores.

***Utiliza el patrón Builder cuando quieras que el código sea capaz de crear distintas representaciones de ciertos productos (por ejemplo, casas de piedra y madera).***

El patrón Builder se puede aplicar cuando la construcción de varias representaciones de un producto requiera de pasos similares que sólo varían en los detalles.

La interfaz constructora base define todos los pasos de construcción posibles, mientras que los constructores concretos implementan estos pasos para construir representaciones particulares del producto. Entre tanto, la clase directora guía el orden de la construcción.

***Utiliza el patrón Builder para construir árboles con el patrón Composite u otros objetos complejos.***

El patrón Builder te permite construir productos paso a paso. Podrás aplazar la ejecución de ciertos pasos sin descomponer el producto final. Puedes incluso invocar pasos de forma recursiva, lo cual resulta útil cuando necesitas construir un árbol de objetos.

Un constructor no expone el producto incompleto mientras ejecuta los pasos de construcción. Esto evita que el código cliente extraiga un resultado incompleto.

### Cómo implementarlo
1. Asegúrate de poder definir claramente los pasos comunes de construcción para todas las representaciones disponibles del producto. De lo contrario, no podrás proceder a implementar el patrón.
2. Declara estos pasos en la interfaz constructora base.
3. Crea una clase constructora concreta para cada una de las representaciones de producto e implementa sus pasos de construcción.
4. No olvides implementar un método para extraer el resultado de la construcción. La razón por la que este método no se puede declarar dentro de la interfaz constructora es que varios constructores pueden construir productos sin una interfaz común. Por lo tanto, no sabemos cuál será el tipo de retorno para un método como éste. No obstante, si trabajas con productos de una única jerarquía, el método de extracción puede añadirse sin problemas a la interfaz base.
5. Piensa en crear una clase directora. Puede encapsular varias formas de construir un producto utilizando el mismo objeto constructor.
6. El código cliente crea tanto el objeto constructor como el director. Antes de que empiece la construcción, el cliente debe pasar un objeto constructor al director. Normalmente, el cliente hace esto sólo una vez, mediante los parámetros del constructor del director. El director utiliza el objeto constructor para el resto de la construcción. Existe una manera alternativa, en la que el objeto constructor se pasa directamente al método de construcción del director.
7. El resultado de la construcción tan solo se puede obtener directamente del director si todos los productos siguen la misma interfaz. De lo contrario, el cliente deberá extraer el resultado del constructor.

### Pros
- Puedes construir objetos paso a paso, aplazar pasos de la construcción o ejecutar pasos de forma recursiva.
- Puedes reutilizar el mismo código de construcción al construir varias representaciones de productos.
- Principio de responsabilidad única. Puedes aislar un código de construcción complejo de la lógica de negocio del producto.

### Contras
- La complejidad general del código aumenta, ya que el patrón exige la creación de varias clases nuevas.

### Relaciones con otros patrones
- Muchos diseños empiezan utilizando el Factory Method (menos complicado y más personalizable mediante las subclases) y evolucionan hacia Abstract Factory, Prototype, o Builder (más flexibles, pero más complicados).
- Builder se enfoca en construir objetos complejos, paso a paso. Abstract Factory se especializa en crear familias de objetos relacionados. Abstract Factory devuelve el producto inmediatamente, mientras que Builder te permite ejecutar algunos pasos adicionales de construcción antes de extraer el producto.
- Puedes utilizar Builder al crear árboles Composite complejos porque puedes programar sus pasos de construcción para que funcionen de forma recursiva.
- Puedes combinar Builder con Bridge: la clase directora juega el papel de la abstracción, mientras que diferentes constructoras actúan como implementaciones.
- Los patrones Abstract Factory, Builder y Prototype pueden todos ellos implementarse como Singletons.


### BUILDER EN LOMBOK
Lombok implementa el patrón Builder a través de la anotación @Builder. Al agregar esta anotación a una clase, Lombok genera automáticamente el código necesario para crear un objeto de esa clase utilizando un patrón Builder.

### ¿Cómo funciona?
- Anota la clase: La clase que quieres que tenga un Builder se anota con @Builder.
- Genera el constructor: Lombok genera un constructor vacío para la clase.
- Genera el método builder(): Lombok genera un método estático llamado builder() que devuelve una nueva instancia del Builder anidado.
- Genera métodos para cada campo: Lombok genera un método para cada campo de la clase. Cada método toma un argumento que corresponde al valor del campo correspondiente. Estos métodos se utilizan para establecer los valores de los campos del objeto que se está construyendo.
- Genera el método build(): Lombok genera un método llamado build() que devuelve una nueva instancia del objeto de la clase, utilizando los valores que se han establecido en los campos.
- Clase Builder anidada: Lombok genera una clase Builder anidada que contiene los métodos para establecer los valores de los campos del objeto.

Ejemplo:

```
@Builder
public class Persona {

    private String nombre;
    private int edad;
    private String ciudad;

    // Constructor vacío
    public Persona() {}

    // Método builder()
    public static Persona.Builder builder() {
        return new Persona.Builder();
    }

    // Métodos para establecer los valores de los campos
    public Persona.Builder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Persona.Builder edad(int edad) {
        this.edad = edad;
        return this;
    }

    public Persona.Builder ciudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    // Método build()
    public Persona build() {
        return new Persona(nombre, edad, ciudad);
    }

    // Clase Builder anidada
    public static class Builder {

        private String nombre;
        private int edad;
        private String ciudad;

        private Builder() {}

        public Persona build() {
            return new Persona(nombre, edad, ciudad);
        }
    }
}
```


```
Persona persona = Persona.builder()
.nombre("Juan")
.edad(30)
.ciudad("Sevilla")
.build();
```

### Beneficios:
- Reduce el código repetitivo: Elimina la necesidad de escribir código repetitivo para crear objetos con múltiples campos.
- Mejora la legibilidad del código: El código generado por Lombok es más legible y fácil de entender.
- Facilita el mantenimiento del código: El código generado por Lombok es más fácil de mantener, ya que no es necesario modificar el código manualmente cuando se cambia la clase.

### Limitaciones:
- Dependencia de Lombok: El código generado por Lombok depende de la biblioteca Lombok. Esto significa que la biblioteca Lombok debe estar presente en el proyecto para que el código funcione correctamente.
- Menos control sobre el código generado: Lombok genera el código automáticamente, lo que significa que hay menos control sobre el código generado que si se escribiera manualmente.
