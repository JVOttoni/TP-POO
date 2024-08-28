package org.example.data;

public class Celula {

    private int x;
    private int y;
    private float helio3; //entre 0 e 1, padrão 1
    private float rugosidade; //entre 0 e 1, padrão 0



    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setHelio3(float helio3) {
        this.helio3 = helio3;
    }
    public float getHelio3() {
        return helio3;
    }
    
    public float getRugosidade() {
        return rugosidade;
    }
    public float getErroleitura() {
        return erroleitura;
    }
    public float getErroleitura2() {
        return erroleitura2;
    }
    private float erroleitura, erroleitura2; //entre 0 e 0.1, padrão [0.02,0.02]
}
