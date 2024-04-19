package com.arquivos.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquivos.entity.Arquivo;
import com.arquivos.services.ArquivoService;



@RestController
@RequestMapping("api/arquivo")
public class ArquivoController {
	
    private ArquivoService arquivoService;


    public ArquivoController(ArquivoService arquivoService) {
		this.arquivoService = arquivoService;
	}

	@GetMapping
    public ResponseEntity<List<Arquivo>> getAllArquivos() {
        List<Arquivo> arquivos = arquivoService.getAllData();
        if (arquivos.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(arquivos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arquivo> getArquivoById(@PathVariable("id") String arquivoId) {
        Arquivo arquivo = arquivoService.getArquivoById(arquivoId);
        if (arquivo == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(arquivo);
    }

    @PostMapping
    public ResponseEntity<Arquivo> saveArquivo(@RequestBody Arquivo arquivo) {
        Arquivo savedArquivo = arquivoService.saveArquivo(arquivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArquivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Arquivo> updateArquivo(@PathVariable("id") String arquivoId, @RequestBody Arquivo novoArquivo) {
        Arquivo updatedArquivo = arquivoService.updateArquivo(arquivoId, novoArquivo);
        if (updatedArquivo == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedArquivo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArquivo(@PathVariable("id") String arquivoId) {
        arquivoService.deleteArquivosById(arquivoId);
        return ResponseEntity.noContent().build();
    }
}
