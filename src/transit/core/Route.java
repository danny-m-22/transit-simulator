package transit.core;

import java.util.ArrayList;

import transit.people.Passenger;


public abstract class Route 
{
	protected int routeNumber;
	protected String routeDescription;
	public Stop firstStop;
	protected ArrayList<Vehicle> vehicles;
	
	//Routes are made of LINKED LIST of STOPS
	
	public void setRouteNumber(int routeNumber)
	{
		this.routeNumber = routeNumber;
	}
	public int getRouteNumber()
	{
		return this.routeNumber;
	}
	public void setRouteDescription(String routeDescription)
	{
		this.routeDescription = routeDescription;
	}
	public String getRouteDescription()
	{
		return this.routeDescription;
	}
	public void setFirstStop(Stop stop)
	{
		this.firstStop = stop;
	}
	public Stop getFirstStop()
	{
		return this.firstStop;
	}
	
	
	public Route(int routeNumber, String routeDescription, Stop firstStop)
	{
		this.routeNumber = routeNumber;
		this.routeDescription = routeDescription; 
		this.firstStop = firstStop;
		this.vehicles = new ArrayList<Vehicle>();
	}
	

	public void gainPassengersAll()
	{
		Stop stop = firstStop.nextStop;
		firstStop.gainPassengers();
		while(stop != firstStop)
		{
			stop.gainPassengers();
			stop = stop.nextStop;
		}
	}
	
	public void moveAll(int minutes)
	{
		for(Vehicle e : vehicles)
		{
			e.move(minutes);
		}
	}
	
	public ArrayList<Vehicle> getVehicles()
	{
		return vehicles;
	}
	
	
	//abstract methods 
	public abstract void addDriver(String name, double speed);
	public abstract void addStop(String stopName, double x, double y);
	
}
