package org.example.data;

import org.example.robos.FTT;
import org.example.robos.Robo;
import org.example.robos.V;
import org.example.robos.XYZ;

public class LerRobo {
    public String nome;
    public enum Tipo{
        FTT,
        V,
        XYZ
    }
    Tipo tipo;
    public boolean carroceria = false;
    public Robo criarRobo(float tempo, Terreno terreno){
        switch (tipo){
            case FTT:

                new FTT(terreno, carroceria, nome, tempo);
                break;

            case V:
                new V(terreno, carroceria, nome, tempo);
                break;

            case XYZ:
                new XYZ(terreno, carroceria, nome, tempo);
                break;
        }
        throw new RuntimeException("unreachable");
    }
}
