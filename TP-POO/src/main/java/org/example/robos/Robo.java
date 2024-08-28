package org.example.robos;

import org.example.Carroceria.Carroceria;
import org.example.Sonda.Sonda;
import org.example.equipe.Equipe;
import org.example.data.Terreno;
import org.example.data.Celula;

import java.util.Random;

public abstract class Robo {
    public Robo(Terreno terreno, String nome, float tempo) {
        this.terreno = terreno;
        this.nome = nome;
        this.tempo = tempo;
    }

    protected Terreno terreno;
    Carroceria carroceria;
    Sonda sonda;
    protected String nome;
    protected int usosSonda = 2;
    protected float prospecta = 0, helioatual = 0, heliototal = 0;
    protected float cargaMax = carga();
    protected float tempo;
    protected int direcao = 1;
    protected Celula celula;
    public String getNome() {
        return nome;
    }
    public void setTempo(float tempo) {
        this.tempo = tempo;
    }
    public int esquerda() {
        // 1 cima, 2 baixo, 3 esqueda, 4 direita
        switch (direcao) {
            case 1:
                direcao = 3;
                return direcao;
            case 2:
                direcao = 4;
                return direcao;
            case 3:
                direcao = 2;
                return direcao;
            case 4:
                direcao = 1;
                return direcao;
        }
        System.out.println("Houve um erro");
        return direcao;
        
    }
    public int direita() {

        // 1 cima, 2 baixo, 3 esquerda, 4 direita
        switch (direcao) {
            case 1:
                direcao = 4;
                return direcao;
            case 2:
                direcao = 3;
                return direcao;
            case 3:
                direcao = 1;
                return direcao;
            case 4:
                direcao = 2;
                return direcao;
        }
        System.out.println("Houve um erro");
        return direcao;
    }
    public boolean anda() {
        switch (direcao) {
            case 1:
                if (celula.getY() >= terreno.getLargura()) {
                    return false;
                } else{
                    tempoAndar();
                    celula.setY(celula.getY()+1);
                }
                break;

            case 2:
                if (celula.getY() <= 0) {
                    return false;
                } else {
                    tempoAndar();
                    celula.setY(celula.getY()-1);
                }
                break;

            case 3:
                if (celula.getX() <= 0) {
                    return false;
                } else {
                    tempoAndar();
                    celula.setX(celula.getX()-1);
                }
                break;

            case 4:
                if (celula.getX() >= terreno.getComprimento()) {
                    return false;
                } else {
                    tempoAndar();
                    celula.setX(celula.getX()+1);
                }
                break;
        }
        return true;
    }
    public float rugosidade() {
        tempo -= 2;
        Celula celulaVisivel;
        switch (direcao) {
            case 1:
                if (celula.getY() >= terreno.getLargura()) {
                    return 0;
                } else {
                    celulaVisivel = terreno.getCelula(celula.getX(), celula.getY() + 1);
                    return celulaVisivel.getRugosidade();
                }

            case 2:
                if (celula.getY() <= 0) {
                    return 0;
                } else {
                    celulaVisivel = terreno.getCelula(celula.getX(), celula.getY() - 1);
                    return celulaVisivel.getRugosidade();
                }

            case 3:
                if (celula.getX() <= 0) {
                    return 0;
                } else {
                    celulaVisivel = terreno.getCelula(celula.getX() - 1, celula.getY());
                    return celulaVisivel.getRugosidade();
                }

            case 4:
                if (celula.getX() >= terreno.getComprimento()) {
                    return 0;
                } else {
                    celulaVisivel = terreno.getCelula(celula.getX() + 1, celula.getY());
                    return celulaVisivel.getRugosidade();
                }
        }
        return 0;
    }
    public Celula posicao(){
        tempo -= 1;
        return celula;
    }
    public float sonda() {
        chanceErro();
        helioatual = helioatual + (prospecta * sonda.getBuffVolume());
        helioatual = Math.min(cargaMax, helioatual);
        celula.setHelio3(0);
        tempoSonda();
        return prospecta;
    }
    public float concentracao() {
        prospecta = terreno.getCelula(celula.getX(), celula.getY()).getHelio3();
        tempo -= 2 * carroceria.getBuffConcentracao();
        return prospecta;
    }
    public float tempo(){
        return tempo;
    }
    public void tempoSonda(){
        if (prospecta > 0){
            tempo -= 5 * sonda.getBuffExtracao();
        }
        else { tempo -= 3 * sonda.getBuffExtracao();}
    }
    public void chanceErro(){
        int chanceerro = 1;

        Random random = new Random();
        chanceerro = random.nextInt(chanceerro + 2);

        if (chanceerro == 0) {
            prospecta = celula.getHelio3() - celula.getErroleitura();
        } else if (chanceerro == 1) {
            prospecta = celula.getHelio3() - celula.getErroleitura2();
        } else {
            prospecta = celula.getHelio3();
        }
    }
    public float carga(){
        float max = 2.0F;
        return max * carroceria.getBuffCarga();
    }
    public void capacidade(){
        if (helioatual <= cargaMax){
            System.out.println(helioatual + " / " + cargaMax);}
        else {
            helioatual = cargaMax;
            System.out.println("A carga máxima foi atingida");
        }
    }
    public void descarga(){
        heliototal += helioatual;
        helioatual = 0;
        tempoInatividade();
    }
    public float tempoInatividade(){
        float tempoGasto = 4 * carroceria.getMultInatividade();
        tempo -= tempoGasto;
        return tempoGasto;
    }
    public float tempoAndar(){
        return 10 * rugosidade() * carroceria.getBuffAnda();
    }
}
