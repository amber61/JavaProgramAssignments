package server;

/* File Name: ColorConverter.java
 * Author Name: Zhe Huang
 * Date: 2017-03-22
 * Description: This file support convert annotation to convert color and string.
 * Reference for storing colors: 
 * [1] t. i. S. p. c. c. P. v. B. I. Amokrane Chentir, "Java - How to convert a Color.toString() into a Color?," StackOverflow, 6 3 2010. [Online]. Available: https://stackoverflow.com/questions/2394388/java-how-to-convert-a-color-tostring-into-a-color. [Accessed 22 3 2017].
 * [2] T. Janssen, "How to implement a JPA Attribute Converter," Thoughts on Java, [Online]. Available: http://www.thoughts-on-java.org/jpa-21-how-to-implement-type-converter/. [Accessed 22 3 2017].
 */
import java.awt.Color;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * This class converts between Color and String for storing in database. Date
 * March 22, 2017
 * 
 * @author Zhe (Amber) Huang
 * @version 1.0.0
 * @see java.awt.Color
 * @see javax.persistence.AttributeConverter
 * @see java.util.Random
 * @since 1.8.0_73
 */

@Converter(autoApply = true)
public class ColorConverter implements AttributeConverter<Color, String> {

	// converts value stored in the entity attribute into the data
	// representation to be stored in database
	@Override
	public String convertToDatabaseColumn(Color color) {
		if (color.getRed() == 255)
			return "Red";
		else if (color.getBlue() == 255)
			return "Blue";
		else if (color.getGreen() == 255)
			return "Green";
		else
			return "Invalid color";
	}

	// converts the data stored in the database column into the value to be
	// stored in the entity attribute
	@Override
	public Color convertToEntityAttribute(String colorString) {
		if (colorString.equals("Red"))
			return Color.RED;
		else if (colorString.equals("Blue"))
			return Color.BLUE;
		else if (colorString.equals("Green"))
			return Color.GREEN;
		else
			return Color.BLACK;
	}

}
