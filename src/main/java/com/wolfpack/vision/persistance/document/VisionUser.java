package com.wolfpack.vision.persistance.document;

import com.wolfpack.vision.model.InterestDTO;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Builder
@Data
public class VisionUser {
    @Id
    private String id;
    private String password;
    private String name;
    private String emailId;
    private String doB;
   private List<InterestDTO> interest;
}
