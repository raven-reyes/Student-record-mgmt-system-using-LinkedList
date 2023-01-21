// student record management system using linkedlist in Java
import java.util.Scanner;
public class SRMSystem {
	static Node head;
	static class Node{
		int rollNumber; // part of node data
		String name;    // part of node data
		String dept;    // part of node data
		int marks;      // part of node data
		Node next;      // link to the next node / link to the next student record
public Node(int rollNumber, String name, String dept, int marks) { // our class node constructor
			this.rollNumber = rollNumber;
			this.name = name;
			this.dept = dept;
			this.marks = marks;
		}
	}
	 // check if  a student rcord already exist
	// which is same as checking if a particular node exist in a linked list.
	public boolean check(int data) {
		if(head==null) {
			return false;
		}
		Node temp = head;
		while(temp!=null) {
			if(temp.rollNumber == data) {
				return true; // data found
			}
			temp = temp.next;
		}
		return false; //data not found
	}
	//insert data to the list
	public void insert(int rollNumber, String name, String dept, int marks) {
		// we check if a particular student record exist using roll number
		if(check(rollNumber)) {
			System.out.println("record with roll number " + rollNumber+ " already exist");
			return;
		}
		Node newNode = new Node(rollNumber, name, dept, marks);
		// if no record exist , insert the first record or 
		// if the new record to insert has a smaller roll number than the first record in the list
		if(head==null || newNode.rollNumber < head.rollNumber) { 
			newNode.next= head;
			head = newNode;
		} else { // insert at any other position
			Node temp = head;
			while(temp.next!=null && temp.next.rollNumber < newNode.rollNumber) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
		System.out.println("student inserted successfully");
	}
	// delete from the list
	public static void delete(int rollNumber) {
		if(head == null) { // if no record in the list
			System.out.println("no record available");
		} else if(head.rollNumber == rollNumber) {  // if deleting the first record
			head = head.next;
			System.out.println();
			System.out.println("record deleted successfully");
		} else { // deleting from any other position. middle and end
			Node prev = null;
			Node temp = head;
			while(temp!=null && temp.rollNumber != rollNumber) {
				prev = temp;
				temp = temp.next;
			} 
			if(temp == null) { // if record with given roll number is not available
				System.out.println();
				System.out.println("this record is not available");
			} else { // deleting the given and found  record
			prev.next = temp.next;
			System.out.println();
			System.out.println("record deleted successfully");
			}
		}
	}
	// searching for a student record
	public static void search(int rollNumber) { 
		if(head==null) { // if no record exist
			System.out.println("no record available");
		} else {  // searching the student record list from beginning to end
			Node temp = head;
			while(temp!=null && temp.rollNumber != rollNumber) {
				temp = temp.next;
			}
			if(temp == null) { // if record with given roll number is not available
				System.out.println();
				System.out.println("this record is not available");
			} else {  // returning the found record
				System.out.println();
				System.out.print("record has been found");
				System.out.println();
				System.out.print("rollNo\tname\tdept\tmarks\n");
System.out.print(temp.rollNumber + "\t" +  temp.name + "\t" +  temp.dept +"\t"  + temp.marks);
				System.out.println();
			}
		}
	}
	// traversing and printing all student records
	public static void display() {
		if(head == null) { // if no record exist
			System.out.println("list is empty");
		} else { // displaying found student records
			System.out.print("rollNo\tname\tdept\tmarks\n");
			Node temp = head;
			while(temp!=null) {
 System.out.print(temp.rollNumber + "\t" +  temp.name + "\t" +  temp.dept +"\t"  + temp.marks);
				temp = temp.next;
				System.out.println();
			}
		}
	}
// Driver code
	public static void main(String[] args) {
		System.out.println("\twelcome to student record mgmt system");
		SRMSystem list = new SRMSystem();
		Scanner sc=new Scanner(System.in);
		head = null;
		int rollNumber;
		String name;
		String dept;
		int marks;
		while(true) {
			displayMenu();
			int option=sc.nextInt();
          if(option==1) {
        	  System.out.println("enter student roll number");
        	  rollNumber = sc.nextInt();
        	  System.out.println("enter student name");
        	  name = sc.nextLine();
        	  name = sc.next();
        	  System.out.println("enter student department");
        	  dept = sc.next();
        	  System.out.println("enter student marks");
        	  marks = sc.nextInt();
        	  list.insert(rollNumber, name, dept , marks);
		} else if(option==2) {
			System.out.println("enter a student roll number to delete a student record");
			rollNumber = sc.nextInt();
			System.out.println("are you sure you want to delete this record ?");
			System.out.println("1.yes");
			System.out.println("2.no");
			int choice = sc.nextInt();
			if(choice == 1) {
				delete(rollNumber);
			} else {
				System.out.println("okay");
			}
		}
		 else if(option ==3) {
			 System.out.println("enter a student roll number to search a student");
			 rollNumber = sc.nextInt();
			 search(rollNumber);
		 }
		 else if(option == 4) {
			 display();
		 }
		 else if(option == 5) {
			 System.out.println("bye");
			 break;
		 } 
		 else {
			 System.out.println("invalid choice, please pick an option from the menu below");
		 }
		}
	}
	         // menu options
		public static void displayMenu() {
			System.out.println("\t1.create new record");
			System.out.println("\t2.enter student roll number to delete record");
			System.out.println("\t3.search a student using roll number");
			System.out.println("\t4.show all student records");
			System.out.println("\t5.exit");
			System.out.println("enter your choice 1, 2, 3, 4, or 5");
		}
	}








