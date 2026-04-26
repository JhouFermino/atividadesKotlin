fun main() {
    // Instanciação dos três personagens com atributos iniciais
    val guerreiro = Guerreiro("Aragorn", forca=10, velocidade=5,  vida=100, defesa=30)
    val mago       = Mago     ("Gandalf", forca=8,  velocidade=6,  vida=80,  magia=20)
    val ladino     = Ladino  ("Altair",  forca=7,  velocidade=10, vida=90,  sagacidade=15)

    println("=== BATALHA: PODERES ===")
    guerreiro.usarPoder(mago)       // Guerreiro anuncia escudo
    mago.usarPoder(guerreiro)       // Mago conjura feitiço — defesa do Guerreiro absorve
    ladino.usarPoder(guerreiro)     // Ladino ataca com sagacidade

    println("\n=== BATALHA: ATAQUES NORMAIS ===")
    guerreiro.atacar(ladino)        // ataque padrão com Força + bônus
    ladino.defender(guerreiro)      // tenta desviar com velocidade
}