package br.com.caelum.twittelum.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Usuario dono;
    @Size(max = 240)
    private String conteudo;
    private String foto;
    @OneToMany(mappedBy = "tweet", cascade = CascadeType.REMOVE)
    private List<Curtida> curtidas = new ArrayList<>();
    private LocalDateTime data;


    public Usuario getDono() {
        return dono;
    }

    public void setDono(Usuario dono) {
        this.dono = dono;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }


    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Curtida> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Curtida> curtidas) {
        this.curtidas = curtidas;
    }


    public void setData(String data) {
        this.data = LocalDateTime.parse(data);
    }
}
