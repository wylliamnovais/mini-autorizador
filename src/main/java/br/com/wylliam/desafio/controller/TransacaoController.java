package br.com.wylliam.desafio.controller;

import br.com.wylliam.desafio.domain.dto.CartaoResponseDTO;
import br.com.wylliam.desafio.domain.dto.TransacaoRequestDTO;
import br.com.wylliam.desafio.exception.ResponseError;
import br.com.wylliam.desafio.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/transacoes")
@Tag(name = "Transacao", description = "Operações para Gerenciamento das Transações dos Cartões.")
public class TransacaoController {


    @Autowired
    private TransacaoService transacaoService;


    @PostMapping
    @Operation(summary = "Endpoint Responsável por Atualizar o Saldo do Cartao.", description = "Método para Atualizar o Saldo do Cartao.", tags = {"Transacao"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transação executada com Sucesso", content = @Content(schema = @Schema(implementation = CartaoResponseDTO.class))),
            @ApiResponse(responseCode = "422", description = "Erro da Aplicação", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class)))),
            @ApiResponse(responseCode = "500", description = "Erro do Servidor", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class))))
    })
    public ResponseEntity<?> cadastrarTransacao(@RequestBody TransacaoRequestDTO dto) {
        return ResponseEntity.ok(transacaoService.cadastrarTransacao(dto));
    }




}
