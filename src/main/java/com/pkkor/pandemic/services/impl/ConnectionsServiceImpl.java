package com.pkkor.pandemic.services.impl;

import com.google.gson.Gson;
import com.pkkor.pandemic.entities.connection.Connection;
import com.pkkor.pandemic.services.ConnectionsService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConnectionsServiceImpl implements ConnectionsService {
    private static final Map<String, List<String>> CONNECTIONS;

    static {
        CONNECTIONS = new HashMap<>();

        try {
            File file = new ClassPathResource("connections.json").getFile();
            String connectionsString = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
            Gson gson = new Gson();
            Connection[] connectionsArray = gson.fromJson(connectionsString, Connection[].class);
            for (Connection c : connectionsArray) {
                CONNECTIONS.computeIfAbsent(c.getFrom(), k -> new ArrayList<>());
                CONNECTIONS.get(c.getFrom()).add(c.getTo());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, List<String>> getConnections() {
        return CONNECTIONS;
    }

}
