package org.example.data;
//Classes necessárias

import java.io.IOException;
import java.io.FileReader;
import com.google.gson.Gson;

public class Terreno {

    private int comprimento;
    private int largura;

    public Celula getCelula(int x, int y) {
        return celulas[x * (comprimento + 1) + y];
    }

    private Celula[]celulas;

    public static Terreno lerTerreno(String arquivo){
        Gson gson = new Gson();
        try {
            FileReader file = new FileReader(arquivo);
            Terreno mapa = gson.fromJson(file, Terreno.class);
            file.close();
            return mapa;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public int getLargura() {
        return this.largura;
    }

    public int getComprimento() {
        return this.comprimento;
    }

}


