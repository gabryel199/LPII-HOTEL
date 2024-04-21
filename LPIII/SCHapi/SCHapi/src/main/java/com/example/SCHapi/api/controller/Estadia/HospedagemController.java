package com.example.SCHapi.api.controller.Estadia;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.SCHapi.exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import com.example.SCHapi.api.dto.Estadia.HospedagemDTO;
import com.example.SCHapi.api.dto.Estadia.Lista.ProdutoSolicitadoDTOList;
import com.example.SCHapi.api.dto.Estadia.Lista.QuartoHospedagemDTOList;
import com.example.SCHapi.model.entity.Estadia.AvaliacaoHospedagem;
import com.example.SCHapi.model.entity.Estadia.Hospedagem;
import com.example.SCHapi.model.entity.Estadia.StatusHospedagem;
import com.example.SCHapi.model.entity.Estadia.Lista.ProdutoSolicitado;
import com.example.SCHapi.model.entity.Estadia.Lista.QuartoHospedagem;
import com.example.SCHapi.model.entity.Pessoa.Cliente;
import com.example.SCHapi.model.entity.Pessoa.Funcionario;
import com.example.SCHapi.model.entity.Pessoa.Hotel;
import com.example.SCHapi.model.entity.Produto.Produto;
import com.example.SCHapi.model.entity.Quarto.Quarto;
import com.example.SCHapi.model.entity.Quarto.TipoQuarto;
import com.example.SCHapi.service.Estadia.AvaliacaoHospedagemService;
import com.example.SCHapi.service.Estadia.HospedagemService;
import com.example.SCHapi.service.Estadia.StatusHospedagemService;
import com.example.SCHapi.service.Estadia.Lista.ProdutoSolicitadoService;
import com.example.SCHapi.service.Estadia.Lista.QuartoHospedagemService;
import com.example.SCHapi.service.Pessoa.ClienteService;
import com.example.SCHapi.service.Pessoa.FuncionarioService;
import com.example.SCHapi.service.Pessoa.HotelService;
import com.example.SCHapi.service.Produto.ProdutoService;
import com.example.SCHapi.service.Quarto.QuartoService;
import com.example.SCHapi.service.Quarto.TipoQuartoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hospedagens")
@RequiredArgsConstructor
public class HospedagemController {
    private final HospedagemService service;
    private final ClienteService clienteService;
    private final HotelService hotelService;
    private final FuncionarioService funcionarioService;
    private final StatusHospedagemService statushospedagemService;
    private final AvaliacaoHospedagemService avaliacaohospedagemService;
    private final ProdutoSolicitadoService produtoSolicitadoService;
    private final QuartoHospedagemService quartoHospedagemService;
    private final QuartoService quartoService;
    private final ProdutoService produtoService;

