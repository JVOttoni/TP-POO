package org.example.data;
//Classes necessárias

import com.google.gson.Gson;
import org.example.equipe.Controlador;
import org.example.equipe.Equipe;
import java.io.IOException;
import java.io.FileReader;

public class Config {

    public Equipe equipeA;
    public Equipe equipeB;
    public float tempo;

    public static Config lerConfig(String arquivo)  {
        Gson gson = new Gson();
        try {
            FileReader file = new FileReader(arquivo);
            Config c = gson.fromJson(file, Config.class);
            file.close();
            return c;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
