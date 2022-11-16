import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import interfaces.IFlightClient;
import model.Flight;


public class FlightClient implements IFlightClient {

	private static Logger logger = Logger.getLogger(FlightServer.class.getName());
	private String clientName;
	List<Flight> flights;

	// ui

	// global state
	

	public FlightClient(String clientName) {
		this.clientName = clientName;
	}

	@Override
	public void receiveListOfFlights(List<Flight> flights) {
		this.flights = flights;
		logger.log(Level.INFO, "List of flights received: " + flights.size());
	}

	@Override
	public void receiveUpdatedFlight(Flight flight, boolean deleted) {
		for(int i = 0; i < flights.size(); i++) {
			if(flights.get(i).getUUID().equals(flight.getUUID())) {
				if(deleted) {
					flights.remove(i);
				} else {
					//TODO update GUI with new flight data
				}
			}
		}
		logger.log(Level.INFO, "Flight updated: " + flight.toString());
	}

	//TODO start the UI in here
	public void startup() {
		
	}

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry();
			FlightServer stub = (FlightServer) registry.lookup("flights");
			String clientName = UUID.randomUUID().toString();
			FlightClient client = new FlightClient(clientName);
			stub.login(clientName, client);
			client.startup();
			stub.logout(clientName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
