package com.app.vitalsign.mapper;

import com.app.vitalsign.dto.VitalSignDTO;
import com.app.vitalsign.entity.VitalSign;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface VitalSignMapper {

    VitalSign toEntity(VitalSignDTO vitalSignDTO);

    VitalSignDTO toDTO(VitalSign vitalSign);
}
