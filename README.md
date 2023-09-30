# LABORATORIO 2 - PATTERNS

#### TALLER 2
##### PATTERNS - FACTORY

## PRE-RREQUISITOS
- Java OpenJDK Runtime Environment: 17.x.x
- Apache Maven: 3.9.x

## OBJETIVOS
1. Entender qué es Maven
2. Usar comandos de generación de arquetipos, compilación y ejecución de un proyecto usando Maven
3. Obtener puntos adicionales por PR qué corrijan o mejoren los laboratorios

## LA HERRAMIENTA MAVEN
La herramienta [Apache Maven](https://maven.apache.org/what-is-maven.html) se usa para gestionar y manejar proyectos de software. La base de maven para un proyecto es el concepto de un modelo de objeto de proyecto (POM), Maven puede gestionar la compilación, los informes y la documentación de un proyecto a partir de este modelo, que se concreta en el archivo `pom.xml`.

Ingresar a la página de la herramienta y entender:
- Cuál es su mayor utilidad
```diff
- Falta respuesta
```
- Fases de maven
```diff
- Falta respuesta
```
- Ciclo de vida de la construcción
```diff
- Falta respuesta
```
- Para qué sirven los plugins
```diff
- Falta respuesta
```
- Qué es y para qué sirve el repositorio central de maven
```diff
- Falta respuesta
```

## EJERCICIO DE LAS FIGURAS
### CREAR UN PROYECTO CON MAVEN
Buscar cómo se crea un proyecto maven con ayuda de los arquetipos (archetypes).

Busque cómo ejecutar desde línea de comandos el objetivo "generate" del plugin "archetype", con los siguientes parámetros:
```yml
ProjectId: org.apache.maven.archetypes:maven-archetype-quickstart:1.0
Id del Grupo: edu.eci.cvds
Id del Artefacto: Patterns
Paquete: edu.eci.cvds.patterns.archetype
```

Se debió haber creado en el directorio, un nuevo proyecto `Patterns` a partir de un modelo o arquetipo, que crea un conjunto de directorios con un conjunto de archivos básicos.

Cambie al directorio `Patterns`:
```sh
$ cd Patterns
```

Para ver el conjunto de archivos y directorios creados por el comando `mvn` ejecute el comando `tree`.
```sh
$ tree
```

En algunos sistemas operativos, este comando no funciona correctamente o puede requerir un parámetro (por ejemplo: `tree /f`). En caso que funcione, la
salida muestra la estructura del proyecto, similar a como se muestra a continuación:
```sh
.
│ pom.xml
└───src
├───main
│ └───java
│ └───edu
│ └───eci
│ └───cvds
│ └───patterns
  └───archetype
│ App.java
│
└───test
└───java
└───edu
└───eci
└───cvds
└───patterns
└───archetype
AppTest.java
```


Mi proyecto:
![img.png](img%2Fimg.png)
```diff
+ Ok
```


## AJUSTAR ALGUNAS CONFIGURACIONES EN EL PROYECTO
Edite el archivo `pom.xml` y realize la siguiente actualización:

Hay que cambiar la version del compilador de Java a la versión 8, para ello, agregue la sección `properties` antes de la sección de
dependencias:
```xml
<properties>
  <maven.compiler.target>1.8</maven.compiler.target>
  <maven.compiler.source>1.8</maven.compiler.source>
</properties>
```

Mi Proyecto:

![img_1.png](img%2Fimg_1.png)

## COMPILAR Y EJECUTAR
Para compilar ejecute el comando:
```sh
$ mvn package
```

Si maven no actualiza las dependencias utilice la opción `-U` así:
```sh
$ mvn -U package
```

Busque cuál es el objetivo del parámetro "package" y qué otros parámetros se podrían enviar al comando `mvn`.

-El objetivo de package es crear un archivo JAR o WAR del proyecto para convertirlo a un formato distribuible (librerias ejemplo).

Busque cómo ejecutar desde línea de comandos, un proyecto maven y verifique la salida cuando se ejecuta con la clase `App.java` como parámetro en "mainClass". Tip: https://www.mojohaus.org/exec-maven-plugin/usage.html

```sh
$ mvn exec:java -Dexec.mainClass="nombre_de_tu_clase_principal" -Dexec.args="arg1"
```

```sh
$ mvn exec:java -Dexec.mainClass="edu.eci.cvds.patterns.archetype.App" -Dexec.args=""
```

Realice el cambio en la clase `App.java` para crear un saludo personalizado, basado en los parámetros de entrada a la aplicación. 

Utilizar la primera posición del parámetro que llega al método "main" para realizar elsaludo personalizado, en caso que no sea posible, se debe mantener el saludo como se encuentra actualmente:

Buscar cómo enviar parámetros al plugin "exec".
```diff
- Falta respuesta
```

Ejecutar nuevamente la clase desde línea de comandos y verificar la salida: Hello World!

Ejecutar la clase desde línea de comandos enviando su nombre como parámetro y verificar la salida. Ej: Hello Pepito!

![img_2.png](img%2Fimg_2.png)

Ejecutar la clase con su nombre y apellido como parámetro. ¿Qué sucedió?

-Solo me imprimio mi nombre ya que los argumentos estan entrando en un array y estamos tomando la primera posición

Verifique cómo enviar los parámetros de forma "compuesta" para que el saludo se realice con nombre y apellido.

Ejecutar nuevamente y verificar la salida en consola. Ej: Hello Pepito Perez!

![img_3.png](img%2Fimg_3.png)
```diff
+ ✅
```

Se planteó un try y catch para que responda a los argumentos que entre.

## HACER EL ESQUELETO DE LA APLICACIÓN

¿Cuál fábrica hiciste? y ¿Cuál es mejor?

Refactorización planteada según el patrón de diseño Simple Factory haciendo uso de switch-case de Java y usando las enumeraciones (Clase).
```diff
+ ✅
```

Consideramos que el mejor metodo es Factory method ya que el diseño permite que cada vez que se agregue una nueva figura en el proyecto no se tenga que agregar al switch de shapesFactory el caso de la nueva figura, sino simplemente que esta sea una clase abstracta que retorne las instancias de las figuras al cliente. La creacion de las figuras ya no dependera de un switch.

- Simple Factory:

![image](https://github.com/PDSW-ECI/labs/assets/4140058/0788a0b7-a071-4b90-ac3f-5982289ff3b3)

- Factory Method:

![imagen](https://github.com/PDSW-ECI/labs/assets/4140058/cd82548d-347b-4a10-88bd-2d203dac12bd)

- Abstract Factory:

![imagen](https://github.com/PDSW-ECI/labs/assets/4140058/1c79a12b-21d4-46be-8f19-40f3b62b6af7)

Ejecute múltiples veces la clase ShapeMain, usando el plugin exec de maven con los siguientes parámetros y verifique la salida en consola para cada una:
- Sin parámetros
- Parámetro: qwerty
- Parámetro: pentagon
- Parámetro: Hexagon

¿Cuál(es) de las anteriores instrucciones se ejecutan y funcionan correctamente y por qué?

Solo funciona Hexagon ya que es la unica que coincide con el nombre de la clase y sin parametros ya que se ejecuta pero el main necesita un argumento para operar.
```diff
+ ✅
```

- NOTA: Investigue para qué sirve "gitignore" y cómo se usa. Para futuras entregas, debe estar configurado.

## Investigación

Es un archivo que se agrega al repositorio para que Git ignore directorios, archivos, extensiones, etc. Con el fin de que estos no sean guardados en el repositorio. Puede ver un ejemplo del gitignore que se subio en en este repositorio.
```diff
+ ✅
```

<!-- https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax -->
