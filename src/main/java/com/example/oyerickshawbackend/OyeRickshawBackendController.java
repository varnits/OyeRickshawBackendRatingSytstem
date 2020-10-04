package com.example.oyerickshawbackend;
import Model.Driver;
import Model.Passenger;
import Model.Ride;
import Repositories.DriverRepository;
import Repositories.PassengerRepository;
import Repositories.RideRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping(value = "/kk/{id}", method = RequestMethod.GET)
    public void getPetById(@PathVariable("id") ObjectId id) {
      System.out.println("sdadas");
    }
    @RequestMapping(value = "/driverrating/{rideId}/{rating}", method = RequestMethod.POST)
    public String rateDriverbyRideId(@PathVariable("rideId")String rideId,@PathVariable("rating")String rating) {
        System.out.println("sdadas");

        return rateDriver(rideId,Double.valueOf(rating));

    }
    @RequestMapping(value = "/getdriverrating/{driverId}", method = RequestMethod.GET)
    public String getRatingOfDriver(@PathVariable("driverId")String driverId) {
        System.out.println("sdadas");

        return getRatingForDriver(driverId);

    }
    @RequestMapping(value = "/getpassengerrating/{passengerId}", method = RequestMethod.GET)
    public String getRatingOfPassenger(@PathVariable("passengerId")String passengerId) {
        System.out.println("sdadas");
        return getRatingForPasssenger(passengerId);

    }


    @RequestMapping(value = "/passengerrating/{rideId}/{rating}", method = RequestMethod.POST)
    public String ratePassengerbyRideId(@PathVariable("rideId")String rideId,@PathVariable("rating")String rating) {
        System.out.println("sdadas");

        return ratePassenger(rideId,Double.valueOf(rating));

    }
    @RequestMapping(value = "/k", method = RequestMethod.GET)
    public String bc() {
        return "sda";
    }

    public String rateDriver(String rideId,Double rating){
        System.out.println(" s"+rideId);
        Ride ride=(rideRepository.findByRideId(rideId));
        String driverId=ride.getDriverId();
        System.out.println(" kks"+driverId);

        Driver driver = driverRepository.findByDriverId(driverId);
        Double r = driver.getRating();
        int ridesCompleted = driver.getRidesCompleted();
        Double newr = ((r * ridesCompleted) + rating) / (ridesCompleted + 1);
        driver.setRating(newr);
        driver.setRidesCompleted(ridesCompleted + 1);

        driverRepository.save(driver);



        return String.valueOf(driverRepository.findByDriverId(driverId).getRating());
    }
    public String ratePassenger(String rideId,Double rating){
        Ride ride=(rideRepository.findByRideId(rideId));
        String passengerId=ride.getPassengerId();

        Passenger passenger=passengerRepository.findByPassengerId(passengerId);
        Double p=passenger.getRating();
        int ridesCompleted=passenger.getRidesCompleted();
        Double newr=((p*ridesCompleted)+rating)/(ridesCompleted+1);
        passenger.setRating(newr);
        passenger.setRidesCompleted(ridesCompleted+1);

       passengerRepository.save(passenger);
        return String.valueOf(passengerRepository.findByPassengerId(passengerId).getRating());
    }
    private String getRatingForDriver(String driverId) {
        String rating="Not found";
        try{
            Double d=driverRepository.findByDriverId(driverId).getRating();
            return d.toString();
        }
        catch (NullPointerException e){return rating;}
    }
    private String getRatingForPasssenger(String passengerId) {
        String result="Not found";
        try{
            Double rating=passengerRepository.findByPassengerId(passengerId).getRating();
            return rating.toString();
        }
        catch (NullPointerException e){return result;}
    }
}
