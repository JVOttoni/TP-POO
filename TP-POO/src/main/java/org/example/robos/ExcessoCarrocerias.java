package org.example.robos;

public class ExcessoCarrocerias extends RuntimeException{

    @Override
    public String getMessage() {
        return "O limite de carrocerias foi atingido";
    }
}
