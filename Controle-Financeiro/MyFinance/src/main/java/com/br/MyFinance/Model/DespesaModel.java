package com.br.MyFinance.Model;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "despesa")
public class DespesaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dsDespesa", nullable = false)
    private String descricao;

    @Column(name = "valorDespesa", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorDespesa;

    @Column(name = "dataDespesa", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdTipoDespesa", nullable = false)
    private TipoDespesaModel tipoDespesa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdContaBancaria", nullable = false)
    private ContaBancariaModel contaDespesa;

    @Column(name = "observacoes", length = 500)
    private String observacoes;

    @Column(name = "idRepetir", nullable = false)
    private boolean repetir;

    public DespesaModel() {
    }

    public DespesaModel(Long id, String descricao, BigDecimal valorDespesa, Date data, TipoDespesaModel tipoDespesa,
                        ContaBancariaModel contaDespesa, String observacoes, boolean repetir) {
        this.id = id;
        this.descricao = descricao;
        this.valorDespesa = valorDespesa;
        this.data = data;
        this.tipoDespesa = tipoDespesa;
        this.contaDespesa = contaDespesa;
        this.observacoes = observacoes;
        this.repetir = repetir;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(BigDecimal valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TipoDespesaModel getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesaModel tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public ContaBancariaModel getContaDespesa() {
        return contaDespesa;
    }

    public void setContaDespesa(ContaBancariaModel contaDespesa) {
        this.contaDespesa = contaDespesa;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public boolean isRepetir() {
        return repetir;
    }

    public void setRepetir(boolean repetir) {
        this.repetir = repetir;
    }

    @Override
    public String toString() {
        return "DespesaModel{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valorDespesa=" + valorDespesa +
                ", data=" + data +
                ", tipoDespesaId=" + (tipoDespesa != null ? tipoDespesa.getCdTipoDespesa() : "null") +
                ", contaDespesaId=" + (contaDespesa != null ? contaDespesa.getId() : "null") +
                ", observacoes='" + observacoes + '\'' +
                ", repetir=" + repetir +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DespesaModel that = (DespesaModel) obj;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? Objects.hash(id) : 0;
    }
}
