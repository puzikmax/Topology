package com.service.Topology.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.service.Topology.Entity.Model;
import com.service.Topology.Entity.Point;
import com.service.Topology.repository.ModelRepository;
import com.service.Topology.repository.PointRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class MessageService {

    private final ModelRepository modelRepository;
    private final PointRepository pointRepository;

    public MessageService(ModelRepository modelRepository, PointRepository pointRepository) {
        this.modelRepository = modelRepository;
        this.pointRepository = pointRepository;
    }

    public byte[] uploadXmlMessage(MultipartFile file) throws IOException {
        byte[] xmlMessage = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new ByteArrayOutputStream());
        stream.write(xmlMessage);
        stream.flush();
        stream.close();
        //saveData(parsingXml(convertByteToString(xmlMessage)));
        saveModel(parsingModelFromXml(convertByteToString(xmlMessage)));
        return xmlMessage;
    }
    private String convertByteToString(byte[] bytes) {
        return new String(bytes);
    }
    private Point parsingXml(String convertFile) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        Point point = xmlMapper.readValue(convertFile, Point.class);
        pointRepository.save(point);
        return point;
    }
    private Model parsingModelFromXml(String convertFile) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        Model model = xmlMapper.readValue(convertFile, Model.class);
        modelRepository.save(model);
        return model;
    }
    private void saveData(Point point){
        pointRepository.save(point);
    }
    private void saveModel(Model model){
        modelRepository.save(model);
    }

}
