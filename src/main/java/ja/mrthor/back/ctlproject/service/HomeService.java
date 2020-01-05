package ja.mrthor.back.ctlproject.service;

import ja.mrthor.back.ctlproject.entity.Home;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HomeService {
    List<Home> getHomes();
}
