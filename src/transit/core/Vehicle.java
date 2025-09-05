package transit.core;

import java.util.ArrayList;

import transit.people.*;

public abstract class Vehicle 
{
	protected String identifier;
	protected String driverName;
	protected double speed;
	protected double xCoordinate; 
	protected double yCoordinate; 
	protected Route route;
	public Stop currentDestination;
	protected ArrayList<Passenger> passengers;
	protected boolean isStopped;


	//getters and setters
	public String getIdentifier()
	{
		return identifier;
	}
	public void setIdentifier(String identifier)
	{
		this.identifier = identifier;
	}
	public boolean getIsStopped()
	{
		return isStopped;
	}
	public void setIsStopped(boolean isStopped)
	{
		this.isStopped = isStopped;
	}
	public void setDriverName(String name)
	{
		this.driverName = name;
	}
	public String getDriverName()
	{
		return this.driverName;
	}
	public void setSpeed(double speed)
	{
		this.speed = speed;
	}
	public double getSpeed()
	{
		return this.speed;
	}
	public void setXCoordinate(double x)
	{
		this.xCoordinate = x;
	}
	public double getXCoordinate()
	{
		return this.xCoordinate;
	}
	public void setYCoordinate(double y)
	{
		this.yCoordinate = y;
	}
	public double getYCoordinate()
	{
		return this.yCoordinate;
	}
	public Stop getCurrentDestination()
	{
		return this.currentDestination;
	}
	public void setCurrentDestination(Stop dest)
	{
		this.currentDestination = dest;
	}

	//constructors
	public Vehicle(String driverName, double speed, Route route)
	{
		this.identifier = driverName.hashCode() + "";
		this.driverName = driverName;
		this.speed = speed;
		this.xCoordinate = route.firstStop.xCoordinate;
		this.yCoordinate = route.firstStop.yCoordinate;
		this.route = route;
		this.currentDestination = route.firstStop;
		this.passengers = new ArrayList<Passenger>();
		this.isStopped = true;
	}

	public Vehicle(String driverName, double speed, Route route, Stop currentDestination)
	{
		this.identifier = driverName.hashCode() + "";
		this.driverName = driverName;
		this.speed = speed;
		this.xCoordinate = currentDestination.xCoordinate;
		this.yCoordinate = currentDestination.yCoordinate;
		this.route = route;
		this.currentDestination = currentDestination;
		this.passengers = new ArrayList<Passenger>();
		this.isStopped = true;
	}

	//methods
	public void thankTheDriver() 
	{
		System.out.println("Thanks " + driverName + "!"); 
	}

	public int letPassengersOff()
	{
		int letOff = 0;
		ArrayList<Integer> toRemove = new ArrayList<Integer>();

		//store indices of let off passengers, increase letOff counter
		for(int i = 0; i < this.passengers.size(); i++)
		{
			if(passengers.get(i).getDestination() == currentDestination)
			{
				letOff = letOff + 1;
				toRemove.add(i);
			}
		}

		//add passengers to passengers arrived list, then remove from passengers list
		if(letOff > 0)
		{
			for(int i = toRemove.size() -1; i >= 0; i--)
			{
				currentDestination.passengersArrived.add(passengers.get(toRemove.get(i)));
				passengers.remove(toRemove.get(i));
			}
		}
		return letOff;
	}


	public int letPassengersOn()
	{
		int potentialPassengers = currentDestination.passengersWaiting.size();
		int capacity = getCapacity();
		int counter = 0;

		//see if counter is less than available spots AND counter is less than number of passengers waiting
		
		while(counter <= capacity - this.passengers.size() && counter <= currentDestination.passengersWaiting.size() && currentDestination.passengersWaiting.size() != 0)
		{
			counter = counter + 1;
			passengers.add(currentDestination.passengersWaiting.get(0));
			currentDestination.passengersWaiting.remove(0);

		}
		return counter;
	}


	

	//abstract methods
	public abstract double move(int minutes);
	public abstract int getCapacity();

}