// Implements a 2-D array of characters

public class CharMatrix
{
  // Instance Variable
  private char[][] matrix;
  
  // Constructor: creates a grid with dimensions rows, cols,
  // and fills it with spaces
  public CharMatrix(int rows, int cols)
  {
      matrix = new char[rows][cols];
      
      for (int iRow = 0; iRow < rows; iRow++)
      {
        for (int iCol = 0; iCol < cols; iCol++)
        {
            matrix[iRow][iCol] = ' ';
        }
      }
  }

  // Constructor: creates a grid with dimensions rows , cols ,
  // and fills it with the fill  character
  public CharMatrix(int rows, int cols, char fill)
  {
      matrix = new char[rows][cols];
      
      
      for (int iRow = 0; iRow < rows; iRow++)
      {
        for (int iCol = 0; iCol < cols; iCol++)
        {
            matrix[iRow][iCol] = fill;
        }
      }
  }

  // Returns the number of rows in grid
  public int numRows()
  {
      return matrix.length;
  }

  // Returns the number of columns in grid
  public int numCols()
  {
      return matrix[0].length;
  }

  // Returns the character at row, col location
  public char charAt(int row, int col)
  {
      return matrix[row][col];
  }

  // Sets the character at row, col location to ch
  public void setCharAt(int row, int col, char ch)
  {
      matrix[row][col] = ch;
  }

  // Returns true if the character at row, col is a space,
  // false otherwise
  public boolean isEmpty(int row, int col)
  {
      if (matrix[row][col] == ' '){return true;}
      
      else{ return false;}
  }

  // Fills the given rectangle with fill  characters.
  // row0, col0 is the upper left corner and row1, col1 is the
  // lower right corner of the rectangle.
  public void fillRect(int row0, int col0, int row1, int col1, char fill)
  {
      for (int i = row0; i <= row1; i++){
          for (int j = col0; j <= col1; j++){
              matrix[i][j] = fill;
          }
      }
    
  }

  // Fills the given rectangle with SPACE characters.
  // row0, col0 is the upper left corner and row1, col1 is the
  // lower right corner of the rectangle.
  public void clearRect(int row0, int col0, int row1, int col1)
  {
      for (int i = row0; i <= row1; i++){
          for (int j = col0; j <= col1; j++){
              matrix[i][j] = ' ';
          }
      }
    
  }

  // Returns the count of all non-space characters in row 
  public int countInRow(int row)
  {
      int count = 0;
      for (int i = 0; i < matrix[row].length; i++){
          if (matrix[row][i] != ' '){count++;}
      }
      
      return count;
  }

  // Returns the count of all non-space characters in col 
  public int countInCol(int col)
  {
      int count = 0;
      for (int i = 0; i < matrix.length; i++){
          if (matrix[i][col] != ' '){count++;}
      }
      
      return count;
  }
}
