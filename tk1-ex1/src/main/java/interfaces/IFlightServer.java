package interfaces;

import java.rmi.Remote;

import model.Flight;

public interface IFlightServer extends Remote {

	public void login(String clientName, IFlightClient client);

	public void logout(String clientName);

	public void updateFlight(String clientName, Flight flight);
	
	public void deleteFlight(String clientName, Flight flight);
}
