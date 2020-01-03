package ja.mrthor.back.ctlproject.service;

import ja.mrthor.back.ctlproject.entity.Home;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HomeService {
    Page<Home> getHomes(Pageable pageable);
}
