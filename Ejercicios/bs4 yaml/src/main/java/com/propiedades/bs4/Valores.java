package com.propiedades.bs4;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "my")
public class Valores {

    private int VAR2;

    public int getVAR2() {
        return VAR2;
    }

    public void setVAR2(int VAR2) {
        this.VAR2 = VAR2;
    }

    @Override
    public String toString() {
        return "Valores{" +
                "VAR2=" + VAR2 +
                '}';
    }
}
