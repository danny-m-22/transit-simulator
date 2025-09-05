package transit.core;

import java.util.ArrayList;
import transit.people.*;

public abstract class Stop 
{
	protected String stopName;
	protected int stopNumber;
	protected double xCoordinate; 
	protected double yCoordinate;
	protected ArrayList<Passenger> passengersWaiting; 
	protected ArrayList<Passenger> passengersArrived; 
	public Stop nextStop;
	
	
	//getters and setters
	public void setStopName(String name)
	{
		this.stopName = name;
	}
	public String getStopName()
	{
		return this.stopName;
	}
	public void setStopNumber(int num)
	{
		this.stopNumber = num;
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
	public void setNextStop(Stop next)
	{
		this.nextStop = next;
	}
	public Stop getNextStop()
	{
		return this.nextStop;
	}
	
	
	//constructors
	public Stop(String stopName, int stopNumber, double xCoordinate, double yCoordinate)
	{
		if(stopName == null)
		{
			throw new IllegalArgumentException("A stop must have a name!");
		}
		this.stopName = stopName;
		this.stopNumber = stopName.hashCode();
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.passengersWaiting = new ArrayList<Passenger>();
		this.passengersArrived = new ArrayList<Passenger>();
		this.nextStop = null;
	}
	
	
	//methods
	public ArrayList<Passenger> losePassengers(int numPassengers)
	{
		if(this.passengersWaiting.size() < numPassengers)
		{
			return null;
		}
		else if(passengersWaiting.size() > 0)
		{
			int counter = 0;
			ArrayList<Passenger> passengersLost =  new ArrayList<Passenger>();
			while(passengersWaiting.size() > 0 && counter < numPassengers)
			{
				passengersLost.add(this.passengersWaiting.get(0));
				this.passengersWaiting.remove(0);
				counter++;
			}
			return passengersLost;
		}
		else
		{
			return null;
		}
		
	}
	
	public String toString()
	{
		String str = "";
		str += "Stop name: " + stopName + "\n";
		str += "\tStop number: " + stopNumber + "\n";
		str += "\tPosition: (" + xCoordinate + ", " + yCoordinate + ")\n";
		str += "\tPassengers waiting: ";
		for(Passenger e: passengersWaiting)
		{
			str += e.getName() +", ";
		}
		str += "\n\tPassengers arrived: ";
		for(Passenger e: passengersArrived)
		{
			str += e.getName() + ", ";
		}
		return str;
	}
	
	public ArrayList<Passenger> getPassengersWaiting()
	{
		return passengersWaiting;
	}
	
public ArrayList<Passenger> getPassengersArrived()
{
	return passengersArrived;
}
	
	
	//abstract methods
	public abstract void gainPassengers();
}
