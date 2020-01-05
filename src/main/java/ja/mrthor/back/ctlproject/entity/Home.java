package ja.mrthor.back.ctlproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * @author mrthor
 *
 */
@Entity
@Table(name = "home")
public class Home {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="number_of_rooms")
    private String numberOfRooms;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="status")
    private String status;

    @Column(name="images")
    private String images;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}