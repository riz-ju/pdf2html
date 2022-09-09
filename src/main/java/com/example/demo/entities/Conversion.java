package com.example.demo.entities;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conversion {

    @Id
    private String conversionId;
    private String status;
    private String pdfUrl;
    private String convertedPath;
    private String createdTime;
    private String modifiedTime;

}
