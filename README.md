# CONVERSOR DE IMAGENES – JAVA

Repositorio: [https://github.com/Luiloprom/conversor_img.git](https://github.com/Luiloprom/conversor_img.git)

# Índice

- [CONVERSOR DE IMÁGENES – JAVA](#conversor-de-imágenes--java)
- [App.java](#appjava)
- [Comando.java](#comandojava)
- [Conversor.java](#conversorjava)
- [Tests con JUnit](#tests-con-junit)
  - [testConvertir](#testconvertir)
  - [testConvertirError](#testconvertirerror)

---

### App.java

En **App.java** se definen las rutas y nombres de los archivos de imagen y el comando para la conversión. Cuando lo ejecuto llamo al método `convertir` que devuelve String.

```java
    public class App {

        public static final String COMANDO = "convert";
        public static final String ENTRADA = "goku.jpg";
        public static final String SALIDA = "goku.png";

        public static final String RUTA = "src/main/resources/";
        public static final String IMG_ENTRADA = RUTA + ENTRADA;
        public static final String IMG_SALIDA = RUTA + SALIDA;
        public static final String[] INSTRUCCION = { COMANDO, IMG_ENTRADA, IMG_SALIDA };


        public static void main(String[] args) throws Exception {
            Comando convert = new Conversor();
            System.out.println(convert.convertir(INSTRUCCION));
        }
    }
```

---

### Comando.java

En **Comando.java** defino una interfaz, con el método `convertir` que recibe el array con las instrucciones y devuelve un String.

```java
    public interface Comando {
        public String convertir(String[] instruccion) throws Exception;
    }
```

---

### Conversor.java

En **Conversor.java** implemento la interfaz `Comando`. Y defino el método escribir que devuelve un mendaje dependiendo del codigo de salida del proceso.

```java
    public class Conversor implements Comando {
        public static final String MSG_ERROR = "A ocurrido un error al convertir la imagen";
        public static final String MSG_SALIDA = "Imagen convertida correctamente";


        @Override
        public String convertir(String[] instruccion) throws Exception {
            Process p = Runtime.getRuntime().exec(instruccion);
            return (p.waitFor() == 0) ? MSG_SALIDA : MSG_ERROR;
        }
    }
```

--- 

### Tests con JUnit

He comprobado que el método `convertir` devuelve correctamente los mensajes de éxito y error.

- #### testConvertir

```java
    @Test
        public void testConvertir() throws Exception {
        Comando comando = new Conversor();
        String[] instruccion = { "echo", "hola mundo" };
        String resultado = comando.convertir(instruccion);
        assertEquals(Conversor.MSG_SALIDA, resultado);
    }
```

---

- #### testConvertirError

```java
    @Test
        public void testConvertirError() throws Exception {
        Comando comando = new Conversor();
        String[] instruccion = { "ls", "hola que tal" }; 
        String resultado = comando.convertir(instruccion);
        assertEquals(Conversor.MSG_ERROR, resultado);
    }
```
> Meto ese comando que devuelve salida diferente a 0