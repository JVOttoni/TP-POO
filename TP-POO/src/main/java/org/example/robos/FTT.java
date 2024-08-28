package org.example.robos;

import org.example.Carroceria.Carroceria;
import org.example.Carroceria.CarroceriaFortaleza;
import org.example.Sonda.Sonda;
import org.example.Sonda.SondaCapacidade;
import org.example.data.Celula;
import org.example.data.Terreno;

public class FTT extends Robo {
    private int countCarroceria = 1;

    public FTT(Terreno terreno, boolean carroceria, String nome, float tempo) {
        super(terreno, nome, tempo);
        if (carroceria) {
            if (countCarroceria == 0){
                throw new ExcessoCarrocerias();
            }
            this.carroceria = new CarroceriaFortaleza();
            countCarroceria --;
        }else this.carroceria = new Carroceria();
        this.sonda = new SondaCapacidade();
    }

    public float carga() {
        float max = 3 * super.carga();
        return max;
    }
    public float tempoAndar() {
        float tempoGasto = (float) (super.tempoAndar() * 1.7);
        tempo -= tempoGasto;
        return tempoGasto;
    }
    public void tempoSonda() {
        if (prospecta > 0) {
            tempo -= (float) (5.0 * 2.5);
        } else {
            tempo -= (float) (3.0 * 2.5);
        }
    }
}
