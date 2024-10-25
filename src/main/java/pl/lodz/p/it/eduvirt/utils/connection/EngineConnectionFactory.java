package pl.lodz.p.it.eduvirt.utils.connection;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.ConnectionBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EngineConnectionFactory {
    @Value("${ovirt.engine.url}")
    private String url;
    @Value("${ovirt.engine.username}")
    private String user;
    @Value("${ovirt.engine.password}")
    private String password;
    @Value("${ovirt.engine.jks.file}")
    private String trustStoreFile;
    @Value("${ovirt.engine.jks.password}")
    private String trustStorePassword;

    public Connection createConnection() {
        return ConnectionBuilder.connection()
                .url(url + "/api")
                .user(user)
                .password(password)
                .trustStoreFile(trustStoreFile)
                .trustStorePassword(trustStorePassword)
                .build();
    }
}
