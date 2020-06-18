package com.zzx.springbootgencode.db;

import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class YamlDbProperties {
    private String url;
    private String username;
    private String password;

    public static YamlDbProperties getValue() {
        YamlDbProperties yamlDbProperties = new YamlDbProperties();
        Yaml yaml = new Yaml();
        Map<String, Object> ret = yaml.load(YamlDbProperties.class.getClassLoader().getResourceAsStream("application.yml"));
        Map<String, Object> spring = (Map<String, Object>) ret.get("spring");
        Map<String, Object> datasource = (Map<String, Object>) spring.get("datasource");

        String url = String.valueOf(datasource.get("url"));
        String username = String.valueOf(datasource.get("username"));
        String password = String.valueOf(datasource.get("password"));

        yamlDbProperties.setUrl(url);
        yamlDbProperties.setUsername(username);
        yamlDbProperties.setPassword(password);
        return yamlDbProperties;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
