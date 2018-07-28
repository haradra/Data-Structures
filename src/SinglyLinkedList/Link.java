package SinglyLinkedList;

public class Link {
	public String ballName;
	public int ballsSold;
	public Link next;
	
	public Link(String ballName, int ballsSold) {
		this.ballName = ballName;
		this.ballsSold = ballsSold;
	}
	
	public void display() {
		System.out.println(ballName + ": " + ballsSold);
	}
	
	public String StringtoString() {
		return ballName;
	}
	
	public static void main(String[] args) {
		// Testing the linked list
		LinkList theLinkedList = new LinkList();
		theLinkedList.insertFirstLink("Volleyball", 45);
		theLinkedList.insertFirstLink("Basketball", 9);
		theLinkedList.insertFirstLink("Tennis ball", 178);
		theLinkedList.insertFirstLink("Rugby ball", 60);
		theLinkedList.display();
		
		theLinkedList.findLink("Basketball");
		theLinkedList.removeFirstLink();
		theLinkedList.display();
		theLinkedList.removeLink("Volleyball");
		theLinkedList.display();
		
	}
}

class LinkList{
	public Link firstLink;
	LinkList(){
		firstLink = null;
	}
	
	public boolean isEmpty() {
		return this.firstLink == null;
	}
	
	public void insertFirstLink(String ballName, int ballsSold) {
		Link newLink = new Link(ballName, ballsSold);
		newLink.next = this.firstLink;
		this.firstLink = newLink;
		
	}
	
	public Link removeFirstLink() {
		Link linkReference = firstLink;
		if (!this.isEmpty()) {
			this.firstLink = this.firstLink.next;
		} else {
			System.out.println("Empty LinkedList");
		}
		return linkReference;
	}
	
	public void display() {
		Link theLink = firstLink;
		
		while(theLink != null){
			theLink.display();
			theLink = theLink.next;
			System.out.println("Next Link: " + theLink);
		}
	}
	
	public Link findLink(String ballName) {
		Link theLink = firstLink;
		if (!isEmpty()) {
			while(theLink.ballName != ballName) {
				if (theLink.next == null) {
					return null;
				} else {
					theLink = theLink.next;
				}
			}
		} else {
			System.out.println("Empty LinkedList");
		}
		return theLink;
	}
	
	public Link removeLink(String ballName) {
		
		Link currentLink = firstLink;
		Link previousLink = firstLink;
		while(currentLink.ballName != ballName) {
			if (currentLink.next == null) {
				return null;
			} else {
				previousLink = currentLink;
				currentLink = currentLink.next;
			}
		}
		if(currentLink == firstLink) {
			firstLink = firstLink.next;
		} else {
			previousLink.next = currentLink.next;
		}
		return currentLink;
	}
}