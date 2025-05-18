package com.br.MyFinance.Service;

import com.br.MyFinance.Dto.Request.ContaBancariaRequestDto;
import com.br.MyFinance.Dto.Response.ContaBancariaResponseDto;
import com.br.MyFinance.Model.BancoModel;
import com.br.MyFinance.Model.ContaBancariaModel;
import com.br.MyFinance.Model.UsuarioModel;
import com.br.MyFinance.Repository.BancoRepository;
import com.br.MyFinance.Repository.ContaBancariaRepository;
import com.br.MyFinance.Repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BancoRepository bancoRepository;


    public List<ContaBancariaResponseDto> listarContasDoUsuario(@Valid long cdUsuario) {

       return null;
    }

    public ContaBancariaModel criarContaBancaria(@Valid ContaBancariaRequestDto contaBancariaRequestDto) {

        return null;
    }



    public ContaBancariaResponseDto editarContaBancaria(@Valid ContaBancariaRequestDto contaBancariaRequestDto) {
        return null;
    }

    private UsuarioModel validarEObterUsuario(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    private BancoModel obterBancoSeExistir(Long bancoId) {
        if (bancoId == null) {
            return null;
        }
        return bancoRepository.findById(bancoId)
                .orElseThrow(() -> new IllegalArgumentException("Banco não encontrado"));
    }
}
