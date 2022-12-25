package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelProduto {

    private int idProduto;

    private String descricaoProduto;

    private double valorProduto;
}