package org.example.robos;

import org.example.Carroceria.Carroceria;
import org.example.Carroceria.CarroceriaAvancada;
import org.example.Carroceria.CarroceriaTurbo;
import org.example.Sonda.Sonda;
import org.example.Sonda.SondaPrecisao;
import org.example.Sonda.SondaRapida;
import org.example.data.Celula;
import org.example.data.Terreno;

import javax.swing.plaf.PanelUI;
import java.util.Random;

public class XYZ extends Robo{
    public int countCarroceria = 1;
    public XYZ(Terreno terreno, boolean carroceria, String nome, float tempo) {
        super(terreno, nome, tempo);
        if (carroceria) {
            if (countCarroceria == 0){
                throw new ExcessoCarrocerias();
            }
            this.carroceria = new CarroceriaTurbo();
            countCarroceria --;
        }else this.carroceria = new Carroceria();
        this.sonda = new SondaRapida();
    }
    public float carga() {
        float max;
        max = (float) (super.carga() * 0.5);
        return max;
    }
    public float tempoAndar(){
        float tempoGasto = super.tempoAndar() / 2;
        tempo -= tempoGasto;
        return tempoGasto;
    }
    public void tempoSonda(){
        if (prospecta > 0){
            tempo -= (float) (5.0 / 2.0);
        }
        else { tempo -= (float) (3.0 / 2.0);
        }
    }
    public void chanceErro(){
        int chanceerro = 1;

        Random random = new Random();
        chanceerro = random.nextInt(chanceerro + 3);

        if (chanceerro <= 1) {
            prospecta = celula.getHelio3() - celula.getErroleitura();
        } else if (chanceerro == 2) {
            prospecta = celula.getHelio3() - celula.getErroleitura2();
        } else {
            prospecta = celula.getHelio3();
        }
    }
}
