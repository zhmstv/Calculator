import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        this.view.addOperationListener(new OperationListener());
    }

    class OperationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double firstNumber = view.getFirstNumber();
                double secondNumber = view.getSecondNumber();
                String result = "";

                if (e.getSource() == view.getAddButton()) {
                    result = String.valueOf(model.add(firstNumber, secondNumber));
                } else if (e.getSource() == view.getSubButton()) {
                    result = String.valueOf(model.subtract(firstNumber, secondNumber));
                } else if (e.getSource() == view.getMulButton()) {
                    result = String.valueOf(model.multiply(firstNumber, secondNumber));
                } else if (e.getSource() == view.getDivButton()) {
                    result = String.valueOf(model.divide(firstNumber, secondNumber));
                }
                
                view.setResult(result);

            } catch (NumberFormatException ex) {
                view.setResult("Ошибка: Введите числовые значения");
            } catch (ArithmeticException ex) {
                view.setResult(ex.getMessage());
            }
        }
    }
}
