/**
 * 
 */
package de.travelbasys.training2;

/**
 * Die User Klasse repräsentiert einen Benutzer der Anwendung. 
 * 
 * @author tba
 */
public class User {
	
	private String name;
	private int age;
	
	private static final String DEFAULT_NAME = "Bill";
	private static final int DEFAULT_AGE = 15;
	
	/**
	 * Erzeugt ein neues User Objekt mit dem angegebenen Namen
	 * und dem angegebenen Alter.
	 * 
	 * @param name Name des Users.
	 * @param age Alter des Users.
	 * @throws Exception 
	 */
	public User(String name, int age ) throws IllegalArgumentException {
		this.name = name;
		setAge( age );
	}
	
	/**
	 * Erzeugt ein neues User Objekt mit dem angegebenen Namen
	 * und einem default Alter (derzeit 15).
	 * 
	 * @param name Name des Users.
	 * @throws IllegalArgumentException 
	 */
	public User(String name) throws IllegalArgumentException {
		this( name, DEFAULT_AGE );
	}

	/**
	 * Erzeugt ein neues User Objekt mit einem default Namen
	 * (derzeit "Bill") und dem default Alter.
	 * @throws IllegalArgumentException 
	 */
	public User() throws IllegalArgumentException {
		this( DEFAULT_NAME );
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * 
	 * @param age
	 * @throws IllegalArgumentException 
	 */
	public void setAge(int age) throws IllegalArgumentException {
		if( age > 0 ){
			this.age = age;
		}
		else{
			throw new IllegalArgumentException( "Alter ungültig: " + age );
		}
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
