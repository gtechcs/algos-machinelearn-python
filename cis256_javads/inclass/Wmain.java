import javax.swing.JOptionPane;

public class Wmain {
	
	
 public static void main (String[] args) {
  
  wlist words = new wlist();
  String searchword;

  words.add("hi");
  words.add("bye");
  words.add("xxx");
  
  System.out.println("Slow length = "+words.slowLength());
  System.out.println("Fast length = "+words.length());
  JOptionPane.showMessageDialog(null,"List: " + words);
  
  searchword = JOptionPane.showInputDialog("enter a word to search for"    );
  if (words.isThere(searchword)) 
	  JOptionPane.showMessageDialog(null, "it's there");
  else
	  JOptionPane.showMessageDialog(null,"it's not there");

  
  searchword = JOptionPane.showInputDialog("enter a word to search for"    );
  if (words.isThere(searchword)) 
	  JOptionPane.showMessageDialog(null, "it's there");
  else
	  JOptionPane.showMessageDialog(null,"it's not there");

  
  searchword = JOptionPane.showInputDialog("enter a word to search for"    );
  if (words.isThere(searchword)) 
	  JOptionPane.showMessageDialog(null, "it's there");
  else
	  JOptionPane.showMessageDialog(null,"it's not there");

  
  }
}