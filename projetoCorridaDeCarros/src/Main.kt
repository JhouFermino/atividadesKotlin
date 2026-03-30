/*
Desafio do Dia (em sala)
Simule uma corrida de carros:
Crie uma classe Piloto (nome, idade, habilidade)
Crie uma classe Carro (velocidade, aceleração, freio, tanque, consumo, resistência)
Depois crie uma Lista com vários carros
Crie uma classe Pista (lista de carros, posições, voltas, clima)
A classe Pista deve uma função que define as posições dos carros de acordo com os atributos dos Pilotos e Carros.
Faça um placar
*/
fun main(){
    val piloto1 = Piloto("Ayrton", 30, 95)
    val piloto2 = Piloto("Sesssenta e Sete Rodrigues", 67, 90)
    val piloto3 = Piloto("Max", 25, 92)
    val piloto4 = Piloto("Huilson do Acre", 4, 80)

    val carro1 = Carro("Ferrari", 90, 76, 80, 100, 10, 85, piloto1)
    val carro2 = Carro("SexSiven", 67, 87, 72, 100, 15, 80, piloto2)
    val carro3 = Carro("RedBull", 92, 90, 78, 100, 11, 88, piloto3)
    val carro4 = Carro("Carro da firma (sem o parabrisa)", 100, 100, 92, 200, 30, 55, piloto4)
    val listaCarros = listOf(carro1, carro2, carro3, carro4)

    val pista = Pista(listaCarros, voltas = 10, clima = "sol")

    pista.mostrarPlacar()
}