import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int a;
        Scanner sc = new Scanner(System.in);
        System.out.print("Width: ");
        int width = sc.nextInt();
        System.out.print("Height: ");
        int height = sc.nextInt();
        MainWindow.setMainWindow(width, height);
    }

}

