package com.example.slicelink.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkResponseDto {

    String shortUrl;

    String originalUrl;

    Integer noOfClicks;



}
