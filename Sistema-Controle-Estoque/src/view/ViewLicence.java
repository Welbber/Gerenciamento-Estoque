package view;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;


public class ViewLicence extends javax.swing.JFrame {

    public ViewLicence() {
        initComponents();
    }

    private void initComponents() {

        javax.swing.JPanel conteinerAgrupaComponentes = new javax.swing.JPanel();
        javax.swing.JLabel lblHeaderMensage = new javax.swing.JLabel();
        javax.swing.JButton abrirLinkLicenca = new javax.swing.JButton();
        javax.swing.JButton btnJaConheceLicenca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        lblHeaderMensage.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 14)); // NOI18N
        lblHeaderMensage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeaderMensage.setText("LICENÇA PUBLICA GERAL - GNU");

        abrirLinkLicenca.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/imagens_icones/iconfinder_licence_49373.png")))); // NOI18N
        abrirLinkLicenca.setText("Abrir Licença");
        abrirLinkLicenca.setPreferredSize(new java.awt.Dimension(93, 32));
        abrirLinkLicenca.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abrirLinkLicencaMouseEntered(evt);
            }
        });
        abrirLinkLicenca.addActionListener(this::abrirLinkLicencaActionPerformed);

        btnJaConheceLicenca.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/imagens_icones/iconfinder_check-mark-80px_510930.png")))); // NOI18N
        btnJaConheceLicenca.setText("Ja Conheço");
        btnJaConheceLicenca.setPreferredSize(new java.awt.Dimension(89, 32));
        btnJaConheceLicenca.addActionListener(this::btnJaConheceLicencaActionPerformed);

        javax.swing.GroupLayout conteinerAgrupaComponentesLayout = new javax.swing.GroupLayout(conteinerAgrupaComponentes);
        conteinerAgrupaComponentes.setLayout(conteinerAgrupaComponentesLayout);
        conteinerAgrupaComponentesLayout.setHorizontalGroup(
            conteinerAgrupaComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteinerAgrupaComponentesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(conteinerAgrupaComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeaderMensage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(conteinerAgrupaComponentesLayout.createSequentialGroup()
                        .addComponent(btnJaConheceLicenca, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(abrirLinkLicenca, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))
                .addContainerGap())
        );
        conteinerAgrupaComponentesLayout.setVerticalGroup(
            conteinerAgrupaComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteinerAgrupaComponentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeaderMensage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(conteinerAgrupaComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abrirLinkLicenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJaConheceLicenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(conteinerAgrupaComponentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(conteinerAgrupaComponentes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(296, 100));
        setLocationRelativeTo(null);
    }

    private void btnJaConheceLicencaActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void abrirLinkLicencaMouseEntered(java.awt.event.MouseEvent evt) {
    }

    private void abrirLinkLicencaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
              URI link = new URI("https://www.gnu.org/licenses/gpl-3.0.pt-br.html");  
             try {
                 Desktop.getDesktop().browse(link);
            } catch (IOException e) {
                    System.out.println("Erro ao abrir navegador" + e);
            }    
        } catch (URISyntaxException e) {
               System.out.println("ERRO AO ABRIR LINK " + e);
        }
    }
}
