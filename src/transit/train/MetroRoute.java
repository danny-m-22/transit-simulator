package transit.train;

import transit.core.*;
import transit.people.Passenger;

public class MetroRoute extends Route 
{
	//constructor
	public MetroRoute(int routeNum, String routeDesc, MetroStation first)
	{
		super(routeNum, routeDesc, first);
		firstStop.nextStop = first;
	}

	//methods
	@Override
	public void addDriver(String name, double speed) 
	{
		Train train = new Train(name, speed, 3, this);
		this.vehicles.add(train);
	}



	@Override
	public void addStop(String stopName, double x, double y) 
	{
		MetroStation newMT = new MetroStation(stopName, x, y);
		MetroStation nextStop = (MetroStation) firstStop;
		while(nextStop.nextStop != firstStop)
		{
			nextStop = (MetroStation) nextStop.nextStop;
		}
		newMT.nextStop = firstStop;
		nextStop.nextStop = newMT;

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
