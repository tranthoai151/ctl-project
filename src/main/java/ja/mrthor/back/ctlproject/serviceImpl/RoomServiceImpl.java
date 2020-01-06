package ja.mrthor.back.ctlproject.serviceImpl;

import ja.mrthor.back.ctlproject.entity.Room;
import ja.mrthor.back.ctlproject.respository.RoomRepository;
import ja.mrthor.back.ctlproject.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getRoomsByHomeId(Integer homeId) {
        List<Room> rooms = new ArrayList<>();
        try{
            rooms = roomRepository.findByHomeId(homeId);
        }catch (Exception e){
            rooms = null;
            System.out.println(e.getMessage());
        }
        return rooms;
    }
}