    // @GetMapping()
    // public ResponseEntity get() {
    //    List<Hospedagem> hospedagens = service.getHospedagens();
    //     return ResponseEntity.ok(hospedagens.stream().map(HospedagemDTO::create).collect(Collectors.toList()));
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity get(@PathVariable("id") Long id) {
    //     Optional<Hospedagem> hospedagem = service.getHospedagemById(id);
    //     if (!hospedagem.isPresent()) {
    //         return new ResponseEntity("Hospedagem não encontrada", HttpStatus.NOT_FOUND);
    //     }
    //     return ResponseEntity.ok(hospedagem.map(HospedagemDTO::create));
    // }
    
    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Hospedagem> hospedagem = service.getHospedagemById(id);
        List<QuartoHospedagem> listaQuartos = quartoHospedagemService.getQuartoHospedagemByHospedagem(hospedagem);
        List<ProdutoSolicitado> produtoSolicitado = produtoSolicitadoService.getProdutoSolicitadoByHospedagem(hospedagem);
        //Optional<List<QuartoHospedagem>> = Optional.of(listaQuartos);
        HospedagemDTO hospedagemDTO = new HospedagemDTO();
        hospedagemDTO = HospedagemDTO.create(hospedagem.get(), listaQuartos, produtoSolicitado);
        if (!hospedagem.isPresent()) {
            return new ResponseEntity("Hospedagem não encontrada", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(hospedagemDTO);
        // return ResponseEntity.ok(hospedagem.map(HospedagemDTO::create));
    }

    @PostMapping
    public ResponseEntity post(@RequestBody HospedagemDTO dto) {
        try {
            Hospedagem hospedagem = converter(dto);
            hospedagem = service.salvar(hospedagem);
            // loop para cada elemento da lista salvar o hospedagemreserva
            for (QuartoHospedagemDTOList quartoHospedagemDto : dto.getListaQuartos()) {
                QuartoHospedagem quartoHospedagem = converterQuartoHospedagem(quartoHospedagemDto, hospedagem.getId());
                quartoHospedagemService.salvar(quartoHospedagem);
            }
            // loop para cada elemento da lista salvar o produtosolicitado
            for (ProdutoSolicitadoDTOList produtoSolicitadoDto : dto.getProdutoHospedagem()) {
                ProdutoSolicitado produtoSolicitado = converterProdutoSolicitado(produtoSolicitadoDto, hospedagem.getId());
                produtoSolicitadoService.salvar(produtoSolicitado);
            }
            return new ResponseEntity(hospedagem, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    public Hospedagem converter(HospedagemDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Hospedagem hospedagem = modelMapper.map(dto, Hospedagem.class);
        if (dto.getIdCliente() != null) {
            Optional<Cliente> cliente = clienteService.getClienteById(dto.getIdCliente());
            if (!cliente.isPresent()) {
                hospedagem.setCliente(null);
            } else {
                hospedagem.setCliente(cliente.get());
            }
        }
        if (dto.getIdHotel() != null) {
            Optional<Hotel> hotel = hotelService.getHotelById(dto.getIdHotel());
            if (!hotel.isPresent()) {
                hospedagem.setHotel(null);
            } else {
                hospedagem.setHotel(hotel.get());
            }
        }
        if (dto.getIdFuncionario() != null) {
            Optional<Funcionario> funcionario = funcionarioService.getFuncionarioById(dto.getIdFuncionario());
            if (!funcionario.isPresent()) {
                hospedagem.setFuncionario(null);
            } else {
                hospedagem.setFuncionario(funcionario.get());
            }
        }
        if (dto.getIdStatusHospedagem() != null) {
            Optional<StatusHospedagem> statushospedagem = statushospedagemService.getStatusHospedagemById(dto.getIdStatusHospedagem());
            if (!statushospedagem.isPresent()) {
                hospedagem.setStatusHospedagem(null);
            } else {
                hospedagem.setStatusHospedagem(statushospedagem.get());
            }
        }
        if (dto.getIdAvaliacaoHospedagem() != null) {
            Optional<AvaliacaoHospedagem> avaliacaohospedagem = avaliacaohospedagemService.getAvaliacaoHospedagemById(dto.getIdAvaliacaoHospedagem());
            if (!avaliacaohospedagem.isPresent()) {
                hospedagem.setAvaliacaoHospedagem(null);
            } else {
                hospedagem.setAvaliacaoHospedagem(avaliacaohospedagem.get());
            }
        }
        return hospedagem;
    }

    public QuartoHospedagem converterQuartoHospedagem(QuartoHospedagemDTOList dto, Long hospedagemId) {
        ModelMapper modelMapper = new ModelMapper();
        QuartoHospedagem quartoHospedagem = modelMapper.map(dto, QuartoHospedagem.class);
        if (hospedagemId != null) {
            Optional<Hospedagem> hospedagem = service.getHospedagemById(hospedagemId);
            if (!hospedagem.isPresent()) {
                quartoHospedagem.setHospedagem(null);
            } else {
                quartoHospedagem.setHospedagem(hospedagem.get());
            }
        }
        if (dto.getNum() != null) {
            Optional<Quarto> quarto = quartoService.getQuartoById(dto.getNum());
            if (!quarto.isPresent()) {
                quartoHospedagem.setQuarto(null);
            } else {
                quartoHospedagem.setQuarto(quarto.get());
            }
        }
        return quartoHospedagem;
    }

    public ProdutoSolicitado converterProdutoSolicitado(ProdutoSolicitadoDTOList dto, Long hospedagemId) {
        ModelMapper modelMapper = new ModelMapper();
        ProdutoSolicitado produtoSolicitado = modelMapper.map(dto, ProdutoSolicitado.class);
        if (hospedagemId != null) {
            Optional<Hospedagem> hospedagem = service.getHospedagemById(hospedagemId);
            if (!hospedagem.isPresent()) {
                produtoSolicitado.setHospedagem(null);
            } else {
                produtoSolicitado.setHospedagem(hospedagem.get());
            }
        }
        if (dto.getIdProduto() != null) {
            Optional<Produto> produto = produtoService.getProdutoById(dto.getIdProduto());
            if (!produto.isPresent()) {
                produtoSolicitado.setProduto(null);
            } else {
                produtoSolicitado.setProduto(produto.get());
            }
        }
        return produtoSolicitado;
    }
}