package br.com.descomplica.projeto.documentacao.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="instrutor")
public class Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instrutor_id")
    private Integer instrutorid;

    @Column(name = "rg")
    private Integer rg;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nascimento")
    private Date nascimento;

    @Column(name = "titulacao")
    private Integer titulacao;

    @OneToMany(mappedBy = "instrutor")
    private Set<Turma> turmas;

    // getters e setters
    public Integer getInstrutorid(){
        return instrutorid;
    }
    public void setInstrutorid(Integer instrutorid){
        this.instrutorid = instrutorid;
    }

    public Integer getRg() {
        return rg;
    }
    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getTitulacao() {
        return titulacao;
    }
    public void setTitulacao(Integer titulacao) {
        this.titulacao = titulacao;
    }
}