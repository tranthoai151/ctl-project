package ja.mrthor.back.ctlproject.serviceImpl;

import ja.mrthor.back.ctlproject.entity.Home;
import ja.mrthor.back.ctlproject.respository.HomeRepository;
import ja.mrthor.back.ctlproject.service.HomeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Home getHomeById(Integer id) {
        Home home = homeRepository.getOne(id);
        return home;
    }

    @Override
    public Optional<Home> findOne(Integer id) {
        return homeRepository.findById(id);
    }
}
