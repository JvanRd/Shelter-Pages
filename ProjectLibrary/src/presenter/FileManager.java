package presenter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import dtos.BookDto;
import model.Book;
import model.Section;
import model.User;

/**
 * This class provides methods for reading and writing data to files.
 */

public class FileManager {
	
	/**
	 * Retrieves a list of User objects from a JSON file located at the specified
	 * path.
	 *
	 * @return an ArrayList of User objects containing user information from the
	 *         JSON file
	 * @throws IOException if there is an error reading the JSON file
	 */
	public ArrayList<User> getUsers() throws IOException {
		ArrayList<User> userList = new ArrayList<>();
		String path = "resources/resourcesFile/Users.json";
		try (InputStream fis = new FileInputStream(path); JsonReader reader = Json.createReader(fis)) {
			JsonArray jsonArray = reader.readArray();
			for (JsonValue jsonValue : jsonArray) {
				JsonObject jsonObject = jsonValue.asJsonObject();
				User user = new User(jsonObject.getString("name"), jsonObject.getString("password"),
						jsonObject.getInt("money"));
				user.setPriceInCart(jsonObject.getInt("priceInCart"));

				ArrayList<Book> shoppingCart = new ArrayList<>();
				JsonArray cartArray = jsonObject.getJsonArray("shoppingCart");
				for (JsonValue cartValue : cartArray) {
					JsonObject cartObject = cartValue.asJsonObject();
					Book book = new Book(cartObject.getString("name"), cartObject.getString("author"),
							cartObject.getInt("price"));
					shoppingCart.add(book);
				}
				user.setShoppingCart(shoppingCart);
				userList.add(user);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * Persists a User object to a JSON file.
	 *
	 * @param user the User object to be persisted
	 * @return true if the persistence is successful, false otherwise
	 */
	public boolean persistirUsers(ArrayList<User> userList) {
		String path = "resources/resourcesFile/Users.json";
		try {
			try (OutputStream fos = new FileOutputStream(path);
			 JsonWriter writer = Json.createWriter(fos)) {
				JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
				for (User u : userList) {
					JsonObjectBuilder userBuilder = Json.createObjectBuilder()
							.add("name", u.getName())
							.add("password", u.getPassword())
							.add("money", u.getMoney())
							.add("priceInCart", u.getPriceInCart());

					JsonArrayBuilder cartBuilder = Json.createArrayBuilder();
					for (Book book : u.getShoppingCart()) {
						JsonObjectBuilder itemBuilder = Json.createObjectBuilder()
								.add("name", book.getName())
								.add("author", book.getAuthor())
								.add("price", book.getPrice());
						cartBuilder.add(itemBuilder);
					}

					userBuilder.add("shoppingCart", cartBuilder);
					arrayBuilder.add(userBuilder);
				}

				JsonArray updatedArray = arrayBuilder.build();
				writer.writeArray(updatedArray);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	/**
	 * Retrieves a list of sections from an XML file located at the specified path.
	 *
	 * @return an ArrayList of Section objects representing the sections in the XML
	 *         file
	 * @throws IOException if there is an error reading the XML file
	 */
	public ArrayList<Section> getSections() throws IOException {
		ArrayList<Section> sectionList = new ArrayList<>();
		String path = "resources/resourcesFile/sectionBooks.xml";

		XStream xstream = new XStream(new DomDriver());
		xstream.alias("sections", List.class);
		xstream.alias("Section", Section.class);
		xstream.alias("Book", Book.class);
		xstream.addPermission(AnyTypePermission.ANY);
		try (FileInputStream fis = new FileInputStream(path)) {
			sectionList = (ArrayList<Section>) xstream.fromXML(fis);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}

		return sectionList;
	}

	/**
	 * Retrieves the value associated with the given key from the config.properties file.
	 *
	 * @param  key  the key for which the value is to be retrieved
	 * @return      the value associated with the given key, or null if the file cannot be read
	 */
	public static String getValue(String key) {
		String path = "resources/resourcesFile/config.properties";
		Properties properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return properties.getProperty(key);
	}

	public ArrayList<BookDto> consumeServices() {
		ArrayList<BookDto> books = new ArrayList<>();
		String endpointUrl = "http://localhost:8080/books";
		try {
			URL url = new URL(endpointUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			connection.connect();
			BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
			String output;
			StringBuilder response = new StringBuilder();
			while ((output = br.readLine()) != null) {
				response.append(output);
			}
			connection.disconnect();
			books = convertJsonToBooks(response.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return books;
	}

	public ArrayList<BookDto> convertJsonToBooks(String json) {
		Type listType = new TypeToken<ArrayList<BookDto>>() {
		}.getType();
		return new Gson().fromJson(json, listType);
	}
}
