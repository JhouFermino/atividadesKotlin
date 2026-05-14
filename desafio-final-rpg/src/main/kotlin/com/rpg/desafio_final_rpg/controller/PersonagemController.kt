package com.rpg.desafio_final_rpg.controller

import com.rpg.desafio_final_rpg.model.Personagem
import com.rpg.desafio_final_rpg.service.PersonagemService
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestClient

@RestController
class PersonagemController (
    @Value("\${rival.url}") private val rivalUrl: String,
    val personagemService: PersonagemService,
    val restClient: RestClient //Essa injeção é necessária para MANDAR mensagens
    //na forma de clientee/servidor

) {
    @GetMapping("/msg")
    fun mandarMensagemParaPersonagemRival(@RequestParam mensagem: String) {
        //Para mandar algo preciso configurar as rotas
        //10.10.7.137
        val mensagem = "oi???"
        try {
            restClient.post()
                .uri("rivalUrl")
                .body(mensagem)
                .retrieve()
                .toBodilessEntity()

        }catch (e: Exception){
            println("Deu erro: ${e.message}")
        }
    }
    @PostMapping("/ouvir")
    fun receberMensagemDoPersonagemRival(@RequestBody mensagem: String){
        println("Mensagem Recebida do rival $mensagem")
    }
    @PostMapping("/ataque")
    fun atacar(){
        /**
         * logica aqui
         */
    }
}