package com.service.Topology.controller;

import com.service.Topology.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping
public class FileController {

    private final MessageService messageService;

    public FileController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(value = "/upload")
    @ResponseBody
    public byte[] uploadFile(@RequestParam MultipartFile file) throws IOException {
        return messageService.uploadXmlMessage(file);
    }
}
