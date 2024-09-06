1public class ContactList {
    private Node head;

    public ContactList() {
        this.head = null;
    }

    public void addContact(Contact contact) {
        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public Contact searchContact(String nameOrPhone) {
        Node temp = head;
        while (temp != null) {
            if (temp.contact.getName().equals(nameOrPhone) || temp.contact.getPhoneNumber().equals(nameOrPhone)) {
                return temp.contact;
            }
            temp = temp.next;
        }
        return null;
    }

    public boolean removeContact(String nameOrPhone) {
        if (head == null) return false;

        if (head.contact.getName().equals(nameOrPhone) || head.contact.getPhoneNumber().equals(nameOrPhone)) {
            head = head.next;
            return true;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.contact.getName().equals(nameOrPhone) || temp.next.contact.getPhoneNumber().equals(nameOrPhone)) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void listContacts() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.contact);
            temp = temp.next;
        }
    }
}
