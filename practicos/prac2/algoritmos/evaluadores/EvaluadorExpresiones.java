package algoritmos.evaluadores;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class EvaluadorExpresiones {

    public enum TipoEvaluacion{
        PALINDROMO,
        PARENTESIS
    }
    private File archivoEntrada;
    private TipoEvaluacion evaluacion;

    public EvaluadorExpresiones(String archivoEntrada, TipoEValucacion evaluacion){
        this(new File(archivoEntrada), evaluacion);
    }
    public EvaluadorExpresiones(Path archivoEntrada, TipoEValucacion evaluacion){
        this(archivoEntrada.toFile(), evaluacion);
    }
    public EvaluadorExpresiones(File archivoEntrada, TipoEValucacion evaluacion){
        if(archivoEntrada == null) throw new IlegalArgmentExeption ("Archivo de entrada es nulo");
        if(evaluacion == null) throw new IlegalArgmentExeption("Tipo de evaluacion es nulo");
        if(!entrada.exists()) throw new IlegalArgmentExeption("Archivo de entrada no existe (" + rutaEntrada + ")");
        if(!entrada.isFile()) throw new IlegalArgmentExeption("ARchivo de entrada no representa un archivo (" + rutaEntrada + ")");
        if(!entrada.canRead()) throw new IlegalArgmentExeption("No se tiene permiso para leer el archivo (" + rutaEntrada + ")");
        this.archivoEntrada = archivoEntrada;
        this.evaluacion = evaluacion;
    }
    public Map<String, Boolean> evaluar(){
        try{
            Map<String, Boolean> resultados = new HashMap<>();
            for(String line :  File.readLines(archivoEntrada.toPath()) ){

                switch(TipoEvaluacion){
                    case TipoEvaluacion.PALINDROMO:{
                        resultados.put(line, esPalindromo(line));
                        break;
                    }
                    case TipoEvaluacion.PARENTESIS:{
                        resultados.put(line, parentesisBalanceado(line));
                        break;
                    }
                }
            }
        } catch (IOException x){
            throw new IllegalStatrException("Hubo un error al leer las lineas del archivo de entrada" , x)
        }
    }
}