import java.awt.*;

class TextPanel extends Panel{
    private static Graphics TextPanel;
    private static final TextField TextField = new TextField();
    private static Panel panel = new Panel();
    {

    }
    public static Panel getGraph(){
        return panel;
    }
    public static TextField getTextPanel(){
        return TextField;
    }
    TextPanel(){
        panel.setBackground(Color.black);
        Font font = ChooseFontPanel.getFont();
        setFont(font);
        repaint();
        TextPanel = getGraphics();
        TextField.setSize(MainWindow.getWidth(),
                20
        );
        //TextField.setLocation(10,MainWindow.getHeight()/3*2);
        TextField.addActionListener(e->{
            System.out.println(TextField.getText());
            panel = new Panel();
        });

    }

    public void paint(Graphics g) {
        System.out.println("Got text: "+ TextField.getText());
        g.drawString(TextField.getText(), panel.getWidth()/5, panel.getHeight()/2);
    }
}


