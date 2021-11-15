package com.sanix.spring_cloud_stream_demo.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {

    private String title;
    private String actor;
    private int year;
}
