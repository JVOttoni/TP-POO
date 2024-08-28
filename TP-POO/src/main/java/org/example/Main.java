package org.example;

import org.example.equipe.Controlador;
import org.example.data.Terreno;
import org.example.data.Config;
import org.example.robos.Robo;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nBEM VINDOS, SE PREPAREM PARA O RESULTADO DO JOGO!\n\n");


        Config c = Config.lerConfig("equipe.json");
        System.out.println("Nome da Primeira Equipe: " + c.equipeA.getName());
        System.out.println("Nome da Segunda Equipe: " + c.equipeB.getName());
        System.out.println("Tempo da Partida: " + c.tempo);


        Terreno mapa = Terreno.gerarTerreno("terreno.json");
        System.out.println("Tamanho Máximo do mapa: X,Y: " + mapa.getComprimento()+ ","+ mapa.getLargura() + "\n");

        Robo equipeA = new Robo();
        Robo equipeB = new Robo();
        equipeA.setTempo(c.tempo);
        equipeB.setTempo(c.tempo);
        Controlador controladorA = c.controleA;
        Controlador controladorB = c.controleB;

        equipeA.spawn(mapa, c.equipeA);
        equipeB.spawn(mapa, c.equipeB);

        controladorA.seguirComandos(equipeA);
        controladorB.seguirComandos(equipeB);

}
