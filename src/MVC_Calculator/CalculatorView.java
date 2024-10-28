import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JTextField firstNumber = new JTextField(10);
    private JTextField secondNumber = new JTextField(10);
    private JTextField resultField = new JTextField(10);

    private JButton addButton = new JButton("+");
    private JButton subButton = new JButton("-");
    private JButton mulButton = new JButton("*");
    private JButton divButton = new JButton("/");

    public CalculatorView() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        
        panel.add(new JLabel("Первое число:"));
        panel.add(firstNumber);
        panel.add(new JLabel("Второе число:"));
        panel.add(secondNumber);
        panel.add(new JLabel("Результат:"));
        panel.add(resultField);
        resultField.setEditable(false);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(addButton);
        buttonsPanel.add(subButton);
        buttonsPanel.add(mulButton);
        buttonsPanel.add(divButton);

        this.add(panel, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public double getFirstNumber() throws NumberFormatException {
        return Double.parseDouble(firstNumber.getText());
    }

    public double getSecondNumber() throws NumberFormatException {
        return Double.parseDouble(secondNumber.getText());
    }

    public void setResult(String result) {
        resultField.setText(result);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubButton() {
        return subButton;
    }

    public JButton getMulButton() {
        return mulButton;
    }

    public JButton getDivButton() {
        return divButton;
    }

    public void addOperationListener(ActionListener listener) {
        addButton.addActionListener(listener);
        subButton.addActionListener(listener);
        mulButton.addActionListener(listener);
        divButton.addActionListener(listener);
    }
}

