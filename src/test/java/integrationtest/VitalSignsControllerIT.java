package integrationtest;

import com.app.vitalsign.VitalsignApplication;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Base64;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = VitalsignApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@WireMockTest(httpPort = 8084)
public class VitalSignsControllerIT {
    @Autowired
    private MockMvc mockMvc;

    String username = "Suku1";
    String password = "Suku1";
    String basicAuthHeader = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

    @Test
    void testGetWeather_Success() throws Exception {
        mockMvc.perform(get("/vital-signs")
                        .header("Authorization", basicAuthHeader) // ✅ Add Basic Auth Header
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetWeather_WireMock_Success() throws Exception {
        // ✅ Mock external Login API response (Correct way)
        WireMock.stubFor(WireMock.post(WireMock.urlPathEqualTo("/auth/login"))
                .withQueryParam("username", WireMock.equalTo("admin"))
                .withQueryParam("password", WireMock.equalTo("admin"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"token\": \"mockjwt\"}"))); // Mocked JWT Token


        WireMock.stubFor(WireMock.get("/api/users")
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("[ {"
                                + " \"id\": 10,"
                                + " \"name\": \"Suku1\","
                                + " \"mobileNumber\": \"9876543220\","
                                + " \"role\": \"USER\""
                                + " }]")));


        // ✅ Store the result and print response
        MvcResult result = mockMvc.perform(get("/vital-signs")
                        .header("Authorization", basicAuthHeader)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn(); // Store result

        // ✅ Print response body
        String responseBody = result.getResponse().getContentAsString();
        System.out.println("Response Body: " + responseBody);
    }
}
