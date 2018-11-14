package pages;

import static utils.Utilities.getKeyValueFromDataTable;

import java.util.HashMap;
import java.util.Map;
import static utils.YmlReader.*;
import cucumber.api.DataTable;

public class FlightSchedulePage {

	
	public Map<String, Object> createClientObject(DataTable dataTable) throws Exception {
		Map<String,Object> client = new HashMap<String,Object>();
		client.put("provider", getKeyValueFromDataTable(dataTable,"provider"));
		client.put("number", getKeyValueFromDataTable(dataTable,"number"));
		client.put("type", getKeyValueFromDataTable(dataTable,"type"));
		client.put("status", getKeyValueFromDataTable(dataTable, "status"));
		client.put("originTerminalCode", getKeyValueFromDataTable(dataTable, "originTerminalCode"));
		client.put("destinationTerminalCode", getKeyValueFromDataTable(dataTable, "destinationTerminalCode"));
		client.put("travelSector", getKeyValueFromDataTable(dataTable, "travelSector"));
		client.put("transportVehicle", getKeyValueFromDataTable(dataTable, "transportVehicle"));
		client.put("departureTime", getKeyValueFromDataTable(dataTable, "departureTime"));
		client.put("arrivalTime", getKeyValueFromDataTable(dataTable, "arrivalTime"));
		
		return client;
	}
	
}
