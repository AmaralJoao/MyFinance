package com.br.MyFinance.Util;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ApplicationScoped
public class UsuarioSessao {

	public Long obterUsuarioDaSessao() {
		try {
			return (Long) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cdUsuario");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao obter usuário da sessão", ""));
			return null;
		}
	}

}
