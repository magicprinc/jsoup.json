package example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.JsonTreeBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.stream.Collectors;

import static org.jsoup.parser.JsonTreeBuilder.jsonParser;
import static org.junit.jupiter.api.Assertions.*;

/**
 https://raw.githubusercontent.com/LearnWebCode/json-example/master/animals-1.json

 @see org.jsoup.parser.JsonTreeBuilderTest
 @see JsonTreeBuilder#jsonToXml(String)
 @author Andrey Fink 2023-12-02
*/
public class ExampleTest {

	@Test void simple () throws IOException {
		Document doc = Jsoup.connect("https://raw.githubusercontent.com/LearnWebCode/json-example/master/animals-1.json")
			.parser(jsonParser(true))
			.get();

		System.out.println(doc.html());// compare with ^^^

		String s = doc.select("obj val#name").stream()
			.map(Element::text)
			.collect(Collectors.joining(", "));
		assertEquals("Meowsy, Barky, Purrpaws", s);
	}

}