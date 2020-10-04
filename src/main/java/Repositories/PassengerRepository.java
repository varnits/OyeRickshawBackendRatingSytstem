package Repositories;

import Model.Driver;
import Model.Passenger;
import Model.Ride;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends MongoRepository<Passenger, String> {
    Driver findBy_id(ObjectId _id);
    @Query("{ 'passengerId' : ?0 }")
    Passenger findByPassengerId(String passengerId);
}