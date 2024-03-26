package runnerClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
	public static Properties property;
	private static String ConfigPath = "C:\\Users\\Pavan.Teli\\eclipse-workspace\\carina-demoNew\\src\\main\\resources\\config.properties";

	public static void initializePropertyFile() {
		property = new Properties();
		try {
			InputStream is = new FileInputStream(ConfigPath);
			property.load(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
