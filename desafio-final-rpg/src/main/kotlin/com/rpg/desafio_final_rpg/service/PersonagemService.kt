package com.rpg.desafio_final_rpg.service

import com.rpg.desafio_final_rpg.model.Personagem
import com.rpg.desafio_final_rpg.repository.PersonagemRepository
import org.springframework.stereotype.Service

@Service
class PersonagemService (val personagemRepository : PersonagemRepository
) {
    /**
     *CRUD do Personagem
     */


    //Salvar
    fun salvar (personagem: Personagem) {

        //se não tenho um Primary key vou criar uma nova entidade
        //Se já tiver um nome igual no banco, somente vai editar
        //se tenho um Primary key somente vou editar
        personagemRepository.save(personagem)
    }
    //Buscar
    fun buscarTodos() : List<Personagem>{
        return personagemRepository.findAll()
    }

    fun buscarPorNome(nome: Long) : Personagem{
        return personagemRepository.findById(nome).get()
    }
    //Excluir

    fun excluirPersonagem(nome: Long) {
        personagemRepository.deleteById(nome)
    }
}