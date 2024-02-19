import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SingleLinkedList {
	Node head;
	
	public void displayTable() {//printing the high score table
		if(head==null)
			System.out.println("List is empty");
		
		else {
			Node tmp=head;
			while(tmp!=null) {
			System.out.println(((Player)tmp.getData()).getName()+" "+((Player)tmp.getData()).getScore());
			tmp=tmp.getLink();
		}
		}
	}
	public void add(Object data) {
		Node newNode=new Node(data);
		if(head==null)
			head=newNode;
		else {
			Node temp=head;
			while(temp.getLink()!=null) {
				temp=temp.getLink();	
			}
			temp.setLink(newNode);
			
		}
		
		
	}
	public int size() {
		if(head==null) 
			return 0;
		else {
			int count=0;
			Node temp=head;
			while(temp != null) {
				temp=temp.getLink();
				count++;
			}
			
			return count;
			
		}
	
	}
	public void display() {
		if(head==null) 
			System.out.println("List is empty");
		else {
			
			Node temp=head;
			while(temp != null) {
				System.out.print(temp.getData()+" ");
				temp=temp.getLink();
				
			}
			
		}
	}
	public void addInOrder(Object data) {
	Node previous=null;
	Node n=new Node(data);
	if(head==null)//adding first item
		head=n;
	else if (((Player)n.getData()).getScore()> ((Player)head.getData()).getScore()){//inserting at front
		n.setLink(head);
		head=n;
		}
	else {//inserting in between and at last 
		
		Node tmp=head;
		while(tmp!=null&& ((Player)tmp.getData()).getScore()>((Player)n.getData()).getScore()) {
			previous=tmp;
			tmp=tmp.getLink();
			
		}
		if(tmp==null) 
			previous.setLink(n);
		else {
			n.setLink(tmp);
			previous.setLink(n);
		}
		
	
	}
	}
	public void delete(Object dataToDelete,int counter1) {
		int counter=0;
		if(head==null)
			System.out.println("Linked list is empty");
		else {
			while(head!=null&&(Integer)head.getData()== (Integer)dataToDelete && counter!=counter1) {//counter shows how many we will delete
				head=head.getLink();
				counter++;
			}
			
			Node temp=head;
			Node previous=null;
			while(temp!=null && counter!=counter1) {
				if((Integer)temp.getData()==(Integer)dataToDelete) {
					previous.setLink(temp.getLink());
					temp=previous;
					counter++;
				}
				previous=temp;
				temp=temp.getLink();
				
			}
			
		}
	}
	public void fileWriter(String txt) throws IOException {//writing score table to the file
		File file=new File(txt);
		if(!file.exists()) {
			file.createNewFile();
		}
		FileWriter fWriter=new FileWriter(file,false);
		BufferedWriter bWriter=new BufferedWriter(fWriter);
		Node tmp=head;
		while(tmp!=null) {
			bWriter.write(((Player)tmp.getData()).getName()+" "+((Player)tmp.getData()).getScore());bWriter.newLine();
			 tmp=tmp.getLink();
		}
		bWriter.close();
	}
	public int minValue() {//finding min value in sll
		if(head==null) {
			System.out.println("Linked list is empty");
			return Integer.MAX_VALUE;
		}
		else {
			int min=Integer.MAX_VALUE;
			Node temp=head;
			while(temp!=null) {
				if((int)temp.data<min) {
					min=(int)temp.data;
				}	
				temp=temp.getLink();
			}
			
			return min;
			
		}
	}
	public int counter(Object data) {//returns how many data are in sll
		int counter=0;
		if(head==null) 
			System.out.println("List is empty");
		else {
			
			Node temp=head;
			while(temp != null) {
				if((int)temp.data==(int)data)
					counter++;
				temp=temp.getLink();
			}
			
		}
		return counter;
	}

}
