package com.example.slicelink.Service;


import com.example.slicelink.Dto.LinkResponseDto;
import com.example.slicelink.Entity.Link;
import com.example.slicelink.Repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class LinkService {

    private static final String ALPHANUMERIC_CODE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ&abcdefghijklmnopqrstuvwxyz?0123456789";
    private static final int URL_CODE_LENGTH = 6;

    public String generatedCode(){

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(int i=0;i<URL_CODE_LENGTH;i++){
            int idx = random.nextInt(ALPHANUMERIC_CODE.length());

            sb.append(ALPHANUMERIC_CODE.charAt(idx));
        }
        return sb.toString();
    }


    @Autowired
    LinkRepository linkRepository;

    public Link shortenLink(String originalLink){

        String code = generatedCode();

        Link link = new Link();

        link.setCode(code);
        link.setOriginal(originalLink);

        return linkRepository.save(link);

    }

    public Optional<Link> getOriginalLink(String urlCode){
        Optional<Link> optionalLink = linkRepository.findByUrlCode(urlCode);
        if (optionalLink.isPresent()) {
            Link link = optionalLink.get();
            link.setCount(link.getCount() + 1); // Increment the count
            linkRepository.save(link); // Save updated count to the database
        }
        return optionalLink;
    }

//    public ResponseEntity<LinkResponseDto> noOfLinkClicks(String urlCode) {
//        Optional<Link> optionalLink = linkRepository.findByUrlCode(urlCode);
//
//        Link link = optionalLink.get();
//
//        LinkResponseDto linkResponseDto = new LinkResponseDto(link.getUrlCode() , link.getOriginalUrl() , link.getCount());
//
//        return ResponseEntity.ok(linkResponseDto);
//    }


}
