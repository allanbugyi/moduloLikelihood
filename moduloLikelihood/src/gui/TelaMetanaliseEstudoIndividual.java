/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import mapeamento.EstudoIndividual;
import mapeamento.MetanaliseEstudoIndividual;
import moduloLikelihoodException.ModuloLikelihoodException;

/**
 *
 * @author allan
 */
public class TelaMetanaliseEstudoIndividual extends javax.swing.JFrame {
    
    private Vector<String> tableHeaders = new Vector<String>();
    private Vector<Object> oneRow = null;
    private Vector tableData = new Vector();
    private JLabel EstudoIndividual_titulo_label = null;

    /**
     * Creates new form TelaMetanaliseEstudoIndividual
     */
    
    public TelaMetanaliseEstudoIndividual() {
        inicializaTela();
        initComponents();
        
        this.MetEstInd_TabelaListagem_table.changeSelection(this.MetEstInd_TabelaListagem_table.getRowCount()-1, 0, true, false);
        this.MetEstInd_TabelaListagem_tableMouseClicked(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EstudoTitulo_label = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MetEstInd_TabelaListagem_table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        MetEstInd_PercentualIntConf_label = new javax.swing.JLabel();
        MetEstInd_PercentualIntConf_text = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        MetEstInd_LKNegativa_label = new javax.swing.JLabel();
        MetEstInd_LKPositiva_label = new javax.swing.JLabel();
        MetEstInd_LKPositiva_text = new javax.swing.JTextField();
        MetEstInd_LKNegativa_text = new javax.swing.JTextField();
        MetEstInd_ErroPadraoLKPositiva_label = new javax.swing.JLabel();
        MetEstInd_ErroPadraoLKPositiva_text = new javax.swing.JTextField();
        MetEstInd_ErroPadraoLKNegativa_label = new javax.swing.JLabel();
        MetEstInd_ErroPadraoLKNegativa_text = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        MetEstInd_IntConfInfLKPositiva_text = new javax.swing.JTextField();
        MetEstInd_IntConfInfLKPositiva_label = new javax.swing.JLabel();
        MetEstInd_IntConfSupLKPositiva_label = new javax.swing.JLabel();
        MetEstInd_IntConfSupLKPositiva_text = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        MetEstInd_IntConfInfLKNegativa_label = new javax.swing.JLabel();
        MetEstInd_IntConfInfLKNegativa_text = new javax.swing.JTextField();
        MetEstInd_IntConfSupLKNegativa_text = new javax.swing.JTextField();
        MetEstInd_IntConfSupLKNegativa_label = new javax.swing.JLabel();
        MetEstInd_PesoMHLKPositiva_label = new javax.swing.JLabel();
        MetEstInd_PesoMHLKPositiva_text = new javax.swing.JTextField();
        MetEstInd_PesoMHLKNegativa_label = new javax.swing.JLabel();
        MetEstInd_PesoMHLKNegativa_text = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        MetEstInd_Sensibilidade_text = new javax.swing.JTextField();
        MetEstInd_Sensibilidade_label = new javax.swing.JLabel();
        MetEstInd_Especificidade_text = new javax.swing.JTextField();
        MetEstInd_Especificidade_label = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Metanálise Estudo Individual");
        setResizable(false);

        EstudoTitulo_label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Estudos Individuais", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        MetEstInd_TabelaListagem_table.setModel(new javax.swing.table.DefaultTableModel(tableData, tableHeaders){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }
    );
    MetEstInd_TabelaListagem_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    MetEstInd_TabelaListagem_table.setShowHorizontalLines(false);
    MetEstInd_TabelaListagem_table.setShowVerticalLines(false);
    MetEstInd_TabelaListagem_table.getTableHeader().setReorderingAllowed(false);
    this.MetEstInd_TabelaListagem_table.getColumnModel().getColumn(2).setPreferredWidth(400);

    this.MetEstInd_TabelaListagem_table.setSelectionMode(NORMAL);
    MetEstInd_TabelaListagem_table.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            MetEstInd_TabelaListagem_tableMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(MetEstInd_TabelaListagem_table);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
            .addContainerGap())
    );

    MetEstInd_PercentualIntConf_label.setText("Intervalo de Confiança");

    MetEstInd_PercentualIntConf_text.setEditable(false);

    jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    MetEstInd_LKNegativa_label.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
    MetEstInd_LKNegativa_label.setText("Likelihood Negativa");

    MetEstInd_LKPositiva_label.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
    MetEstInd_LKPositiva_label.setText("Likelihood Positiva");

    MetEstInd_LKPositiva_text.setEditable(false);

    MetEstInd_LKNegativa_text.setEditable(false);

    MetEstInd_ErroPadraoLKPositiva_label.setText("Erro Padrão");

    MetEstInd_ErroPadraoLKPositiva_text.setEditable(false);

    MetEstInd_ErroPadraoLKNegativa_label.setText("Erro Padrão");

    MetEstInd_ErroPadraoLKNegativa_text.setEditable(false);

    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Intervalos de confiança"));
    jPanel4.setForeground(new java.awt.Color(204, 204, 204));

    MetEstInd_IntConfInfLKPositiva_text.setEditable(false);

    MetEstInd_IntConfInfLKPositiva_label.setText("Inferior");

    MetEstInd_IntConfSupLKPositiva_label.setText("Superior");

    MetEstInd_IntConfSupLKPositiva_text.setEditable(false);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(MetEstInd_IntConfInfLKPositiva_label)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(MetEstInd_IntConfInfLKPositiva_text, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(MetEstInd_IntConfSupLKPositiva_label)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(MetEstInd_IntConfSupLKPositiva_text, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(37, Short.MAX_VALUE))
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(MetEstInd_IntConfInfLKPositiva_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(MetEstInd_IntConfInfLKPositiva_label))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(MetEstInd_IntConfSupLKPositiva_label)
                .addComponent(MetEstInd_IntConfSupLKPositiva_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(50, 50, 50))
    );

    jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Intervalos de Confiança"));

    MetEstInd_IntConfInfLKNegativa_label.setText("Inferior");

    MetEstInd_IntConfInfLKNegativa_text.setEditable(false);

    MetEstInd_IntConfSupLKNegativa_text.setEditable(false);

    MetEstInd_IntConfSupLKNegativa_label.setText("Superior");

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(MetEstInd_IntConfSupLKNegativa_label)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(MetEstInd_IntConfSupLKNegativa_text, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(MetEstInd_IntConfInfLKNegativa_label)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MetEstInd_IntConfInfLKNegativa_text, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel5Layout.setVerticalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(MetEstInd_IntConfInfLKNegativa_label)
                .addComponent(MetEstInd_IntConfInfLKNegativa_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(MetEstInd_IntConfSupLKNegativa_label)
                .addComponent(MetEstInd_IntConfSupLKNegativa_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    MetEstInd_PesoMHLKPositiva_label.setText("Peso Mantel-Hansel");

    MetEstInd_PesoMHLKPositiva_text.setEditable(false);

    MetEstInd_PesoMHLKNegativa_label.setText("Peso Mantel-Hansel");

    MetEstInd_PesoMHLKNegativa_text.setEditable(false);

    jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
    jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(MetEstInd_PesoMHLKPositiva_label)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MetEstInd_LKPositiva_label)
                        .addComponent(MetEstInd_ErroPadraoLKPositiva_label))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MetEstInd_ErroPadraoLKPositiva_text, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MetEstInd_LKPositiva_text, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addComponent(MetEstInd_PesoMHLKPositiva_text, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(15, 15, 15)
            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(MetEstInd_ErroPadraoLKNegativa_label)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MetEstInd_ErroPadraoLKNegativa_text, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(MetEstInd_LKNegativa_label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(MetEstInd_LKNegativa_text, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(MetEstInd_PesoMHLKNegativa_label)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addComponent(MetEstInd_PesoMHLKNegativa_text, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MetEstInd_LKPositiva_label)
                            .addComponent(MetEstInd_LKPositiva_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MetEstInd_LKNegativa_label)
                            .addComponent(MetEstInd_LKNegativa_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MetEstInd_ErroPadraoLKPositiva_label)
                            .addComponent(MetEstInd_ErroPadraoLKPositiva_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MetEstInd_ErroPadraoLKNegativa_label)
                            .addComponent(MetEstInd_ErroPadraoLKNegativa_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(MetEstInd_PesoMHLKPositiva_label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(MetEstInd_PesoMHLKPositiva_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(MetEstInd_PesoMHLKNegativa_label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(MetEstInd_PesoMHLKNegativa_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 24, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jSeparator4)
                    .addContainerGap())))
    );

    jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    MetEstInd_Sensibilidade_text.setEditable(false);

    MetEstInd_Sensibilidade_label.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
    MetEstInd_Sensibilidade_label.setText("Sensibilidade");

    MetEstInd_Especificidade_text.setEditable(false);

    MetEstInd_Especificidade_label.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
    MetEstInd_Especificidade_label.setText("Especificidade");

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                    .addComponent(MetEstInd_Especificidade_label)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(MetEstInd_Especificidade_text, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(MetEstInd_Sensibilidade_label)
                    .addGap(18, 18, 18)
                    .addComponent(MetEstInd_Sensibilidade_text, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel7Layout.setVerticalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(MetEstInd_Sensibilidade_label)
                .addComponent(MetEstInd_Sensibilidade_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(MetEstInd_Especificidade_label)
                .addComponent(MetEstInd_Especificidade_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MetEstInd_PercentualIntConf_label)
                    .addGap(18, 18, 18)
                    .addComponent(MetEstInd_PercentualIntConf_text, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MetEstInd_PercentualIntConf_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MetEstInd_PercentualIntConf_label))
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
    );
    jPanel6Layout.setVerticalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 55, Short.MAX_VALUE)
    );

    jSeparator3.setBackground(new java.awt.Color(240, 240, 240));
    jSeparator3.setForeground(new java.awt.Color(240, 240, 240));
    jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(EstudoTitulo_label)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(EstudoTitulo_label)
                    .addGap(576, 576, 576))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10))))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MetEstInd_TabelaListagem_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MetEstInd_TabelaListagem_tableMouseClicked
        this.limpaTela();
        ArrayList queryResults = null;
        
        if(this.EstudoIndividual_titulo_label == null){
            this.EstudoIndividual_titulo_label = new JLabel();
            this.EstudoIndividual_titulo_label.setFont(new Font("Tahoma", Font.BOLD, 25));
            this.EstudoIndividual_titulo_label.setVisible(true);
            this.jPanel6.setLayout(new FlowLayout());
            this.jPanel6.add(this.EstudoIndividual_titulo_label);
        }
        
        try {
            queryResults = persistencia.CRUD.executaConsulta(String.valueOf(this.MetEstInd_TabelaListagem_table.getValueAt(this.MetEstInd_TabelaListagem_table.getSelectedRow(), 0)), null);
            EstudoIndividual estInd = null;
            if (!queryResults.isEmpty()) estInd = (EstudoIndividual) queryResults.get(0); this.atualizaTela(estInd.getMetanaliseEstudoIndividual(), estInd.getTitulo());
            
            
           // int estInd_titulo_labelLocation = 1219/this.EstudoTitulo_label.getSize().width;
           // this.EstudoTitulo_label.setLocation(1, 1);
        } catch (ModuloLikelihoodException ex) {
            JOptionPane.showMessageDialog(this.rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_MetEstInd_TabelaListagem_tableMouseClicked

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
            java.util.logging.Logger.getLogger(TelaMetanaliseEstudoIndividual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMetanaliseEstudoIndividual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMetanaliseEstudoIndividual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMetanaliseEstudoIndividual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMetanaliseEstudoIndividual().setVisible(true);
            }
        });
    }
    
    private void inicializaTela(){
        this.tableHeaders.add("ID"); 
        this.tableHeaders.add("Título");
        this.tableHeaders.add("Descrição");
        
        for(Object obj : persistencia.CRUD.executaConsulta()){
            EstudoIndividual estInd = (EstudoIndividual) obj;
            this.oneRow = new Vector<Object>();
            this.oneRow.add(estInd.getId());
            this.oneRow.add(estInd.getTitulo());
            this.oneRow.add(estInd.getDescricao());
            this.tableData.add(oneRow);
        }
    }
    
    private void atualizaTela(MetanaliseEstudoIndividual metEstInd, String estInd_titulo){
        this.EstudoIndividual_titulo_label.setText(estInd_titulo);
        
        if(!(metEstInd == null)){
            this.MetEstInd_PercentualIntConf_text.setText(String.valueOf(metEstInd.getPercentualIntervaloConfianca()));
            this.MetEstInd_Sensibilidade_text.setText(String.valueOf(metEstInd.getSensibilidade()));
            this.MetEstInd_Especificidade_text.setText(String.valueOf(metEstInd.getEspecificidade()));
            this.MetEstInd_LKPositiva_text.setText(String.valueOf(metEstInd.getLikelihoodPositiviva()));
            this.MetEstInd_LKNegativa_text.setText(String.valueOf(metEstInd.getLikelihoodNegativa()));
            this.MetEstInd_ErroPadraoLKPositiva_text.setText(String.valueOf(metEstInd.getErroPadraoLkPositiva()));
            this.MetEstInd_ErroPadraoLKNegativa_text.setText(String.valueOf(metEstInd.getErroPadraoLkNegativa()));
            this.MetEstInd_IntConfSupLKPositiva_text.setText(String.valueOf(metEstInd.getIntervaloConfiancaLkpositivoZPositivo()));
            this.MetEstInd_IntConfInfLKPositiva_text.setText(String.valueOf(metEstInd.getIntervaloConfiancaLkpositivaZNegativo()));
            this.MetEstInd_IntConfSupLKNegativa_text.setText(String.valueOf(metEstInd.getIntervaloConfiancaLknegativaZPositivo()));
            this.MetEstInd_IntConfInfLKNegativa_text.setText(String.valueOf(metEstInd.getIntervaloConfiancaLknegativaZPositivo()));
            this.MetEstInd_PesoMHLKPositiva_text.setText(String.valueOf(metEstInd.getPesoMhLkpositiva()));
            this.MetEstInd_PesoMHLKNegativa_text.setText(String.valueOf(metEstInd.getPesoMhLknegativa()));
        }
    }
    
    private void limpaTela(){
            this.MetEstInd_PercentualIntConf_text.setText("");
            this.MetEstInd_Sensibilidade_text.setText("");
            this.MetEstInd_Sensibilidade_text.setText("");
            this.MetEstInd_Especificidade_text.setText("");
            this.MetEstInd_LKPositiva_text.setText("");
            this.MetEstInd_LKNegativa_text.setText("");
            this.MetEstInd_ErroPadraoLKPositiva_text.setText("");
            this.MetEstInd_ErroPadraoLKNegativa_text.setText("");
            this.MetEstInd_IntConfSupLKPositiva_text.setText("");
            this.MetEstInd_IntConfInfLKPositiva_text.setText("");
            this.MetEstInd_IntConfSupLKNegativa_text.setText("");
            this.MetEstInd_IntConfInfLKNegativa_text.setText("");
            this.MetEstInd_PesoMHLKPositiva_text.setText("");
            this.MetEstInd_PesoMHLKNegativa_text.setText("");
    }
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EstudoTitulo_label;
    private javax.swing.JLabel MetEstInd_ErroPadraoLKNegativa_label;
    private javax.swing.JTextField MetEstInd_ErroPadraoLKNegativa_text;
    private javax.swing.JLabel MetEstInd_ErroPadraoLKPositiva_label;
    private javax.swing.JTextField MetEstInd_ErroPadraoLKPositiva_text;
    private javax.swing.JLabel MetEstInd_Especificidade_label;
    private javax.swing.JTextField MetEstInd_Especificidade_text;
    private javax.swing.JLabel MetEstInd_IntConfInfLKNegativa_label;
    private javax.swing.JTextField MetEstInd_IntConfInfLKNegativa_text;
    private javax.swing.JLabel MetEstInd_IntConfInfLKPositiva_label;
    private javax.swing.JTextField MetEstInd_IntConfInfLKPositiva_text;
    private javax.swing.JLabel MetEstInd_IntConfSupLKNegativa_label;
    private javax.swing.JTextField MetEstInd_IntConfSupLKNegativa_text;
    private javax.swing.JLabel MetEstInd_IntConfSupLKPositiva_label;
    private javax.swing.JTextField MetEstInd_IntConfSupLKPositiva_text;
    private javax.swing.JLabel MetEstInd_LKNegativa_label;
    private javax.swing.JTextField MetEstInd_LKNegativa_text;
    private javax.swing.JLabel MetEstInd_LKPositiva_label;
    private javax.swing.JTextField MetEstInd_LKPositiva_text;
    private javax.swing.JLabel MetEstInd_PercentualIntConf_label;
    private javax.swing.JTextField MetEstInd_PercentualIntConf_text;
    private javax.swing.JLabel MetEstInd_PesoMHLKNegativa_label;
    private javax.swing.JTextField MetEstInd_PesoMHLKNegativa_text;
    private javax.swing.JLabel MetEstInd_PesoMHLKPositiva_label;
    private javax.swing.JTextField MetEstInd_PesoMHLKPositiva_text;
    private javax.swing.JLabel MetEstInd_Sensibilidade_label;
    private javax.swing.JTextField MetEstInd_Sensibilidade_text;
    private javax.swing.JTable MetEstInd_TabelaListagem_table;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
