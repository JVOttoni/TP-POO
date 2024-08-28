package org.example.equipe;

import org.example.data.Celula;
import org.example.robos.Robo;

import java.util.Random;

public class Controlador {

    static enum Estado {
        CONCENTRA,
        SONDA,
        ESCOLHER_DIRECAO,
        ANDAR
    }
    Estado estado = Estado.CONCENTRA;
    private static Random random = new Random();
    public void seguirComandos(Robo robo) {
        float cargaMax = robo.carga();

        while(tempo>0){
        switch (estado) {
            case CONCENTRA:
                float concentracao = robo.concentracao();
                if (concentracao > 0) estado = Estado.SONDA;
                else estado = Estado.ESCOLHER_DIRECAO;
                break;

            case SONDA:
                float prospecta = robo.sonda();
                System.out.println("O robô " + robo.getNome() + " prospectou " + prospecta + " de Helio 3");
                if (cargaMax == prospecta){
                    robo.descarga();
                }
                robo.capacidade();
                estado = Estado.ESCOLHER_DIRECAO;
                break;

            case ESCOLHER_DIRECAO:
                boolean bool = random.nextBoolean();
                float rugoso = robo.rugosidade();
                if (bool){
                    robo.esquerda();
                }
                else robo.direita();

                if (rugoso < robo.rugosidade()){
                    if (bool){
                        robo.direita();
                    }
                    else robo.esquerda();
                }
                robo.tempo();
                estado = Estado.ANDAR;

            case ANDAR:
                robo.anda();
                Celula celula = robo.posicao();
                System.out.println("X: " + celula.getX() + " / Y: " + celula.getY());
                estado = Estado.CONCENTRA;
            }
        }
    }
}
