package view;

import controller.ControllerTblProduto;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.ModelProduto;
import model.ModelUsuario;
import utiuls.FormatadorDados;

public class ViewProduto extends javax.swing.JFrame {

    private Font spectral;
    private ModelProduto produto;
    private ControllerTblProduto controlaProduto;
    private DefaultTableModel tblModeloPadrao;
    private List<ModelProduto> listaProdutos;
    private String controlaOpcaoUsuario;
    private ModelUsuario userLogado;

    public ViewProduto(ModelUsuario user) {

        this.userLogado = user;

        initComponents();

        setFonteExterna();

        listaProdutosTbl();
        this.controlaOpcaoUsuario = "CADASTRAR";
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        conteinerAgrupaElementosFrame = new javax.swing.JPanel();
        lblCodigoId = new javax.swing.JLabel();
        lblDescricaoProduto = new javax.swing.JLabel();
        lblValorProduto = new javax.swing.JLabel();
        txtCodigoIdProduto = new javax.swing.JTextField();
        txtDescricaoProduto = new javax.swing.JTextField();
        txtValorProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostraProdutos = new javax.swing.JTable();
        conteinerAgrupaButtons = new javax.swing.JPanel();
        btnSalvarProduto = new javax.swing.JButton();
        btnLimpaCampos = new javax.swing.JButton();
        btnAlterarProduto = new javax.swing.JButton();
        btnExcluirProduto = new javax.swing.JButton();
        btnVoltarView = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manipulação de Produtos");
        setResizable(false);

        conteinerAgrupaElementosFrame.setBackground(new java.awt.Color(183, 183, 183));

        lblCodigoId.setFont(new java.awt.Font("Times New Roman", 1, 14));
        lblCodigoId.setText("CÓDIGO");

        lblDescricaoProduto.setFont(new java.awt.Font("Times New Roman", 1, 14));
        lblDescricaoProduto.setText("DESCRIÇÃO PRODUTO *");

        lblValorProduto.setFont(new java.awt.Font("Times New Roman", 1, 14));
        lblValorProduto.setText("VALOR *");

        txtCodigoIdProduto.setEditable(false);

        tblMostraProdutos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "CÓDIGO", "DESCRIÇÃO PRODUTO", "VALOR"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMostraProdutos);
        if (tblMostraProdutos.getColumnModel().getColumnCount() > 0) {
            tblMostraProdutos.getColumnModel().getColumn(0).setMinWidth(80);
            tblMostraProdutos.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblMostraProdutos.getColumnModel().getColumn(0).setMaxWidth(80);
            tblMostraProdutos.getColumnModel().getColumn(2).setMinWidth(80);
            tblMostraProdutos.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblMostraProdutos.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        conteinerAgrupaButtons.setBackground(new java.awt.Color(102, 102, 102));

        btnSalvarProduto.setFont(new java.awt.Font("Times New Roman", 1, 14));
        btnSalvarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/icone-salvar-btn-produto.png")));
        btnSalvarProduto.setText("SALVAR PRODUTO");
        btnSalvarProduto.setPreferredSize(new java.awt.Dimension(48, 48));
        btnSalvarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarProdutoActionPerformed(evt);
            }
        });

        btnLimpaCampos.setFont(new java.awt.Font("Times New Roman", 1, 14));
        btnLimpaCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/icone-limpeza-btn-produto.png")));
        btnLimpaCampos.setText("LIMPAR");
        btnLimpaCampos.setPreferredSize(new java.awt.Dimension(48, 48));
        btnLimpaCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaCamposActionPerformed(evt);
            }
        });

        btnAlterarProduto.setFont(new java.awt.Font("Times New Roman", 1, 14));
        btnAlterarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/icone-alterar-produ-btn.png")));
        btnAlterarProduto.setText("ALTERAR");
        btnAlterarProduto.setPreferredSize(new java.awt.Dimension(48, 48));
        btnAlterarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarProdutoActionPerformed(evt);
            }
        });

        btnExcluirProduto.setFont(new java.awt.Font("Times New Roman", 1, 14));
        btnExcluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/icone-deletar-product-btn-produto.png")));
        btnExcluirProduto.setText("EXCLUIR");
        btnExcluirProduto.setPreferredSize(new java.awt.Dimension(48, 48));
        btnExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout conteinerAgrupaButtonsLayout = new javax.swing.GroupLayout(conteinerAgrupaButtons);
        conteinerAgrupaButtons.setLayout(conteinerAgrupaButtonsLayout);
        conteinerAgrupaButtonsLayout.setHorizontalGroup(
                conteinerAgrupaButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(conteinerAgrupaButtonsLayout.createSequentialGroup()
                                .addComponent(btnSalvarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpaCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        conteinerAgrupaButtonsLayout.setVerticalGroup(
                conteinerAgrupaButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSalvarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimpaCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(conteinerAgrupaButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAlterarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnVoltarView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/icone-voltar-view.png")));
        btnVoltarView.setPreferredSize(new java.awt.Dimension(32, 32));
        btnVoltarView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout conteinerAgrupaElementosFrameLayout = new javax.swing.GroupLayout(conteinerAgrupaElementosFrame);
        conteinerAgrupaElementosFrame.setLayout(conteinerAgrupaElementosFrameLayout);
        conteinerAgrupaElementosFrameLayout.setHorizontalGroup(
                conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(conteinerAgrupaElementosFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
                                        .addGroup(conteinerAgrupaElementosFrameLayout.createSequentialGroup()
                                                .addComponent(lblCodigoId)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblValorProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(conteinerAgrupaElementosFrameLayout.createSequentialGroup()
                                                .addComponent(txtCodigoIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtValorProduto))
                                        .addGroup(conteinerAgrupaElementosFrameLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(conteinerAgrupaButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(conteinerAgrupaElementosFrameLayout.createSequentialGroup()
                                                                .addGap(378, 378, 378)
                                                                .addComponent(btnVoltarView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        conteinerAgrupaElementosFrameLayout.setVerticalGroup(
                conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(conteinerAgrupaElementosFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnVoltarView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCodigoId)
                                        .addComponent(lblDescricaoProduto)
                                        .addComponent(lblValorProduto))
                                .addGap(18, 18, 18)
                                .addGroup(conteinerAgrupaElementosFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCodigoIdProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                        .addComponent(txtDescricaoProduto)
                                        .addComponent(txtValorProduto))
                                .addGap(18, 18, 18)
                                .addComponent(conteinerAgrupaButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
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

        setSize(new java.awt.Dimension(888, 635));
        setLocationRelativeTo(null);
    }


    private void btnSalvarProdutoActionPerformed(java.awt.event.ActionEvent evt) {

        switch (this.controlaOpcaoUsuario) {

            case "CADASTRAR":

                if (this.txtDescricaoProduto.getText().isEmpty() || this.txtValorProduto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Para cadastrar um Produto Prencha os campos obrigatorios", "Falha ao Cadastrar", JOptionPane.WARNING_MESSAGE);
                } else {

                    this.controlaProduto = new ControllerTblProduto();
                    this.produto = new ModelProduto();
                    this.produto.setDescricaoProduto(this.txtDescricaoProduto.getText());

                    try {
                        FormatadorDados f = new FormatadorDados();
                        this.produto.setValorProduto(f.formataValor(this.txtValorProduto.getText()));
                    } catch (NumberFormatException e) {

                        this.produto.setValorProduto(0);
                        System.out.println("O campor valor do produto não pode ficar vazio!: " + e);
                    }
                    this.controlaProduto = new ControllerTblProduto();
                    if (this.controlaProduto.controllerCadastraProduto(produto)) {
                        JOptionPane.showMessageDialog(this, "Produto Cadastrado Com Sucesso", "Sucesso Cadastro", JOptionPane.INFORMATION_MESSAGE);
                        listaProdutosTbl();
                        limpaCamposView();
                    } else {
                        JOptionPane.showMessageDialog(this, "Produto Não Cadastrado\n Preencha os Campos Corretamente!", "Erro no Cadastro", JOptionPane.ERROR_MESSAGE);
                        limpaCamposView();
                    }
                }
                break;

            case "ALTERAR":

                if (this.txtDescricaoProduto.getText().isEmpty() || this.txtValorProduto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Para Alterar um Produto Prencha os campos obrigatorios", "Falha ao Atualizar", JOptionPane.WARNING_MESSAGE);
                } else {

                    this.produto = new ModelProduto();
                    this.controlaProduto = new ControllerTblProduto();
                    this.produto.setDescricaoProduto(this.txtDescricaoProduto.getText());
                    try {
                        this.produto.setIdProduto(Integer.parseInt(this.txtCodigoIdProduto.getText()));
                        FormatadorDados f = new FormatadorDados();
                        this.produto.setValorProduto(f.formataValor(this.txtValorProduto.getText()));
                    } catch (NumberFormatException e) {

                        this.produto.setValorProduto(0);
                        System.out.println("O campor valor do produto não pode ficar vazio!: " + e);
                    }
                    if (this.controlaProduto.controllerAtualizaProduto(this.produto)) {
                        JOptionPane.showMessageDialog(this, "Atualização Ocorrida Com Sucesso", "Sucesso Atualição", JOptionPane.INFORMATION_MESSAGE);
                        limpaCamposView();
                        listaProdutosTbl();
                        this.controlaOpcaoUsuario = "CADASTRAR";
                    } else {
                        limpaCamposView();
                        JOptionPane.showMessageDialog(this, "Falha ao Atualizar Produto", "Erro Atualização", JOptionPane.ERROR_MESSAGE);
                        this.controlaOpcaoUsuario = "CADASTRAR";
                    }

                }
                break;
            default:
                JOptionPane.showMessageDialog(this, "Opção Invalida", "Opção Invalida", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void btnAlterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {

        int linhaSelecionada, ColunaIdTabela = 0, codigoProduto;
        linhaSelecionada = this.tblMostraProdutos.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Para poder Alterar Informações de Um Produto,\n Selecione Um Produto Listado na Tabela!", "Erro ALTERAÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {

            codigoProduto = (int) this.tblMostraProdutos.getValueAt(linhaSelecionada, ColunaIdTabela);

            this.produto = new ModelProduto();
            this.controlaProduto = new ControllerTblProduto();
            this.produto = this.controlaProduto.controllerGetProduto(codigoProduto);

            if (this.produto != null) {
                this.txtCodigoIdProduto.setText(String.valueOf(this.produto.getIdProduto()));
                this.txtDescricaoProduto.setText(this.produto.getDescricaoProduto());
                this.txtValorProduto.setText(String.valueOf(this.produto.getValorProduto()));
                this.controlaOpcaoUsuario = "ALTERAR";
            } else {

                this.txtCodigoIdProduto.setText("Sem Codigo");
                this.txtDescricaoProduto.setText("Não Possui Descrição");
                this.txtValorProduto.setText("Não Possui Valor");
            }
        }
    }

    private void btnExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {

        int linhaSelecionada = this.tblMostraProdutos.getSelectedRow();

        if (linhaSelecionada < 0)
            JOptionPane.showMessageDialog(this, "SELECIONE UM PRODUTO PARA SER EXCLUIDO", "EXCLUSÃO PRODUTO", JOptionPane.ERROR_MESSAGE);
        else {


            int colunaCodigo = 0;

            int codigoProduto = (int) this.tblMostraProdutos.getValueAt(linhaSelecionada, colunaCodigo);

            this.controlaProduto = new ControllerTblProduto();
            if (this.controlaProduto.controllerExcluirProduto(codigoProduto)) {
                JOptionPane.showMessageDialog(this, "Exclusão de produto ocorrida com sucesso!", "EXLUIR PRODUTO", JOptionPane.INFORMATION_MESSAGE);

                this.listaProdutosTbl();
            } else {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao excluir produto!", "EXLUIR PRODUTO", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void btnVoltarViewActionPerformed(java.awt.event.ActionEvent evt) {

        ViewPrincipalResponsiva p = new ViewPrincipalResponsiva(this.userLogado);
        p.setVisible(true);
        dispose();
    }

    private void btnLimpaCamposActionPerformed(java.awt.event.ActionEvent evt) {

        this.limpaCamposView();

        this.tblModeloPadrao.setNumRows(0);
    }


    private void listaProdutosTbl() {

        this.tblModeloPadrao = (DefaultTableModel) this.tblMostraProdutos.getModel();

        this.tblModeloPadrao.setNumRows(0);
        this.produto = new ModelProduto();
        this.listaProdutos = new ArrayList<>();
        this.controlaProduto = new ControllerTblProduto();
        this.listaProdutos = this.controlaProduto.controllerGetListaProdutos();


        for (int indice = 0; indice < this.listaProdutos.size(); indice += 1) {

            this.tblModeloPadrao.addRow(new Object[]{
                    this.listaProdutos.get(indice).getIdProduto(),
                    this.listaProdutos.get(indice).getDescricaoProduto(),
                    this.listaProdutos.get(indice).getValorProduto()
            });


            this.tblModeloPadrao.setValueAt("R$ " + this.listaProdutos.get(indice).getValorProduto(), indice, 2);
        }
    }

    private void setFonteExterna() {

        try {
            spectral = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("fontes_externas/Spectral-Bold.ttf"));
        } catch (IOException | FontFormatException e) {
            System.out.println("Não carregou as fonte externa padrão da tela de produtos! " + e);
        }


        this.lblCodigoId.setFont(spectral.deriveFont(Font.PLAIN, 18));
        this.lblDescricaoProduto.setFont(spectral.deriveFont(Font.PLAIN, 18));
        this.lblValorProduto.setFont(spectral.deriveFont(Font.PLAIN, 18));


        btnSalvarProduto.setFont(spectral.deriveFont(Font.PLAIN, 16));
        btnLimpaCampos.setFont(spectral.deriveFont(Font.PLAIN, 16));
        btnAlterarProduto.setFont(spectral.deriveFont(Font.PLAIN, 16));
        btnExcluirProduto.setFont(spectral.deriveFont(Font.PLAIN, 16));
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(spectral);
        this.setFont(spectral);
    }

    private void limpaCamposView() {
        this.txtCodigoIdProduto.setText(null);
        this.txtDescricaoProduto.setText(null);
        this.txtValorProduto.setText(null);
    }

    private javax.swing.JButton btnAlterarProduto;
    private javax.swing.JButton btnExcluirProduto;
    private javax.swing.JButton btnLimpaCampos;
    private javax.swing.JButton btnSalvarProduto;
    private javax.swing.JButton btnVoltarView;
    private javax.swing.JPanel conteinerAgrupaButtons;
    private javax.swing.JPanel conteinerAgrupaElementosFrame;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigoId;
    private javax.swing.JLabel lblDescricaoProduto;
    private javax.swing.JLabel lblValorProduto;
    private javax.swing.JTable tblMostraProdutos;
    private javax.swing.JTextField txtCodigoIdProduto;
    private javax.swing.JTextField txtDescricaoProduto;
    private javax.swing.JTextField txtValorProduto;
}