import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TextPanel {
    private static TextField TextInputField;

    public static TextField getTextInputField() {
        return TextInputField;
    }
    TextPanel(){
        TextInputField = new TextField();
        TextInputField.setBounds(10,
                MainWindow.getHeight()/3*2,
                MainWindow.getWidth()-10,
                20);
        TextInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(TextInputField.getText());
            }
        });
    }
}
