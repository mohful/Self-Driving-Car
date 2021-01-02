
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
 READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
 the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Mohammed Fulwala
Student Number: 217459744
Course Section: E
 */

package Assignment1;
import java.util.*;

/**
 * 
 * @author EECS2030 Team
 *
 */

public class Map {
	boolean [][] map; 
	private int row;
	private int column;
	/**
	 * This is the constructor that constructs the city map, 
	 * which is a grid of row by column.
	 * @param row is the number of east-west streets of the city
	 * @param column is the number of north-south streets of the city
	 */
	public Map(int row, int column) {

		this.row = row;
		this.column = column;

	}
	/**
	 * This method checks the correctness of the input parameters. If the preconditions are not met 
	 * an exception is thrown, otherwise depending to the direction, it calls 
	 * one of the four recursive functions of goSouthWest, goSouthEast, goNorthWest and goNorthEast.
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre the integer parameters should be in the range of the city grid.(i.e. [0, N) if N is the number of east-west streets and [0, M) if 
	 * M is the number of north-south streets.) 
	 * @exception IllegalArgumentException if any of the precondition did not meet.
	 */
	public String getPath (int startRow, int startCol, int destRow, int destCol , String path) {

		if (startRow < 0 || startRow >= this.row || startCol < 0 || startCol >= this.column || destRow < 0 || destRow >= this.row || destCol < 0 || destCol >= this.column) {

			throw new IllegalArgumentException();

		}

		else if (startRow == destRow && startCol == destCol) {

			return "";

		}

		else if (startRow >= destRow && startCol >= destCol) {

			return goSouthWest(startRow, startCol, destRow, destCol, path);

		}

		else if (startRow >= destRow && startCol <= destCol) {

			return goSouthEast(startRow, startCol, destRow, destCol, path);
		}

		else if (startRow <= destRow && startCol <= destCol) {

			return goNorthEast(startRow, startCol, destRow, destCol, path);

		}

		else {

			return goNorthWest(startRow, startCol, destRow, destCol, path);

		}

	}
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point.  
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol >= destCol </code>
	 */

	private String goSouthWest (int startRow, int startCol, int destRow, int destCol , String path) {

		if (startRow > destRow) {

			return path + goSouthWest(startRow - 1, startCol, destRow, destCol, " (" + --startRow + "," + startCol + ") ");

		}

		else if (startCol > destCol) {

			return path + goSouthWest(startRow, startCol - 1, destRow, destCol, " (" + startRow + "," + --startCol + ") ");

		}

		else {

			return " (" + startRow + "," + startCol + ")";

		}

	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goSouthEast (int startRow, int startCol, int destRow, int destCol , String path) {

		if (startRow > destRow) {

			return path + goSouthEast(startRow - 1, startCol, destRow, destCol, "(" + --startRow + "," + startCol + ") ");

		}

		else if (startCol < destCol) {

			return path + goSouthEast(startRow, startCol + 1, destRow, destCol, "(" + startRow + "," + ++startCol + ") ");

		}

		else {

			return path;

		}
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goNorthEast (int startRow, int startCol, int destRow, int destCol , String path) {

		if (startRow < destRow) {

			return path + goNorthEast(startRow + 1, startCol, destRow, destCol, "(" + ++startRow + "," + startCol + ") ");

		}

		else if (startCol < destCol) {

			return path + goNorthEast(startRow, startCol + 1, destRow, destCol, "(" + startRow + "," + ++startCol + ") ");

		}

		else {

			return "(" + startRow + "," + startCol + ")";

		}
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and <code> startCol >= destCol </code>
	 */
	private String goNorthWest (int startRow, int startCol, int destRow, int destCol , String path) {

		if (startRow < destRow) {

			return path + goNorthWest(startRow + 1, startCol, destRow, destCol, "(" + ++startRow + "," + startCol + ") ");

		}

		else if (startCol > destCol) {

			return path + goNorthWest(startRow, startCol - 1, destRow, destCol, "(" + startRow + "," + --startCol + ") ");

		}

		else {

			return path;

		}
	}

	/**
	 * This method find a path from (startRow, startCol) to a border point of the city. 
	 * Please note that the starting point should be included in the path.
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @return is a path from (starting row, staring col) to a border point of the city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 */

	public String findPath (int startRow, int startCol) {

		List<String> paths = new ArrayList<>();
		Set<String> uniques = new HashSet<>();

		//Indirect Recursion by calling first helper method.

		findPathList(uniques, paths, startRow, startCol);

		return String.join(" ", paths).trim();

	}

	/** 
	 * This is the First Helper Method. THIS IS A RECURSIVE METHOD.
	 * It checks the base case, the recursive case and the case where the car is caught by the police.
	 * If the car is caught by the police, it calls the Second Helper Method to get the coordinates in order to start the method again.
	 * Set uniques and List paths are cleared when the police catches the self driving car.
	 * @author Mohammed Fulwala
	 * @param uniques is a setof type String to make sure the path is not duplicated.
	 * @param paths is a list of type String that stores every coordinate.
	 * @param startRow is the starting row of the path.
	 * @param startCol is the starting column of the path.
	 * @return no return statement as its a void method. return is used to get out of the if statement though, or else it will run endlessly.
	 */

	private void findPathList(Set<String> uniques, List<String> paths, int startRow, int startCol) {

		Random rand = new Random();

		int num = rand.nextBoolean() ? -1 : 1;
		int direction = rand.nextBoolean() ? 0 : 1;

		//Case when police catches car (Recursive Case)

		if (!uniques.add("(" + startRow + "," + startCol + ")")) {

			int firstRow = getCoordinates(paths.get(0)).get(0);    
			int firstCol = getCoordinates(paths.get(0)).get(1);
			uniques.clear();
			paths.clear();
			findPathList(uniques, paths, firstRow, firstCol);
			return;

		}

		//Base Case

		if (startRow == 0 || startRow == this.row - 1 || startCol == 0 || startCol == this.column - 1) {

			uniques.add("(" + startRow + "," + startCol + ")");
			paths.add("(" + startRow + "," + startCol + ")");
			return;

		}

		paths.add("(" + startRow + "," + startCol + ")");

		//Recursive Case

		if (direction == 0) {

			findPathList(uniques, paths, startRow + num, startCol);

		}

		else {

			findPathList(uniques, paths, startRow, startCol + num);

		}

	}

	/**
	 * This is the Second Helper Method. THIS IS NOT A RECURSIVE METHOD.
	 * It gets the coordinates where the police catches the self-driving car.
	 * It stores the coordinates in a list and returns the coordinates back to the First Helper Method.
	 * @author Mohammed Fulwala
	 * @param a string that stores the coordinate in the list path in case the police catches the self driving car.
	 * @return a list that is of integer type is returned with the row and column for the first helper to start over.
	 */

	private List<Integer> getCoordinates(String element) {

		String point = element;
		point = point.substring(1, element.length() - 1);
		String[] points = point.split(",");
		int row = Integer.parseInt(points[0]);
		int col = Integer.parseInt(points[1]);

		List<Integer> coords = new ArrayList<>();
		coords.add(row);
		coords.add(col);

		return coords;

	}


} 
