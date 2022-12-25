package view;

import controller.ControllerTblEstoque;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import model.ModelEstoque;
import model.ModelProduto;
import model.ModelUsuario;

public class ViewPrincipalResponsiva extends javax.swing.JFrame {

    private boolean controleMostraOcultaPainel;
    private Font fonteExterna;
    private ModelUsuario usuarioLogado;
    private DefaultTableModel tabelaModeloPadrao;
    private ControllerTblEstoque controlaEstoque;
    private ArrayList<ModelEstoque> listaEstoques;
    private ModelProduto produto;
    private ModelUsuario userMovimentacao;


    public ViewPrincipalResponsiva(ModelUsuario pUsuarioLogado) {
        initComponents();
        setFontExterna();
        this.usuarioLogado = pUsuarioLogado;
        carregaMovimentacoesTabela();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        conteinerCabecalho = new javax.swing.JPanel();
        conteinerRedimensionamentoIcons = new javax.swing.JPanel();
        conteinerButtonFechar = new javax.swing.JPanel();
        iconeFecharJanela = new javax.swing.JLabel();
        conteinerBotaoMinimizar = new javax.swing.JPanel();
        iconeMinimizarJanela = new javax.swing.JLabel();
        conteinerButtonMaximizar = new javax.swing.JPanel();
        iconeMaximizarJanela = new javax.swing.JLabel();
        lblTituloCabecalho = new javax.swing.JLabel();
        conteinerMenuEsquerdo = new javax.swing.JPanel();
        conteinerMenuIcone = new javax.swing.JPanel();
        linhaDivisaoAcimaMenuBurger = new javax.swing.JPanel();
        conteinerMenuHamburguerIcon = new javax.swing.JPanel();
        iconMenuHanburguer = new javax.swing.JLabel();
        linhaDivisaoAcimaMenuEngrenagem = new javax.swing.JPanel();
        conteinerEngrenagemIcon = new javax.swing.JPanel();
        iconeMenuEngrenagem = new javax.swing.JLabel();
        conteinerPainelControle = new javax.swing.JPanel();
        conteinerBotao01 = new javax.swing.JPanel();
        botaoUsuariosSistema = new javax.swing.JButton();
        conteinerBotao02 = new javax.swing.JPanel();
        botaoProdutosSistema = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        conteinerBotao03 = new javax.swing.JPanel();
        botaoEstoqueSistema = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        conteinerBotao04 = new javax.swing.JPanel();
        botaoSobreSistema = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        conteinerBotao05 = new javax.swing.JPanel();
        botaoLicencaSistemaVersionInformation = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        conteinerConteudo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMostraMovimentacoes = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        conteinerCabecalho.setBackground(new java.awt.Color(15, 19, 52));
        conteinerCabecalho.setLayout(new java.awt.BorderLayout());

        conteinerRedimensionamentoIcons.setBackground(new java.awt.Color(5, 10, 46));
        conteinerRedimensionamentoIcons.setPreferredSize(new java.awt.Dimension(150, 100));
        conteinerRedimensionamentoIcons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        conteinerButtonFechar.setBackground(new java.awt.Color(5, 10, 46));
        conteinerButtonFechar.setLayout(new java.awt.BorderLayout());

        iconeFecharJanela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconeFecharJanela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/close.png")));
        iconeFecharJanela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconeFecharJanelaMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iconeFecharJanelaMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                iconeFecharJanelaMouseExited(evt);
            }
        });
        conteinerButtonFechar.add(iconeFecharJanela, java.awt.BorderLayout.CENTER);

        conteinerRedimensionamentoIcons.add(conteinerButtonFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 50, 100));

        conteinerBotaoMinimizar.setBackground(new java.awt.Color(5, 10, 46));
        conteinerBotaoMinimizar.setLayout(new java.awt.BorderLayout());

        iconeMinimizarJanela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconeMinimizarJanela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/minimize.png")));
        conteinerBotaoMinimizar.add(iconeMinimizarJanela, java.awt.BorderLayout.CENTER);

        conteinerRedimensionamentoIcons.add(conteinerBotaoMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 100));

        conteinerButtonMaximizar.setBackground(new java.awt.Color(5, 10, 46));
        conteinerButtonMaximizar.setLayout(new java.awt.BorderLayout());

        iconeMaximizarJanela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconeMaximizarJanela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/maximize.png")));
        iconeMaximizarJanela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconeMaximizarJanelaMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iconeMaximizarJanelaMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                iconeMaximizarJanelaMouseExited(evt);
            }
        });
        conteinerButtonMaximizar.add(iconeMaximizarJanela, java.awt.BorderLayout.CENTER);

        conteinerRedimensionamentoIcons.add(conteinerButtonMaximizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 50, 100));

        conteinerCabecalho.add(conteinerRedimensionamentoIcons, java.awt.BorderLayout.LINE_END);

        lblTituloCabecalho.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloCabecalho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloCabecalho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/iconfinder_customer-satisfaction-system-review-evaluation_3709746.png")));
        lblTituloCabecalho.setText("GERENCIADOR ESTOQUE VERSION 1.0");
        conteinerCabecalho.add(lblTituloCabecalho, java.awt.BorderLayout.CENTER);

        getContentPane().add(conteinerCabecalho, java.awt.BorderLayout.PAGE_START);

        conteinerMenuEsquerdo.setPreferredSize(new java.awt.Dimension(270, 450));
        conteinerMenuEsquerdo.setLayout(new java.awt.BorderLayout());

        conteinerMenuIcone.setBackground(new java.awt.Color(15, 19, 52));
        conteinerMenuIcone.setPreferredSize(new java.awt.Dimension(50, 450));
        conteinerMenuIcone.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        linhaDivisaoAcimaMenuBurger.setBackground(new java.awt.Color(5, 10, 46));
        linhaDivisaoAcimaMenuBurger.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout linhaDivisaoAcimaMenuBurgerLayout = new javax.swing.GroupLayout(linhaDivisaoAcimaMenuBurger);
        linhaDivisaoAcimaMenuBurger.setLayout(linhaDivisaoAcimaMenuBurgerLayout);
        linhaDivisaoAcimaMenuBurgerLayout.setHorizontalGroup(
                linhaDivisaoAcimaMenuBurgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );
        linhaDivisaoAcimaMenuBurgerLayout.setVerticalGroup(
                linhaDivisaoAcimaMenuBurgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 10, Short.MAX_VALUE)
        );

        conteinerMenuIcone.add(linhaDivisaoAcimaMenuBurger, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 10));

        conteinerMenuHamburguerIcon.setBackground(new java.awt.Color(5, 10, 46));
        conteinerMenuHamburguerIcon.setLayout(new java.awt.BorderLayout());

        iconMenuHanburguer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconMenuHanburguer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/burguer-menu.png")));
        iconMenuHanburguer.setToolTipText("MENU");
        iconMenuHanburguer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconMenuHanburguerMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iconMenuHanburguerMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                iconMenuHanburguerMouseExited(evt);
            }
        });
        conteinerMenuHamburguerIcon.add(iconMenuHanburguer, java.awt.BorderLayout.CENTER);

        conteinerMenuIcone.add(conteinerMenuHamburguerIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 50));

        linhaDivisaoAcimaMenuEngrenagem.setBackground(new java.awt.Color(5, 10, 46));
        linhaDivisaoAcimaMenuEngrenagem.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout linhaDivisaoAcimaMenuEngrenagemLayout = new javax.swing.GroupLayout(linhaDivisaoAcimaMenuEngrenagem);
        linhaDivisaoAcimaMenuEngrenagem.setLayout(linhaDivisaoAcimaMenuEngrenagemLayout);
        linhaDivisaoAcimaMenuEngrenagemLayout.setHorizontalGroup(
                linhaDivisaoAcimaMenuEngrenagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );
        linhaDivisaoAcimaMenuEngrenagemLayout.setVerticalGroup(
                linhaDivisaoAcimaMenuEngrenagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 10, Short.MAX_VALUE)
        );

        conteinerMenuIcone.add(linhaDivisaoAcimaMenuEngrenagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 50, 10));

        conteinerEngrenagemIcon.setBackground(new java.awt.Color(5, 10, 46));
        conteinerEngrenagemIcon.setLayout(new java.awt.BorderLayout());

        iconeMenuEngrenagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconeMenuEngrenagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/icones/engrenagem (1).png")));
        iconeMenuEngrenagem.setToolTipText("CONFIGURAÇÕES");
        iconeMenuEngrenagem.setPreferredSize(new java.awt.Dimension(50, 50));
        iconeMenuEngrenagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconeMenuEngrenagemMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iconeMenuEngrenagemMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                iconeMenuEngrenagemMouseExited(evt);
            }
        });
        conteinerEngrenagemIcon.add(iconeMenuEngrenagem, java.awt.BorderLayout.CENTER);

        conteinerMenuIcone.add(conteinerEngrenagemIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 50, 50));

        conteinerMenuEsquerdo.add(conteinerMenuIcone, java.awt.BorderLayout.LINE_START);

        conteinerPainelControle.setBackground(new java.awt.Color(25, 29, 74));
        conteinerPainelControle.setPreferredSize(new java.awt.Dimension(150, 400));

        conteinerBotao01.setBackground(new java.awt.Color(15, 19, 52));
        conteinerBotao01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                conteinerBotao01MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                conteinerBotao01MouseExited(evt);
            }
        });

        botaoUsuariosSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/user-btn-1.png")));
        botaoUsuariosSistema.setToolTipText("GERENCIAR USUARIOS SISTEMA");
        botaoUsuariosSistema.setPreferredSize(new java.awt.Dimension(32, 32));
        botaoUsuariosSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoUsuariosSistemaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout conteinerBotao01Layout = new javax.swing.GroupLayout(conteinerBotao01);
        conteinerBotao01.setLayout(conteinerBotao01Layout);
        conteinerBotao01Layout.setHorizontalGroup(
                conteinerBotao01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(conteinerBotao01Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoUsuariosSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        conteinerBotao01Layout.setVerticalGroup(
                conteinerBotao01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteinerBotao01Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botaoUsuariosSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        conteinerBotao02.setBackground(new java.awt.Color(15, 19, 52));

        botaoProdutosSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/icone-produto-btn-2.png")));
        botaoProdutosSistema.setToolTipText("GERENCIAR PRODUTOS ESTOQUE");
        botaoProdutosSistema.setPreferredSize(new java.awt.Dimension(32, 32));
        botaoProdutosSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoProdutosSistemaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout conteinerBotao02Layout = new javax.swing.GroupLayout(conteinerBotao02);
        conteinerBotao02.setLayout(conteinerBotao02Layout);
        conteinerBotao02Layout.setHorizontalGroup(
                conteinerBotao02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(conteinerBotao02Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoProdutosSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        conteinerBotao02Layout.setVerticalGroup(
                conteinerBotao02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteinerBotao02Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botaoProdutosSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        conteinerBotao03.setBackground(new java.awt.Color(15, 19, 52));

        botaoEstoqueSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/icone-estoque-btn-3.png")));
        botaoEstoqueSistema.setToolTipText("GERENCIAR ESTOQUE");
        botaoEstoqueSistema.setPreferredSize(new java.awt.Dimension(32, 32));
        botaoEstoqueSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEstoqueSistemaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout conteinerBotao03Layout = new javax.swing.GroupLayout(conteinerBotao03);
        conteinerBotao03.setLayout(conteinerBotao03Layout);
        conteinerBotao03Layout.setHorizontalGroup(
                conteinerBotao03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteinerBotao03Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoEstoqueSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        conteinerBotao03Layout.setVerticalGroup(
                conteinerBotao03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteinerBotao03Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botaoEstoqueSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        conteinerBotao04.setBackground(new java.awt.Color(15, 19, 52));

        botaoSobreSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/about-btn-04.png")));
        botaoSobreSistema.setToolTipText("SABER MAIS SOBRE SISTEMA");
        botaoSobreSistema.setPreferredSize(new java.awt.Dimension(32, 32));

        javax.swing.GroupLayout conteinerBotao04Layout = new javax.swing.GroupLayout(conteinerBotao04);
        conteinerBotao04.setLayout(conteinerBotao04Layout);
        conteinerBotao04Layout.setHorizontalGroup(
                conteinerBotao04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteinerBotao04Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoSobreSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        conteinerBotao04Layout.setVerticalGroup(
                conteinerBotao04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botaoSobreSistema, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        conteinerBotao05.setBackground(new java.awt.Color(15, 19, 52));

        botaoLicencaSistemaVersionInformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_icones/iconfinder_gnu_4691330.png")));
        botaoLicencaSistemaVersionInformation.setToolTipText("LICENÇA USADA");
        botaoLicencaSistemaVersionInformation.setPreferredSize(new java.awt.Dimension(32, 32));
        botaoLicencaSistemaVersionInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLicencaSistemaVersionInformationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout conteinerBotao05Layout = new javax.swing.GroupLayout(conteinerBotao05);
        conteinerBotao05.setLayout(conteinerBotao05Layout);
        conteinerBotao05Layout.setHorizontalGroup(
                conteinerBotao05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteinerBotao05Layout.createSequentialGroup()
                                .addContainerGap(94, Short.MAX_VALUE)
                                .addComponent(botaoLicencaSistemaVersionInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(94, Short.MAX_VALUE))
        );
        conteinerBotao05Layout.setVerticalGroup(
                conteinerBotao05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botaoLicencaSistemaVersionInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout conteinerPainelControleLayout = new javax.swing.GroupLayout(conteinerPainelControle);
        conteinerPainelControle.setLayout(conteinerPainelControleLayout);
        conteinerPainelControleLayout.setHorizontalGroup(
                conteinerPainelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(conteinerBotao05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(conteinerBotao04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator4)
                        .addComponent(jSeparator3)
                        .addComponent(conteinerBotao03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(conteinerBotao02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2)
                        .addComponent(conteinerBotao01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1)
        );
        conteinerPainelControleLayout.setVerticalGroup(
                conteinerPainelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(conteinerPainelControleLayout.createSequentialGroup()
                                .addComponent(conteinerBotao01, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conteinerBotao02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(conteinerBotao03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(conteinerBotao04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(conteinerBotao05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(154, 154, 154))
        );

        conteinerMenuEsquerdo.add(conteinerPainelControle, java.awt.BorderLayout.CENTER);

        getContentPane().add(conteinerMenuEsquerdo, java.awt.BorderLayout.LINE_START);

        conteinerConteudo.setBackground(new java.awt.Color(73, 128, 242));

        tabelaMostraMovimentacoes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String[]{
                        "Operação", "Produto", "Quantidade", "Usúario", "Preço ", "Data"
                }
        ));
        jScrollPane1.setViewportView(tabelaMostraMovimentacoes);

        javax.swing.GroupLayout conteinerConteudoLayout = new javax.swing.GroupLayout(conteinerConteudo);
        conteinerConteudo.setLayout(conteinerConteudoLayout);
        conteinerConteudoLayout.setHorizontalGroup(
                conteinerConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );
        conteinerConteudoLayout.setVerticalGroup(
                conteinerConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        getContentPane().add(conteinerConteudo, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(800, 500));
        setLocationRelativeTo(null);
    }


    private void iconeFecharJanelaMouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    public void mudarCor(JPanel conteiner, Color novaCor) {
        conteiner.setBackground(novaCor);
    }

    private void iconeFecharJanelaMouseEntered(java.awt.event.MouseEvent evt) {
        mudarCor(conteinerButtonFechar, new Color(25, 29, 74));
    }

    private void iconeFecharJanelaMouseExited(java.awt.event.MouseEvent evt) {
        mudarCor(conteinerButtonFechar, new Color(5, 10, 46));
    }

    private void iconeMaximizarJanelaMouseEntered(java.awt.event.MouseEvent evt) {
        mudarCor(conteinerButtonMaximizar, new Color(25, 29, 74));
    }

    private void iconeMaximizarJanelaMouseExited(java.awt.event.MouseEvent evt) {
        mudarCor(conteinerButtonMaximizar, new Color(5, 10, 46));
    }

    private void iconeMaximizarJanelaMouseClicked(java.awt.event.MouseEvent evt) {
        if (this.getExtendedState() != ViewPrincipalResponsiva.MAXIMIZED_BOTH) {
            this.setExtendedState(ViewPrincipalResponsiva.MAXIMIZED_BOTH);
        } else {
            this.setExtendedState(ViewPrincipalResponsiva.NORMAL);
        }
    }

    private void iconMenuHanburguerMouseClicked(java.awt.event.MouseEvent evt) {
        clicouMenu(conteinerMenuHamburguerIcon, conteinerEngrenagemIcon, 1);
    }

    private void iconMenuHanburguerMouseEntered(java.awt.event.MouseEvent evt) {
        mudarCor(linhaDivisaoAcimaMenuBurger, new Color(247, 78, 105));
    }

    private void iconMenuHanburguerMouseExited(java.awt.event.MouseEvent evt) {
        mudarCor(linhaDivisaoAcimaMenuBurger, new Color(247, 78, 105));
        if (controleMostraOcultaPainel) {
            ocultarMostrarMenu(conteinerMenuEsquerdo, controleMostraOcultaPainel);
            SwingUtilities.updateComponentTreeUI(this);
            controleMostraOcultaPainel = false;
        } else {
            ocultarMostrarMenu(conteinerMenuEsquerdo, controleMostraOcultaPainel);
            SwingUtilities.updateComponentTreeUI(this);
            controleMostraOcultaPainel = true;
        }
    }

    private void iconeMenuEngrenagemMouseEntered(java.awt.event.MouseEvent evt) {
        mudarCor(linhaDivisaoAcimaMenuEngrenagem, new Color(8, 177, 150));
    }

    private void iconeMenuEngrenagemMouseExited(java.awt.event.MouseEvent evt) {
        mudarCor(linhaDivisaoAcimaMenuEngrenagem, new Color(8, 177, 150));
    }

    private void iconeMenuEngrenagemMouseClicked(java.awt.event.MouseEvent evt) {
        clicouMenu(conteinerEngrenagemIcon, conteinerMenuHamburguerIcon, 1);
    }

    private void botaoEstoqueSistemaActionPerformed(java.awt.event.ActionEvent evt) {
        ViewEstoque gerenciarEstoque = new ViewEstoque(this.usuarioLogado);
        gerenciarEstoque.setVisible(true);
        dispose();
    }

    private void conteinerBotao01MouseExited(java.awt.event.MouseEvent evt) {
    }

    private void conteinerBotao01MouseEntered(java.awt.event.MouseEvent evt) {
    }

    private void botaoUsuariosSistemaActionPerformed(java.awt.event.ActionEvent evt) {
        ViewUsuario gerenciarUsuario = new ViewUsuario(this.usuarioLogado);
        gerenciarUsuario.setVisible(true);
        dispose();
    }

    private void botaoProdutosSistemaActionPerformed(java.awt.event.ActionEvent evt) {
        ViewProduto gerenciarProduto = new ViewProduto(this.usuarioLogado);
        gerenciarProduto.setVisible(true);
        dispose();
    }

    private void botaoLicencaSistemaVersionInformationActionPerformed(java.awt.event.ActionEvent evt) {
        ViewLicence l = new ViewLicence();
        l.setVisible(true);
    }


    public void clicouMenu(JPanel conteiner1, JPanel conteiner2, int numeroLogico) {
        if (numeroLogico == 1) {
            conteiner1.setBackground(new Color(25, 29, 74));
            conteiner2.setBackground(new Color(5, 10, 46));
        } else {
            conteiner1.setBackground(new Color(5, 10, 46));
            conteiner2.setBackground(new Color(25, 29, 74));
        }
    }

    public void ocultarMostrarMenu(JPanel conteinerMenuMostraOculta, boolean painelControle) {
        if (painelControle) {
            conteinerMenuMostraOculta.setPreferredSize(new Dimension(50, conteinerMenuMostraOculta.getHeight()));
        } else {
            conteinerMenuMostraOculta.setPreferredSize(new Dimension(270, conteinerMenuMostraOculta.getHeight()));
        }
    }

    private void setFontExterna() {
        try {
            fonteExterna = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("fontes_externas/Gayathri-Regular.ttf")));
        } catch (IOException | FontFormatException e) {
            System.out.println("Não carregou as fonte externa padrão da tela principal! " + e);
        }
        lblTituloCabecalho.setFont(fonteExterna.deriveFont(Font.PLAIN, 20));
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fonteExterna);
        this.setFont(fonteExterna);
    }

    private void carregaMovimentacoesTabela() {
        this.tabelaModeloPadrao = (DefaultTableModel) this.tabelaMostraMovimentacoes.getModel();
        this.tabelaModeloPadrao.setNumRows(0);
        this.controlaEstoque = new ControllerTblEstoque();
        this.listaEstoques = new ArrayList<>();
        this.listaEstoques = (ArrayList<ModelEstoque>) this.controlaEstoque.controllerGetEstoques();
        if (this.listaEstoques.isEmpty()) {
            this.tabelaModeloPadrao.setNumRows(0);
        } else {
            this.controlaEstoque = new ControllerTblEstoque();
            for (int indice = 0; indice < listaEstoques.size(); indice++) {
                ModelEstoque itemEstoque = listaEstoques.get(indice);
                this.produto = new ModelProduto();
                this.produto = this.controlaEstoque.controlerGetDetalhesProduto(itemEstoque.getFk_produto());
                this.userMovimentacao = new ModelUsuario();
                this.userMovimentacao = this.controlaEstoque.controlerGetUsuario(itemEstoque.getFk_usuario());
                if (this.produto == null || this.userMovimentacao == null) {
                    this.tabelaModeloPadrao.addRow(new Object[]{
                            (itemEstoque.getTipo_movimentacao() == 0) ? "ENTRADA" : "SAIDA",
                            "PRODUTO NÃO CADASTRADO",
                            itemEstoque.getQuantidade(),
                            "USUARIO NÃO CADASTRADO",
                            itemEstoque.getPreco(),
                            itemEstoque.getDataMovimentacao()
                    });
                } else {
                    this.tabelaModeloPadrao.addRow(new Object[]{
                            (itemEstoque.getTipo_movimentacao() == 0) ? "ENTRADA" : "SAIDA",
                            this.produto.getDescricaoProduto(),
                            itemEstoque.getQuantidade(),
                            this.userMovimentacao.getNome(),
                            itemEstoque.getPreco(),
                            itemEstoque.getDataMovimentacao()
                    });
                }


            }
        }
    }

    private javax.swing.JButton botaoEstoqueSistema;
    private javax.swing.JButton botaoLicencaSistemaVersionInformation;
    private javax.swing.JButton botaoProdutosSistema;
    private javax.swing.JButton botaoSobreSistema;
    private javax.swing.JButton botaoUsuariosSistema;
    private javax.swing.JPanel conteinerBotao01;
    private javax.swing.JPanel conteinerBotao02;
    private javax.swing.JPanel conteinerBotao03;
    private javax.swing.JPanel conteinerBotao04;
    private javax.swing.JPanel conteinerBotao05;
    private javax.swing.JPanel conteinerBotaoMinimizar;
    private javax.swing.JPanel conteinerButtonFechar;
    private javax.swing.JPanel conteinerButtonMaximizar;
    private javax.swing.JPanel conteinerCabecalho;
    private javax.swing.JPanel conteinerConteudo;
    private javax.swing.JPanel conteinerEngrenagemIcon;
    private javax.swing.JPanel conteinerMenuEsquerdo;
    private javax.swing.JPanel conteinerMenuHamburguerIcon;
    private javax.swing.JPanel conteinerMenuIcone;
    private javax.swing.JPanel conteinerPainelControle;
    private javax.swing.JPanel conteinerRedimensionamentoIcons;
    private javax.swing.JLabel iconMenuHanburguer;
    private javax.swing.JLabel iconeFecharJanela;
    private javax.swing.JLabel iconeMaximizarJanela;
    private javax.swing.JLabel iconeMenuEngrenagem;
    private javax.swing.JLabel iconeMinimizarJanela;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblTituloCabecalho;
    private javax.swing.JPanel linhaDivisaoAcimaMenuBurger;
    private javax.swing.JPanel linhaDivisaoAcimaMenuEngrenagem;
    private javax.swing.JTable tabelaMostraMovimentacoes;
}