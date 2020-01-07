package ja.mrthor.back.ctlproject.service;


import ja.mrthor.back.ctlproject.entity.Room;
import ja.mrthor.back.ctlproject.util.ResponseData;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RoomService {
    Page<Room> getRoomsByHomeId(Integer homeId, Integer pageIndex, Integer perPage);
}
