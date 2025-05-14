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
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BancoRepository bancoRepository;

    @Transactional
    public List<ContaBancariaResponseDto> listarContasDoUsuario(@Valid long cdUsuario) {

        return contaBancariaRepository.findBycdUsuario(cdUsuario)
                .orElse(List.of())
                .stream()
                .map(ContaBancariaResponseDto::new).collect(Collectors.toList());

    }

    public ContaBancariaModel criarContaBancaria(@Valid ContaBancariaRequestDto contaBancariaRequestDto) {

        UsuarioModel usuario = usuarioRepository.findById(contaBancariaRequestDto.getCdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + contaBancariaRequestDto.getCdUsuario()));

        // Banco é opcional
        BancoModel banco = null;
        if (contaBancariaRequestDto.getCdBanco() != null) {
            banco = bancoRepository.findById(contaBancariaRequestDto.getCdBanco())
                    .orElseThrow(() -> new IllegalArgumentException("Banco não encontrado com ID: " + contaBancariaRequestDto.getCdBanco()));
        }

        // Cria a conta usando o método no DTO
        ContaBancariaModel conta = contaBancariaRequestDto.toModel(usuario, banco);

        contaBancariaRepository.save(conta);
        return conta;
    }


    public void editarContaBancaria(@Valid ContaBancariaRequestDto contaBancariaRequestDto) {

        ContaBancariaModel contaExistente = contaBancariaRepository.findById(contaBancariaRequestDto.getCdContaBancaria())
                .orElseThrow(() -> new EntityNotFoundException("Conta bancária não encontrada com ID: " + contaBancariaRequestDto.getCdContaBancaria()));

        // Valida usuário
        UsuarioModel usuario = usuarioRepository.findById(contaBancariaRequestDto.getCdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + contaBancariaRequestDto.getCdUsuario()));

        // Banco é opcional
        BancoModel banco = null;
        if (contaBancariaRequestDto.getCdBanco() != null) {
            banco = bancoRepository.findById(contaBancariaRequestDto.getCdBanco())
                    .orElseThrow(() -> new IllegalArgumentException("Banco não encontrado com ID: " + contaBancariaRequestDto.getCdBanco()));
        }

        // Atualiza os campos da conta existente
        contaExistente.setNome(contaBancariaRequestDto.getNome());
        contaExistente.setTipoConta(contaBancariaRequestDto.getTipoConta());
        contaExistente.setUsuario(usuario);
        contaExistente.setBanco(banco);

        contaBancariaRepository.save(contaExistente);

    }
}
