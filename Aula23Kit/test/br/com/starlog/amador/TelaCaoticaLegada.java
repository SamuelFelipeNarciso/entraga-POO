package br.com.starlog.amador;

import br.com.starlog.controller.TransmissaoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TELA CAÓTICA LEGADA (O Monstro que mistura tudo)
 * Esta classe representa o código antigo que acumulava interface, criptografia e regras.
 */
public class TelaCaoticaLegada extends JFrame {

    private JTextField txtRemetente;
    private JTextField txtMensagem;
    private JTextField txtChave;
    private JTextArea txtResultado;
    
    private TransmissaoController controller;

    public TelaCaoticaLegada() {
        super("StarLog-Zero • Terminal Legado (Caótico)");
        this.controller = new TransmissaoController();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel de Formulário
        JPanel painelFormulario = new JPanel(new GridLayout(4, 2, 5, 5));
        painelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        painelFormulario.add(new JLabel("Remetente:"));
        txtRemetente = new JTextField();
        painelFormulario.add(txtRemetente);

        painelFormulario.add(new JLabel("Mensagem:"));
        txtMensagem = new JTextField();
        painelFormulario.add(txtMensagem);

        painelFormulario.add(new JLabel("Chave (1-25):"));
        txtChave = new JTextField();
        painelFormulario.add(txtChave);

        JButton btnDespacharCifrado = new JButton("Despachar Cifrado");
        painelFormulario.add(new JLabel(""));
        painelFormulario.add(btnDespacharCifrado);

        add(painelFormulario, BorderLayout.NORTH);

        // Área de Resultado
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        add(new JScrollPane(txtResultado), BorderLayout.CENTER);

        // O famoso botão monolítico que foi refatorado para o MVC
        btnDespacharCifrado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String remetente = txtRemetente.getText();
                    String mensagem = txtMensagem.getText();
                    String chaveStr = txtChave.getText();

                    // Delegação limpa para o Controller refatorado
                    String pacoteFinal = controller.processarTransmissao(remetente, mensagem, chaveStr);
                    
                    txtResultado.append("Sucesso: " + pacoteFinal + "\n");
                    txtResultado.append("Total de transmissões: " + controller.getTotalTransmissoes() + "\n\n");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(TelaCaoticaLegada.this, 
                            "Erro na transmissão: " + ex.getMessage(), 
                            "Falha Crítica", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaCaoticaLegada().setVisible(true);
        });
    }
}