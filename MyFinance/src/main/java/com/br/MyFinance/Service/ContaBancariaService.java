package com.br.MyFinance.Service;

import com.br.MyFinance.Mapper.ContaBancariaMapper;
import com.br.MyFinance.Model.BancoModel;
import com.br.MyFinance.Model.ContaBancariaModel;
import com.br.MyFinance.Model.DadosUsuarioModel;
import com.br.MyFinance.Repository.BancoRepository;
import com.br.MyFinance.Repository.BaseRepository;
import com.br.MyFinance.Repository.ContaBancariaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContaBancariaService extends BaseService<ContaBancariaModel, Integer>{

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;
    @Autowired
    private BancoRepository bancoRepository;
    @Autowired
    private ContaBancariaMapper contaBancariaMapper;

    public ContaBancariaService(BaseRepository<ContaBancariaModel, Integer> repository) {
        super(repository);
    }


    @Transactional(readOnly = true)
    public List<ContaBancariaModel> listarContasDoUsuario(@Valid Integer cdDadosUsuario) {

        return contaBancariaRepository.findByUsuarioId(cdDadosUsuario)
                .orElseThrow(() -> new IllegalArgumentException("usuario não possui conta"));
    }

    public ContaBancariaModel criarContaBancaria(@Valid ContaBancariaModel contaBancariaModel) {

        if (contaBancariaModel.getCdContaBancaria() != null){
            throw new IllegalArgumentException("Favor não inserir cdContaBancaria para criação de uma nova conta");
        }

        DadosUsuarioModel cdDadosUsuario = obterUsuario(contaBancariaModel.getUsuario().getCdDadosusuario());
        BancoModel banco = obterBancoSeExistir(contaBancariaModel.getBanco().getCdBanco());
        contaBancariaModel.setUsuario(cdDadosUsuario);
        contaBancariaModel.setBanco(banco);

        validarDadosDaConta(contaBancariaModel);
        return contaBancariaRepository.save(contaBancariaModel);
    }



    public ContaBancariaModel editarContaBancaria(@Valid ContaBancariaModel contaBancariaModel) {

        if (contaBancariaModel.getCdContaBancaria() == null){
            throw new IllegalArgumentException("Favor informar a conta para aditar");
        }

        ContaBancariaModel contaExistente = contaBancariaRepository.findById(contaBancariaModel.getCdContaBancaria())
                .orElseThrow(() -> new IllegalArgumentException("Conta bancária não encontrada"));

        validarDadosDaConta(contaBancariaRequestDto);

        DadosUsuarioModel cdUsuario = obterUsuario(contaBancariaRequestDto.getCdUsuario());
        BancoModel banco = obterBancoSeExistir(contaBancariaRequestDto.getCdBanco());

        contaBancariaMapper.updateModelFromDto(contaBancariaRequestDto, contaExistente);
        contaExistente.setUsuario(cdUsuario);
        contaExistente.setBanco(banco);

        ContaBancariaModel contaAtualizada = contaBancariaRepository.save(contaExistente);
        return contaBancariaMapper.toDto(contaAtualizada);
    }

    private void validarDadosDaConta(ContaBancariaModel contaBancariaParaValidar){

        if (contaBancariaParaValidar.getNmContaBancaria() == null || contaBancariaParaValidar.getNmContaBancaria().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da conta é obrigatório");
        }
        if (contaBancariaParaValidar.getIdTipoConta() == null) {
            throw new IllegalArgumentException("Tipo da conta é obrigatório");
        }
        if (contaBancariaParaValidar.getBanco() == null){
            throw new IllegalArgumentException("Banco é obrigatório");
        }
        if (contaBancariaParaValidar.getUsuario().getCdDadosusuario() == null) {
            throw new IllegalArgumentException("Usuário é obrigatório");
        }

    }

    private DadosUsuarioModel obterUsuario(Long usuarioId) {
       /* if (usuarioId == null) {
            throw new IllegalArgumentException("ID do usuário não pode ser nulo");
        }
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));*/

        return null;
    }

    private BancoModel obterBancoSeExistir(Long bancoId) {
        if (bancoId == null) {
            return null;
        }
        return bancoRepository.findById(bancoId)
                .orElseThrow(() -> new IllegalArgumentException("Banco não encontrado"));
    }
}
