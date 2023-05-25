package com.service.Topology.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.service.Topology.Entity.Message;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.format.jackson.JacksonXmlFormatMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Service
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class XmlDeserializer {
    public Message parseMessageFromXml(byte[] xmlMessage) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(xmlMessage, Message.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
