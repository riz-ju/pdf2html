package com.example.demo.models;


import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConversionDTO {
    //private String status;
    private String pdfUrl;
    private String convertedPath;
}
