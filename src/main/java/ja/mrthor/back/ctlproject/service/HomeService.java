package ja.mrthor.back.ctlproject.service;

import ja.mrthor.back.ctlproject.entity.Home;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface HomeService {
    List<Home> getHomes();
    Home getHomeById(Integer id);
    Optional<Home> findOne(Integer id);

}
