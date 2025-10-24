package es.etg.dam;

public class App {
    public static final String ENTRADA = "goku.jpg ";
    public static final String SALIDA = "goku.png";
    public static final String RUTA = "/src/main/resources/";
    public static final String IMG_ENTRADA = RUTA + ENTRADA;
    public static final String IMG_SALIDA = RUTA + SALIDA;
    public static final String COMANDO = "convert ";

    public static void main(String[] args) throws Exception{
        String[] comando = { COMANDO + IMG_ENTRADA + IMG_SALIDA };

        Comando convertir = new Conversor();        
        System.out.println(convertir.lanzar(comando));
    }

}