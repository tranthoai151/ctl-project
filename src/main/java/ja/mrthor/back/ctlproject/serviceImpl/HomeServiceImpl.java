package ja.mrthor.back.ctlproject.serviceImpl;

import ja.mrthor.back.ctlproject.entity.Home;
import ja.mrthor.back.ctlproject.respository.HomeRepository;
import ja.mrthor.back.ctlproject.service.HomeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    private final HomeRepository homeRepository;

    public HomeServiceImpl(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @Override
    public List<Home> getHomes() {

        List<Home> homes = homeRepository.findAll();
        return homes;
    }
}
