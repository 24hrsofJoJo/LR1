import java.awt.*;


class DrawPanel extends Panel {

    public static Color BGColor = Color.CYAN;
    public static Color TextColor = Color.black;
    public static String Text = "Java";
    public static int x = 75;
    public static int y = 30;

    public Panel getDrawPanel(){
        return this;
    }

    public void setActionListeners(){
        List[] array = ChooseFontPanel.getFontLists();
        for (List i: array)
            i.addActionListener(e-> repaint());
        Choice choice = ChooseColorPanel.getColorList();
        choice.addItemListener(e-> repaint());
        Checkbox[] arr = ChooseColorPanel.getCheckBoxes();
        for (Checkbox i: arr)
            i.addItemListener(e-> repaint());
        TextPanel.textField.addActionListener(e-> repaint());
        Scrollbar[] ScArray = TextPanel.getScrollbars();
        for (Scrollbar i: ScArray)
            i.addAdjustmentListener(e-> repaint());
    }
    @Override
    public void paint(Graphics g){
        setActionListeners();
        super.paint(g);
        g.setColor(BGColor);
        g.fillRect(0,0,MainWindow.getWidth(),MainWindow.getHeight()/3);
        g.setColor(TextColor);
        g.setFont(ChooseFontPanel.getFont());
        g.drawString(Text,x,y);
    }
}

class TextPanel{
    private static final Panel panel = new Panel();
    public static TextField textField = new TextField();
    private static Scrollbar scVert;
    private static Scrollbar scHor;

    public static Panel getTextPanel(){
        return panel;
    }

    public static Scrollbar[] getScrollbars(){
        return new Scrollbar[]{scVert,scHor};
    }

    public static void createTextPanel(){
        panel.setLayout(new BorderLayout());

        scVert = new Scrollbar(Scrollbar.VERTICAL,100,0,0,300);
        scHor = new Scrollbar(Scrollbar.HORIZONTAL,0,0,0,600);

        scVert.addAdjustmentListener(e-> DrawPanel.y = scVert.getValue());
        scHor.addAdjustmentListener(e-> DrawPanel.x = scHor.getValue());
        textField.setText("Java");
        textField.addActionListener(e->{
            if (ChooseColorPanel.getChosenCheckbox()==0){
                DrawPanel.Text = textField.getText();
            }
        });

        panel.add(scVert, BorderLayout.WEST);
        panel.add(scHor, BorderLayout.SOUTH);
        panel.add(textField, BorderLayout.NORTH);
        panel.add(new DrawPanel().getDrawPanel(), BorderLayout.CENTER);
    }
}


