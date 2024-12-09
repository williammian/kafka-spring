package com.wm.pix.service;

import com.wm.pix.dto.PixDTO;
import com.wm.pix.model.Pix;
import com.wm.pix.repository.PixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PixService {

    @Autowired
    private final PixRepository pixRepository;

    public PixDTO salvarPix(PixDTO pixDTO) {
        //para o kafka-connect o produtor bastará salvar o registro no BD
        pixRepository.save(Pix.toEntity(pixDTO));
        return pixDTO;
    }

}
