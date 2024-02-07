import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ChooseColorPanel{
    private static Panel chooseColorPanel = new Panel();
    private static Button TextColor;
    private static Button BGColor;
    static Panel voidPanel1 = new Panel();
    static Panel voidPanel2 = new Panel();
    private static CheckboxGroup cbg;
    private static Checkbox fromTextPanel;
    private static Checkbox fontName;
    private static Label ColorOf = new Label("Text Color", Label.CENTER);
    private static Choice ColorList;
    private static int choice = 0;
    //TODO: Написать функционал класса ChooseColorPanel

    private static Panel[] createChooseWorkPanel(){
        TextColor = new Button("Text Color");
        TextColor.addActionListener(e -> {
            choice = 0;
            ColorOf.setText("Text Color");
        });
        BGColor = new Button("BG Color");
        BGColor.addActionListener(e -> {
            choice = 1;
            ColorOf.setText("BG Color");
        });
        cbg = new CheckboxGroup();
        fromTextPanel = new Checkbox("From Panel", cbg, true);
        fontName = new Checkbox("Font name", cbg, false);

        Panel TextVariant = new Panel();
        TextVariant.setLayout(new GridLayout(2,0));
        TextVariant.add(TextColor);
        TextVariant.add(fromTextPanel);

        Panel NamesVariant = new Panel();
        NamesVariant.setLayout(new GridLayout(2,0));
        NamesVariant.add(BGColor);
        NamesVariant.add(fontName);
        Panel[] arr = new Panel[2];
        arr[0] = TextVariant;
        arr[1] = NamesVariant;
        return arr;
    }

    private static Panel createColorChoosePanel(){
        Panel ChooseColor = new Panel();
        ChooseColor.setLayout(new GridLayout(3,0));


        ColorList = new Choice();
        ColorList.add("Black");
        ColorList.add("Cyan");
        Panel voidPanel = new Panel();
        System.out.println(choice);
        ColorOf = new Label((choice==0)?"Text Color":"BG Color");
        System.out.println(ColorOf.getText());
        ChooseColor.add(ColorOf);
        ChooseColor.add(ColorList);
        ChooseColor.add(voidPanel);
        return ChooseColor;
    }
    public static Panel getChooseColorPanel(){
        return chooseColorPanel;
    }

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