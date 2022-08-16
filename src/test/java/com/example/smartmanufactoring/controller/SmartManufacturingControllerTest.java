package com.example.smartmanufactoring.controller;


import com.example.smartmanufactoring.dto.FactoryMapper;
import com.example.smartmanufactoring.dto.LocationMapper;
import com.example.smartmanufactoring.persistence.entity.Factory;
import com.example.smartmanufactoring.persistence.entity.FactoryStatus;
import com.example.smartmanufactoring.persistence.entity.Location;
import com.example.smartmanufactoring.persistence.entity.LocationStatus;
import com.example.smartmanufactoring.rest.SmartManufacturingController;
import com.example.smartmanufactoring.service.FactoryService;
import com.example.smartmanufactoring.service.LocationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SmartManufacturingController.class)
public class SmartManufacturingControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FactoryService factoryService;

    @MockBean
    private LocationService locationService;

    @MockBean
    private FactoryMapper factoryMapper;

    @MockBean
    private LocationMapper locationMapper;

    @Test
    public void getFactoriesByAPI() throws Exception {

        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("name", "ABB");
        requestParams.add("country",null);
        requestParams.add("city",null);
        requestParams.add("street",null);
        requestParams.add("zipCode",null);
        requestParams.add("status",null);
        when(factoryService.getFactoriesBy("ABB", null, null, null, null, null))
                .thenReturn(List.of(new Factory(1l, "ABB",
                                    "ABB is a leading global technology company that energizes the transformation of society and industry to achieve a more productive, sustainable future.",
                                        54.553365,
                                        24.832456,
                                                FactoryStatus.OPERATIVE,
                                                new Location(1l, "Estonia", "Tallinn", "Sutiste tee 42", "13420", LocationStatus.ACTIVE))));
        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/smart-manufacturing/factories/")
                        .params(requestParams)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1));
    }

}
