//Desafio do dia
//   Crie uma aplicação de lista de supermercado que deve:
//Ser capaz de adicionar mercadorias;
//Remover mercadorias;
//Alterar preço;
//Implemente menus e funções de acordo com sua criatividade;

fun main(){
    val nomes = mutableListOf<String>()
    val precos = mutableListOf<Double>()
    val quantidade = mutableListOf<Int>()

    while (true){
        //Criação do meunu com um loop usando while com true para rodar "infinitamente"
        println("DIGITE UMA OPÇÃO ABAIXO:")
        println("1-Adicionar ao estoque")
        println("2-Remover do estoque")
        println("3-Alterar valor")
        println("4-Mostrar lista")
        print("Resposta:")

        val escolha = readln().toInt()
        when (escolha) {
            1 -> adicionarMercadoria(nomes, precos, quantidade) //chamando função adicionarMercadoria que criei abaixo

            2 -> removerMercadoria(nomes,precos, quantidade) //chamando função removerMercadoria

            3 -> modificarValor(nomes, precos, quantidade) //chamando função modificarValor

            4 -> listarCompras(nomes,precos,quantidade)//chamando função listarCompras
        }

    }
}

fun adicionarMercadoria(nomes: MutableList<String>,
                        precos: MutableList<Double>,
                        quantidade: MutableList<Int>){

    println("Digite o nome do produto:")
    val nome = readln()

    if(nome == "" || nomes.contains(nome)){ //caso o nome do produto for vazio ou ser igual a outro produto, printará Nome inválido!
        println("NOME INVALIDO!\n")
    }
    else {
        println("Digite o valor do produto:")
        val valor = readln().toDouble()

        if(valor == 0.0){
            println("Produto deve possuir valor")

        } else {

            println("Digite a quantia do produto:")
            val quantia = readln().toInt()

            if(quantia == 0){

                println("Mano faz as coisas direito!")

            }else {

                nomes.add(nome)
                precos.add(valor)
                quantidade.add(quantia)
                println("\n | ${nome} FOI ADICIONADO AO ESTOQUE! | \n")
            }
        }
    }
}


fun removerMercadoria(nomes: MutableList<String>,
                      precos: MutableList<Double>,
                      quantidade: MutableList<Int>){
    println("Digite o nome do produto que deseja remover:")
    val nome = readln()

    val indice = nomes.indexOf(nome)

    if (indice != -1){
        println("Digite a quantia que deseja remover:")
        val qntRemover = readln().toInt()

        if(qntRemover < quantidade[indice]){
            quantidade[indice] -= qntRemover
            println("Do Produto: ${nomes[indice]}, quantidade atual: ${quantidade[indice]}")
        } else{
            nomes.removeAt(indice)
            quantidade.removeAt(indice)
            precos.removeAt(indice)
            println("PRODUTO REMOVIDO!")
        }
    }
    else {
        println("PRODUTO NÃO ENCONTRADO!")
    }
}


fun modificarValor(nomes: MutableList<String>,
                   precos: MutableList<Double>,
                   quantidade: MutableList<Int>){
    println("Digite o produto que deseja modificar o valor:")
    val nome = readln()
    val indice = nomes.indexOf(nome)

    if(indice != -1){

        println("Digite novo valor:")
        val novoPreco = readln().toDouble()

        if (novoPreco != precos[indice]){

            precos[indice] = novoPreco

        }
        else {
            println("Valor precisa ser diferente!")
        }

    }else{
        println("PRODUTO NÃO ENCONTRADO!")
    }
}


fun listarCompras(nomes: MutableList<String>,
                  precos:MutableList<Double>,
                  quantidade: MutableList<Int>){
    println("\n")
    println("-----------------------------------------------")
    for (i in nomes.indices) {
        println("Produto: ${nomes[i]} | Valor: ${precos[i]} | Quantidade: ${quantidade[i]}")
    }
    println("-----------------------------------------------")
    println("\n")
}