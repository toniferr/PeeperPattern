Pros
Puedes construir objetos paso a paso, aplazar pasos de la construcción o ejecutar pasos de forma recursiva.
Puedes reutilizar el mismo código de construcción al construir varias representaciones de productos.
Principio de responsabilidad única. Puedes aislar un código de construcción complejo de la lógica de negocio del producto.

Contras
La complejidad general del código aumenta, ya que el patrón exige la creación de varias clases nuevas.

Relaciones con otros patrones
Muchos diseños empiezan utilizando el Factory Method (menos complicado y más personalizable mediante las subclases) y evolucionan hacia Abstract Factory, Prototype, o Builder (más flexibles, pero más complicados).
Builder se enfoca en construir objetos complejos, paso a paso. Abstract Factory se especializa en crear familias de objetos relacionados. Abstract Factory devuelve el producto inmediatamente, mientras que Builder te permite ejecutar algunos pasos adicionales de construcción antes de extraer el producto.
Puedes utilizar Builder al crear árboles Composite complejos porque puedes programar sus pasos de construcción para que funcionen de forma recursiva.
Puedes combinar Builder con Bridge: la clase directora juega el papel de la abstracción, mientras que diferentes constructoras actúan como implementaciones.
Los patrones Abstract Factory, Builder y Prototype pueden todos ellos implementarse como Singletons.


BUILDER EN LOMBOK
Lombok implementa el patrón Builder a través de la anotación @Builder. Al agregar esta anotación a una clase, Lombok genera automáticamente el código necesario para crear un objeto de esa clase utilizando un patrón Builder.

¿Cómo funciona?
Anota la clase: La clase que quieres que tenga un Builder se anota con @Builder.
Genera el constructor: Lombok genera un constructor vacío para la clase.
Genera el método builder(): Lombok genera un método estático llamado builder() que devuelve una nueva instancia del Builder anidado.
Genera métodos para cada campo: Lombok genera un método para cada campo de la clase. Cada método toma un argumento que corresponde al valor del campo correspondiente. Estos métodos se utilizan para establecer los valores de los campos del objeto que se está construyendo.
Genera el método build(): Lombok genera un método llamado build() que devuelve una nueva instancia del objeto de la clase, utilizando los valores que se han establecido en los campos.
Clase Builder anidada: Lombok genera una clase Builder anidada que contiene los métodos para establecer los valores de los campos del objeto.

Ejemplo:

Java
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

Uso:

Java
Persona persona = Persona.builder()
.nombre("Juan")
.edad(30)
.ciudad("Sevilla")
.build();


Beneficios:
Reduce el código repetitivo: Elimina la necesidad de escribir código repetitivo para crear objetos con múltiples campos.
Mejora la legibilidad del código: El código generado por Lombok es más legible y fácil de entender.
Facilita el mantenimiento del código: El código generado por Lombok es más fácil de mantener, ya que no es necesario modificar el código manualmente cuando se cambia la clase.

Limitaciones:
Dependencia de Lombok: El código generado por Lombok depende de la biblioteca Lombok. Esto significa que la biblioteca Lombok debe estar presente en el proyecto para que el código funcione correctamente.
Menos control sobre el código generado: Lombok genera el código automáticamente, lo que significa que hay menos control sobre el código generado que si se escribiera manualmente.
