package es.etg.dam;




public class Conversor implements Comando {
    public final String MSG_ERROR = "A ocurrido un error al convertir la imagen";
    public final String MSG_SALIDA = "Imagen convertida correctamente";

    @Override
    public String lanzar(String[] instruccion) throws Exception{
        Process p = Runtime.getRuntime().exec(instruccion);

        return (p.waitFor() == 0) ? MSG_SALIDA : MSG_ERROR;
    }
}
