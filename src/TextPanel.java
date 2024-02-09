import java.awt.*;

class TextPanel extends Panel {

    Scrollbar scVert = new Scrollbar(Scrollbar.VERTICAL,0,10,0,4000);

    public Panel getTextPanel(){
        return this;
    }
    @Override
    public void paint(Graphics g){
        this.setLayout(new BorderLayout());

        super.paint(g);

        scVert.setLocation(10,10);
        this.add(scVert, BorderLayout.WEST);

        Button button = new Button("sjadbfkasd");
        this.add(button, BorderLayout.NORTH);
        g.drawString("Hello",100,100);


    }

}


