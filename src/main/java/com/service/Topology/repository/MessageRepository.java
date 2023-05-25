package com.service.Topology.repository;

import com.service.Topology.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

}
