package Repositories;
import Model.Driver;
import Model.Ride;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends MongoRepository<Driver, String> {
    Driver findBy_id(ObjectId _id);
    @Query("{ 'driverId' : ?0 }")
    Driver findByDriverId(String driverId);

}