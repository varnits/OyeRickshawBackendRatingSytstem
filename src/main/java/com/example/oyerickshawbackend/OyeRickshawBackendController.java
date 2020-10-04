package com.example.oyerickshawbackend;
import Model.Driver;
import Model.Passenger;
import Model.Ride;
import Repositories.DriverRepository;
import Repositories.PassengerRepository;
import Repositories.RideRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
public class OyeRickshawBackendController {
    @Autowired
    private RideRepository rideRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private PassengerRepository passengerRepository;

    @RequestMapping(value = "/driverrating/{rideId}/{rating}", method = RequestMethod.PATCH)
    public String rateDriverbyRideId(@PathVariable("rideId")String rideId,@PathVariable("rating")Double rating) {

        return rateDriver(rideId,rating);

    }
    @RequestMapping(value = "/getdriverrating/{driverId}", method = RequestMethod.GET)
    public String getRatingOfDriver(@PathVariable("driverId")String driverId) {

        return getRatingForDriver(driverId);

    }
    @RequestMapping(value = "/getpassengerrating/{passengerId}", method = RequestMethod.GET)
    public String getRatingOfPassenger(@PathVariable("passengerId")String passengerId) {
        return getRatingForPasssenger(passengerId);

    }


    @RequestMapping(value = "/passengerrating/{rideId}/{rating}", method = RequestMethod.PATCH)
    public String ratePassengerbyRideId(@PathVariable("rideId")String rideId,@PathVariable("rating")Double rating) {

        return ratePassenger(rideId,rating);

    }
    //Fetches the driverid for a particular rideId and updates the ratings of that driver
    public String rateDriver(String rideId,Double rating){
        Ride ride;

        String driverId;
        try {
            ride=rideRepository.findByRideId(rideId);
        }
        catch(DataAccessResourceFailureException e){
            return "Couldnt Search Datastore";
        }
        //catch other exceptions

        if(ride==null)
            return "Invalid ride Id";
        driverId=ride.getDriverId();
        Driver driver = driverRepository.findByDriverId(driverId);

        Double oldRating = driver.getRating();
        int ridesCompleted = driver.getRidesCompleted();
        Double newRating = ((oldRating * ridesCompleted) + rating) / (ridesCompleted + 1);
        driver.setRating(newRating);
        driver.setRidesCompleted(ridesCompleted + 1);

        driverRepository.save(driver);



        return String.valueOf(driverRepository.findByDriverId(driverId).getRating());
    }
    //Fetches the driverid for a particular rideId and updates the ratings of that driver
    public String ratePassenger(String rideId,Double rating){
        Ride ride;
        String passengerId;
        try {
            ride=rideRepository.findByRideId(rideId);
        }
        catch(DataAccessResourceFailureException e){
            return "Couldnt Search Datastore";
        }
        //catch other exceptions

        if(ride==null)
            return "Invalid ride Id";
            passengerId=ride.getPassengerId();


        Passenger passenger=passengerRepository.findByPassengerId(passengerId);
        Double oldRating=passenger.getRating();
        int ridesCompleted=passenger.getRidesCompleted();
        Double newRating=((oldRating*ridesCompleted)+rating)/(ridesCompleted+1);
        passenger.setRating(newRating);
        passenger.setRidesCompleted(ridesCompleted+1);

       passengerRepository.save(passenger);
        return String.valueOf(passengerRepository.findByPassengerId(passengerId).getRating());
    }
    //Fetches the ratings for a particular driverId
    private String getRatingForDriver(String driverId) {
        Driver driver;
        try{
            driver=driverRepository.findByDriverId(driverId);
        }
        catch (DataAccessResourceFailureException e){return "Couldnt Search Datastore";}
        if(driver==null)
            return  "Invalid driver Id ";
        Double rating=driver.getRating();
        return rating.toString();
    }

    //Fetches the ratings for a particular driverId
    private String getRatingForPasssenger(String passengerId) {
        Passenger passenger;
        try{
             passenger=passengerRepository.findByPassengerId(passengerId);
        }
        catch (DataAccessResourceFailureException e){return "Couldnt Search Datastore";}
        if(passenger==null)
            return  "Invalid passenger Id ";
        Double rating=passenger.getRating();
            return rating.toString();
    }
}
