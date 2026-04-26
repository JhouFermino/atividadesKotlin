import kotlin.random.Random

// Ladino usa Sagacidade no lugar da Força nos ataques especiais
class Ladino(
    nome: String, forca: Int, velocidade: Int, vida: Int,
    var sagacidade: Int  // substitui a Força no poder
) : Personagem(nome, forca, velocidade, vida) {

    // Poder: usa Sagacidade + bônus aleatório (igual ao atacar, mas sem Força)
    override fun usarPoder(inimigo: Personagem) {
        val bonus = Random.nextInt(1, 11)
        val dano  = sagacidade + bonus
        println("$nome atacou com SAGACIDADE causando $dano de dano!")
        inimigo.receberDano(dano)
    }
}