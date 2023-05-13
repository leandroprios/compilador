package edu.unnoba.compiladores.compilador_unnoba_2023;

import edu.unnoba.compiladores.compilador_unnoba_2023.exceptions.VarAlreadyExistTSException;
import edu.unnoba.compiladores.compilador_unnoba_2023.exceptions.VarNotDeclaredTSException;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        //Compilador_unnoba_2023.generarLexer();
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        codigo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        analisisResult = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        parserResult = new javax.swing.JTextArea();
        btnExport = new javax.swing.JButton();
        MenuAnalizar = new javax.swing.JMenuBar();
        btnImportar = new javax.swing.JMenu();
        btnAnalizar = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setResizable(false);

        tabs.setName(""); // NOI18N
        tabs.setPreferredSize(new java.awt.Dimension(1024, 768));

        codigo.setColumns(20);
        codigo.setRows(5);
        jScrollPane1.setViewportView(codigo);

        tabs.addTab("Código", jScrollPane1);

        analisisResult.setColumns(20);
        analisisResult.setRows(5);
        jScrollPane2.setViewportView(analisisResult);

        tabs.addTab("Análisis Lexico", jScrollPane2);

        parserResult.setColumns(20);
        parserResult.setRows(5);
        jScrollPane4.setViewportView(parserResult);

        btnExport.setText("Exportar");
        btnExport.setPreferredSize(new java.awt.Dimension(75, 22));
        btnExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(472, 472, 472)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        tabs.addTab("Análisis Sintáctico", jPanel2);

        btnImportar.setText("Importar");
        btnImportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImportarMouseClicked(evt);
            }
        });
        MenuAnalizar.add(btnImportar);

        btnAnalizar.setText("Analizar ");
        btnAnalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnalizarMouseClicked(evt);
            }
        });
        MenuAnalizar.add(btnAnalizar);

        jMenu1.setText("Ayuda");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        MenuAnalizar.add(jMenu1);

        setJMenuBar(MenuAnalizar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        tabs.getAccessibleContext().setAccessibleName("Código");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnInstruccionesMouseClicked(java.awt.event.MouseEvent evt) {


    }
    private void btnAnalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnalizarMouseClicked

        File file = new File("pruebas.txt");
        try {
            PrintWriter escribir = new PrintWriter(file);
            escribir.print(this.codigo.getText());
            escribir.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        String resultLexico = "";
        String resultCup="";
        MiLexicoCup lexico;
        MiParser parser=null;
        try {
            lexico = new MiLexicoCup(new FileReader("pruebas.txt"));
            while (!lexico.yyatEOF()) {
                System.out.println("Analizo: " + lexico.yytext());
                Symbol token;
                token =lexico.next_token();
                if(token!=null && MiParserSym.terminalNames[token.sym]!="EOF"){
                    resultLexico += "Token: " + MiParserSym.terminalNames[token.sym] + "\n";
                }            
            }
            parser= new MiParser(new MiLexicoCup(new FileReader("pruebas.txt")));
            parser.parse();
            String s = parser.getS();
            this.parserResult.selectAll();
            this.parserResult.replaceSelection("");
            if(null==s){
                this.parserResult.setText("Analisis Sintáctico finalizado con éxito\n" +
                        parser.printProduccionesRecorridas(parser.getProduccionesList()).concat(
                        parser.concatHt(parser.getSymbolTable())));
            }
            else
                this.parserResult.setText(s);
            
        } catch (FileNotFoundException ex) {
            resultLexico += "Error: " + ex.getMessage() + "\n";
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            resultLexico += "Error: " + ex.getMessage() + "\n";
        }
        catch (Error e) {
            resultLexico += "Error: " + e.getMessage() + "\n";
            this.analisisResult.setText("Error: " + e.getMessage());
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, e);
        } catch (VarAlreadyExistTSException | VarNotDeclaredTSException ex){
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            this.parserResult.setText(ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        resultLexico += "Analisis lexico terminado.";
        this.analisisResult.setText(resultLexico);
        this.tabs.setSelectedIndex(1);
        parser.printHt(parser.getSymbolTable());

    }//GEN-LAST:event_btnAnalizarMouseClicked

    private void btnImportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportarMouseClicked
        JFileChooser fc = new JFileChooser();

        int section = fc.showOpenDialog(this);

        if (section == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try (FileReader fr = new FileReader(file)) {
                String text = "";
                int valor = fr.read();
                while (valor != -1) {
                    text += (char) valor;
                    valor = fr.read();
                }
                this.codigo.setText(text);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_btnImportarMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        FrmAyuda ayuda = new FrmAyuda();
        ayuda.show(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void btnExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseClicked
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("text files","*.txt", "txt");
        fc.addChoosableFileFilter(filter);
        fc.setFileFilter(filter);
        int section = fc.showOpenDialog(this);

        if (section == JFileChooser.APPROVE_OPTION) {
            File file = new File(fc.getSelectedFile() + ".txt");

            try (PrintWriter pr = new PrintWriter(file)) {
                pr.print(this.parserResult.getText());
                pr.close();
                JDialog d = new JDialog(this, "", false);
                d.setLayout( new FlowLayout() );
                d.setBackground(Color.white);
                d.add( new JLabel (""));
                d.add( new JLabel ("Archivo exportado!"));
                d.add( new JLabel (""));
                d.setSize(200,100);
                d.setVisible(true);
                d.setLocationRelativeTo(null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_btnExportMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuAnalizar;
    private javax.swing.JTextArea analisisResult;
    private javax.swing.JMenu btnAnalizar;
    private javax.swing.JButton btnExport;
    private javax.swing.JMenu btnImportar;
    private javax.swing.JTextArea codigo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea parserResult;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables
}
