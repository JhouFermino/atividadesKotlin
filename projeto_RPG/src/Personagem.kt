import kotlin.random.Random

// Classe base aberta (open) para permitir herança pelas classes filhas
open class Personagem(
    val nome: String,       // nome é imutável
    var forca: Int,         // atributos mutáveis para buff/debuff
    var velocidade: Int,
    var vida: Int
) {
    // Ataca o inimigo somando força + bônus aleatório (1-10)
    open fun atacar(inimigo: Personagem) {
        val bonus = Random.nextInt(1, 11)
        val dano = forca + bonus
        println("$nome atacou causando $dano de dano!")
        inimigo.receberDano(dano)
    }

    // Tenta desviar usando velocidade; se falhar, sofre o ataque do inimigo
    fun defender(inimigo: Personagem) {
        val velHeroi   = velocidade + Random.nextInt(1, 11)
        val velInimigo = inimigo.velocidade + Random.nextInt(1, 11)
        if (velHeroi > velInimigo) {
            println("$nome desviou do ataque!")
        } else {
            inimigo.atacar(this)  // falhou: inimigo contra-ataca
        }
    }

    // Poder padrão sem efeito — cada subclasse deve sobrescrever
    open fun usarPoder(inimigo: Personagem) {
        println("$nome tentou usar um poder, mas falhou.")
    }

    // Aplica o dano recebido; pode ser sobrescrito (ex.: Guerreiro usa defesa)
    open fun receberDano(dano: Int) {
        vida = maxOf(0, vida - dano)
        println("$nome agora tem $vida de vida")
    }
}