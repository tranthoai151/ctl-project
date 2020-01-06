package ja.mrthor.back.ctlproject.resource;

import ja.mrthor.back.ctlproject.entity.Home;
import ja.mrthor.back.ctlproject.entity.Room;
import ja.mrthor.back.ctlproject.service.RoomService;
import ja.mrthor.back.ctlproject.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class RoomResource {
    private final Logger log = LoggerFactory.getLogger(RoomResource.class);

    @Autowired
    private RoomService roomService;
    @GetMapping("/rooms_of_home/{homeId}")
    public List<Room> getRoomsByHomeId(@PathVariable Integer homeId) {
        List<Room> rooms = roomService.getRoomsByHomeId(homeId);
        if(rooms.size() == 0 && rooms.isEmpty()){
            throw new RuntimeException("Some Error has Happened! Contact Support at Dragons");
        }
        return rooms;
    }

}
