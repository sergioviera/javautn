import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;


/**
 * Probando algunas librerías del JFC (Java Fundation Classes)
 * @author sergio
 *
 */
public class Ejercicio12 {
	
	public static void main(String[] args){
		log("*** Comenzando pruebas ***");
		log("seleccione su prueba del 1 al 5 (0 para terminar)");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		log("***************************");
		
		while(option!=0){
			switch (option) {
			case 1:
				probarStrings( "Hola Mundo en Java" );
				break;
	
			case 2:
				probarMath();
				break;
	
			case 3:
				probarExcepciones();
				break;
	
			case 4:
				probarColecciones();
				break;
	
			default:
				probarJavaUtils();
				break;
			}
			option = sc.nextInt();
		}
		
		sc.close();
	}

	// este método me ayuda a no andar escribiendo el System.out.println en todos lados.
	private static void log(String msg) {
		System.out.println( msg );
	}
	
	// Java Strings
	private static void probarStrings(String texto) {
		log( "Probando con string \""+texto+"\"" );
		
		boolean vacio = texto.isEmpty();

		log( "es vacío? = "+vacio );
		
		if( !vacio ){
			log( "longitud: "+texto.length() );
			log( "minusculas: "+texto.toLowerCase() );
			log( "mayusculas: "+texto.toUpperCase() );
			log( "caracter en posición 0: "+texto.charAt(0) );
			log( "indice de 'a': "+texto.indexOf("a") );
			log( "reemplazar la primer 'a' por 'o': "+texto.replace("a", "o") );
			log( "reemplazar todas las 'a' por 'o': "+texto.replaceAll("a", "o") );
			
			String textoEnMayusc = texto.toUpperCase();
			String textoEnMinusc = texto.toLowerCase();
			
			log( "Mayusc igual a minusc? = "+textoEnMayusc.equals( textoEnMinusc ) );
			log( "Mayusc igual a minusc? = "+textoEnMayusc.equalsIgnoreCase( textoEnMinusc ) );
		}
		
		// Ejercicios:
		// 1- verificar si una palabra es palindrome
		// 2- invertir una cadena
	}
	
	
	// Java Math
	private static void probarMath() {
		log("Probando java.lang.Math");
		
		double e = 2.7182818284590452354;
	    double pi = 3.14159265358979323846;
	    
	    log( "e = "+Math.E );
	    log( "pi = "+Math.PI );
	    log( "cos 0 = "+Math.cos(0) );
	    log( "e^3 = " +  Math.exp(3));
	    log( "ln 3 = " +  Math.log(3));
	    log( "10^2 = " +  Math.pow(10,2));
	    log( "4,234781 redondeado = " +  Math.round(4.234781));
	    log( "Un número aleatorio = " +  Math.random() );
	    log( "Otro número aleatorio = " +  Math.random() );
	    
	    // Ejercicios:
	    // 1- hallar el área de un circulo de radio r
	    // 2- dados a, b y c, calcular las raices
	}

	
	// Exceptions
	private static void probarExcepciones() {
		String cadena1 = "Hola mundo reloaded";
		String cadena2 = null;
		//excepción simple
		try{
			cadena2.equals(cadena1);
		}catch(NullPointerException e){
			logError( e );
			cadena2 = "cadena recuperada";
		}
		
		try{
			cadena1.charAt(1000);
		}catch(StringIndexOutOfBoundsException e){
			logError( e );
		}finally{
			cadena2 = "siempre cambia";
		}
		
		try{
			excepcionPersonalizada( false );
		}catch( PersonalException e ){
			log("Excepción personalizada atrapada!");
		}finally{
			log("...siempre se ejecuta...");
		}
		
	}

	private static void excepcionPersonalizada( boolean flag ) throws PersonalException {
		//Este es un método común que bajo alguna condición podria tirar una excepción personalizada
		if( flag )
			throw new PersonalException();
		else
			log("excepción sin arrojar");
	}

	private static void logError(Exception e) {
		log( "Excepción del tipo " + e.getClass() );
		System.err.println( e.getLocalizedMessage() );
	}

	// Java Util (Array, Collection, String)
	private static void probarJavaUtils() {
		String [] stringArray = {"ab", "aB", "c", "0", "2", "1Ad", "a10"};

		log("Ordenando Array...");
		Arrays.sort( stringArray );
		log( Arrays.toString(stringArray) );

		//java.util.Collection
		List<String> palabras = new ArrayList<String>();
		palabras.add( "hola" );
		mostrarList( palabras );
		
		palabras.remove(0);
		mostrarList( palabras );
		
		log( "palabras es vacio? "+palabras.isEmpty() );
		
		palabras.add( "uno" );
		palabras.add( "dos" );
		palabras.add( "tres" );
		mostrarList( palabras );
		
		palabras.clear();
		mostrarList( palabras );
	}	
	
	// Collections
	private static void probarColecciones() {
		//List
		List<String> palabras = new ArrayList<String>();
		
		palabras.add( "hola" );
		palabras.add( "mundo" );
		palabras.add( "java" );
		palabras.add( "con" );
		palabras.add( "un" );
		palabras.add( "ejemplo" );
		palabras.add( "de" );
		palabras.add( "colecciones" );
		
		mostrarList( palabras );
		
		log("Ordenando...");
		Collections.sort( palabras );
		mostrarList( palabras );

		log("Ordenando por criterio...");
		Collections.sort( palabras, new Comparator<String>(){
			@Override
			public int compare(String p1, String p2) {
				return p1.length() - p2.length();
			}});
		mostrarList( palabras );
		
		log( "invirtiendo..." );
		Collections.reverse( palabras );
		mostrarList( palabras );
		
		//Hash
		HashMap<String,String> pares = new HashMap<String,String>();
		pares.put("uno", "Primer elemento");
		pares.put("dos", "Segundo elemento");
		pares.put("tres", "Tercer elemento");
		
		for(Entry<String, String> entry : pares.entrySet()){
			log("Key: "+entry.getKey()+" - Value: "+entry.getValue());
		}
		
		log("contiene la clave \"uno\"? "+pares.containsKey("uno") );
		log("contiene la clave \"diez\"? "+pares.containsKey("diez") );

		log("contiene el valor \"Primer elemento\"? "+pares.containsValue("Primer elemento") );
		log("contiene el valor \"diez\"? "+pares.containsValue("diez") );
	
	}

	private static void mostrarList(List<String> palabras) {
		log("Mostrando List:");
		System.out.print( "[ " );
		for(String palabra : palabras){
			System.out.print( palabra + " " );
		}
		System.out.println( "]" );
	}

	
}

class PersonalException extends Exception {

	private static final long serialVersionUID = 2108190271234950435L;

	public PersonalException(){
		System.out.println("Creando mi excepción...");
	}
}

