package algoritmos.evaluadores;

import EvaluadorExpresiones;
import EvaluadorExpresiones.TipoEvaluacion;
import java.io.File;

public class Evaluador {

    private static final String _PALINDROMO = "palindromo";
    private static final String _PARENTESIS = "parentesis";

    public static void main(String[] args) {
        if (args.length != 2)
            throw new IlegalArgmentExeption("uso: Evaluador <archivo entrada> <(PALINDROMO| PARENTESIS)>");

        String rutaEntrada = args[0];
        String tipoEvaluacion = args[1];
        File entrada = new File(rutaEntrada);

        if (!entrada.exists())
            throw new IlegalArgmentExeption("Archivo de entrada no existe (" + rutaEntrada + ")");
        if (!entrada.isFile())
            throw new IlegalArgmentExeption("ARchivo de entrada no representa un archivo (" + rutaEntrada + ")");
        if (!entrada.canRead())
            throw new IlegalArgmentExeption("No se tiene permiso para leer el archivo (" + rutaEntrada + ")");
        TipoEvaluacion evaluacion;
        switch (tipoEvaluacion.toLowerCase()) {
            case PALINDROMO: {
                evaluacion = TipoEvaluacion.PALINDROMO;
                break;
            }
            case PARENTESIS: {
                evaluacion = TipoEvaluacion.PARENTESIS;
                break;
            }
            default:
                throw new IlegalArgmentExeption("Valor invalido para el tipo de evaluacion (" + tipoEvaluacion + ")");
        }
        EvaluadorExpresiones evaluador = new EvaluadorExpresiones(entrada, evaluacion);
        Map<String, Boolean> resultados = evaluador.evaluar();
        escribirResultados(resultados, evaluacion, entrada);
    }

    private void static escribirResultados(Map<String, Boolean> resultados, TipoEvaluacion evaluacion, File entrada){
        Path directorio = entrada.toPath().getParent();
        String nombreArchivo = entrada.toPath().getFileName();
        
    }
}