package com.fisc.decltaf.web.rest;

import com.fisc.decltaf.service.DecltafKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/decltaf-kafka")
public class DecltafKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DecltafKafkaResource.class);

    private DecltafKafkaProducer kafkaProducer;

    public DecltafKafkaResource(DecltafKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
