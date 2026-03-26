
/*
Faça uma calculadora inteligente capaz de reconhecer
números e operadores matemáticos direto no console,
porém com o mínimo de 9 caracteres, e com parênteses.
Exemplo: 5 + 7 * 9 / 2 (5 - 4) * 2
 */

fun main (){

    println("Digite uma conta matemática:")
    val conta = readln().trim().replace(" ", "")


    val resultado = resolverExpressao(conta)

    println("Resultado: $resultado")

}


fun resolverExpressao(expressao: String): Double {

    var exp = expressao

    // Resolvendo a questão do parênteses primeiro
    while (exp.contains("(")) {

        val inicio = exp.lastIndexOf("(")
        val fim = exp.indexOf(")", inicio)

        val dentro = exp.substring(inicio + 1, fim)

        val resultadoDentro = resolverExpressao(dentro)

        exp = exp.take(inicio) + resultadoDentro + exp.substring(fim + 1)
    }

    val numeros = mutableListOf<Double>()
    val operadores = mutableListOf<Char>()
    var numeroAtual = ""

    for (c in exp) {
        if (c.isDigit() || c == '.') {
            numeroAtual += c
        } else {
            numeros.add(numeroAtual.toDouble())
            operadores.add(c)
            numeroAtual = ""
        }
    }

    numeros.add(numeroAtual.toDouble())

    var i = 0

    // daí * e /
    while (i < operadores.size) {
        if (operadores[i] == '*' || operadores[i] == '/') {

            val resultado = if (operadores[i] == '*') {
                numeros[i] * numeros[i + 1]
            } else {
                numeros[i] / numeros[i + 1]
            }

            numeros[i] = resultado
            numeros.removeAt(i + 1)
            operadores.removeAt(i)

        } else {
            i++
        }
    }

    // e por fim + e -
    var resultadoFinal = numeros[0]

    for (j in operadores.indices) {
        if (operadores[j] == '+') {
            resultadoFinal += numeros[j + 1]
        } else {
            resultadoFinal -= numeros[j + 1]
        }
    }

    return resultadoFinal
}