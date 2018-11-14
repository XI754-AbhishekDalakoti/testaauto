package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

@SuppressWarnings("unchecked")
public class YmlReader {

	public static Map<String, String> uiDataMap = new HashMap<String, String>();
	private static Map<String, Object> yamlMap = new HashMap<String, Object>();

	private static Map<String, Object> getYaml() throws FileNotFoundException {
		if (yamlMap.isEmpty()) {
			Yaml yaml = new Yaml();
			Reader yamlFile = new FileReader(Constants.APITestDataPath);
//			EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
//			String apiTestDataPath = variables.getProperty("APITestDataPath");
//			System.out.println(apiTestDataPath);
//			Reader yamlFile = new FileReader(apiTestDataPath);

			yamlMap = (Map<String, Object>) yaml.load(yamlFile);
		}
		return yamlMap;
	}

	public static String getUIData(String Key) {

		return uiDataMap.get(Key);
	}

	public static Object getKeyObject(String Key) throws FileNotFoundException {

		return getYaml().get(Key);
	}

	public static String getNestedKeyValueFromYML(String parent, String child) throws Exception{
		Map<String, Object> keyPair = (Map<String, Object>) getYaml().get(parent);
		return (String) keyPair.get(child);
	}
}
