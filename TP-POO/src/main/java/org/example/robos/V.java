package org.example.robos;

import org.example.Carroceria.Carroceria;
import org.example.Carroceria.CarroceriaAvancada;
import org.example.Sonda.SondaPrecisao;
import org.example.data.Celula;
import org.example.data.Terreno;

import java.util.Random;

public class V extends Robo{
    public int countCarroceria = 1;
    public V(Terreno terreno, boolean carroceria, String nome, float tempo) {
        super(terreno, nome, tempo);
        if (carroceria) {
            if (countCarroceria == 0){
                throw new ExcessoCarrocerias();
            }
            this.carroceria = new CarroceriaAvancada();
            countCarroceria --;
        }else this.carroceria = new Carroceria();
        this.sonda = new SondaPrecisao();
    }
    public void chanceErro(){
        int chanceerro = 1;

        Random random = new Random();
        chanceerro = random.nextInt(chanceerro + 10 * sonda.getPrecisao());

        if (chanceerro <= 1) {
            prospecta = celula.getHelio3() - celula.getErroleitura();
        } else if (chanceerro > 2) {
            prospecta = celula.getHelio3();
        }
    }
    public float sonda() {
        float maxHelio = 0;
        int aux = 0;

        //O robo verifica 3 celulas e extrai a que tem maior potencial de helio3
        Celula[] celulas = new Celula[3];
        celulas[0] = terreno.getCelula(celula.getX(), celula.getY());
        celulas[1] = terreno.getCelula(celula.getX()+1, celula.getY());
        celulas[2] = terreno.getCelula(celula.getX()+2, celula.getY());

        for (int i = 0; i <= 2; i++){
            if (celulas[i].getHelio3() > maxHelio ) {
                maxHelio = celulas[i].getHelio3();
                aux = i;
            }
        }

        chanceErro();
        if (maxHelio >= sonda.getPrecisao()) {
            helioatual = helioatual + maxHelio;
            celulas[aux].setHelio3(0);
        }

        return maxHelio;
    }
    public float tempoAndar(){
        float tempoGasto = super.tempoAndar();
        if(celula.getHelio3() > 0){
            tempoGasto *= carroceria.getBuffDeslocaProspecta();
        }
        tempo -= tempoGasto;
        return tempoGasto;
    }
}
