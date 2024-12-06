package com.wm.pix.controller;

import com.wm.pix.dto.PixDTO;
import com.wm.pix.dto.PixStatus;
import com.wm.pix.service.PixService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/pix")
@RequiredArgsConstructor
public class PixController {

    private final PixService pixService;

    @PostMapping
    public PixDTO salvarPix(@RequestBody PixDTO pixDTO) {

        pixDTO.setDataTransferencia(LocalDateTime.now());
        pixDTO.setStatus(PixStatus.EM_PROCESSAMENTO);

        return pixService.salvarPix(pixDTO);
    }
}
