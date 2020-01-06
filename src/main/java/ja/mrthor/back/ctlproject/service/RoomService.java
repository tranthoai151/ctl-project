package ja.mrthor.back.ctlproject.service;


import ja.mrthor.back.ctlproject.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> getRoomsByHomeId(Integer homeId);
}
