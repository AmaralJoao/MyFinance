package com.br.MyFinance.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_permission")
public class UsuarioPermissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn
    private UsersModel login;

    @JoinColumn
    private PermissionModel permissoes;

    public UsuarioPermissaoModel() {
    }

    public UsuarioPermissaoModel(long id, UsersModel login, PermissionModel permissoes) {
        this.id = id;
        this.login = login;
        this.permissoes = permissoes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UsersModel getLogin() {
        return login;
    }

    public void setLogin(UsersModel login) {
        this.login = login;
    }

    public PermissionModel getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(PermissionModel permissoes) {
        this.permissoes = permissoes;
    }
}
