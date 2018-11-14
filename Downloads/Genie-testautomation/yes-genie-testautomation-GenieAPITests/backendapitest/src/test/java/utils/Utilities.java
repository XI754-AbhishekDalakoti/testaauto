package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Utilities {
	
	/*
	 * return key value
	 * Datatable
	 * */
	public static String getKeyValueFromDataTable(DataTable table, String key) throws Exception{
		List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (Map<String, String> map : data) 
			return map.get(key);
		return "Key not found";
	}
	
	/*
	 * create InputReader stream
	 * */
	public static InputStream getInputStream(String filePath) throws FileNotFoundException {
		return new FileInputStream(
			      new File(filePath));
	}
	/*
	 * return JsonSchemaValidator 
	 * */
	public static JsonSchemaValidator matchesJsonSchema(String schemaFileName) throws FileNotFoundException {
		return JsonSchemaValidator.matchesJsonSchema(getInputStream(Constants.schemaFolderPath + Constants.separator + schemaFileName));
	}
	
	/*
	 * return payload as string
	 * */
	public static String generateStringFromResource(String fileName) throws IOException {

	    return new String(Files.readAllBytes(Paths.get(Constants.payloadFolderPath + Constants.separator + fileName)));

	}
}
