package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelEstoque {

    private int id_pk;

    private int quantidade;

    private double preco;

    private int tipo_movimentacao;

    private String dataMovimentacao;

    private int fk_usuario;

    private int fk_produto;
}
