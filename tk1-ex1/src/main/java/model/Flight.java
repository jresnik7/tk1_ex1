package model;

public class Flight {
	private String modelName;
	private String arrivalAirport;
	private String departureAirport;
	private String airType;
	private String name;
	private String codeName;
	private String scheduledDateTime;
	private String estimatedDateTime;
	private String terminal;
	private String gates;
	private char status;
	private String checkInDateTime;
	private int flightNumber;
	private boolean departing;
	private int checkInCounter;
	private String checkInLocation;
	private String originDate;
	private final String UUID;

	public Flight(String UUID, boolean departing, int flightNumber, String codeName, String name, 
			String airType, String departureAirport, String arrivalAirport, String modelName, 
			String originDate, String scheduledDateTime, String terminal, String gates, 
			String estimatedDateTime, char status) {
		this.UUID = UUID;
		this.setDeparting(departing);
		this.setFlightNumber(flightNumber);
		this.setCodeName(codeName);
		this.setName(name);
		this.setAirType(airType);
		this.setDepartureAirport(departureAirport);
		this.setArrivalAirport(arrivalAirport);
		this.setModelName(modelName);
		this.setOriginDate(originDate);
		this.setScheduledDateTime(scheduledDateTime);
		this.setTerminal(terminal);
		this.setGates(gates);
		this.setEstimatedDateTime(estimatedDateTime);
		this.setStatus(status);
		this.setCheckInCounter(-1);
		this.setCheckInLocation("");
		this.setCheckInDateTime("");
	}
	
	public Flight(String UUID, boolean departing, int flightNumber, String codeName, String name, 
			String airType, String departureAirport, String arrivalAirport, String modelName, 
			String originDate, String scheduledDateTime, String terminal, String gates,
			char status, int checkInCounter, String checkInLocation, 
			String checkInDateTime) {
		this.UUID = UUID;
		this.setDeparting(departing);
		this.setFlightNumber(flightNumber);
		this.setCodeName(codeName);
		this.setName(name);
		this.setAirType(airType);
		this.setDepartureAirport(departureAirport);
		this.setArrivalAirport(arrivalAirport);
		this.setModelName(modelName);
		this.setOriginDate(originDate);
		this.setScheduledDateTime(scheduledDateTime);
		this.setTerminal(terminal);
		this.setGates(gates);
		this.setStatus(status);
		this.setEstimatedDateTime("");
		this.setCheckInCounter(checkInCounter);
		this.setCheckInLocation(checkInLocation);
		this.setCheckInDateTime(checkInDateTime);
	}
	
	public void updatedFlight(String UUID, boolean departing, int flightNumber, String codeName, 
			String name, String airType, String departureAirport, String arrivalAirport, 
			String modelName, String originDate, String scheduledDateTime, String terminal, 
			String gates, String estimatedDateTime, char status, int checkInCounter, String checkInLocation, 
			String checkInDateTime) {
		this.setDeparting(departing);
		this.setFlightNumber(flightNumber);
		this.setCodeName(codeName);
		this.setName(name);
		this.setAirType(airType);
		this.setDepartureAirport(departureAirport);
		this.setArrivalAirport(arrivalAirport);
		this.setModelName(modelName);
		this.setOriginDate(originDate);
		this.setScheduledDateTime(scheduledDateTime);
		this.setTerminal(terminal);
		this.setGates(gates);
		this.setEstimatedDateTime(estimatedDateTime);
		this.setStatus(status);
		this.setCheckInCounter(checkInCounter);
		this.setCheckInLocation(checkInLocation);
		this.setCheckInDateTime(checkInDateTime);
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getAirType() {
		return airType;
	}

	public void setAirType(String airType) {
		this.airType = airType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getScheduledDateTime() {
		return scheduledDateTime;
	}

	public void setScheduledDateTime(String scheduledDateTime) {
		this.scheduledDateTime = scheduledDateTime;
	}

	public String getEstimatedDateTime() {
		return estimatedDateTime;
	}

	public void setEstimatedDateTime(String estimatedDateTime) {
		this.estimatedDateTime = estimatedDateTime;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getGates() {
		return gates;
	}

	public void setGates(String gates) {
		this.gates = gates;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getCheckInDateTime() {
		return checkInDateTime;
	}

	public void setCheckInDateTime(String checkInDateTime) {
		this.checkInDateTime = checkInDateTime;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public boolean isDeparting() {
		return departing;
	}

	public void setDeparting(boolean departing) {
		this.departing = departing;
	}

	public int getCheckInCounter() {
		return checkInCounter;
	}

	public void setCheckInCounter(int checkInCounter) {
		this.checkInCounter = checkInCounter;
	}

	public String getCheckInLocation() {
		return checkInLocation;
	}

	public void setCheckInLocation(String checkInLocation) {
		this.checkInLocation = checkInLocation;
	}

	public String getOriginDate() {
		return originDate;
	}

	public void setOriginDate(String originDate) {
		this.originDate = originDate;
	}
	
	public String getUUID() {
		return UUID;
	}
}
