package ja.mrthor.back.ctlproject.resource;

import ja.mrthor.back.ctlproject.entity.HelloWorldBean;
import ja.mrthor.back.ctlproject.entity.Home;
import ja.mrthor.back.ctlproject.entity.UploadFileResponse;
import ja.mrthor.back.ctlproject.service.FileStorageService;
import ja.mrthor.back.ctlproject.service.HomeService;
import ja.mrthor.back.ctlproject.util.PaginationUtil;
import ja.mrthor.back.ctlproject.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class HomeResource {
    private final Logger log = LoggerFactory.getLogger(HomeResource.class);

    @Autowired
    private HomeService homeService;

    @Autowired
    private FileStorageService fileStorageService;


    //GET HOMES
    @GetMapping("/homes")
    public List<Home> getHomes() {
        log.debug("REST request to get a page of Homes");
        List<Home> homes = homeService.getHomes();
        if(homes.size() == 0 && homes.isEmpty()){
            throw new RuntimeException("Some Error has Happened! Contact Support at Dragons");
        }
        return homes;
    }

    //GET HOME BY ID
//    @GetMapping("/homes/{id}")
//    public Home getHomesById(@PathVariable Integer id){
//        log.debug("REST request to get a page of Homes");
//        Home home = homeService.getHomeById(id);
//        return home;
//    }

    @GetMapping("/homes/{id}")
    public ResponseEntity<Home> getCompany(@PathVariable Integer id) {
        log.debug("REST request to get homes : {}", id);
        Optional<Home> home = homeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(home);
    }

    //demo file
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }
}
