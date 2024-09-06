import java.util.Scanner;

public class ContactManager {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu: 1. Adicionar, 2. Buscar, 3. Remover, 4. Listar, 5. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Nome: ");
                    String name = scanner.nextLine();
                    System.out.println("Telefone: ");
                    String phone = scanner.nextLine();
                    System.out.println("Email: ");
                    String email = scanner.nextLine();
                    contactList.addContact(new Contact(name, phone, email));
                    break;
                case 2:
                    System.out.println("Nome ou Telefone para Buscar: ");
                    String searchQuery = scanner.nextLine();
                    Contact foundContact = contactList.searchContact(searchQuery);
                    if (foundContact != null) {
                        System.out.println(foundContact);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Nome ou Telefone para Remover: ");
                    String removeQuery = scanner.nextLine();
                    boolean removed = contactList.removeContact(removeQuery);
                    System.out.println(removed ? "Contato removido." : "Contato não encontrado.");
                    break;
                case 4:
                    contactList.listContacts();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}
