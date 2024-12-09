package com.wm.pix.consumer;

import com.wm.pix.dto.PixDTO;
import com.wm.pix.dto.PixStatus;
import com.wm.pix.model.Key;
import com.wm.pix.model.Pix;
import com.wm.pix.repository.KeyRepository;
import com.wm.pix.repository.PixRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.avro.generic.GenericData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ValidarPix {

    @Autowired
    private PixRepository pixRepository;

    @Autowired
    private KeyRepository keyRepository;

    @KafkaListener(topics = "pix-app.public.pix", groupId = "group-1")
    public void process(GenericData.Record data) throws JsonProcessingException {
        System.out.println(data.get("after").toString());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        PixDTO dto = objectMapper.readValue(data.get("after").toString(), PixDTO.class);
        System.out.println("Pix processado: " + dto.getIdentifier());

        if (dto.getStatus().equals(PixStatus.EM_PROCESSAMENTO)) {
            Pix pix = pixRepository.findByIdentifier(dto.getIdentifier());

            Key origem = keyRepository.findByChave(dto.getChaveOrigem());
            Key destino = keyRepository.findByChave(dto.getChaveDestino());

            if (origem == null || destino == null) {
                pix.setStatus(PixStatus.ERRO);
            } else {
                pix.setStatus(PixStatus.PROCESSADO);
            }
            pixRepository.save(pix);
        }

    }

}
