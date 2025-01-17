package com.example.slicelink.Controller;


import com.example.slicelink.Dto.LinkResponseDto;
import com.example.slicelink.Entity.Link;
import com.example.slicelink.Service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping()
public class LinkController {

    @Autowired
    LinkService linkService;

    @PostMapping("/shorten")
    public ResponseEntity<Link> storeLink(@RequestParam String originalUrl){
        return ResponseEntity.ok(linkService.shortenLink(originalUrl));
    }

    @GetMapping("/{urlCode}")
    public ResponseEntity<?> backToOriginal(@PathVariable String urlCode){
        Optional<Link> optionalLink = linkService.getOriginalLink(urlCode);
        if(optionalLink.isPresent()){
            Link link = optionalLink.get();
            return ResponseEntity.status(302).location(URI.create(link.getOriginalUrl())).build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/count/{urlCode}")
//    public ResponseEntity<LinkResponseDto> linkAccesedCount(@PathVariable String urlCode){
//        return linkService.noOfLinkClicks(urlCode);
//    }

}
