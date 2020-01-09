package bankAccountApp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	static String name = "george";
	static char gender = 'M';
	static int age = 62;
	static float height = 5.9f;
	static float weight = 160f;
	static String hairColor = "brown";
	static String eyeColor = "hazel";
	static String emailAddress = "bozo.net";
	String serializedPerson = null;
	
	@Before
	public void setup() {
		name = "george";
		gender = 'M';
		age = 62;
		height = 5.9f;
		weight = 160f;
		hairColor = "brown";
		eyeColor = "hazel";
		emailAddress = "bozo.net";
		serializedPerson = name + Person.DELIM + gender + Person.DELIM + age + Person.DELIM + height + Person.DELIM
				+ weight + Person.DELIM + hairColor + Person.DELIM + eyeColor + Person.DELIM + emailAddress;
	}

	@Test
	public void test_create_ver1_and_gets() {
		// Given
		Person person = new Person();

		// Then
		assertEquals("", person.getName());
		assertEquals('m', person.getGender());
		assertEquals("", person.getAge());
		assertEquals(0.0, person.getHeight(), 0);
		assertEquals(0.0, person.getWeight(), 0);
		assertEquals("", person.getHairColor(), 0);
		assertEquals("", person.getEyeColor(), 0);
	}

	@Test
	public void test_create_ver1_and_gets_hamcrest() {
		// Given
		Person person = new Person();

		// Then
		// TODO add assert for default values

	}

	@Test
	public void test_create_ver2_and_gets() {
		// Given
		Person person = new Person(name, gender, age, height);

		// Then
		assertEquals("", person.getName());
		assertEquals('m', person.getGender());
		assertEquals("", person.getAge());
		assertEquals(0.0, person.getHeight(),0);

	}

	@Test
	public void test_create_ver2_and_gets_hamcrest() {
		// Given
		Person person = new Person(name, gender, age, height);
		//TODO change assertThat to actual and expected
		// Then
		assertThat(name, equalTo(person.getName()));
		assertThat(gender, equalTo(person.getGender()));
		assertThat(age, equalTo(person.getAge()));
		assertThat(height, equalTo(person.getHeight()));
	}

	@Test
	public void test_create_ver3_and_gets() throws Exception {
		// Given
		Person person = new Person(name, gender, age, weight, height, hairColor, eyeColor, emailAddress);

		// Then
		assertEquals(name, person.getName());
		assertEquals(gender, person.getGender());
		assertEquals(age, person.getAge());
		assertEquals(height, person.getHeight(), 0f);
		assertEquals(weight, person.getWeight(), 0f);
		assertEquals(hairColor, person.getHairColor());
		assertEquals(eyeColor, person.getEyeColor());
		assertEquals(emailAddress, person.getEmail());
	}

	@Test
	public void test_create_ver3_and_gets_hamcrest() throws Exception {
		// Given
		Person person = new Person(name, gender, age, weight, height, hairColor, eyeColor, emailAddress);

		// Then
		//TODO change assertThat to actual and expected		
		assertThat(name, equalTo(person.getName()));
		assertThat(gender, equalTo(person.getGender()));
		assertThat(age, equalTo(person.getAge()));
		assertThat(height, equalTo(person.getHeight()));
		assertThat(weight, equalTo(person.getWeight()));
		assertThat(hairColor, equalTo(person.getHairColor()));
		assertThat(eyeColor, equalTo(person.getEyeColor()));
		assertThat(emailAddress, equalTo(person.getEmail()));
	}

	@Test
	public void test_create_ver4_and_gets() throws Exception {
		// Given
		Person person = new Person(serializedPerson);

		// Then
		assertEquals(name, person.getName());
		assertEquals(gender, person.getGender());
		assertEquals(age, person.getAge());
		assertEquals(height, person.getHeight(), 0f);
		assertEquals(weight, person.getWeight(), 0f);
		assertEquals(hairColor, person.getHairColor());
		assertEquals(eyeColor, person.getEyeColor());
		assertEquals(emailAddress, person.getEmail());
		assertEquals(name, person.getName());

	}

	@Test
	public void test_create_ver4_and_gets_hamcrest() throws Exception {
		// Given
		Person person = new Person(serializedPerson);

		// Then
		assertEquals(name, person.getName());
		assertEquals(name, person.getName());
		assertEquals(gender, person.getGender());
		assertEquals(age, person.getAge());
		assertEquals(height, person.getHeight(), 0f);
		assertEquals(weight, person.getWeight(), 0f);
		assertEquals(hairColor, person.getHairColor());
		assertEquals(eyeColor, person.getEyeColor());
		assertEquals(emailAddress, person.getEmail());
		assertThat(age, equalTo(person.getAge()));
		// TODO change assertThat to actual and expected.  Finish assertThat and remove assertEquals
		assertThat(emailAddress, equalTo(person.getEmail()));
		assertThat(name, equalTo(person.getName()));
		assertThat(height, equalTo(person.getHeight()));
		assertThat(eyeColor, equalTo(person.getEyeColor()));
		assertThat(weight, equalTo(person.getWeight()));
		assertThat(gender, equalTo(person.getGender()));
	}

	@Test
	public void test_all_sets_hamcrest() throws Exception {
		String newName = "Peter";
		char newGender = 'F';
		int newAge = 63;
		float newHeight = 6f;
		float newWeight = 170f;
		String newHairColor = "blonde";
		String newEyeColor = "green";
		String newEmailAddress = "gene@homeontherange.com";

		// Given
		Person person = new Person(name, gender, age, weight, height, hairColor, eyeColor, emailAddress);

		// When
		person.setAge(newAge);
		person.setEmail(newEmailAddress);
		person.setName(newName);
		person.setHeight(newHeight);
		person.setEyeColor(newEyeColor);
		person.setWeight(newWeight);
		person.setGender(newGender);

		// Then
		assertThat(newAge, equalTo(person.getAge()));
		// TODO change assertThat to actual, expected
		assertThat(newEmailAddress, equalTo(person.getEmail()));
		assertThat(newName, equalTo(person.getName()));
		assertThat(newHeight, equalTo(person.getHeight()));
		assertThat(newEyeColor, equalTo(person.getEyeColor()));
		assertThat(newWeight, equalTo(person.getWeight()));
		assertThat(newGender, equalTo(person.getGender()));
	}

	@Test
	public void test_person_serialization_hamcrest() throws Exception {
		// Given
		Person person = new Person(name, gender, age, weight, height, hairColor, eyeColor, emailAddress);
		String serializedPerson = person.toString();

		// Then
		String[] tokens = serializedPerson.split(Person.DELIM);
		// TODO change assertThat to actual, expected

		assertThat(8, equalTo(tokens.length));

		// TODO assert remaining token entries
		assertThat(name, equalTo(tokens[0]));
	}

	@Test
	public void test_person_validate_gender(){
		
	}
	
	//TODO add a create person with a bad gender value. Catch expected exception.
	//TODO also test the setGender exception
}
