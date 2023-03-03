import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сервер запущен, ожидаем соединение....");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился к серверу!");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            View view = new View();
            Presenter presenterPrint = new Presenter();



            while (true) {
                String clientRequest = dataInputStream.readUTF();
                if (clientRequest.equals("off")) {
                    presenterPrint.printing("До новых встреч!");
                    break;
                }
                presenterPrint.printing("Получено число" + " " + clientRequest);
                dataOutputStream.writeUTF("Мы получили чило:" + " " + clientRequest);
                int x = Integer.parseInt(clientRequest);

                String clientRequest2 = dataInputStream.readUTF();
                presenterPrint.printing("Получена операция" + " " + clientRequest2);
                dataOutputStream.writeUTF("Мы получили операцию:" + " " + clientRequest2);

                String clientRequest3 = dataInputStream.readUTF();
                presenterPrint.printing("Получено число" + " " + clientRequest3);
                dataOutputStream.writeUTF("Мы получили число:" + " " + clientRequest3);
                int y = Integer.parseInt(clientRequest3);
                Presenter presenter = new Presenter(x, y);

                switch (clientRequest2){
                    case "+":
                        dataOutputStream.writeInt(presenter.summa());
                        break;
                    case "-":
                        dataOutputStream.writeInt(presenter.subt());
                        break;
                    case "*":
                        dataOutputStream.writeInt(presenter.multi());
                        break;
                    case "/":
                        dataOutputStream.writeInt(presenter.divis());
                        break;
                    default:
                        dataOutputStream.writeUTF("Введен не верный оператор");
                        break;
                }





            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
