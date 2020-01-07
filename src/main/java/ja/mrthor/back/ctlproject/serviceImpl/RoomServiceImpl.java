package ja.mrthor.back.ctlproject.serviceImpl;

import ja.mrthor.back.ctlproject.entity.Room;
import ja.mrthor.back.ctlproject.respository.RoomRepository;
import ja.mrthor.back.ctlproject.service.RoomService;
import ja.mrthor.back.ctlproject.util.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Page<Room> getRoomsByHomeId(Integer homeId, Integer pageIndex, Integer perPage) {
        Pageable pageable = PageRequest.of(pageIndex, perPage, Sort.by("name"));

        Page<Room> pageRooms = roomRepository.findAll(pageable);

        return pageRooms;
    }
}
