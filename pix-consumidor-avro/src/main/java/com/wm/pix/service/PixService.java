package com.wm.pix.service;

import com.wm.pix.avro.Pix;
import com.wm.pix.dto.PixDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PixService {

    private final KafkaTemplate<String, Pix>  kafkaTemplate;

    public PixDTO salvarPix(PixDTO pixDTO) {

        Pix pix =  Pix.newBuilder()
                .setChaveDestino(pixDTO.getChaveDestino())
                .setChaveOrigem(pixDTO.getChaveOrigem())
                .setStatus(pixDTO.getStatus().toString())
                .setValor(pixDTO.getValor())
                .setDataTransferencia(pixDTO.getDataTransferencia().toString())
                .build();

        kafkaTemplate.send("pix-topic-avro", pixDTO.getChaveOrigem(), pix);
        return pixDTO;
    }

}
