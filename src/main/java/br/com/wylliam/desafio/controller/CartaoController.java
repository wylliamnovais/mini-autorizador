package br.com.wylliam.desafio.controller;

import br.com.wylliam.desafio.domain.dto.CartaoRequestDTO;
import br.com.wylliam.desafio.domain.dto.CartaoResponseDTO;
import br.com.wylliam.desafio.exception.ResponseError;
import br.com.wylliam.desafio.service.CartaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController()
@RequestMapping("/cartoes")
@Tag(name = "Cartões", description = "Operações para Gerenciamento das Cartões.")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    @Operation(summary = "Endpoint Responsável por criar a Cartao.", description = "Método para criar a Cartao.", tags = {"Cartao"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartao Cadastrada", content = @Content(schema = @Schema(implementation = CartaoResponseDTO.class))),
            @ApiResponse(responseCode = "422", description = "Erro da Aplicação", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class)))),
            @ApiResponse(responseCode = "500", description = "Erro do Servidor", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class))))})
    public ResponseEntity<?> cadastrarCartao(@RequestBody CartaoRequestDTO dto) {
        return ResponseEntity.ok(cartaoService.cadastrarCartao(dto));
    }

    @GetMapping("/{numeroCartao}")
    @Operation(summary = "Endpoint Responsável por Consultar o saldo do Cartão.", description = "Método para consulta do saldo do Cartao.", tags = {"Cartao"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtenção com sucesso:", content = @Content(schema = @Schema(implementation = BigDecimal.class))),
            @ApiResponse(responseCode = "404", description = "Erro da Aplicação", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class)))),
            @ApiResponse(responseCode = "500", description = "Erro do Servidor", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseError.class))))})
    public ResponseEntity<?> consultarSaldoCartao(@Parameter(name = "numeroCartao", description = "Numero Cartão.", required = true) @PathVariable(name = "numeroCartao") String numeroCartao) {
        return ResponseEntity.ok(cartaoService.consultarSaldoCartaoPorId(numeroCartao));
    }

}
