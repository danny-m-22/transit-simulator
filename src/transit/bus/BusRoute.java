package transit.bus;

import transit.core.*;

public class BusRoute extends Route 
{
	//constructor
	public BusRoute(int routeNum, String routeDesc, BusStop first)
	{
		super(routeNum, routeDesc, first);
		firstStop.nextStop = first;
	}

	//methods
	@Override
	public void addDriver(String name, double speed) 
	{
		Bus bus = new Bus(name, speed, this);
		this.vehicles.add(bus);

	}

	@Override
	public void addStop(String stopName, double x, double y) 
	{
		BusStop newBS = new BusStop(stopName, x, y);
		BusStop nextStop = (BusStop) firstStop;
		while(nextStop.nextStop != firstStop)
		{
			nextStop = (BusStop) nextStop.nextStop;
		}
		newBS.nextStop = firstStop;
		nextStop.nextStop = newBS;

	}

	public String toString()
	{
		String str = "";
		str += "Route number: " + routeNumber + "\n";
		str += "\tRoute Description: " + routeDescription + "\n";
		str += "Stops: ";
		Stop currentStop = firstStop;
		while(currentStop.nextStop != firstStop)
		{
			str += currentStop.toString() + ". ";
		}
		str += "\n Vehicles: ";
		for (Vehicle v : this.vehicles)
		{
			str += v.toString() + " ,";
		}

		return str;
	}
}