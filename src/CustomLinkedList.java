public class CustomLinkedList {
    private Node head;

    public CustomLinkedList(){

    }

    public void addNode(int data){
        Node newNode = new Node(data);


        //To check if head is null
        if(head == null){
            head = newNode;
        }
        else {
            //look for null pointer
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }

            // We now know currentNode is pointing to null = end of the list
            currentNode.setNext(newNode);
            newNode.setPrevious(currentNode);

        }
    }

    public void addToHead(int data){
        Node newNode = new Node(data);

        newNode.setNext(head);
        this.setHead(newNode);
        newNode.getNext().setPrevious(newNode);
    }

    public void addToTail(int data){
        Node newNode = new Node(data);
        Node currentNode = head;
        while(currentNode.getNext() != null){
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(newNode);
        newNode.setPrevious(currentNode);
    }

    public void addToPos(int pos, int data){
        //Create a new node
        Node newNode = new Node(data);

        if(pos == 0){
            addToHead(data);
        }

        else {
            //Loop through list to find pos
            Node currentNode = head;
            for (int i = 0; i < pos ; i++) {
                //Check to see if pos goes beyond end of list
                if (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                } else {
                    break;
                }
            }

            //Set pointers
            newNode.setNext(currentNode);
            newNode.setPrevious(currentNode.getPrevious());
            currentNode.getPrevious().setNext(newNode);
            currentNode.setPrevious(newNode);
            /*currentNode.getPrevious().setNext(newNode);
            newNode.setNext(currentNode);
            newNode.setPrevious(newNode.getPrevious());
            currentNode.setPrevious(newNode);*/
            //newNode.setNext(currentNode.getNext());
            //currentNode.setNext(newNode);
            //newNode.setPrevious(currentNode);
            /*currentNode.getPrevious().setNext(newNode);
            newNode.setPrevious(currentNode.getPrevious());
            newNode.setNext(currentNode);
            currentNode.setPrevious(newNode);*/


        }
    }

    public void changeData(int dataToReplace, int newData){
        //Create a new node
        Node currentNode = head;

        //Loop through the list to find the node pointing to the data we want to replace
        while(currentNode.getData() != dataToReplace){
            currentNode =currentNode.getNext();
        }
        //replace the node's data with the new Data
        currentNode.setData(newData);

    }

    /*public void remove(int index){
        Node currentNode = head;
        for(int i = 0; i<index-1; i++){
            if(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
        }
        currentNode.setNext();

    }
*/

    public void delete(int data){
        Node currentNode = head;
        if(currentNode.getData() == data){
            this.setHead(currentNode.getNext());
            head.setPrevious(null);
            return;
        }
        currentNode = currentNode.getNext();
        while(currentNode.getNext() != null){
            if(currentNode.getData() == data){
                currentNode.getPrevious().setNext(currentNode.getNext());
                currentNode.getNext().setPrevious(currentNode.getPrevious());
                break;
            }
            else{
                currentNode = currentNode.getNext();
            }
        }
        if(currentNode.getNext() == null && currentNode.getData() == data){
            currentNode.getPrevious().setNext(null);
        }
        //currentNode.getNext().setPrevious(currentNode.getPrevious());
        //currentNode.getPrevious().setNext(currentNode.getNext());


    }

    private Node getHead() {
        return head;
    }

    private void setHead(Node head) {
        this.head = head;
    }

    public  String toString(){
        String data = "";
        //look for null pointer
        Node currentNode = head;
        while (currentNode.getNext() != null) {
            data = data + currentNode.getData() + ", ";
            currentNode = currentNode.getNext();
        }
        data = data + currentNode.getData();
        return data;
    }

    public String reverseOutput(){
        String data = "";
        //look for null pointer
        Node currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        while(currentNode.getPrevious() != null){
            data = data + currentNode.getData() + ", ";
            currentNode = currentNode.getPrevious();
        }
        data = data + currentNode.getData();
        System.out.println(data);
        return data;
    }
}
