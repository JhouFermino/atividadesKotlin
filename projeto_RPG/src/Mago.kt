// Mago possui o atributo Magia, potencializando seu poder especial
class Mago(
    nome: String, forca: Int, velocidade: Int, vida: Int,
    var magia: Int  // atributo exclusivo: amplifica o poder
) : Personagem(nome, forca, velocidade, vida) {

    // Poder: dano = Magia + Força + Vida (enunciado: "somada junto do atributo de Magia")
    override fun usarPoder(inimigo: Personagem) {
        val dano = magia + forca + vida
        println("$nome conjurou MAGIA causando $dano de dano!")
        inimigo.receberDano(dano)
    }
}