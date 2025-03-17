package com.app.vitalsign.service;

import com.app.vitalsign.dto.VitalSignDTO;
import com.app.vitalsign.entity.VitalSign;
import com.app.vitalsign.mapper.VitalSignMapper;
import com.app.vitalsign.repository.VitalSignRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VitalSignService {

    @Autowired
    private VitalSignRepository repository;

    @Autowired
    private VitalSignMapper vitalSignMapper;

    public VitalSignDTO saveVitalSign(VitalSignDTO vitalSignDTO) {
        VitalSign vitalSign = vitalSignMapper.toEntity(vitalSignDTO);
        vitalSign = repository.save(vitalSign);

        return vitalSignMapper.toDTO(vitalSign);
    }

    public List<VitalSignDTO> getAllVitalSigns() {
        return repository.findAll().stream()
                .map(vitalSign -> vitalSignMapper.toDTO(vitalSign)).collect(Collectors.toList());
    }
}

