public class Vehicle {
	public Vehicle(String model, Type vehicleType) {
		_model = model; // string
		_vehicleType = vehicleType; // int .... nope 
	}
	
	
	

	public Type getVehicleType() { return _vehicleType; } // change int to type
	public void setVehicleType(Type vehicleT) { _vehicleType = vehicleT; }
	public String getTitle() { return _model; }

	/* 	
				this is static final?
				the code smell is having number of constant variables instead of using a an Enum.
				public static final int MOTORBIKE = 2;
				public static final int ALL_TERRAIN = 1;
				public static final int CAR = 0;
	*/

	private String _model;
	private Type _vehicleType; //does not need to be integer -> // change it to TYPE : it helps putting all of them into a group of enums = similar things

	enum Type { MOTORBIKE, ALL_TERRAIN, CAR } // when ever you are refering type of vehicle refer one of the types.
}
