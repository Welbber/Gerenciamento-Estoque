package view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.Calendar;
import java.util.Objects;

import model.ModelUsuario;

public class ViewPrincipal extends javax.swing.JFrame {

    ModelUsuario user;
    Font fonteExterna;

    public ViewPrincipal(ModelUsuario usuarioLogado) {
        this.user = usuarioLogado;
        initComponents();
        this.lblUsuario.setText(this.user.getLogin());
        this.dataHoraSessao();
        this.setFontExterna();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnUser = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnMovimentaEstoque = new javax.swing.JButton();
        btnSobreSistema = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblSessao = new javax.swing.JLabel();
        lblDataHora = new javax.swing.JLabel();
        lblUsuarioLogado = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PRINCIPAL");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(25, 56, 255));

        btnUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnUser.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/imagens_icones/btn-user.png")))); // NOI18N
        btnUser.setText("USÚARIOS");
        btnUser.setToolTipText("");
        btnUser.setPreferredSize(new java.awt.Dimension(64, 64));
        btnUser.addActionListener(this::btnUserActionPerformed);

        btnProduto.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnProduto.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/imagens_icones/icone-produto-btn-principal.png")))); // NOI18N
        btnProduto.setText("PRODUTOS");
        btnProduto.setPreferredSize(new java.awt.Dimension(64, 64));
        btnProduto.addActionListener(this::btnProdutoActionPerformed);

        btnMovimentaEstoque.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnMovimentaEstoque.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/imagens_icones/icons-movimento-de-estoque-64-btn-principal.png")))); // NOI18N
        btnMovimentaEstoque.setText("ESTOQUE");
        btnMovimentaEstoque.setPreferredSize(new java.awt.Dimension(64, 64));
        btnMovimentaEstoque.addActionListener(this::btnMovimentaEstoqueActionPerformed);

        btnSobreSistema.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSobreSistema.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/imagens_icones/icone-informacao-sistema-btn-principal.png")))); // NOI18N
        btnSobreSistema.setText("SOBRE");
        btnSobreSistema.setPreferredSize(new java.awt.Dimension(64, 64));

        btnSair.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/imagens_icones/icons8-desligar-64.png")))); // NOI18N
        btnSair.setText("SAIR");
        btnSair.setPreferredSize(new java.awt.Dimension(64, 64));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMovimentaEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSobreSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMovimentaEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSobreSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(171, 171, 147));
        jLabel1.setText("GERENCIAMENTO DE ESTOQUE");

        jPanel3.setBackground(new java.awt.Color(66, 79, 199));

        lblSessao.setForeground(new java.awt.Color(255, 255, 255));
        lblSessao.setText("INFORMATION SYSTEM");

        lblUsuarioLogado.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarioLogado.setText("USUARIO LOGADO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblDataHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblSessao, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                        .addComponent(lblUsuarioLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(9, 13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(117, 117, 117))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(915, 510));
        setLocationRelativeTo(null);
    }

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {
        ViewProduto prod = new ViewProduto(this.user);
        prod.setVisible(true);
        dispose();
    }

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {
        ViewUsuario interfaceUsuario = new ViewUsuario(this.user);
        interfaceUsuario.setVisible(true);
        dispose();
    }

    private void btnMovimentaEstoqueActionPerformed(java.awt.event.ActionEvent evt) {
        ViewEstoque ve = new ViewEstoque(this.user);
        ve.setVisible(true);
        dispose();
    }

    private void dataHoraSessao() {
        Calendar data = Calendar.getInstance();
        int dia = data.get(Calendar.DAY_OF_MONTH);
        int mes = data.get(Calendar.MONTH) + 1;
        int ano = data.get(Calendar.YEAR);
        int hora = data.get(Calendar.HOUR_OF_DAY);
        int minute = data.get(Calendar.MINUTE);
        this.lblDataHora.setText("<html><body><p align=center>" + dia + "/" + mes + "/" + ano + "</p>"
                + "<p align=center>" + hora + ":" + minute + "</p></body></html>");
    }

    private void setFontExterna() {
        try {
            fonteExterna = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("fontes_externas/Gayathri-Regular.ttf")));
        } catch (IOException | FontFormatException e) {
            System.out.println("Não carregou as fonte externa padrão da tela principal! " + e);
        }
        lblDataHora.setFont(fonteExterna.deriveFont(Font.PLAIN, 15));
        lblUsuario.setFont(fonteExterna.deriveFont(Font.PLAIN, 15));
        lblSessao.setFont(fonteExterna.deriveFont(Font.PLAIN, 15));
        lblUsuarioLogado.setFont(fonteExterna.deriveFont(Font.PLAIN, 15));
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fonteExterna);
        this.setFont(fonteExterna);
    }

    private javax.swing.JButton btnMovimentaEstoque;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSobreSistema;
    private javax.swing.JButton btnUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblDataHora;
    private javax.swing.JLabel lblSessao;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuarioLogado;
}