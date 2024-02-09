import java.awt.*;

/**
 * This class implements a panel containing components
 * that allow you to customize the text and background color,
 * as well as choose where the text for the TextPanel comes from
 * @see ChooseFontPanel
 * @see TextPanel
 */
class ChooseColorPanel{
    private static final Panel chooseColorPanel = new Panel();
    static Panel voidPanel1 = new Panel();
    static Panel voidPanel2 = new Panel();
    private static final Color[] ColorArray = {Color.black, Color.cyan};
    private static Checkbox fromTextPanel;
    private static Checkbox fontName;
    private static Label ColorOf = new Label("Text Color", Label.CENTER);
    private static Choice ColorList;
    private static int choice = 0;
    private static int chosenCheckbox = 0;

    public static Choice getColorList(){
        return ColorList;
    }

    public static Checkbox[] getCheckBoxes(){
        return new Checkbox[]{fromTextPanel,fontName};
    }

    public static int getChosenCheckbox(){
        return chosenCheckbox;
    }

    /**
     * @return An array containing 2 panels with buttons and checkboxes that allow you to customize the logic of the ColorList
     * @see #createChooseColorPanel()
     * @see #createColorChoosePanel()
     */
    private static Panel[] createChooseWorkPanel(){

        Button textColor = new Button("Text Color");
        textColor.addActionListener(e -> {
            choice = 0;
            ColorOf.setText("Text Color");
        });

        Button BGColor = new Button("BG Color");
        BGColor.addActionListener(e -> {
            choice = 1;
            ColorOf.setText("BG Color");
        });

        CheckboxGroup cbg = new CheckboxGroup();
        fromTextPanel = new Checkbox("From Panel", cbg, true);
        fontName = new Checkbox("Font name", cbg, false);
        fontName.addItemListener(e-> {
            chosenCheckbox = 1;
            DrawPanel.Text = ChooseFontPanel.getFont().getFontName();
        });
        fromTextPanel.addItemListener(e-> {
            chosenCheckbox = 0;
            DrawPanel.Text = TextPanel.textField.getText();
        });

        Panel TextVariant = new Panel();
        TextVariant.setLayout(new GridLayout(2,0));
        TextVariant.add(textColor);
        TextVariant.add(fromTextPanel);

        Panel NamesVariant = new Panel();
        NamesVariant.setLayout(new GridLayout(2, 0));
        NamesVariant.add(BGColor);
        NamesVariant.add(fontName);

        Panel[] arr = new Panel[2];
        arr[0] = TextVariant;
        arr[1] = NamesVariant;
        return arr;
    }

    /**
     * @return Panel, containing ColorList, that allow you to customize BG and text color
     * @see #createChooseWorkPanel()
     * @see #createChooseColorPanel()
     */
    private static Panel createColorChoosePanel(){
        Panel ChooseColor = new Panel();
        ChooseColor.setLayout(new GridLayout(3,0));

        ColorList = new Choice();
        ColorList.add("Black");
        ColorList.add("Cyan");
        ColorList.addItemListener(e->{
            if (choice==0)
                DrawPanel.TextColor = ColorArray[ColorList.getSelectedIndex()];
            else
                DrawPanel.BGColor = ColorArray[ColorList.getSelectedIndex()];
        });

        Panel voidPanel = new Panel();
        ColorOf = new Label((choice==0)?"Text Color":"BG Color", Label.CENTER);
        ChooseColor.add(ColorOf);
        ChooseColor.add(ColorList);
        ChooseColor.add(voidPanel);
        return ChooseColor;
    }
    public static Panel getChooseColorPanel(){
        return chooseColorPanel;
    }

    /**
     * Method that combines the panels from createChooseWorkPanel() and createColorChoosePanel() into one panel to be added to the MainWindow Frame
     * @see #createChooseWorkPanel()
     * @see #createColorChoosePanel()
     * @see MainWindow
     */
    public static void createChooseColorPanel() {

        chooseColorPanel.setLayout(new GridLayout(0,5));

        Panel[] arr = createChooseWorkPanel();
        chooseColorPanel.add(arr[0]);
        chooseColorPanel.add(arr[1]);
        chooseColorPanel.add(voidPanel1);
        chooseColorPanel.add(createColorChoosePanel());
        chooseColorPanel.add(voidPanel2);
        chooseColorPanel.setBackground(Color.green);
    }
}