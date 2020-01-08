package ja.mrthor.back.ctlproject.resource;

import ja.mrthor.back.ctlproject.entity.Home;
import ja.mrthor.back.ctlproject.service.HomeService;
import ja.mrthor.back.ctlproject.util.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin/homes")
public class AdminHomeResource {
    private final Logger log = LoggerFactory.getLogger(HomeResource.class);

    @Autowired
    private HomeService homeService;

    //GET HOMES
    @GetMapping("/search")
    public ResponseData getHomesByAdmin(@RequestParam(name = "pageIndex") Integer pageIndex,
                                        @RequestParam(name = "perPage") Integer perPage) {
        ResponseData response = new ResponseData();

        Page<Home> homes = homeService.getHomesAllByAdmin(pageIndex, perPage);
        if(homes == null){
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Some Error has Happened! Contact Support at Dragons Admin");
            return response;
        }
        response.setData(homes.getContent());
        response.setPageIndex(homes.getNumber());
        response.setPerPage(homes.getSize());
        response.setTotalPage(homes.getTotalPages());
        response.setStatus(HttpStatus.OK);
        response.setMessage("Success");
        return response;
    }

    //GET HOME ById
    @GetMapping("/{id}")
    public Home getHomeById(@PathVariable Integer id) {
        return homeService.getHomeById(id);
    }


}
