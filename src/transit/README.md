# Transit Simulator

A Java-based transit system simulator that models buses, trains, routes, stops, and passengers.

## Project Structure
```
src/
└── transit/
├── bus/ # Bus, BusRoute, BusStop
├── core/ # Route, Stop, Vehicle (base classes)
├── people/ # Passenger
├── train/ # Train, MetroRoute, MetroStation
└── testing/ # TransitRunner (entry point)
bin/ # Compiled .class files
```

- **src/** contains all source code.
- **bin/** contains compiled classes (ignored in Git).

## Requirements
- Java 17 (or compatible version)
- An IDE such as IntelliJ IDEA / Eclipse / VS Code, or command-line tools

## Compilation
From the project root:
```
javac -d bin src/transit/**/*.java
```
## Running the Simulator
```
java -cp bin transit.testing.TransitRunner
```
## Features

- Create bus and train routes with stops and stations.

- Represent passengers traveling along routes.

- Core abstractions for vehicles, routes, and stops.

- Example runner included in TransitRunner.
