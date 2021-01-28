fun main() {
    println("-> Bem vindo ao Bytebank <-")


    val contaAlex = Conta()
    contaAlex.titular = "Alex"
    contaAlex.numero = 1000
    contaAlex.setSaldo(300.0)

    val contaFran = Conta()
    contaFran.titular = "Fran"
    contaFran.numero = 1001
    contaFran.setSaldo(300.0)

    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.getSaldo())

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.getSaldo())

    println("Depositando na conta do Alex")
    contaAlex.deposita(50.0)
    println(contaAlex.getSaldo())

    println("Depositando na conta do Fran")
    contaFran.deposita(70.0)
    println(contaFran.getSaldo())

    println("Sacando da conta do Alex")
    contaAlex.saca(250.0)
    println(contaAlex.getSaldo())

    println("Sacando na conta do Fran")
    contaFran.saca(100.0)
    println(contaFran.getSaldo())

    println("Saque em excesso do Alex")
    contaAlex.saca(300.0)
    println(contaAlex.getSaldo())

    println("Saque em excesso da Fran")
    contaFran.saca(300.0)
    println(contaFran.getSaldo())

    println("Tranferencia conta Fran para Alex")
    if (contaFran.transfere(85.0, contaAlex)) {
        println("Transferencia bem sucedida!!")
    } else {
        println("Transferencia nao realizada!!")
    }
    println("Conta Alex ${contaAlex.getSaldo()}")
    println("Conta Fran ${contaFran.getSaldo()}")

}

class Conta {
    var titular = ""
    var numero = 0
    private var saldo = 0.0

    fun deposita(valor: Double) {
        this.saldo += valor
    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }

    fun getSaldo(): Double {
        return saldo
    }

    fun setSaldo(valor: Double) {
        if (valor > 0) {
            saldo = valor
        }
    }

    //testaCopiasEReferencias()
    fun testaCopiasEReferencias() {
        val numeroX = 10
        var numeroY = numeroX
        numeroY++

        println("numero X: $numeroX")
        println("numero Y: $numeroY")

        val contaJoao = Conta()
        contaJoao.titular = "João"
        var contaMaria = Conta()
        contaMaria.titular = "Maria"
        contaJoao.titular = "João"

        println("Titular da conta joao: ${contaJoao.titular}")
        println("Titular da conta Maria: ${contaMaria.titular}")

        println(contaJoao)
        println(contaMaria)

    }

    //testalacos()
    fun testalacos() {
        for (i in 1..5) {
            println(i)
        }
        var i = 0
        while (i <= 5) {
            val titular: String = "Alex $i"
            val numeroConta: Int = 1000 + i
            var saldo: Double = 0.0
            saldo = i + 10.0

            println("o titular é: $titular")
            println("o saldo é: $saldo")
            println("o numero da conta é: $numeroConta")
            println()
            i++
        }
    }

    //testaCondicoes()
    fun testaCondicoes(saldo: Double) {
        when {
            saldo > 0.0 -> {
                println("Conta é positiva")
            }
            saldo == 0.0 -> {
                println("conta é neutra")
            }
            else -> {
                println("Conta é negativa")
            }
        }
        if (saldo > 0.0) {
            println("Conta é positiva")
        } else if (saldo == 0.0) {
            println("conta é neutra")
        } else
            println("Conta é negativa")
    }
}