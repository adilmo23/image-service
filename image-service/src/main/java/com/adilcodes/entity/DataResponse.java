package com.adilcodes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse {

    private User user;
    private List<Image> image;
    private String status;
    private boolean success;
}
