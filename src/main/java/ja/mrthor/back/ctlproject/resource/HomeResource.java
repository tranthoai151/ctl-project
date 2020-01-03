package ja.mrthor.back.ctlproject.resource;

import ja.mrthor.back.ctlproject.entity.HelloWorldBean;
import ja.mrthor.back.ctlproject.entity.Home;
import ja.mrthor.back.ctlproject.service.HomeService;
import ja.mrthor.back.ctlproject.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeResource {
    private final Logger log = LoggerFactory.getLogger(HomeResource.class);

    @Autowired
    private HomeService homeService;

    @GetMapping("/homes")
    public ResponseEntity<List<Home>> getHomes(Pageable pageable) {
        log.debug("REST request to get a page of Homes");
        final Page<Home> page = homeService.getHomes(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/homes");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
}
