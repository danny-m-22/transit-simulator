package transit.train;

import java.util.ArrayList;

import transit.core.*;
import transit.people.Passenger;

//constructor
public class MetroStation extends Stop
{
	public MetroStation(String name, double x, double y)
	{
		super(name, name.hashCode(), x, y);
	}
	
	//method
	public void gainPassengers()
	{
		int random = (int)(Math.random() * 9 + 1);
		for (int i = 0; i < random; i++)
		{
			passengersWaiting.add(new Passenger(this));
		}
	}
}