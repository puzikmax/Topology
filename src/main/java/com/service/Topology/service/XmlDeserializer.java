package com.service.Topology.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.service.Topology.Entity.Message;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class XmlDeserializer {

    private final MessageService messageService;

    public XmlDeserializer(MessageService messageService) {
        this.messageService = messageService;
    }

    public Message parseMessageFromXml(String convertFile) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(convertFile, Message.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
