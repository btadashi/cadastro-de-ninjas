package com.brunotadashi.CadastroDeNinjas.Missoes;

import com.brunotadashi.CadastroDeNinjas.Ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_missao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String dificuldade;

    @OneToMany(mappedBy = "missao")
    @JsonIgnore
    private List<NinjaModel> ninjas;
}
