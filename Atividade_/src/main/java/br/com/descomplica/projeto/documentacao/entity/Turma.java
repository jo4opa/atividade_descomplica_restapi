package br.com.descomplica.projeto.documentacao.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name ="turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turma_id")
    private Integer idturma;

    @Column(name = "horario")
    private Time horario;

    @Column(name = "duracao")
    private Integer duracao;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    // getters e setters

    public Integer getIdturma() {
        return idturma;
    }
    public void setIdturma(Integer idturma) {
        this.idturma = idturma;
    }

    public Time getHorario() {
        return horario;
    }
    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Integer getDuracao() {
        return duracao;
    }
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
