package ja.mrthor.back.ctlproject.resource;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ja.mrthor.back.ctlproject.entity.Home;
import ja.mrthor.back.ctlproject.entity.UploadFileResponse;
import ja.mrthor.back.ctlproject.service.FileStorageService;
import ja.mrthor.back.ctlproject.service.HomeService;
import ja.mrthor.back.ctlproject.util.ResponseUtil;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
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
