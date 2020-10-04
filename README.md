# OyeRickshawBackendRatingSytstem
This is a springboot application that uses Mongo as a database.
The database has 3 collections
1. rides
  - rideId(String)
  - passengerId(String)
  - driverId(String)
2. passengers
  - passengersId(String)
  - ridesCompleted(Integer)
  - rating(Double)
3. drivers
  - driversId(String)
  - ridesCompleted(Integer)
  - rating(Double)
 
 For the purpose of this application, The following entities have been inserted in the MongoDB database
 -  riderIds R00001-6
 -  driverIds D00001-3
 -  passengerIds P00001-3
 
The application can be used to-

1. The passenger should be able to rate a given ride.
   - A Patch API with the request mapped to "/driverrating/{rideId}/{rating}" defined in the REST controller  
   
2. The driver should be able to see aggregated rating of his all rides
   - A Get API with the request mapped to "/getdriverrating/{driverId}" defined in the REST controller   
3. The driver should be able to rate the passenger after ride
   -  A Patch API with the request mapped to "/passengerrating/{rideId}/{rating}" defined in the REST controller  
4. The passenger should be able to see his aggregated rating based on all the rides he has taken.
   - A Get API with the request mapped to "/getpassengerrating/{driverId}" defined in the REST controller 
   
- The Rating ranges from 0-5   
- The application by default runs on server port 8080 
- The jdk version used for this project  - 15
- Use the mongo connection URI as an environment variable(MONGO_STRING) or replace it with the uri in properties file

