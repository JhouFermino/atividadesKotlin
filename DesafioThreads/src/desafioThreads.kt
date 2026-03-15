fun main() {

    // Fila de carros
    val fila = ArrayDeque<Int>()

    var semaforoAberto = false
    var idCarro = 1

    // THREAD DO SEMÁFORO
    println("SIMULAÇÃO DE SEMÁFORO!")
    val semaforoThread = Thread {
        while (true) {

            semaforoAberto = true
            println("\n🟢 Semáforo ABERTO")

            val tempoFinal = System.currentTimeMillis() + 5000

            while (System.currentTimeMillis() < tempoFinal) {

                synchronized(fila) {
                    if (fila.isNotEmpty()) {
                        val carro = fila.removeFirst()
                        println("🚗 Carro $carro passou no semáforo")
                    }
                }

                Thread.sleep(1000)
            }
            semaforoAberto = false
            println("\n🔴 Semáforo FECHADO!")
            Thread.sleep(10000)
        }
    }

    // THREAD de chegados dos carros
    val carrosThread = Thread {

        while (true) {

            Thread.sleep(2000)//tempo de chegada

            synchronized(fila) {
                fila.addLast(idCarro)
                println("🚙 Carro $idCarro chegou na fila")
                idCarro++
            }
        }
    }

    // iniciando as THREADS
    semaforoThread.start()
    carrosThread.start()
}