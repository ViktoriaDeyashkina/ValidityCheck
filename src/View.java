import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.regex.Pattern;

public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        initView();
    }

    private JFrame frame = new JFrame("Validity Check");
    private JButton button1 = new JButton("ИНН");
    private JButton button2 = new JButton("СНИЛС");
    private JButton button3 = new JButton("Банковский счет");


    private void initView() {
        frame.setBounds(500, 150, 300, 300);
        frame.setVisible(true);
        Box box = Box.createVerticalBox();
        box.add(button1);
        box.add(button2);
        box.add(button3);
        frame.getContentPane().add(box);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.checkTaxNumber();

            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.checkInsuaranceNumber();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.checkCountNumber();
            }
        });
    }

    public String getTaxNumber (){
        while (true) {
            String taxNumber = JOptionPane.showInputDialog(
                    new JFrame("Tax Number"),
                    "Введите ИНН").trim();
            if (Pattern.matches("^[0-9]{12}$", taxNumber))
                return taxNumber;
            else {
                JOptionPane.showMessageDialog(
                        new JFrame("Tax Number"),
                        "Был введен некорректный ИНН. Попробуйте еще раз.",
                        "Info",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String getInsuaranceNumber () throws ParseException {
       while (true) {
            String insuaranceNumber = JOptionPane.showInputDialog(
                    new JFrame("Insuarance Number"),
                    "Введите СНИЛС").trim();
            if (Pattern.matches("^([0-9]{3})(?:-| )([0-9]{3})(?:-| )([0-9]{3})(?:-| )([0-9]{2})$", insuaranceNumber))
                return insuaranceNumber;
            else {
                JOptionPane.showMessageDialog(
                        new JFrame("Insuarance Number"),
                        "Был введен некорректный СНИЛС. Попробуйте еще раз.",
                        "Info",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String getBICNumber (){
        while (true) {
            String bicNumber = JOptionPane.showInputDialog(
                    new JFrame("BIC Number"),
                    "Введите БИК банка").trim();
                if (Pattern.matches("^[0-9]{9}$", bicNumber))
                return bicNumber;
            else {
                JOptionPane.showMessageDialog(
                        new JFrame("BIC Number"),
                        "Был введен некорректный БИК банка. Попробуйте еще раз.",
                        "Info",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String getCountNumber (){
        while (true){
            String countNumber = JOptionPane.showInputDialog(
                    new JFrame("Count Number"),
                    "Введите номер счета").trim();
            if (Pattern.matches("^[0-9]{20}$", countNumber)){
                return countNumber;
            } else {
                JOptionPane.showMessageDialog(
                        new JFrame("Count Number"),
                        "Был введен некорректный номер счета. Попробуйте еще раз.",
                        "Info",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    public void notifyChecking (boolean checking){
        if (checking){
            JOptionPane.showMessageDialog(
                    new JFrame("Result"),
                    "Right",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    new JFrame("Result"),
                    "Wrong",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}



