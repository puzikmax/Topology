package com.service.Topology.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@Service
public class MessageService {
    public byte[] uploadXmlMessage(MultipartFile file) throws IOException {
        byte[] xmlMessage = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new ByteArrayOutputStream());
        stream.write(xmlMessage);
        stream.flush();
        stream.close();
        String string = new String(xmlMessage);
        System.out.println(string);
        return xmlMessage;
    }
    public String uploadXmlToString(MultipartFile file) throws IOException {

        return fileWriter;
    }
}
