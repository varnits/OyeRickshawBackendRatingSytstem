package Repositories;

import Model.Passenger;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PassengerRepository extends MongoRepository<Passenger, String> {
    Passenger findBy_id(ObjectId _id);
    @Query("{ 'passengerId' : ?0 }")
    Passenger findByPassengerId(String passengerId);
}