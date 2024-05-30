Pros
Puedes clonar objetos sin acoplarlos a sus clases concretas.
Puedes evitar un código de inicialización repetido clonando prototipos prefabricados.
Puedes crear objetos complejos con más facilidad.
Obtienes una alternativa a la herencia al tratar con preajustes de configuración para objetos complejos.

Contras
Clonar objetos complejos con referencias circulares puede resultar complicado.


Relaciones con otros patrones
Muchos diseños empiezan utilizando el Factory Method (menos complicado y más personalizable mediante las subclases) y evolucionan hacia Abstract Factory, Prototype, o Builder (más flexibles, pero más complicados).
Las clases del Abstract Factory a menudo se basan en un grupo de métodos de fábrica, pero también puedes utilizar Prototype para escribir los métodos de estas clases.
Prototype puede ayudar a cuando necesitas guardar copias de Comandos en un historial.
Los diseños que hacen un uso amplio de Composite y Decorator a menudo pueden beneficiarse del uso del Prototype. Aplicar el patrón te permite clonar estructuras complejas en lugar de reconstruirlas desde cero.
Prototype no se basa en la herencia, por lo que no presenta sus inconvenientes. No obstante, Prototype requiere de una inicialización complicada del objeto clonado. Factory Method se basa en la herencia, pero no requiere de un paso de inicialización.
En ocasiones, Prototype puede ser una alternativa más simple al patrón Memento. Esto funciona si el objeto cuyo estado quieres almacenar en el historial es suficientemente sencillo y no tiene enlaces a recursos externos, o estos son fáciles de restablecer.
Los patrones Abstract Factory, Builder y Prototype pueden todos ellos implementarse como Singletons.
