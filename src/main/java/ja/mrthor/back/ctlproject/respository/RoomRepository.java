package ja.mrthor.back.ctlproject.respository;

import ja.mrthor.back.ctlproject.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    //@Query(value = "select r from Room r where r.homeId = :homeId")
    List<Room> findByHomeId(Integer homeId);
}
