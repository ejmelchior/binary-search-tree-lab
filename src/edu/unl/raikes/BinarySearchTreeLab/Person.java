package edu.unl.raikes.BinarySearchTreeLab;

/**
 * Person object class
 * @author evmelchior
 *
 */
public class Person implements Comparable<Person> {
	int key;
	String name;

	/**
	 * constructor for person object, with NUID int and name String
	 * @param NUID	NUID of person
	 * @param name	name of person
	 */
	Person(int NUID, String name) {
		this.key = NUID;
		this.name = name;
	}

	/**
	 * toString method for person object, prints NUID and name
	 */
	public String toString() {
		return "NUID: " + this.key + "  Name: " + name;
	}

	/**
	 * compares two person objects and returns compare int value
	 */
	public int compareTo(Person other) {
		return Integer.compare(key, other.key);
	}
}
