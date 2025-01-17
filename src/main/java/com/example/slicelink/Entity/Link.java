package com.example.slicelink.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "link")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Column(nullable = false , unique = true)
    private String originalUrl;

    @Column(nullable = false)
    private String urlCode;


    @Column(name = "count")
    private Integer count = 0;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCode(String urlCode) {
        this.urlCode = urlCode;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public void setOriginal(String url){
        this.originalUrl = url;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
}
