package com.Springzada.API.config;

import io.github.cdimascio.dotenv.Dotenv;

public class APIconfig {

    public static void loadEnv(){
        Dotenv dotenv = Dotenv.configure().load();

        String url = dotenv.get("DATABASE_URL");
        String username = dotenv.get("DATABASE_USERNAME");
        String password = dotenv.get("DATABASE_PASSWORD");

        System.setProperty("DATABASE_URL", url);
        System.setProperty("DATABASE_USERNAME", username);
        System.setProperty("DATABASE_PASSWORD", password);
    }
    
}
