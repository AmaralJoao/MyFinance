package com.br.MyFinance.Service;

import com.br.MyFinance.Dto.Request.ContaBancariaRequestDto;
import com.br.MyFinance.Dto.Response.ContaBancariaResponseDto;
import com.br.MyFinance.Mapper.ContaBancariaMapper;
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
import java.util.Optional;
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
    @Autowired
    private ContaBancariaMapper contaBancariaMapper;

    @Transactional(readOnly = true)
    public List<ContaBancariaResponseDto> listarContasDoUsuario(@Valid long cdUsuario) {

        List<ContaBancariaModel> contasUsuario = contaBancariaRepository.findByCdUsuarioConta(cdUsuario)
                .orElseThrow(() -> new IllegalArgumentException("usuario não possui conta"));

       return contasUsuario.stream().map(contaBancariaMapper::toDto).collect(Collectors.toList());
    }

    public ContaBancariaResponseDto criarContaBancaria(@Valid ContaBancariaRequestDto contaBancariaRequestDto) {

        if (contaBancariaRequestDto.getCdContaBancaria() != null){
            throw new IllegalArgumentException("Favor não inserir cdContaBancaria para criação de uma nova conta");
        }

        validarDadosDaConta(contaBancariaRequestDto);

        UsuarioModel cdUsuario = obterUsuario(contaBancariaRequestDto.getCdUsuario());
        BancoModel banco = obterBancoSeExistir(contaBancariaRequestDto.getCdBanco());

        ContaBancariaModel novaContaBancaria = contaBancariaMapper.requestToModel(contaBancariaRequestDto);
        novaContaBancaria.setUsuario(cdUsuario);
        novaContaBancaria.setBanco(banco);

        ContaBancariaModel salvarConta = contaBancariaRepository.save(novaContaBancaria);
        return contaBancariaMapper.toDto(salvarConta);
    }



    public ContaBancariaResponseDto editarContaBancaria(@Valid ContaBancariaRequestDto contaBancariaRequestDto) {

        if (contaBancariaRequestDto.getCdContaBancaria() == null){
            throw new IllegalArgumentException("Favor infermar aconta para aditar");
        }

        ContaBancariaModel contaExistente = contaBancariaRepository.findById(contaBancariaRequestDto.getCdContaBancaria())
                .orElseThrow(() -> new IllegalArgumentException("Conta bancária não encontrada"));

        validarDadosDaConta(contaBancariaRequestDto);

        UsuarioModel cdUsuario = obterUsuario(contaBancariaRequestDto.getCdUsuario());
        BancoModel banco = obterBancoSeExistir(contaBancariaRequestDto.getCdBanco());

        contaBancariaMapper.updateModelFromDto(contaBancariaRequestDto, contaExistente);
        contaExistente.setUsuario(cdUsuario);
        contaExistente.setBanco(banco);

        ContaBancariaModel contaAtualizada = contaBancariaRepository.save(contaExistente);
        return contaBancariaMapper.toDto(contaAtualizada);
    }

    private void validarDadosDaConta(ContaBancariaRequestDto contaBancariaParaValidar){

        if (contaBancariaParaValidar.getNome() == null || contaBancariaParaValidar.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da conta é obrigatório");
        }

        if (contaBancariaParaValidar.getTipoConta() == null) {
            throw new IllegalArgumentException("Tipo da conta é obrigatório");
        }

        if (contaBancariaParaValidar.getCdUsuario() == null) {
            throw new IllegalArgumentException("Usuário é obrigatório");
        }

    }

    private UsuarioModel obterUsuario(Long usuarioId) {
        if (usuarioId == null) {
            throw new IllegalArgumentException("ID do usuário não pode ser nulo");
        }
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
