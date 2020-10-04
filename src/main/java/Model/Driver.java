package Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("drivers")
public class Driver {

    @Id
    private ObjectId _id;

    private String driverId;
    private Integer ridesCompleted;
    private Double rating;
    public Driver(ObjectId _id, String driverId, Integer ridesCompleted, Double rating) {
        this._id = _id;
        this.driverId = driverId;
        this.ridesCompleted = ridesCompleted;
        this.rating = rating;
    }


    // ObjectId needs to be converted to string
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getDriverId() { return driverId; }
    public void setDriverId(String passengerId) { this.driverId = driverId; }

    public Integer getRidesCompleted() { return ridesCompleted; }
    public void setRidesCompleted(Integer ridesCompleted) { this.ridesCompleted = ridesCompleted; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }
}

