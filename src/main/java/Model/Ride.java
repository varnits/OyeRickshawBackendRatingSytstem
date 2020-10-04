package Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rides")
public class Ride {

    @Id
    private ObjectId _id;

    private String rideId;
    private String passengerId;
    private String driverId;
    public Ride(ObjectId _id, String rideId, String passengerId, String driverId) {
        this._id = _id;
        this.rideId = rideId;
        this.passengerId = passengerId;
        this.driverId = driverId;
    }

    // ObjectId needs to be converted to string
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getPassengerId() { return passengerId; }
    public void setPassengerId(String passengerId) { this.passengerId = passengerId; }

    public String getDriverId() { return driverId; }
    public void setDriverId(String driverId) { this.driverId = driverId; }

    public String getRideId() { return rideId; }
    public void setRideId(String rideId) { this.rideId = rideId; }
}