import java.awt.*;

class DrawPanel extends Panel {


    public Panel getDrawPanel(){
        return this;
    }
    @Override
    public void paint(Graphics g){

        super.paint(g);

        g.drawString("Hello",100,100);

    }
}

class TextPanel{
    Scrollbar scVert = new Scrollbar(Scrollbar.VERTICAL,0,10,0,4000);
    private Panel panel = new Panel();

    public Panel getThird(){
        return panel;
    }

    public void suka(){
        panel.setLayout(new BorderLayout());

        scVert.setLocation(10,10);

        panel.add(scVert, BorderLayout.WEST);
        Button button = new Button("sjadbfkasd");
        panel.add(button, BorderLayout.NORTH);

        panel.add(new TextPanel().getTextPanel(), BorderLayout.CENTER);
    }
}


