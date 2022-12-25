package view;

import controller.ControllerTblEstoque;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.ModelEstoque;
import model.ModelProduto;
import model.ModelUsuario;

public class ViewEstoque extends javax.swing.JFrame {

    private Font fonteExterna;
    private ControllerTblEstoque controlEstoque;
    private ModelEstoque estoque;
    private List<ModelProduto> produtos;
    private DefaultTableModel modeloTabelaMovimentacao;
    private List<ModelEstoque> listaEstoque;
    private ModelUsuario usuarioLogado;

    public ViewEstoque(ModelUsuario user) {
        this.usuarioLogado = user;

        initComponents();
        setFontExterna();
        this.carregaMovimentacoesEstoque();
        this.listDescricaoProdutos();

    }

    private void initComponents() {

        conteinerAgrupaElementosFrame = new javax.swing.JPanel();
        lblTipoMov = new javax.swing.JLabel();
        cbTipoMov = new javax.swing.JComboBox<>();
        lblDescricaoProd = new javax.swing.JLabel();
        cbDescriProd = new javax.swing.JComboBox<>();
        lblQtdProd = new javax.swing.JLabel();
        spQtd = new javax.swing.JSpinner();
        lblValorProd = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMostraMovimentacao = new javax.swing.JTable();
        btnSalvarMovim = new javax.swing.JButton();
        gerarRelatorioMov = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movimentação Estoque");
        setResizable(false);

        conteinerAgrupaElementosFrame.setBackground(new java.awt.Color(183, 183, 183));

        lblTipoMov.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTipoMov.setText("TIPO MOVIMENTAÇÃO");

        cbTipoMov.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"ENTRADA", "SAIDÁ"}));
        cbTipoMov.addActionListener(evt -> cbTipoMovActionPerformed(evt));

        lblDescricaoProd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblDescricaoProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescricaoProd.setText("ESCOLHA PRODUTO ABAIXO PELA DESCRIÇÃO");

        cbDescriProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Escolha a Descrição Do Produto"}));

        lblQtdProd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblQtdProd.setText("QUANTIDADE");

        spQtd.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lblValorProd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblValorProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValorProd.setText("VALOR");

        tabelaMostraMovimentacao.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String[]{
                        "Preço", "Produto", "Quantidade", "Movimentação", "Data", "User"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaMostraMovimentacao);
        if (tabelaMostraMovimentacao.getColumnModel().getColumnCount() > 0) {
            tabelaMostraMovimentacao.getColumnModel().getColumn(0).setPreferredWidth(5);
            tabelaMostraMovimentacao.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabelaMostraMovimentacao.getColumnModel().getColumn(2).setPreferredWidth(5);
            tabelaMostraMovimentacao.getColumnModel().getColumn(3).setPreferredWidth(15);
            tabelaMostraMovimentacao.getColumnModel().getColumn(4).setPreferredWidth(15);
            tabelaMostraMovimentacao.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        btnSalvarMovim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/icone-salva-estoque-botao.png"))); // NOI18N
        btnSalvarMovim.setText("Salvar Movimentação");
        btnSalvarMovim.addActionListener(evt -> btnSalvarMovimActionPerformed(evt));

        gerarRelatorioMov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/pdf-report.png"))); // NOI18N
        gerarRelatorioMov.setText("Gerar Relatorio Estoque");
        gerarRelatorioMov.setPreferredSize(new java.awt.Dimension(64, 64));
        gerarRelatorioMov.addActionListener(evt -> gerarRelatorioMovActionPerformed(evt));

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/icone-voltar-view.png"))); // NOI18N
        btnVoltar.setToolTipText("VOLTAR INTERFACE PRINCIPAL");
        btnVoltar.setPreferredSize(new java.awt.Dimension(32, 32));
        btnVoltar.addActionListener(evt -> btnVoltarActionPerformed(evt));

        javax.swing.GroupLayout conteinerAgrupaElementosFrameLayout = new javax.swing.GroupLayout(conteinerAgrupaElementosFrame);
        conteinerAgrupaElementosFrame.setLayout(conteinerAgrupaElementosFrameLayout);
        conteinerAgrupaElementosFrameLayout.setHorizontalGroup(
                conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(conteinerAgrupaElementosFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteinerAgrupaElementosFrameLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(gerarRelatorioMov, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(conteinerAgrupaElementosFrameLayout.createSequentialGroup()
                                                .addGroup(conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblDescricaoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbDescriProd, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(conteinerAgrupaElementosFrameLayout.createSequentialGroup()
                                                                .addGroup(conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(lblTipoMov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(cbTipoMov, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(lblQtdProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(spQtd))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(lblValorProd, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                                                        .addComponent(txtPreco))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                                .addComponent(btnSalvarMovim, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        conteinerAgrupaElementosFrameLayout.setVerticalGroup(
                conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(conteinerAgrupaElementosFrameLayout.createSequentialGroup()
                                .addGroup(conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(conteinerAgrupaElementosFrameLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(conteinerAgrupaElementosFrameLayout.createSequentialGroup()
                                                                .addGroup(conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(lblTipoMov)
                                                                        .addComponent(lblQtdProd)
                                                                        .addComponent(lblValorProd))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(cbTipoMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(spQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(btnSalvarMovim)))
                                        .addGroup(conteinerAgrupaElementosFrameLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(lblDescricaoProd)
                                .addGap(18, 18, 18)
                                .addComponent(cbDescriProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(gerarRelatorioMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(conteinerAgrupaElementosFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(conteinerAgrupaElementosFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(824, 629));
        setLocationRelativeTo(null);
    }

    private void gerarRelatorioMovActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void cbTipoMovActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btnSalvarMovimActionPerformed(java.awt.event.ActionEvent evt) {
        this.controlEstoque = new ControllerTblEstoque();
        this.estoque = new ModelEstoque();
        this.estoque.setQuantidade((int) this.spQtd.getModel().getValue());
        try {
            this.estoque.setPreco(Double.parseDouble(this.txtPreco.getText()));  //indice comboBox - indice mov | 0 = entrada | 1 = saida
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "PREENCHA O CAMPO PREÇO CORRETAMENTE", "PRENCHER CAMPOS OBRIGATORIOS", JOptionPane.WARNING_MESSAGE);
        }
        this.estoque.setTipo_movimentacao(this.cbTipoMov.getSelectedIndex());
        String descr = String.valueOf(this.cbDescriProd.getSelectedItem());
        this.estoque.setFk_usuario(this.usuarioLogado.getCodigoId());
        int idProduto = -1;
        for (int i = 0; i < produtos.size(); i++) {
            ModelProduto produto = produtos.get(i);
            if (produto.getDescricaoProduto().equals(descr)) {
                idProduto = produto.getIdProduto();
            }
        }
        this.estoque.setFk_produto(idProduto);
        if (this.controlEstoque.controllerAddMovEstoque(estoque)) {
            JOptionPane.showMessageDialog(this, "MOVIMENTAÇÃO NO ESTOQUE EFETUADA COM SUCESSO", "MOVIMENTAÇÃO ESTOQUE", JOptionPane.INFORMATION_MESSAGE);
            limpaCampos();
            this.carregaMovimentacoesEstoque();
        } else {
            JOptionPane.showMessageDialog(this, "PREENCHA OS CAMPOS CORRETAMENTE", "MOVIMENTAÇÃO ESTOQUE", JOptionPane.ERROR_MESSAGE);
            limpaCampos();
        }
    }

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        ViewPrincipalResponsiva p = new ViewPrincipalResponsiva(this.usuarioLogado);
        p.setVisible(true);
        dispose();
    }


    private void listDescricaoProdutos() {
        produtos = new ArrayList<>();
        this.controlEstoque = new ControllerTblEstoque();
        produtos = this.controlEstoque.controllerGetDescricaoProdutos();
        for (int i = 0; i < produtos.size(); i++) {
            Object objetoDescricao = produtos.get(i).getDescricaoProduto();
            this.cbDescriProd.addItem(objetoDescricao.toString());
        }
    }

    private void setFontExterna() {
        try {
            fonteExterna = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("fontes_externas/PlayfairDisplay-ExtraBold.ttf"));
        } catch (IOException | FontFormatException e) {
            System.out.println("Não carregou as fonte externa padrão da tela do gerenciamento de estoque! " + e);
        }
        lblTipoMov.setFont(fonteExterna.deriveFont(Font.PLAIN, 15));
        lblValorProd.setFont(fonteExterna.deriveFont(Font.PLAIN, 15));
        lblQtdProd.setFont(fonteExterna.deriveFont(Font.PLAIN, 15));

        lblDescricaoProd.setFont(fonteExterna.deriveFont(Font.PLAIN, 15));
        btnSalvarMovim.setFont(fonteExterna.deriveFont(Font.PLAIN, 20));
        gerarRelatorioMov.setFont(fonteExterna.deriveFont(Font.PLAIN, 20));
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fonteExterna);
        this.setFont(fonteExterna);
    }

    private void carregaMovimentacoesEstoque() {
        this.modeloTabelaMovimentacao = (DefaultTableModel) this.tabelaMostraMovimentacao.getModel();
        this.modeloTabelaMovimentacao.setNumRows(0);
        this.listaEstoque = new ArrayList<>();
        this.controlEstoque = new ControllerTblEstoque();
        this.estoque = new ModelEstoque();
        this.listaEstoque = this.controlEstoque.controlerGetEstoques(usuarioLogado);

        for (int i = 0; i < listaEstoque.size(); i++) {
            this.modeloTabelaMovimentacao.addRow(new Object[]{
                    this.listaEstoque.get(i).getPreco(),
                    this.listaEstoque.get(i).getFk_produto(),
                    this.listaEstoque.get(i).getQuantidade(),
                    (this.listaEstoque.get(i).getTipo_movimentacao() == 0) ? "ENTRADA" : "SAIDA",
                    this.listaEstoque.get(i).getDataMovimentacao(),
                    this.listaEstoque.get(i).getFk_usuario()
            });
        }
    }

    private void limpaCampos() {
        spQtd.setValue(1);
        txtPreco.setText(null);
        cbDescriProd.setSelectedItem("Escolha a Descrição Do Produto");
    }

    private javax.swing.JButton btnSalvarMovim;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbDescriProd;
    private javax.swing.JComboBox<String> cbTipoMov;
    private javax.swing.JPanel conteinerAgrupaElementosFrame;
    private javax.swing.JButton gerarRelatorioMov;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricaoProd;
    private javax.swing.JLabel lblQtdProd;
    private javax.swing.JLabel lblTipoMov;
    private javax.swing.JLabel lblValorProd;
    private javax.swing.JSpinner spQtd;
    private javax.swing.JTable tabelaMostraMovimentacao;
    private javax.swing.JTextField txtPreco;
}
