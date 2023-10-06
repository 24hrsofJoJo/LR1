import java.awt.*;
import java.util.Scanner;

public class MainWindow/*extends Font */{

    private static Frame main_window;
    private static int height;
    private static int width;
    private static Label label;

    public static int getHeight(){
        return height;
    }

    public static int getWidth(){
        return width;
    }

    /**
     * TODO: Переписать для устранения XSS уязвимости
     * @param font
     */
    public static void setFont(Font font){
        label.setFont(font);
        main_window.repaint();
        //System.out.println("!!! "+font.getFontName());
        System.out.println(label.getFont().getFontName());
    }

    public static void set_main_window(){
        main_window = new Frame();
        Scanner sc = new Scanner(System.in);
        System.out.print("Width: ");
        width = sc.nextInt();
        System.out.print("Height: ");
        height = sc.nextInt();
        main_window.setSize(width, height);

        ChooseFontPanel Panel2 = new ChooseFontPanel();
        TextPanel Panel = new TextPanel();
        //System.out.print("Type text: ");
        //String labelText = sc.next();
        label = new Label("123");
        label.setBounds(main_window.getWidth()/2,
                main_window.getHeight()/6*5,
                50,
                25);
        label.setFont(ChooseFontPanel.getFont());
        List[] ListArray = ChooseFontPanel.getFontPanel();
        for (List item: ListArray)
            main_window.add(item);

        TextField t = TextPanel.getTextInputField();

        main_window.add(t);
        main_window.add(label);
        main_window.setLayout(null);
        main_window.setVisible(true);
    }
}
