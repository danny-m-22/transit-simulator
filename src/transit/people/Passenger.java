package transit.people;

import transit.core.*;
import java.util.ArrayList;


public class Passenger 
{
	private String name;
	private Stop destination;


	//getters and setters
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public Stop getDestination()
	{
		return this.destination;
	}
	public void setDestination(Stop destination)
	{
		this.destination = destination;
	}


	//constructors
	public Passenger(String name, Stop currentStop)
	{
		this.name = name;
		this.destination = currentStop;
		while(currentStop == destination)
		{
			Stop randomStop = currentStop;
			int random = (int) (Math.random()*20+1);
			for(int i = 0; i < random; i++)
			{
				randomStop = randomStop.getNextStop();
			}
			this.destination = randomStop;
		}
	}

	public Passenger(Stop currentStop)
	{
		String[] randomNames = {"Danny", "Bob", "Joe", "Sarah", "John", "Elizabeth", "David", "Guy", "Someone", "Person", "Friend", "Dude"};
		String selectedName = randomNames[(int)(Math.random()*12)];
		this.name = selectedName;
		this.destination = currentStop;
		while(currentStop == destination)
		{
			Stop randomStop = currentStop;
			int random = (int) (Math.random()*20+1);
			for(int i = 0; i < random; i++)
			{
				randomStop = randomStop.getNextStop();
			}
			this.destination = randomStop;
		}
	}

	public String toString()
	{
		return name + " going to " + destination.toString();
	}

}
