package com.gft.italy.azni.outlookintegrator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("outlook")
public class OutlookController {

    @Value("${app.id}")
    String appId;

    @Value("${app.scopes}")
    String appScope;

    List<String> appScopes;
    String accessToken;

    @GetMapping("/accessToken")
    public String getAccessToken() {
        System.out.println("App id - " + appId);
        appScopes = Arrays
                .asList(appScope.split(","));

        Graph.initializeGraphAuth(appId, appScopes);
        accessToken = Graph.getUserAccessToken();
        //System.out.println("Access token: " + accessToken);
        return "Access token: " + accessToken;
    }

    @GetMapping("/listCalendar")
    public String getListCalendar() {
        return "listCalendar";
    }

    @PostMapping("/event")
    public String createNewEvent() {
        return "event";
    }
}
