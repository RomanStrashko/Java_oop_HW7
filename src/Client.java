
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("localhost", 1234)) {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            View view = new View();
            File file = new File("Test");
            PrintWriter pw = new PrintWriter(file);
            Presenter presenter = new Presenter();

            while (true) {
                presenter.printing("Вас приветствует калькулятор! \n" + "------------------------");
                presenter.printing("Введите первое вещественное число: ");
                String request = scanner.nextLine();
                dataOutputStream.writeUTF(request);
                if (request.equals("off")){
                    presenter.printing("До новых встреч!");
                    break;
                }
                presenter.printing("Получили сообщение от сервера: " + dataInputStream.readUTF());


                presenter.printing("Введите операцию: ");
                String request2 = scanner.nextLine();
                dataOutputStream.writeUTF(request2);
                presenter.printing("Получили сообщение от сервера: " + dataInputStream.readUTF());


                presenter.printing("Введите второе вещественное число: ");
                String request3 = scanner.nextLine();
                dataOutputStream.writeUTF(request3);
                presenter.printing("Получили сообщение от сервера: " + dataInputStream.readUTF());
                System.out.println();


                presenter.printing("Ответ" + " " + "=" + " " + dataInputStream.readInt());
                System.out.println();





            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
