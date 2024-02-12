import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class implements a panel containing components
 * that allow you to customize the text and background color,
 * as well as choose where the text for the TextPanel comes from
 * @see ChooseFontPanel
 * @see TextPanel
 * @see Panel
 */
class ChooseColorPanel {

    private static final Panel chooseColorPanel = new Panel();

    static Panel voidPanel1 = new Panel();
    static Panel voidPanel2 = new Panel();
    static ArrayList<Color> arr = new ArrayList<>();
    static Color[] ColorArray = new Color[13];
    private static Checkbox fromTextPanel;
    private static Checkbox fontName;
    private static Label ColorOf = new Label("Text Color", Label.CENTER);
    private static final Choice ColorList = new Choice();
    private static int choice = 0;
    private static int chosenCheckbox = 0;
    static {

        int i = 0;
        for (Field f : Color.class.getFields()) {
            if (f.getType() == Color.class) {
                Color c;
                try {
                    c = (Color) f.get(null);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (i%2==0) {
                    arr.add(c);
                    ColorList.add(f.toString().substring(50));
                }
                i++;
            }
        }
        for (int j=0; j<arr.size();j++)
            ColorArray[j] = arr.get(j);
        ColorList.select(4);

    }
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
     * @return Panel with buttons and checkboxes that allow you to customize the logic of the ColorList
     * @see #createChooseColorPanel()
     * @see #createColorChoosePanel()
     * @see Panel
     */
    private static Panel createChooseWorkPanel(){

        Button textColor = new Button("Text Color");
        textColor.addActionListener(e -> {
            choice = 0;
            ColorOf.setText("Text Color");
            ArrayList<Color> arr = new ArrayList<>(Arrays.asList(ColorArray));
            ColorList.select(arr.indexOf(DrawPanel.TextColor));
        });

        Button BGColor = new Button("BG Color");
        BGColor.addActionListener(e -> {
            choice = 1;
            ColorOf.setText("BG Color");
            ArrayList<Color> arr = new ArrayList<>(Arrays.asList(ColorArray));
            ColorList.select(arr.indexOf(DrawPanel.BGColor));
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

        Panel buttons = new Panel();
        buttons.setLayout(new GridLayout(2,2));

        buttons.add(textColor);
        buttons.add(BGColor);
        buttons.add(fromTextPanel);
        buttons.add(fontName);

        return buttons;

    }

    /**
     * @return Panel, containing ColorList, that allow you to customize BG and text color
     * @see #createChooseWorkPanel()
     * @see #createChooseColorPanel()
     * @see Panel
     */
    private static Panel createColorChoosePanel(){

        Panel ChooseColorPan = new Panel();
        ChooseColorPan.setLayout(new GridLayout(1,3));

        ColorList.addItemListener(e->{
            if (choice==0)
                DrawPanel.TextColor = ColorArray[ColorList.getSelectedIndex()];
            else
                DrawPanel.BGColor = ColorArray[ColorList.getSelectedIndex()];
        });

        Panel voidPanel = new Panel();

        ColorOf = new Label((choice==0)?"Text Color":"BG Color", Label.CENTER);
        Panel ChooseColor = new Panel();
        ChooseColor.setLayout(new GridLayout(3,1));

        ChooseColor.add(ColorOf);
        ChooseColor.add(ColorList);
        ChooseColor.add(voidPanel);

        ChooseColorPan.add(voidPanel1);
        ChooseColorPan.add(ChooseColor);
        ChooseColorPan.add(voidPanel2);

        return ChooseColorPan;
    }
    public static Panel getChooseColorPanel(){
        return chooseColorPanel;
    }

    /**
     * Method that combines the panels from createChooseWorkPanel() and createColorChoosePanel() into one panel to be added to the MainWindow Frame
     * @see #createChooseWorkPanel()
     * @see #createColorChoosePanel()
     * @see MainWindow
     * @see Panel
     */
    public static void createChooseColorPanel() {
        chooseColorPanel.setLayout(new GridLayout(0,2));

        Panel buttons = createChooseWorkPanel();

        chooseColorPanel.add(buttons);
        chooseColorPanel.add(createColorChoosePanel());
        chooseColorPanel.setBackground(Color.green);
    }
}
