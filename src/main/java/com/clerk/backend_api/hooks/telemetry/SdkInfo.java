package com.clerk.backend_api.hooks.telemetry;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class SdkInfo {
    public String version;
    public String name;
    public String groupId;

    public SdkInfo(String version, String name, String groupId) {
        this.version = version;
        this.name = name;
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "{" +
                "\"version\":\"" + version + '"' +
                ",\"name\":\"" + name + '"' +
                ",\"groupId\":\"'" + groupId + '"' +
                '}';
    }


    public static Optional<SdkInfo> loadFromResources() {
        String[] possiblePaths = {
                "/META-INF/maven/com.clerk/backend-api/pom.properties",
                "META-INF/maven/com.clerk/backend-api/pom.properties",
                "build/resources/main/META-INF/maven/com.clerk/backend-api/pom.properties"
        };

        for (String path : possiblePaths) {
            try (InputStream input = SdkInfo.class.getClassLoader().getResourceAsStream(path)) {
                if (input != null) {
                    Properties properties = new Properties();
                    properties.load(input);
                    return Optional.of(new SdkInfo(
                            properties.getProperty("version"),
                            properties.getProperty("artifactId"),
                            properties.getProperty("groupId")));
                }
            } catch (IOException e) {
                return Optional.empty();
            }
        }

        return Optional.empty();
    }

}
