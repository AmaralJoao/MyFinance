package com.br.MyFinance.Controller;

import java.io.Serializable;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.MyFinance.Model.UsuarioModel;
import com.br.MyFinance.Service.UsuarioService;

@RequestScoped
@Named("loginBean")
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String usuario;
    private String senha;

    @Inject
    private UsuarioService usuarioService;

    public String login() {
        Optional<UsuarioModel> usuarioOptional = usuarioService.autenticar(usuario, senha);

        if (usuarioOptional.isPresent()) {
            UsuarioModel usuario = usuarioOptional.get();
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cdUsuario", usuario.getCdUsuario());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nomeDoUsuario", usuario.getUsuario());

            return "cadastroReceita?faces-redirect=true"; 
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login ou senha inválidos!"));
            return null;
        }
    }

    // Getters e Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}