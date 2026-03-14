package br.com.ajf.game.util;

/**
 * The Class CSVString.
 */
public final class CSVString
{
	
	/** The Constant MATCHES_TO_CHECK_IF_IS_A_NUMBER. */
	private static final String MATCHES_TO_CHECK_IF_IS_A_NUMBER = "-?\\d+(\\.\\d+)?";
	
	/** The id. */
	private int[] id;
	
	/** The title. */
	private String[] title;
	
	/** The data. */
	private String[][] data;
	
	/**
	 * Instantiates a new CSV string.
	 *
	 * @param csvFilePath the csv file path
	 */
	public CSVString(String csvFilePath)
	{
		String[] aux = new ResourceLoader().read(csvFilePath).split("\n");
		
		title = aux[0].replace("\"", "").split(";");
		
		id = new int[title.length];
		
		for (int i = 0; i < title.length; i++)
		{
			id[i] = i;
		}
		
		data = new String[aux.length][];
		
		for (int i = 1; i < data.length; i++)
		{
			String[] aux2 = aux[i].replace("\"", "").split(",");
		
			data[i] = new String[aux2.length];
			
			for (int j = 0; j < aux2.length; j++)
			{	
				data[i][j] = aux2[j];
			}
		}
	}
	
	/**
	 * Gets the data by column id.
	 *
	 * @param columnId the column id
	 * @return the data by column id
	 */
	public String[] getDataByColumnId(int columnId)
	{
		String[] aux = new String[data.length];
			
			for (int j = 0; j < data[1].length; j++)
			{	
				for(int k = 0;k < data.length-1;k++)
				{
					if(columnId == id[columnId])
					{
						aux[k] = data[k+1][columnId];
					}
				}
			}
		return aux;
	}
	
	/**
	 * Gets the data by column name.
	 *
	 * @param columnName the column name
	 * @return the data by column name
	 */
	public String[] getDataByColumnName(String columnName)
	{
		for (int i = 0; i < title.length; i++)
		{
			if(title[i].equalsIgnoreCase(columnName))
			{
				return getDataByColumnId(i);
			}
		}
		
		return new String[] {};
	}
	
	/**
	 * Gets the row data by id.
	 *
	 * @param rowIndex the row index
	 * @return the row data by id
	 */
	public String[] getRowDataById(int rowIndex)
	{
		String[] aux = new String[data[1].length];
		
		for (int i = 1; i < data.length; i++)
		{	
			for (int j = 0; j < aux.length; j++)
			{	
				if(rowIndex == i)
				{
					if(data[i][j].equalsIgnoreCase(" "))
					{
						aux[j] = "NULL";
					}
					else
					{
						aux[j] = data[i][j];
					}
				}
			}
		}

		return aux;
	}
	
	/**
	 * Gets the parses the data to int array.
	 *
	 * @param data the data
	 * @return the parses the data to int array
	 */
	public int[] getParseDataToIntArray(String[] data)
	{
		int[] aux = new int[data.length];
		
		for (int i = 0; i < aux.length; i++)
		{
			if(data[i+1] != null && canParse(data[i+1]))
			{
				aux[i] = Integer.parseInt(data[i+1]);
			}
		}
		
		return aux;
	}
	
	/**
	 * Gets the parses the data to double array.
	 *
	 * @param data the data
	 * @return the parses the data to double array
	 */
	public double[] getParseDataToDoubleArray(String[] data)
	{
		double[] aux = new double[data.length];
		
		for (int i = 0; i < aux.length; i++)
		{
			if(data[i+1] != null && canParse(data[i+1]))
			{
				aux[i] = Double.parseDouble(data[i+1]);
			}
		}
		
		return aux;
	}
	
	/**
	 * Can parse.
	 *
	 * @param string the string
	 * @return true, if successful
	 */
	private boolean canParse(String string)
	{
		return string.matches(MATCHES_TO_CHECK_IF_IS_A_NUMBER);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();

		builder.append("Rows").append("\t");
		
		for (String aux : title)
		{
			builder.append(aux).append("\t").append("\t");
		}
		
		builder.append("\n");
		
		int rows = 0;
		
		for (int i = 1; i < data.length; i++)
		{	
			builder.append(rows);
			
			for (int j = 0; j < data[i].length; j++)
			{	
				builder.append("\t").append(data[i][j].equals(" ") ? "NULL" : data[i][j]).append("\t").append("\t");
			}
			rows++;
			builder.append("\n");
		}

		return builder.toString();
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String[] getTitle()
	{
		return title.clone();
	}

	/**
	 * Adds the title.
	 *
	 * @param title the title
	 * @return the string[]
	 */
	public String[] addTitle(String[] title)
	{
		return this.title = title;
	}
	
	/**
	 * Adds the title.
	 *
	 * @param newTitle the new title
	 * @param pos the pos
	 * @return the string
	 */
	public String addTitle(String newTitle,int pos)
	{
	  return this.title[pos] = newTitle;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public String[][] getData()
	{
		return data.clone();
	}

	/**
	 * Adds the data.
	 *
	 * @param data the data
	 * @return the string[][]
	 */
	public String[][] addData(String[][] data)
	{
	  return this.data = data;
	}
	
	/**
	 * Adds the data.
	 *
	 * @param newData the new data
	 * @param row the row
	 * @param col the col
	 * @return the string
	 */
	public String addData(String newData,int row,int col)
	{
	   return this.data[row][col] = newData;
	}
}