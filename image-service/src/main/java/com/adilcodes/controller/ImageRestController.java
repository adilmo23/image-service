package com.adilcodes.controller;

import com.adilcodes.Exception.NoAuthAccessTokenException;
import com.adilcodes.entity.Image;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Base64;

import static org.apache.tomcat.util.http.fileupload.FileUploadBase.MULTIPART_FORM_DATA;

@RestController
@RequestMapping("v1/images")
public class ImageRestController {


    @Value("${imgur.client.access_token}")
    private String accessToken;

    @Value("${imgur.client.view}")
    private String viewUrl;

    @Value("${imgur.client.uploadUrl}")
    private String uploadUrl;


    @GetMapping("/view/{imageHash}")
    public ResponseEntity view(@RequestParam(name = "{imageHash}") Image imageHash) {
        if (StringUtils.isBlank(accessToken)) {
            throw new NoAuthAccessTokenException("Access token not found, need admin auth");
        }
        HttpClient request = HttpClient.newBuilder().build();
        HttpRequest response = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(viewUrl + imageHash.getId()))
                .headers("Content-Type", MULTIPART_FORM_DATA, "Authorization", "Bearer " + accessToken)
                .build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam(name = "image") MultipartFile image) throws IOException {
        if (StringUtils.isBlank(accessToken)) {
            throw new NoAuthAccessTokenException("Access token not found, need admin auth");
        }
        String base64Img = Base64.getEncoder().encodeToString(image.getBytes());
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("title", "your title");
        body.add("image", base64Img);
        body.add("description", "your desc");
        body.add("type", "base64");
        HttpClient request = HttpClient.newBuilder().build();
        HttpRequest response = HttpRequest.newBuilder()
                .headers("Content-Type", MULTIPART_FORM_DATA, "Authorization", "Bearer " + accessToken)
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(body)))
                .build();
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{delete}")
    public ResponseEntity delete(@RequestParam("deletehash") Image image) {
        if (StringUtils.isBlank(accessToken)) {
            throw new NoAuthAccessTokenException("Access token not found, need admin auth");
        }
        HttpClient request = HttpClient.newBuilder().build();
        HttpRequest response = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create(viewUrl + image.getDeletehash()))
                .headers("Content-Type", MULTIPART_FORM_DATA, "Authorization", "Bearer " + accessToken)
                .build();
        return ResponseEntity.ok().body(response);
    }


}
