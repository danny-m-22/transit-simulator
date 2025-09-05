package transit.bus;

import transit.core.*;

public class Bus extends Vehicle 
{
	private int capacity = 35;

	public int getCapacity()
	{
		return this.capacity;
	}

	public void setCapacity(int capacity)
	{
		if(capacity>0)
		{
			this.capacity = capacity;
		}
		else
		{
			throw new IllegalStateException("The capacity must be greater than zero");
		}
	}

	//constructors
	public Bus(String driver, double sp, BusRoute rt, BusStop stop)
	{
		super(driver, sp, rt, stop);
	}
	public Bus(String driver, double sp, BusRoute rt)
	{
		super(driver, sp, rt);
	}


	//methods
	public String toString()
	{
		return "Bus " + identifier + " (" + driverName 
				+ ") traveling on route #" + route.getRouteNumber() 
				+ "\n\tCurrently stopped at " + currentDestination.getStopName() + " which is " + "(" +xCoordinate + " ," + yCoordinate + ")"
				+ "\n\t" + passengers.size() + " seats taken out of " + getCapacity();
	}



	@Override
	public double move(int minutes) 
	{
		if(getIsStopped() == true)
		{
			letPassengersOn();
			setIsStopped(false);
			setCurrentDestination(currentDestination.nextStop);
		}
		double distanceBetween = Math.abs(this.currentDestination.getXCoordinate() - getXCoordinate()) + Math.abs(this.currentDestination.getYCoordinate() - getYCoordinate());
		double actualDistance = getSpeed()*minutes/60;

		if(actualDistance >= distanceBetween)
		{
			letPassengersOff();
			this.xCoordinate = currentDestination.getXCoordinate();
			this.yCoordinate = currentDestination.getYCoordinate();
			setIsStopped(true);
			return distanceBetween;
		}
		
		//nested if statements account for directions 
		else if(getSpeed()*minutes/60 < Math.abs(this.currentDestination.getXCoordinate() - getXCoordinate()))
		{
			//all distance is in x direction
			if(this.xCoordinate < this.currentDestination.getXCoordinate())
			{
				this.xCoordinate = this.xCoordinate + actualDistance;
			}
			else
			{
				this.xCoordinate = this.xCoordinate - actualDistance;
			}
			//yCoordinate unchanged
			return actualDistance;
		}
		else
		{
			//distance left to travel in y direction + initial y point
			//change x-coordinate AFTER y-coordinare
			
			if(this.yCoordinate < this.currentDestination.getYCoordinate())
			{
				this.yCoordinate = (actualDistance - Math.abs(this.currentDestination.getXCoordinate() - this.xCoordinate)) + this.yCoordinate;
			}
			else
			{
				this.yCoordinate = -(actualDistance - Math.abs(this.currentDestination.getXCoordinate() - this.xCoordinate)) + this.yCoordinate;
			}
			this.xCoordinate = this.currentDestination.getXCoordinate();
			return actualDistance;

		}
	}

}
