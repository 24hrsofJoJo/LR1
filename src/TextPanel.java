import java.awt.*;

class DrawPanel extends Panel {

    public static Color a = Color.cyan;

    public Panel getDrawPanel(){
        return this;
    }

    public void setActionListeners(){
        List[] array = ChooseFontPanel.getFontLists();
        array[0].addActionListener(e->{
            a = Color.magenta;
            repaint();
        });
    }
    @Override
    public void paint(Graphics g){
        setActionListeners();
        super.paint(g);
        g.setColor(a);
        g.fillRect(0,0,400,133);
        g.setColor(Color.black);
        g.drawString("Hello",75,30);

    }
}

class TextPanel{
    private Panel panel = new Panel();

    public Panel getThird(){
        return panel;
    }

    public void setTextPanel(){
        panel.setLayout(new BorderLayout());

        Scrollbar scVert = new Scrollbar(Scrollbar.VERTICAL,1000,0,0,2000);
        Scrollbar scHor = new Scrollbar(Scrollbar.HORIZONTAL,1000,0,0,2000);

        TextField textField = new TextField();
        textField.setText("Java");


        panel.add(scVert, BorderLayout.WEST);
        panel.add(scHor, BorderLayout.SOUTH);
        panel.add(textField, BorderLayout.NORTH);
        panel.add(new DrawPanel().getDrawPanel(), BorderLayout.CENTER);
    }
}


