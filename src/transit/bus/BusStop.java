package transit.bus;

import transit.core.*;
import transit.people.*;

public class BusStop extends Stop
{
	//constructor
	public BusStop(String name, double x, double y)
	{
		super(name, name.hashCode(), x, y);
	}

	//method
	public void gainPassengers()
	{
		int random = (int)(Math.random() * 4 + 1);
		for (int i = 0; i < random; i++)
		{
			passengersWaiting.add(new Passenger(this));
		}
	}
}