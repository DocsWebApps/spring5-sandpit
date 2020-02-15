package com.docswebapps.spring5sandpit;

import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final int PORT = 9350;

    public static void main(String[] args) throws Exception {
        String appBase = ".";
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(createTempDir());
        tomcat.setPort(PORT);
        tomcat.getHost().setAppBase(appBase);
        tomcat.addWebapp("", appBase);
        System.out.println("Host:" + tomcat.getHost().toString());
        System.out.println("Port:" + PORT);
        tomcat.start();
        tomcat.getServer().await();
    }

    // based on AbstractEmbeddedServletContainerFactory
    private static String createTempDir() {
        try {
            File tempDir = File.createTempFile("tomcat.", "." + PORT);
            tempDir.delete();
            tempDir.mkdir();
            tempDir.deleteOnExit();
            return tempDir.getAbsolutePath();
        } catch (IOException ex) {
            throw new RuntimeException(
                    "Unable to create tempDir. java.io.tmpdir is set to " + System.getProperty("java.io.tmpdir"),
                    ex
            );
        }
    }
}
