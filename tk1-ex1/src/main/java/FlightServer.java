import java.util.ArrayList;

import java.util.UUID;
import java.util.List;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

import interfaces.IFlightClient;
import interfaces.IFlightServer;
import model.Flight;

public class FlightServer implements IFlightServer {

	private static Logger logger = Logger.getLogger(FlightServer.class.getName());
	private List<IFlightClient> clients = new ArrayList<IFlightClient>();
	List<Flight> flights;


	protected FlightServer() {
		super();
		// initialize with some flights
		Flight flight1 = new Flight(UUID.randomUUID().toString(), false, 100, "LH",
				"Lufthansa", "Boeing", "Frankfurt", "Boston", "747", "16.11.2022", 
				"14.05,16.11.2022", "1", "10", "14.05,16.11.2022", 'B');
		

		Flight flight2 = new Flight(UUID.randomUUID().toString(), true, 102, "LH",
				"Lufthansa", "Boeing", "Boston", "Frankfurt", "747", "16.11.2022", 
				"16.05,16.11.2022", "1", "10", 'B', 4, "Lufthansa terminals", "14.05,16.11.2022");
		
		flights = new ArrayList<Flight>();
		flights.add(flight1);
		flights.add(flight2);
	}

	@Override
	public void login(String clientName, IFlightClient client) {
		clients.add(client);
		client.receiveListOfFlights(flights);
		logger.log(Level.INFO, "New client logged in: " + clientName);
	}

	@Override
	public void logout(String clientName) {
		logger.log(Level.INFO, "Client logged out: " + clientName);
	}

	@Override
	public void updateFlight(String clientName, Flight flight) {
		for(int i = 0; i < flights.size(); i++) {
			if(flights.get(i).getUUID().equals(flight.getUUID())) {
				if(flight.isDeparting()) {
					flights.get(i).updatedFlight(flight.getUUID(), 
							flight.isDeparting(), flight.getFlightNumber(), flight.getCodeName(), 
							flight.getName(), flight.getAirType(), flight.getDepartureAirport(),
							flight.getArrivalAirport(), flight.getModelName(), flight.getOriginDate(), 
							flight.getScheduledDateTime(), flight.getTerminal(), flight.getGates(), 
							"", flight.getStatus(), flight.getCheckInCounter(),
							flight.getCheckInLocation(), flight.getCheckInDateTime());
				} else {
					flights.get(i).updatedFlight(flight.getUUID(), 
							flight.isDeparting(), flight.getFlightNumber(), flight.getCodeName(), 
							flight.getName(), flight.getAirType(), flight.getDepartureAirport(),
							flight.getArrivalAirport(), flight.getModelName(), flight.getOriginDate(), 
							flight.getScheduledDateTime(), flight.getTerminal(), flight.getGates(), 
							flight.getEstimatedDateTime(), flight.getStatus(), 
							-1, "", "");
				}
				break;
			}
		}
		informAllClients(flight, false);
		logger.log(Level.INFO, "Update flight: " + flight.toString());
	}

	@Override
	public void deleteFlight(String clientName, Flight flight) {
		for(int i = 0; i < flights.size(); i++) {
			if(flights.get(i).getUUID().equals(flight.getUUID())) {
				flights.remove(i);
				break;
			}
		}
		informAllClients(flight, true);
		logger.log(Level.INFO, "Delete flight: " + flight.toString());
	}

	private void informAllClients(Flight flight, boolean deleted) {
		for(int i = 0; i < clients.size(); i++) {
			clients.get(i).receiveListOfFlights(flights);
		}
	}

	public static void main(String[] args) {
		try {
            FlightServer obj = new FlightServer();
            FlightServer stub = (FlightServer) UnicastRemoteObject.exportObject(obj, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("flights", stub);

			// generate game server

			logger.info("Server is ready");
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Server exception", ex);
			ex.printStackTrace();
		}
	}

}
