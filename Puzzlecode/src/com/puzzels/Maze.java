package com.puzzels;

public class Maze {
  private int[][] maze;                                  
  private final char wall = 'X';   
  private final char finish = 'F'; 
  private final char start = 'S';  
  private final int blocked = -1;  
  private final int visited = -2;
  private final int end = -3;                                         
  private int startRow;            
  private int startCol;            
  private static final int[] moveX = {0, 1, 0, -1};
  private static final int[] moveY = {-1, 0, 1, 0};
  private static final char[] dir = {'^','>','v','<'};
  public Maze(String[] m) {
    if (m.length > 0) { 
      maze = new int[m.length] [m[0].length()];
      for (int i = 0; i < m.length; i++) {
        for (int j = 0; j < m[i].length(); j++) {
          if (m[i].charAt(j) == wall) {
            maze [i][j] = blocked;
          }
          if (m[i].charAt(j) == finish) {
            maze[i][j] = end;
          }
          if (m[i].charAt(j) == start) {
            startRow = i;
            startCol = j;
          }
        }
      }
    } else {
      throw new RuntimeException("Invalid Maze!");
    }
  }
  public void printMaze() {
    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[i].length; j++) {
        if (maze[i][j] == -1) {
          System.out.print('.');
        }
        if (maze[i][j] == -2) {
          System.out.print('.');
        }
        if (maze[i][j] == -3) {
          System.out.print('F');
        }
        if (maze[i][j] == 0) {
          System.out.print('.');
        }
        if (maze[i][j] > 0) {
          System.out.print((char)maze[i][j]);
        }
      }
      System.out.print("\n");
    }
  }
  public boolean canFinish() {
    return walkMaze(startRow, startCol, 'S') ;
  }
  public boolean walkMaze(int row, int col, char direction) {
    if (row < 0  || row >= maze.length 
          || col < 0 || col >= maze[0].length
          || (maze[row][col] != 0 && maze[row][col] != end)) {
          return false;
      }
    if (maze[row][col] == end) {
          return true;
      }
    maze[row][col] = direction;
    int move = 0; 
    boolean found = false;
    while (!found && move < moveX.length) { 
      found = walkMaze(row + moveY[move], col + moveX[move], dir[move]);
      move++;
    }
    if (!found) {
          maze[row][col] = visited;
      }
    return found;
  }
  public static void main(String [] args) {
    String [] myMaze = {
      "XXSXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
      "XX XXXXXXXXXXXXX     XXXXXXXXXXX",
      "XX    XXXXXXXXXX XXX XX     XXXX",
      "XXXXX  XXXXXX    XXX XX XXX XXXX",
      "XXX XX XXXXXX XX XXX XX  XX XXXX",
      "XXX     XXXXX XXXXXX XXXXXX XXXX",
      "XXXXXXX       XXXXXX        XXXX",
      "XXXXXXXXXX XXXXX XXXXXXXXXXXXXXX",
      "XXXXXXXXXX XX    XXXXX      XXXX",
      "XXXXXXXXXX    XXXXXXXX XXXX XXXX",
      "XXXXXXXXXXX XXXXXXXXXX XXXX XXXX",
      "XXXXXXXXXXX            XXXX XXXX",
      "XXXXXXXXXXXXXXXXXXXXXXXX XX XXXX",
      "XXXXXX              XXXX XX XXXX",
      "XXXXXX XXXXXXXXXXXX XX      XXXX",
      "XXXXXX XXF   XXXXXX XXXX XXXXXXX",
      "XXXXXX XXXXX   XXX            XX",
      "XXXXXX XXXXXXX XXXXXXXXXXX XXXXX",
      "XXXXXX XXXXXXX XXXXXXXXXXXXXXXXX",
      "XXXXXX            XXXXXXXXXXXXXX"};
    
      Maze m = new Maze(myMaze);
      if (m.maze[0][0] != 0) {
        System.out.println("this is not zero");
      }
      if (m.canFinish() ){  
        m.printMaze();
      } else {
        m.printMaze();
        System.out.println("No way to get there!");
      }
      
    }  
}   