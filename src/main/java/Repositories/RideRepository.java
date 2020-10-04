package Repositories;

import Model.Ride;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;



public interface RideRepository extends MongoRepository<Ride, String> {
    Ride findBy_id(ObjectId _id);
    @Query("{ 'rideId' : ?0 }")
    Ride findByRideId(String rideId);
}