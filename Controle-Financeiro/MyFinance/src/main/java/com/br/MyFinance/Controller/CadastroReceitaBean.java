package com.br.MyFinance.Controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.MyFinance.Model.ContaBancariaModel;
import com.br.MyFinance.Model.ReceitaModel;
import com.br.MyFinance.Model.TiposRendaModel;
import com.br.MyFinance.Model.UsuarioModel;
import com.br.MyFinance.Service.ContaBancariaService;
import com.br.MyFinance.Service.ReceitaService;
import com.br.MyFinance.Service.TiposRendaService;
import com.br.MyFinance.Util.UsuarioSessao;

@Named("cadastroReceitaBean")
@SessionScoped
public class CadastroReceitaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ContaBancariaService contaBancariaService;

    @Inject
    private TiposRendaService tipoRendaService;

    @Inject
    private ReceitaService receitaService;

    @Inject
    private UsuarioSessao usuarioSessao;

    private ReceitaModel receitaModel = new ReceitaModel();
    private List<TiposRendaModel> tiposRenda;
    private List<ContaBancariaModel> contasBancarias;

    private Long tipoReceitaId;
    private Long contaReceitaId;

    @PostConstruct
    public void init() {
        System.out.println("### CadastroReceitaBean.init() - Iniciando carregamento dos combos");
        carregarCombos();
        System.out.println("### Combos carregados: " + 
                           (tiposRenda != null ? tiposRenda.size() : "null") + " tipos de renda, " + 
                           (contasBancarias != null ? contasBancarias.size() : "null") + " contas bancárias");
    }

    public void salvar() {
        try {
            System.out.println("### CadastroReceitaBean.salvar() - Iniciando processo de salvamento");
            System.out.println("### Valores antes da conversão: tipoReceitaId=" + tipoReceitaId + ", contaReceitaId=" + contaReceitaId);
            
            // Verifica se todos os campos obrigatórios do receitaModel estão preenchidos antes da conversão
            System.out.println("### ReceitaModel antes da conversão: " + 
                              "descricao=" + receitaModel.getDescricao() + 
                              ", valorRenda=" + receitaModel.getValorRenda() + 
                              ", dataRenda=" + receitaModel.getDataRenda() + 
                              ", repetir=" + receitaModel.getRepetir());
            
            // Converte IDs para objetos completos antes de salvar
            TiposRendaModel tipoReceita = obterTipoReceitaPorId(tipoReceitaId);
            ContaBancariaModel contaReceita = obterContaBancariaPorId(contaReceitaId);
            
            System.out.println("### Objetos após conversão: tipoReceita=" + 
                              (tipoReceita != null ? tipoReceita.getCdTipoRenda() : "null") + 
                              ", contaReceita=" + 
                              (contaReceita != null ? contaReceita.getId() : "null"));
            
            receitaModel.setTipoReceita(tipoReceita);
            receitaModel.setContaReceita(contaReceita);
            
            // Garante que a data de criação está definida
            if (receitaModel.getDataCriacao() == null) {
                System.out.println("### Definindo data de criação, estava null");
                receitaModel.setDataCriacao(new Date());
            }

            // Validação adicional
            if (receitaModel.getTipoReceita() == null || receitaModel.getContaReceita() == null) {
                System.out.println("### ERRO: Tipo de receita ou conta bancária não encontrados");
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Preencha todos os campos obrigatórios", ""));
                return;
            }
            
            // Verificação final antes de salvar
            System.out.println("### ReceitaModel final antes de salvar: " + 
                              "tipoReceita=" + (receitaModel.getTipoReceita() != null) + 
                              ", contaReceita=" + (receitaModel.getContaReceita() != null) + 
                              ", descricao=" + receitaModel.getDescricao() + 
                              ", valorRenda=" + receitaModel.getValorRenda() + 
                              ", dataRenda=" + receitaModel.getDataRenda() + 
                              ", dataCriacao=" + receitaModel.getDataCriacao() + 
                              ", repetir=" + receitaModel.getRepetir());

            receitaService.salvar(receitaModel);
            System.out.println("### Receita salva com sucesso!");

            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Receita cadastrada com sucesso", ""));

            limparFormulario();
            carregarCombos();

        } catch (Exception e) {
            System.out.println("### ERRO ao salvar receita: " + e.getMessage());
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Erro ao cadastrar receita: " + e.getMessage(), ""));
        }
    }

    private void carregarCombos() {
        try {
            System.out.println("### Carregando tipos de receita");
            // Carrega tipos de receita
            tiposRenda = tipoRendaService.listarTiposDeReceitas();
            System.out.println("### Tipos de receita carregados: " + (tiposRenda != null ? tiposRenda.size() : "null"));

            // Carrega contas bancárias do usuário
            Long cdUsuario = usuarioSessao.obterUsuarioDaSessao();
            System.out.println("### cdUsuario obtido: " + cdUsuario);
            
            if (cdUsuario != null) {
                contasBancarias = contaBancariaService.listarContasDoUsuario(cdUsuario);
                System.out.println("### Contas bancárias carregadas: " + (contasBancarias != null ? contasBancarias.size() : "null"));
            } else {
                System.out.println("### AVISO: cdUsuario é null, não foi possível carregar contas bancárias");
            }
        } catch (Exception e) {
            System.out.println("### ERRO ao carregar combos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private TiposRendaModel obterTipoReceitaPorId(Long id) {
        if (id == null) {
            System.out.println("### AVISO: tipoReceitaId é null");
            return null;
        }
        
        if (tiposRenda == null || tiposRenda.isEmpty()) {
            System.out.println("### ERRO: Lista de tipos de renda está vazia ou null");
            return null;
        }
        
        TiposRendaModel resultado = tiposRenda.stream()
            .filter(t -> Objects.equals(t.getCdTipoRenda(), id))
            .findFirst()
            .orElse(null);
            
        if (resultado == null) {
            System.out.println("### ERRO: Não foi encontrado tipo de renda com ID " + id);
        }
        
        return resultado;
    }

    private ContaBancariaModel obterContaBancariaPorId(Long id) {
        if (id == null) {
            System.out.println("### AVISO: contaReceitaId é null");
            return null;
        }
        
        if (contasBancarias == null || contasBancarias.isEmpty()) {
            System.out.println("### ERRO: Lista de contas bancárias está vazia ou null");
            return null;
        }
        
        ContaBancariaModel resultado = contasBancarias.stream()
            .filter(c -> Objects.equals(c.getId(), id))
            .findFirst()
            .orElse(null);
            
        if (resultado == null) {
            System.out.println("### ERRO: Não foi encontrada conta bancária com ID " + id);
        }
        
        return resultado;
    }

    private void limparFormulario() {
        System.out.println("### Limpando formulário");
        receitaModel = new ReceitaModel();
        tipoReceitaId = null;
        contaReceitaId = null;
    }

    // Getters e Setters
    public ReceitaModel getReceitaModel() {
        return receitaModel;
    }

    public void setReceitaModel(ReceitaModel receitaModel) {
        this.receitaModel = receitaModel;
    }

    public List<TiposRendaModel> getTiposRenda() {
        return tiposRenda;
    }

    public List<ContaBancariaModel> getContasBancarias() {
        return contasBancarias;
    }

    public Long getTipoReceitaId() {
        return tipoReceitaId;
    }

    public void setTipoReceitaId(Long tipoReceitaId) {
        this.tipoReceitaId = tipoReceitaId;
    }

    public Long getContaReceitaId() {
        return contaReceitaId;
    }

    public void setContaReceitaId(Long contaReceitaId) {
        this.contaReceitaId = contaReceitaId;
    }
}