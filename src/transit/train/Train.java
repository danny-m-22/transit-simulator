package transit.train;

import transit.core.*;
import java.io.*;


public class Train extends Vehicle
{
	private int cars;

	//getter and setter
	public void setCars(int cars)
	{
		if(cars > 0)
		{
			this.cars = cars;
		}
		else
		{
			throw new IllegalStateException("There must be at least one car");
		}
	}
	public int getCars()
	{
		return this.cars;
	}

	//constructors 
	public Train(String driver, double sp, int cars, MetroRoute rt, MetroStation stop)
	{
		super(driver, sp, rt, stop);
		this.cars = cars;
	}
	public Train(String driver, double sp, int cars, MetroRoute rt)
	{
		super(driver, sp, rt);
		this.cars = cars;
	}

	//methods
	public String toString()
	{
		return "Train " + identifier + " (" + driverName 
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
		double distanceBetween = Math.sqrt(Math.pow(this.currentDestination.getXCoordinate() - getXCoordinate(), 2) + Math.pow(this.currentDestination.getYCoordinate() - getYCoordinate(), 2));
		double actualDistance = getSpeed()*minutes/60;

		if(actualDistance >= distanceBetween)
		{
			letPassengersOff();
			this.xCoordinate = currentDestination.getXCoordinate();
			this.yCoordinate = currentDestination.getYCoordinate();
			setIsStopped(true);
			return distanceBetween;
		}
		else
		{
			double ratio = actualDistance/distanceBetween;
			this.xCoordinate = (1-ratio)*this.xCoordinate + ratio * this.currentDestination.getXCoordinate();
			this.yCoordinate = (1-ratio)*this.yCoordinate + ratio * this.currentDestination.getYCoordinate();
			return actualDistance;
		}
	}

	@Override
	public int getCapacity() 
	{
		return cars * 120;
	}

}
