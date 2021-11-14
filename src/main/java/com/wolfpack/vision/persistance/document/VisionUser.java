package com.wolfpack.vision.persistance.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@Data
public class VisionUser {
    @Id
    private String id;

    private String name;
}
