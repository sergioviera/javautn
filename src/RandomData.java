import java.util.Random;

public class RandomData {

	private static String[] femaleNames = {"Juana", "Maria", "Celeste", "Mariana", "Agustina", "Josefina", "Rosa", "Solana", "Eliana", "Silvana"};
	private static String[] maleNames = {"Gabriel","Manuel","Jose","Juan","Mario","Sebastian","Nahuel","Ignacio","Guillermo","Martin"};
	private static String[] surnames = {"Perez","Gonzalez","Gutierrez","Moreno","Solis","Figueroa","Rivadavia","Smith","Puerta","Moreira"};
	private static String[] streets = {"Av. Italia ","Av. 9 de Julio ","San Martín ","Mitre ","Camino Real ","Rivadavia ","Roca ","Calle 22 ","Rio de la Plata ","Buenos Aires "};

	private static Random rnd = new Random();
	
	public static String name(){
		String name;
		
		if( rnd.nextBoolean() ){
			name = femaleNames[ rnd.nextInt(10) ];
		}else{
			name = maleNames[ rnd.nextInt(10) ];
		}
		
		return name + " " + surnames[ rnd.nextInt(10) ];
	}
	
	public static String address(){
		return streets[ rnd.nextInt(10) ] + rnd.nextInt(1000);
	}

	public static String street(){
		return streets[ rnd.nextInt(10) ];
	}
	
	public static long number(){
		return rnd.nextInt(1000);
	}
}
