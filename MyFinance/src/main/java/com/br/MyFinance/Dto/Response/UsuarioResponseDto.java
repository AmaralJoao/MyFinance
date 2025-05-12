package com.br.MyFinance.Dto.Response;

public class UsuarioResponseDto {

    private String usuarioId;
    private String usuario;
    private String email;
    private String token;

    public UsuarioResponseDto(String usuarioId, String usuario, String email, String token) {
        this.usuarioId = usuarioId;
        this.usuario = usuario;
        this.email = email;
        this.token = token;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
