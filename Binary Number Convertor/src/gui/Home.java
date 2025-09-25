package gui;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Home extends javax.swing.JFrame {

    private final JLabel[] binaryLabels = new JLabel[8];

    public Home() {
        initComponents();
        loadBinaryLabels();
    }

    private void loadBinaryLabels() {
        for (int i = 0; i < 8; i++) {
            binaryLabels[i] = new JLabel("0", SwingConstants.CENTER);
            binaryLabels[i].setOpaque(true);
            binaryLabels[i].setBackground(Color.GRAY);
            binaryLabels[i].setFont(new Font("Arial", Font.BOLD, 16));
            display.add(binaryLabels[i]);
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Execution Error", JOptionPane.ERROR_MESSAGE);
    }

   private void updateBinaryDisplay(String binary) {
    String s = String.format("%8s", binary).replace(' ', '0');
    for (int i = 0; i < 8; i++) {
        char c = s.charAt(i);
        binaryLabels[i].setText(String.valueOf(c));
        binaryLabels[i].setBackground((c == '1') ? Color.GREEN : Color.RED);
        binaryLabels[i].setForeground(Color.BLACK); // set text color to black
    }
}


    private void convert() {
        String input = inputField.getText().trim();
        String format = String.valueOf(formatSelector.getSelectedItem());

        if (format.equalsIgnoreCase("binary")) {
            if (!input.matches("[01]{1,8}")) {
                showError("Enter a Valid Binary Value (Up to 8 bits)");
                return;
            }

            String binary = String.format("%8s", input).replace(' ', '0');
            int decimal;
            if (signedRadio.isSelected()) {
                char c = binary.charAt(0);
                decimal = (c == '1') ? Integer.parseInt(binary, 2) - 256 : Integer.parseInt(binary, 2);
                resultLabel.setText("Signed Value: " + decimal);
            } else {
                decimal = Integer.parseInt(binary, 2);
                resultLabel.setText("Unsigned Decimal: " + decimal);
            }
            updateBinaryDisplay(binary);

        } else if (format.equalsIgnoreCase("decimal")) {

            if (!input.matches("-?\\d+")) {
                showError("Enter a valid decimal Number");
                return;
            }

            try {
                int number = Integer.parseInt(input);
                String binary;

                if (signedRadio.isSelected()) {
                    if (number < -128 || number > 127) {
                        throw new NumberFormatException();
                    }
                    binary = String.format("%8s", Integer.toBinaryString(number & 0xFF)).replace(' ', '0');
                    resultLabel.setText("Signed Binary: " + binary);
                } else {
                    if (number < 0 || number > 255) {
                        throw new NumberFormatException();
                    }
                    binary = String.format("%8s", Integer.toBinaryString(number)).replace(' ', '0');
                    resultLabel.setText("UnSigned Binary: " + binary);
                }

                updateBinaryDisplay(binary);
            } catch (NumberFormatException e) {
                showError("Enter a Valid Decimal Number");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        formatSelector = new javax.swing.JComboBox<>();
        inputField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        unsignedRadio = new javax.swing.JRadioButton();
        signedRadio = new javax.swing.JRadioButton();
        display = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        resultLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter Decimal or Binary Value");

        formatSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Binary", "Decimal" }));

        jButton1.setText("Convert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(unsignedRadio);
        unsignedRadio.setSelected(true);
        unsignedRadio.setText("Unsigned (0-255)");

        buttonGroup1.add(signedRadio);
        signedRadio.setText("Signed (-128 to 127)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(formatSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unsignedRadio))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(signedRadio)))))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formatSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unsignedRadio)
                    .addComponent(signedRadio))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        display.setLayout(new java.awt.GridLayout(1, 8, 2, 2));

        resultLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        resultLabel.setText("Result Label");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resultLabel)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(display, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
convert();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel display;
    private javax.swing.JComboBox<String> formatSelector;
    private javax.swing.JTextField inputField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JRadioButton signedRadio;
    private javax.swing.JRadioButton unsignedRadio;
    // End of variables declaration//GEN-END:variables
}
