
public class Employee extends Customer{
	private long file;

	public Employee(){
		this.file = 1000;
	}
	
	
	public long getFile() {
		return file;
	}

	public void setFile(long file) {
		this.file = file;
	}

	public String toString(){
		return "[Empleado] "+file+" -> "+super.toString();
	}
}
