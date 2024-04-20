package com.cele.pinganblue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class PinganblueApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinganblueApplication.class, args);
    }

}
