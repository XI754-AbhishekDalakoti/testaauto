package utils;

import io.restassured.RestAssured;

public class SetupConfiguration {
	YmlReader yamlReader = new YmlReader();
	public static String domain;
	
	@SuppressWarnings("static-access")
	public void setUp(String domain) throws Exception {
		RestAssured.baseURI = yamlReader.getNestedKeyValueFromYML(domain, "baseURL");
		this.domain=domain;
	}
}
