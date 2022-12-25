package view;

import controller.ControllerUsuario;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.ModelUsuario;

public class ViewUsuario extends javax.swing.JFrame {

    private ModelUsuario userGlobal;
    private List<ModelUsuario> listaUsuarios;
    private ControllerUsuario cp;
    private DefaultTableModel tblModeloPadrao;
    private Font fonteExterna;
    private ModelUsuario usuarioLogado;

    private String opcao = "CADASTRAR";


    public ViewUsuario(ModelUsuario user) {

        this.usuarioLogado = user;
        this.listaUsuarios = new ArrayList<>();
        this.cp = new ControllerUsuario();
        this.userGlobal = new ModelUsuario();

        initComponents();

        setFontExterna();

        listaUsuarios();
    }

    private void limparFormulario() {
        txtCodigoId.setText(null);
        txtNomeUser.setText(null);
        txtLoginUser.setText(null);
        txtSenhaUser.setText(null);
        opcao = "CADASTRAR";
    }

    private void listaUsuarios() {
        this.listaUsuarios = cp.getUsuariosControler();

        tblModeloPadrao = (DefaultTableModel) this.getTbllBancoDados.getModel();
        int indice;

        this.tblModeloPadrao.setNumRows(0);

        for (indice = 0; indice < this.listaUsuarios.size(); indice += 1) {

            this.tblModeloPadrao.addRow(new Object[]{
                    this.listaUsuarios.get(indice).getCodigoId(),
                    this.listaUsuarios.get(indice).getNome(),
                    this.listaUsuarios.get(indice).getLogin()
            });
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        conteinerAgrupaElementosJframe = new javax.swing.JPanel();
        txtCodigoId = new javax.swing.JTextField();
        txtNomeUser = new javax.swing.JTextField();
        txtLoginUser = new javax.swing.JTextField();
        txtSenhaUser = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        getTbllBancoDados = new javax.swing.JTable();
        conteinerButtons = new javax.swing.JPanel();
        btnAlterarDadosUser = new javax.swing.JButton();
        btnLimparDadosTela = new javax.swing.JButton();
        btnExcluirDadosUser = new javax.swing.JButton();
        btnSalvarCadUser = new javax.swing.JButton();
        conteinerLabels = new javax.swing.JPanel();
        lblCodigoId = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        btnVoltarView = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Informações Usúarios");
        setResizable(false);

        conteinerAgrupaElementosJframe.setBackground(new java.awt.Color(183, 183, 183));

        txtCodigoId.setEditable(false);

        getTbllBancoDados.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "CÓDIGO", "NOME", "LOGIN"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(getTbllBancoDados);
        if (getTbllBancoDados.getColumnModel().getColumnCount() > 0) {
            getTbllBancoDados.getColumnModel().getColumn(0).setMinWidth(100);
            getTbllBancoDados.getColumnModel().getColumn(0).setPreferredWidth(100);
            getTbllBancoDados.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        conteinerButtons.setLayout(new java.awt.GridLayout());

        btnAlterarDadosUser.setFont(new java.awt.Font("Times New Roman", 1, 14));
        btnAlterarDadosUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/icone-editar-user-btn-user.png")));
        btnAlterarDadosUser.setText("ALTERAR");
        btnAlterarDadosUser.setPreferredSize(new java.awt.Dimension(48, 48));
        btnAlterarDadosUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarDadosUserActionPerformed(evt);
            }
        });
        conteinerButtons.add(btnAlterarDadosUser);

