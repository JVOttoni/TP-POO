TRABALHO PRÁTICO - PARTE 1

1. INTRODUÇÃO
Este documento tem como objetivo apresentar o jogo desenvolvido, seus conceitos e
funcionalidades, focado nas boas práticas de programação orientada a objetos. O jogo trata-se
de uma disputa entre robôs no terreno lunar, que devem capturar hélio-3. Os robôs são
lançados aleatoriamente nas células do mapa e, por fim, vence quem coleta maior quantia de
hélio-3.
Serão apresentados uma breve introdução aos conceitos utilizados, o funcionamento
do código e as instruções para execução.
3. IMPLEMENTAÇÃO
Nesta seção serão apresentados brevemente os módulos desenvolvidos e seu
funcionamento.
2.1 ARQUIVO DE ENTRADA
Foram utilizados dois arquivos de entrada do tipo .json, um para especificações das
equipes que disputarão a partida e o outro com características do terreno do jogo, contendo a
rugosidade, taxas de erro de leitura e a quantidade de hélio-3 de cada célula.
2.2 CONFIG
O arquivo de entrada é lido neste módulo, e são recebidos os dados tais quais os
nomes das equipes, os comandos e o tempo da partida.
2.3 TERRENO
A classe “Terreno” é usada para gerar o terreno de células retangulares onde o jogo se
passará. Os atributos privados utilizados foram “largura” e “comprimento”, que representam
as dimensões do terreno lunar. Já o atributo privado “celulas” corresponde ao array de
objetos da classe “Celula”, que configuram as partes individuais do terreno.
O método “gerarTerreno” lê o conteúdo do arquivo .json e usa o gson para criar uma
instância de “Terreno” a partir dos dados apresentados no arquivo de entrada. Ademais, o
método “getCelula” permite acessar uma célula específica através das coordenadas e calcula
seu índice. Os métodos “getLargura” e “getComprimento” são utilizados simplesmente para
retornar os valores dos atributos largura e comprimento respectivamente.
2.4 CELULA
Os atributos privados dessa classe são as coordenadas x e y do terreno, a rugosidade
da célula e a concentração de hélio-3.
Foram utilizados nesses módulos os métodos getters “getX”, “getY”,
“getRugosidade”,”getHelio3”, “getErroleitura” e “getErroleitura02”, que retornam as
coordenadas x e y, a rugosidade, a quantidade de hélio-3 e os coeficientes de erro de leitura
respectivamente. Já o método setter “setHelio3” possibilita definir o valor de hélio-3 na
célula, recebendo o número como parâmetro e atualizando o atributo “helio3” com essa
quantidade.
2.5 POSICAO
A classe “Posicao” representa o posicionamento do robô. Seu funcionamento é
principalmente uma estrutura de dados simples que armazena os valores das coordenadas
“Posx” e “Posy”.
As classes apresentadas até o momento pertencem ao pacote “data”. O uso de pacotes
é essencial para organização, manutenção e reutilização de códigos.
2.6 CONTROLADOR
O módulo “controlador” é responsável por receber os comandos das equipes através
de um array de objetos do atributo “comandos” e executar o jogo, movendo os robôs pelo
mapa, colhendo hélio-3 e controlando o tempo de jogo. Além disso, é configurado para que
robôs diferentes não estejam prospectando na mesma célula.
O método “seguirComandos” recebe o objeto “Robo” e executa os comandos
atribuídos a ele. Após verificar se o tempo da equipe ainda não acabou, é utilizado um switch
para realizar os comandos necessários, como a impressão do tempo, se o robô virou para
esquerda ou direita e para onde ele olha, avalia se pode ir para a próxima posição e
informações específicas, como sonda, rugosidade, posição e concentração de hélio-3.
2.7 EQUIPE
A classe “equipe” é usada simplesmente para pegar e armazenar o nome de uma
equipe. Neste módulo, foram utilizados os conceitos do encapsulamento ao tornar o atributo
“name” privado e fornecer um método getter “getName” para acessá-lo. Dessa forma, os
dados da equipe são controlados e protegidos.
Sendo assim, as classes da seção 3.6 e 3.7 pertencem ao package “equipe”.
2.8 MAIN
O método main, contido no package “robo”, representa o ponto de entrada do
programa, pois inicia o jogo, lê informações de configuração e terreno, cria robôs para duas
equipes, executa comandos nas equipes e relata a pontuação final. Os comandos para a equipe
A são executados pelo “controladorA” usando o método “seguirComandos”, e os comandos
para a equipe B são executados pelo “controladorB” usando o mesmo método. Os robôs são
inicializados em células aleatórias e o jogo é executado.
4. EXECUÇÃO
O programa foi desenvolvido e testado usando o aplicativo intellij, portanto, não
houve regras específicas para executá-lo além da certificação de que os arquivos .json estão
corretamente inseridos. Todavia, caso compilado em um terminal, a classe com os principais
comandos é a main.
