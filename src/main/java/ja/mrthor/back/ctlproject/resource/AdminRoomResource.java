package ja.mrthor.back.ctlproject.resource;

import ja.mrthor.back.ctlproject.entity.Room;
import ja.mrthor.back.ctlproject.service.RoomService;
import ja.mrthor.back.ctlproject.util.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin/rooms")
public class AdminRoomResource {
    private final Logger log = LoggerFactory.getLogger(AdminRoomResource.class);

    @Autowired
    private RoomService roomService;

    //get rooms by home
    @GetMapping("/rooms_of_home/{homeId}")
    public ResponseData getRoomsByHomeId(@PathVariable Integer homeId, @RequestParam(name = "pageIndex") Integer pageIndex,
                                               @RequestParam(name = "perPage") Integer perPage) {
        ResponseData response = new ResponseData();

        Page<Room> rooms = roomService.getRoomsByHomeId(homeId, pageIndex, perPage);
        if(rooms == null){
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Some Error has Happened! Contact Support at Dragons Admin");
            return response;
        }
        response.setData(rooms.getContent());
        response.setPageIndex(rooms.getNumber());
        response.setPerPage(rooms.getSize());
        response.setTotalPage(rooms.getTotalPages());
        response.setStatus(HttpStatus.OK);
        response.setMessage("Success");
        return response;
    }

    //get room by Id
    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Integer id){
        Room room = new Room();
        room = roomService.getRomById(id);
        return room;
    }

}
