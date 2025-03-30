package com.brunotadashi.CadastroDeNinjas.Ninjas;

import com.brunotadashi.CadastroDeNinjas.Missoes.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {
    private long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private MissaoModel missao;
    private String rank;
}
