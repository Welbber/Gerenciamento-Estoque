package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utiuls.Encriptografia;

import java.security.NoSuchAlgorithmException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelUsuario {

    private Integer codigoId;

    private String nome;

    private String login;

    private String senha;

    public void setSenha(String senha) {
        try {
            this.senha = Encriptografia.encriptografa(senha);
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar encriptograr senha");
        }
    }
}