        btnLimparDadosTela.setFont(new java.awt.Font("Times New Roman", 1, 14));
        btnLimparDadosTela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/icone-limpar-btn-user.png")));
        btnLimparDadosTela.setText("LIMPAR");
        btnLimparDadosTela.setPreferredSize(new java.awt.Dimension(48, 48));
        btnLimparDadosTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparDadosTelaActionPerformed(evt);
            }
        });
        conteinerButtons.add(btnLimparDadosTela);

        btnExcluirDadosUser.setFont(new java.awt.Font("Times New Roman", 1, 14));
        btnExcluirDadosUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/icone-excluir-user-btn-user.png")));
        btnExcluirDadosUser.setText("EXCLUIR");
        btnExcluirDadosUser.setPreferredSize(new java.awt.Dimension(48, 48));
        btnExcluirDadosUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirDadosUserActionPerformed(evt);
            }
        });
        conteinerButtons.add(btnExcluirDadosUser);

        btnSalvarCadUser.setFont(new java.awt.Font("Times New Roman", 1, 14));
        btnSalvarCadUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/disquete-salvar-usuario-btn.png")));
        btnSalvarCadUser.setText("SALVAR");
        btnSalvarCadUser.setPreferredSize(new java.awt.Dimension(48, 48));
        btnSalvarCadUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCadUserActionPerformed(evt);
            }
        });
        conteinerButtons.add(btnSalvarCadUser);

        conteinerLabels.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCodigoId.setFont(new java.awt.Font("Times New Roman", 1, 14));
        lblCodigoId.setText("CÓDIGO");
        conteinerLabels.add(lblCodigoId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 70, -1));

        lblNome.setFont(new java.awt.Font("Times New Roman", 1, 14));
        lblNome.setText("* NOME COMPLETO");
        conteinerLabels.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 0, 290, -1));

        lblLogin.setFont(new java.awt.Font("Times New Roman", 1, 14));
        lblLogin.setText("* LOGIN");
        conteinerLabels.add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 0, 200, -1));

        lblSenha.setFont(new java.awt.Font("Times New Roman", 1, 14));
        lblSenha.setText("* SENHA");
        conteinerLabels.add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(619, 0, 170, -1));

        btnVoltarView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/icone-voltar-view.png")));
        btnVoltarView.setPreferredSize(new java.awt.Dimension(32, 32));
        btnVoltarView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout conteinerAgrupaElementosJframeLayout = new javax.swing.GroupLayout(conteinerAgrupaElementosJframe);
        conteinerAgrupaElementosJframe.setLayout(conteinerAgrupaElementosJframeLayout);
        conteinerAgrupaElementosJframeLayout.setHorizontalGroup(
                conteinerAgrupaElementosJframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(conteinerAgrupaElementosJframeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(conteinerAgrupaElementosJframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(conteinerLabels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(conteinerButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1)
                                        .addGroup(conteinerAgrupaElementosJframeLayout.createSequentialGroup()
                                                .addComponent(txtCodigoId, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtNomeUser)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtLoginUser, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtSenhaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteinerAgrupaElementosJframeLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVoltarView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        conteinerAgrupaElementosJframeLayout.setVerticalGroup(
                conteinerAgrupaElementosJframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(conteinerAgrupaElementosJframeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnVoltarView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(conteinerLabels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(conteinerAgrupaElementosJframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNomeUser, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                        .addComponent(txtLoginUser)
                                        .addComponent(txtSenhaUser)
                                        .addComponent(txtCodigoId))
                                .addGap(18, 18, 18)
                                .addComponent(conteinerButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(conteinerAgrupaElementosJframe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(conteinerAgrupaElementosJframe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(824, 620));
        setLocationRelativeTo(null);
    }

    private void btnSalvarCadUserActionPerformed(java.awt.event.ActionEvent evt) {

        switch (this.opcao) {
            case "CADASTRAR":


                if (this.txtNomeUser.getText().isEmpty() && this.txtLoginUser.getText().isEmpty() && this.txtSenhaUser.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Pre-Encha os Campos Obrigatorios Marcados Com (*)", "Atenção", JOptionPane.WARNING_MESSAGE);
                } else {

                    userGlobal.setNome(txtNomeUser.getText());
                    userGlobal.setLogin(txtLoginUser.getText());
                    userGlobal.setSenha(txtSenhaUser.getText());

                    if (this.cp.controlerSalvarUsuario(userGlobal)) {
                        JOptionPane.showMessageDialog(null, "Usuario Cadastrado Com Sucesso!", "Sucesso Cadastro", JOptionPane.INFORMATION_MESSAGE);

                        limparFormulario();

                        this.tblModeloPadrao.setNumRows(0);

                        listaUsuarios();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario Não Cadastrado", "Error Cadastro Usúario", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case "ALTERAR":


                if (this.txtNomeUser.getText().isEmpty() && this.txtLoginUser.getText().isEmpty() && this.txtSenhaUser.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Para Alterar  um Cadastro Pre-Encha os Campos Obrigatorios Marcados Com (*)", "Atenção", JOptionPane.WARNING_MESSAGE);
                } else {
                    userGlobal.setCodigoId(Integer.parseInt(txtCodigoId.getText()));
                    userGlobal.setNome(txtNomeUser.getText());
                    userGlobal.setLogin(txtLoginUser.getText());
                    userGlobal.setSenha(txtSenhaUser.getText());
                    if (this.cp.controlerAlterarCadastroUsuario(userGlobal)) {
                        JOptionPane.showMessageDialog(null, "Alteração De Cadastro Feita Com Sucesso", "SUCESSO ALTERAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                        limparFormulario();
                        listaUsuarios();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao Alterar um Cadastro", "ERRO ALTERAÇÃO", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            default:
                System.out.println("Opção Não Encontrada");
                break;
        }


    }

    private void btnExcluirDadosUserActionPerformed(java.awt.event.ActionEvent evt) {


        int linhaSelecionada = this.getTbllBancoDados.getSelectedRow();

        if (linhaSelecionada < 0)
            JOptionPane.showMessageDialog(this, "Selecione Um Usuario Para Excluir", "Atenção", JOptionPane.WARNING_MESSAGE);
        else {


            int colunaCodigo = 0, colunaNome = 1, colunaLogin = 2;

            int codigoUser = (int) this.getTbllBancoDados.getValueAt(linhaSelecionada, colunaCodigo);
            if (this.cp.controlerExcluirUsuario(codigoUser)) {

                this.tblModeloPadrao.setNumRows(0);

                this.listaUsuarios();
                JOptionPane.showMessageDialog(this, "Usuario Excluido Com Sucesso", "Exclusão Ocorrida Com Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Ocorreu Um Erro ao Excluir Usuario", "Erro na Exclusão", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void btnLimparDadosTelaActionPerformed(java.awt.event.ActionEvent evt) {

        limparFormulario();
        this.tblModeloPadrao.setNumRows(0);

    }

    private void btnAlterarDadosUserActionPerformed(java.awt.event.ActionEvent evt) {

        int linhaSelecionada, colunaSelecionada = 0, codigoUsuario;

        linhaSelecionada = this.getTbllBancoDados.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Para poder Alterar Um Cadastro de Um Usuario,\n Selecione Um Usuario Listado Na Tabela!", "Erro ALTERAÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {


            codigoUsuario = (int) this.getTbllBancoDados.getValueAt(linhaSelecionada, colunaSelecionada);

            this.userGlobal = this.cp.controlerBuscaUsuario(codigoUsuario);

            if (userGlobal != null) {

                limparFormulario();
                txtCodigoId.setText(userGlobal.getCodigoId().toString());
                txtNomeUser.setText(userGlobal.getNome());
                txtLoginUser.setText(userGlobal.getLogin());
                txtSenhaUser.setText(userGlobal.getSenha());

                opcao = "ALTERAR";
            } else {
                JOptionPane.showMessageDialog(this, "Ocorreu um Erro ao mostrar dados do usario no frame Usuario", "Erro ao mostrar Dados", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void btnVoltarViewActionPerformed(java.awt.event.ActionEvent evt) {

        ViewPrincipalResponsiva framePrincipal = new ViewPrincipalResponsiva(this.usuarioLogado);
        framePrincipal.setVisible(true);
        dispose();
    }

    private void setFontExterna() {
        try {

            fonteExterna = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("fontes_externas/PlayfairDisplay-ExtraBold.ttf"));
        } catch (IOException | FontFormatException e) {
            System.out.println("Não carregou as fonte externa padrão da tela do usuario! " + e);
        }


        lblCodigoId.setFont(fonteExterna.deriveFont(Font.PLAIN, 15));
        lblNome.setFont(fonteExterna.deriveFont(Font.PLAIN, 15));
        lblLogin.setFont(fonteExterna.deriveFont(Font.PLAIN, 15));
        lblSenha.setFont(fonteExterna.deriveFont(Font.PLAIN, 15));

        btnSalvarCadUser.setFont(fonteExterna.deriveFont(Font.PLAIN, 20));
        btnLimparDadosTela.setFont(fonteExterna.deriveFont(Font.PLAIN, 20));
        btnAlterarDadosUser.setFont(fonteExterna.deriveFont(Font.PLAIN, 20));
        btnExcluirDadosUser.setFont(fonteExterna.deriveFont(Font.PLAIN, 20));
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fonteExterna);
        this.setFont(fonteExterna);
    }


    private javax.swing.JButton btnAlterarDadosUser;
    private javax.swing.JButton btnExcluirDadosUser;
    private javax.swing.JButton btnLimparDadosTela;
    private javax.swing.JButton btnSalvarCadUser;
    private javax.swing.JButton btnVoltarView;
    private javax.swing.JPanel conteinerAgrupaElementosJframe;
    private javax.swing.JPanel conteinerButtons;
    private javax.swing.JPanel conteinerLabels;
    private javax.swing.JTable getTbllBancoDados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCodigoId;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtCodigoId;
    private javax.swing.JTextField txtLoginUser;
    private javax.swing.JTextField txtNomeUser;
    private javax.swing.JTextField txtSenhaUser;
}