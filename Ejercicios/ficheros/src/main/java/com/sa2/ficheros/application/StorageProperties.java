package com.sa2.ficheros.application;

import com.sa2.ficheros.FicherosApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {
    String ruta = FicherosApplication.ruta;

    private String location = "upload-dir";

    public StorageProperties() {
        if(ruta.equals("")){
            this.setLocation("upload-dir");
        }
        else{
            this.setLocation(this.ruta);
        }
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
