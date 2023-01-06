package com.adilcodes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private String id;
    private String title;
    private String desc;
    private String link;
    private String deletehash;
}
