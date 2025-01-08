package utilities;

import org.openqa.selenium.devtools.v128.autofill.model.Address;
import com.github.javafaker.Faker;

public class FakerUtility {
	public String getFakeFirstName() {
		Faker faker = new Faker();
		com.github.javafaker.Address address = faker.address();
		String text = address.firstName();
		return text;
		}
	public String getFakeLastName() {
		Faker faker = new Faker();
		com.github.javafaker.Address address = faker.address();
		String text = address.lastName();
		return text;
		}
	public String getFakeCityName() {
		Faker faker = new Faker();
		com.github.javafaker.Address address = faker.address();
		String text = address.cityName();
		return text;
		}
	
}
