package lab_work_seventh;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class VisualMassiv {

	private final int squareWidth = 20;
	private final int squareHeight = 20;
	private final int impassable = 0;
	private final int passable = 1;
	private final int player = 2;
	private final int exit = 3;
	private final int size = 31;
	private final Color lightStateGray = new Color(119,136,153);
	Image imageExit = new ImageIcon("exit.jpg").getImage();
	Image imageHuman = new ImageIcon("human.jpg").getImage();
	



	private int[][] arr = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,2,1,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,0},
			{0,0,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0},
			{0,1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,0,1,0,1,0},
			{0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0},
			{0,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,0},
			{0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,0,1,0,1,1,1,0,1,0,1,0},
			{0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0},
			{0,1,0,1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,0,1,1,1,0,1,1,1,0},
			{0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0},
			{0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,0,1,0,1,0},
			{0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,0,0,1,0,1,0},
			{0,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,0},
			{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0},
			{0,1,0,1,0,1,1,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,1,1,0,1,0,1,1,1,0},
			{0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0},
			{0,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0},
			{0,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0},
			{0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,0,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0},
			{0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0},
			{0,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,0},
			{0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,1,0,0,0},
			{0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,0},
			{0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,0},
			{0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,3,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	};


	private boolean canMoveDown()
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{	
				if(arr[i][j] == player)
				{
					if(i+1 >= size || arr[i+1][j] == impassable)
						return false;
				}
			}
		}
		return true;
	}

	private boolean canMoveUp()
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{	
				if(arr[i][j] == player)
				{
					if(i <= 0 || arr[i-1][j] == impassable)
						return false;
				}
			}
		}
		return true;
	}
	
	private boolean canMoveLeft()
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{	
				if(arr[i][j] == player)
				{
					if(j <= 0 || arr[i][j-1] == impassable)
						return false;
				}
			}
		}
		return true;
	}
	
	private boolean canMoveRight()
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{	
				if(arr[i][j] == player)
				{
					if(j+1 >= size || arr[i][j+1] == impassable)
						return false;
				}
			}
		}
		return true;
	}


	public void moveDown()
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{	
				if(arr[i][j] == player)
				{
					if(canMoveDown())
					{
						if(arr[i+1][j] != exit)
						{
							arr[i+1][j] = player;
							arr[i][j] = passable;
							return;
						}
						else
						{
							System.exit(0);
						}
					}
				}
			}
		}
	}

	public void moveUp()
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{	
				if(arr[i][j] == player)
				{
					if(canMoveUp())
					{
						if(arr[i-1][j] != exit)
						{
							arr[i-1][j] = player;
							arr[i][j] = passable;
							return;
						}
						else
						{
							System.exit(0);
						}
					}
				}
			}
		}
	}

	public void moveLeft()
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{	
				if(arr[i][j] == player)
				{
					if(canMoveLeft())
					{
						if(arr[i][j-1] != exit)
						{
							arr[i][j-1] = player;
							arr[i][j] = passable;
							return;
						}
						else
						{
							System.exit(0);
						}
					}
				}
			}
		}
	}
	
	
	public void moveRight()
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{	
				if(arr[i][j] == player)
				{
					if(canMoveRight())
					{
						if(arr[i][j+1] != exit)
						{
							arr[i][j+1] = player;
							arr[i][j] = passable;
							return;
						}
						else
						{
							System.exit(0);	
						}
							
					}
				}
			}
		}
	}

	public void draw(Graphics g, MyPanel panel)
	{
		for(int i = 0; i < arr.length; i++)
		{
			int[] tempArr = arr[i];
			for(int j = 0; j < tempArr.length; j++)
			{	
				switch(arr[i][j]) {
				case passable:
					g.setColor(Color.WHITE);
					g.fillRect(10 + j * squareWidth,10 + i * squareHeight, squareWidth, squareHeight);
					break;
				case impassable:
					g.setColor(lightStateGray);
					g.fillRect(10 + j * squareWidth,10 + i * squareHeight, squareWidth, squareHeight);
					break;
				case player:
					g.setColor(Color.GREEN);
					g.drawImage(imageHuman,10 + j * squareWidth,10 + i * squareHeight, squareWidth, squareHeight,panel);
					break;
				case exit:
					g.setColor(Color.RED);
					g.drawImage(imageExit, 10 + j * squareWidth, 10 + i * squareHeight,squareWidth,squareHeight,panel);
				}	
			}
		}
	}
}
