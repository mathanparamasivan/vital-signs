package com.app.vitalsign.controller;

import com.app.vitalsign.dto.VitalSignDTO;
import com.app.vitalsign.service.VitalSignService;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class VitalSignControllertest {

    @Mock
    VitalSignService vitalSignService;

    @InjectMocks
    VitalSignController vitalSignController;

    @Test
    public void testGetVitalSign() throws JSONException {

        List<VitalSignDTO> vitalSigns = new ArrayList<>();
        VitalSignDTO vitalSignDTO = new VitalSignDTO();
        vitalSignDTO.setId(1L);
        vitalSignDTO.setHeight(174.00);
        vitalSigns.add(vitalSignDTO);
        Mockito.when(vitalSignService.getAllVitalSigns()).thenReturn(vitalSigns);
        List<VitalSignDTO> result = vitalSignController.getVitalSigns();
        assertThat(result, notNullValue());
        Assertions.assertEquals(1, vitalSigns.size());


        String expectedJson = "{ \"id\": 1, \"name\": \"John\" }";
        String actualJson = "{ \"name\": \"John\", \"id\": 1 }";

        //JSON compare LENIENT mode (ignores order)
        assertEquals(expectedJson, actualJson, true);

    }
}
