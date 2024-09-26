StarFleet OOP Project in Java
Description:

This project is an Object-Oriented Programming (OOP) representation of StarFleet using Java. It showcases various OOP principles such as inheritance, encapsulation, and polymorphism. The project simulates different spaceships, crew members, and their interactions within the StarFleet universe.
Features:

    Comprehensive representation of different spaceships like Bombers, Colonial Vipers, Cylon Raiders, and more.
    Detailed categorization of crew members from officers to crew women.
    Usage of Java's Comparator to sort and compare various entities.
    Demonstrates relationships and interactions between different entities.

Files and Their Connections:
Spaceships:

    Spaceship.java: Base class for all spaceship types.
    Bomber.java: Represents a Bomber spaceship.
    ColonialViper.java: Represents the Colonial Viper spaceship.
    CylonRaider.java: Represents the Cylon Raider spaceship.
    Fighter.java: A general representation of a fighter spaceship.
    StealthCruiser.java: Represents the Stealth Cruiser spaceship.
    TransportShip.java: Represents a transport ship.

Crew Members:

    CrewMember.java: Base class for all crew members.
    CrewWoman.java: Represents a female crew member.
    Officer.java: Represents an officer crew member.
    OfficerRank.java: Enum class for different officer ranks.
    Cylon.java: Represents a Cylon crew member.

Others:

    Weapon.java: Represents weapons that might be equipped by spaceships.
    StarfleetManager.java: Manages the interactions and functionalities of Starfleet.
    SpacefleetTester.java: A tester class for spaceships.
    StarfleetManagerTester.java: A tester class for the Starfleet Manager.
    StarfleetManagerTester-Output.txt: Expected output for the Starfleet Manager Tester.

Abstract Classes and Comparators:

    myAbstCrewMember.java: Abstract class for crew members.
    myAbstFigher.java: Abstract class for fighters.
    myAbstSpaceship.java: Abstract class for spaceships.
    myMapComperator.java: Comparator for maps.
    myRankComperator.java: Comparator for ranks.
    mySpaceshipComperator.java: Comparator for spaceships.

Quick Start Guide:

    Clone the repository.
    Navigate to the project directory.
    Compile the Java files:

javac *.java

    Run the testers to observe the functionality:

java SpacefleetTester
java StarfleetManagerTester
