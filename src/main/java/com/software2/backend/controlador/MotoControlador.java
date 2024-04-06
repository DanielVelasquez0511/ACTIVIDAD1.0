package com.software2.backend.controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.software2.backend.modelo.Moto;

@RestController
@RequestMapping("/api/motos")
public class MotoControlador {
    private List<Moto> motos;

    public MotoControlador(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Moto[] motosArray= objectMapper.readValue(new  ClassPathResource("motos.json").getFile(), Moto[].class);
            motos = new ArrayList<>(Arrays.asList(motosArray));
        } catch (Exception e) {
            e.printStackTrace();
            motos = new ArrayList<>();
        }
    }

    @GetMapping
    public List<Moto> getAllMotos(){
        return motos;
    }

    @GetMapping("/{id}")
    public Moto getMotoById(@PathVariable Long id){
        return motos.stream().filter(moto -> moto.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Moto createMoto(@RequestBody Moto moto) {
        motos.add(moto);
        return moto;
    }

    @PutMapping("/{id}")
    public Moto updateMoto(@PathVariable Long id, @RequestBody Moto updatedMoto) {
        Moto moto = getMotoById(id);
        if (moto != null) {
            moto.setNombre(updatedMoto.getNombre());
            moto.setPrecio(updatedMoto.getPrecio());
            moto.setPeso(updatedMoto.getPeso());
            return moto;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteMoto(@PathVariable Long id) {
        motos.removeIf(moto -> moto.getId().equals(id));
    }
}
