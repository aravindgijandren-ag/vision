package com.wolfpack.vision.persistance.document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venue {
    private String name;
    private Location location;
    private int score;
}
