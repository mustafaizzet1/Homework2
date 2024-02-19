import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class Main {
	public static int delete(SingleLinkedList sll,int counter,int score,int number) {//delete and return score
		for (int i1 = 0; i1 <counter/4 ; i1++) {
			sll.delete(number,4);
			score+=10;
		}
		return score;
	}
	public static int yahtzee(SingleLinkedList sll,int score) {
		int counter1=sll.counter(1);//counter for numbers
		int counter2=sll.counter(2);
		int counter3=sll.counter(3);
		int counter4=sll.counter(4);
		int counter5=sll.counter(5);
		int counter6=sll.counter(6);
		if(counter1>=4) {
				score=delete(sll,counter1,score,1);
		}
		if(counter2>=4) {
			score=delete(sll,counter2,score,2);
		}
		if(counter3>=4) {
			score=delete(sll,counter3,score,3);
		}
		if(counter4>=4) {
				score=delete(sll,counter4,score,4);
		}
		if(counter5>=4) {
				score=delete(sll,counter5,score,5);
		}
		if(counter6>=4) {
				score=delete(sll,counter6,score,6);
		}
		return score;
	}
	public static int largeStraight(SingleLinkedList sll,int score) {
		SingleLinkedList sll1=new SingleLinkedList();
		int counter1=sll.counter(1);//counter for numbers
		int counter2=sll.counter(2);
		int counter3=sll.counter(3);
		int counter4=sll.counter(4);
		int counter5=sll.counter(5);
		int counter6=sll.counter(6);
		sll1.add(counter1);
		sll1.add(counter2);
		sll1.add(counter3);
		sll1.add(counter4);
		sll1.add(counter5);
		sll1.add(counter6);
		int min=sll1.minValue();//return min value
		if(counter1>0 &&counter2>0&&counter3>0&&counter4>0&&counter5>0&&counter6>0) {
		for (int i = 0; i < min; i++) {
		sll.delete(1,1);
		sll.delete(2,1);
		sll.delete(3,1);
		sll.delete(4,1);
		sll.delete(5,1);
		sll.delete(6,1);
			
		score+=30;
			
		}
		}
		return score;
	}
	public static void add(SingleLinkedList sll1,SingleLinkedList sll2) {//adding random numbers into sll
		for (int j = 0; j < 3; j++) {
			sll1.add(1+(int)(Math.random()*6));
			sll2.add(1+(int)(Math.random()*6));
		}
	}
	public static SingleLinkedList fileReading(String txt) {//file reading and adding into the sll
		SingleLinkedList sll=new SingleLinkedList();
		try 
		{        
		File file = new File(txt);
		Scanner x=new Scanner(file);
		while(x.hasNextLine())
		{
		String line=x.nextLine();
		int index=line.indexOf(" ");
		Player p=new Player(line.substring(0, index),Integer.parseInt(line.substring(index+1)));
		sll.addInOrder(p);
		}
		x.close();
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return sll;
	}
	public static void main(String[] args) throws IOException {
		int score1=0;
		int score2=0;
		SingleLinkedList sll1=new SingleLinkedList();
		SingleLinkedList sll2=new SingleLinkedList();
		SingleLinkedList score=new SingleLinkedList();
		score=fileReading("HighScoreTable.txt");
		for (int i = 1; i <= 10; i++) {
			add(sll1,sll2);
			System.out.println("Turn:"+i);
			System.out.print("Player1:");
			sll1.display();
			System.out.print("       "+"score"+score1);
			int tmpscore1=score1;
			score1=largeStraight(sll1,score1);
			score1=yahtzee(sll1, score1);
			System.out.println();
			System.out.print("Player2:");
			sll2.display();
			System.out.print("       "+"score"+score2);
			System.out.println();
			int tmpscore2=score2;
			score2=largeStraight(sll2,score2);
			score2=yahtzee(sll2, score2);
			if(tmpscore1<score1 || tmpscore2<score2) {
				System.out.println();
				System.out.print("Player1:");
				sll1.display();
				System.out.print("       "+"score"+score1);
				System.out.println();
				System.out.print("Player2:");
				sll2.display();
				System.out.print("       "+"score"+score2);
				System.out.println();		
			}
		}
		System.out.println("Game is over");
		if(score2>score1) {
			System.out.println("Winner player 2");
			Player p=new Player("Player2",score2);
			score.addInOrder(p);
		}
		else if(score1==score2)
			System.out.println("Tie");
		else {
			System.out.println("Winner player 1");
			Player p=new Player("Player1",score1);
			score.addInOrder(p);
		}
	System.out.println("High Score Table");
	score.displayTable();
	score.fileWriter("HighScoreTable.txt");
	}

}
