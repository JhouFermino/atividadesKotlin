// Guerreiro herda Personagem e adiciona o atributo Defesa
class Guerreiro(
    nome: String, forca: Int, velocidade: Int, vida: Int,
    var defesa: Int  // atributo exclusivo: absorve dano
) : Personagem(nome, forca, velocidade, vida) {

    // Informa que a defesa passiva está ativa (ela age automaticamente em receberDano)
    override fun usarPoder(inimigo: Personagem) {
        println("$nome ativou ESCUDO! Defesa atual: $defesa")
    }

    // Sobrescreve receberDano: o dano é SEMPRE descontado da Defesa primeiro
    override fun receberDano(dano: Int) {
        if (defesa > 0) {
            val danoRestante = dano - defesa
            defesa = maxOf(0, defesa - dano)  // defesa absorve o que puder
            println("Defesa absorveu dano! Defesa restante: $defesa")

            if (danoRestante > 0) {
                // dano excedeu a defesa: o restante vai para a vida
                vida = maxOf(0, vida - danoRestante)
                println("Dano excedente $danoRestante passou pela defesa!")
            } else {
                println("Dano totalmente bloqueado pelo escudo!")
            }
        } else {
            // sem defesa restante: dano vai direto para a vida
            vida = maxOf(0, vida - dano)
        }
        println("$nome agora tem $vida de vida")
    }
}