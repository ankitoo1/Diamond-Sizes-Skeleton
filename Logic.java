package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;

import java.util.Scanner;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

import static java.lang.System.console;
import static java.lang.System.getProperties;
import static java.lang.System.out;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */

    public void fillInside(double x){
        if (x % 2 == 0) {
            mOut.print("=");
        } else {
            mOut.print("-");
        }
    }

    public void process(int size) {

        // TODO -- add your code here

        int height = size + 1;
        //up & middle part
        for (int i = 1; i <= height; i++)
        {
            printTopFrame(height,i);

            printUpAndMiddle(height,size,i);
            printDownFrame(height,i);
            mOut.println("");
        }

        //down part
        for (int i = height - 1; i >= 1; i--)
        {
            printTopFrame(height, i);
            printDown(height, size, i);
            printDownFrame(height, i);
            mOut.println("");
        }

    }
    private  void printTopFrame(int height,int i)
    {
        for (int j = height; j >= i; j--)
        {
            if (i == 1 && j == height)
                mOut.print("+");
            else if (j == height)
                mOut.print("|");
            else if (i == 1)
                mOut.print("-");
            else
                mOut.print(" ");
        }
    }
    private void printDownFrame(int height,int i)
    {
        for (int j = height; j >= i; j--)
        {
            if (i == 1 && j == 1)
                mOut.print("+");
            else if (j == i)
                mOut.print("|");
            else if (i == 1)
                mOut.print("-");
            else
                mOut.print(" ");

        }
    }
    private void printUpAndMiddle(int height,int size, int i )
    {
        for (int j = 2; j <= i; j++)
        {
            if (i % 2 == 1)
            {
                if (size > 1 && j == 2 && i == 2)
                    mOut.print("/\\");

                else if (j == 2 && i < height)
                    mOut.print("/-");
                else if (j == i && i < height)
                    mOut.print("-\\");
                else if (j == 2 && i == height)
                    mOut.print("<-");
                else if (j == i && i == height)
                    mOut.print("->");
                else
                    mOut.print("--");
            }
            else
            {
                if (size > 1 && j == 2 && i == 2)
                    mOut.print("/\\");
                else if (j == 2 && i < height)
                    mOut.print("/=");
                else if (j == i && i < height)
                    mOut.print("=\\");
                else if (size > 1 && j == 2 && i == height)
                    mOut.print("<=");
                else if (size == 1)
                    mOut.print("<>");
                else if (j == i && i == height)
                    mOut.print("=>");
                else
                    mOut.print("==");
            }
        }
    }

    private void printDown(int height,int size, int i )
    {
        for (int j = 2; j <= i; j++)
        {
            if (i % 2 == 1)
            {

                if (size > 1 && j == 2 && i == 2)
                    mOut.print("\\/");
                else if (j == 2 && i < height)
                    mOut.print("\\-");
                else if (j == i && i < height)
                    mOut.print("-/");
                else
                    mOut.print("--");
            }
            else
            {
                if (size > 1 && j == 2 && i == 2)
                    mOut.print("\\/");
                else if (j == 2 && i < height)
                    mOut.print("\\=");
                else if (j == i && i < height)
                    mOut.print("=/");
                else
                    mOut.print("==");
            }


        }
    }

        /*
        for (int i = 1; i <= (size * 2 + 1); i++) {
            for (int j = 1; j <= (size * 2 + 2); j++) {
                //Making the border of a diamond with <> at the both sides of it
                if ((j == 1 || j == (size * 2 + 2))&& (i == 1 || i == (size * 2 + 1))){
                    mOut.print("+");}
                else if (i == 1 || i == size * 2 + 1) {
                    mOut.print("-");}
                else if (j == 1 || j == size * 2 + 2) {
                    mOut.print("|");}
                else if (i == size + 1 && j == 2) {
                    mOut.print("<");}
                else if (i == size + 1 && j == size * 2+1) {
                    mOut.print(">");}
                //Making the boundaries of a diamond
                else if (i<=size+1 && j<=size+1){
                    if (j==size+3-i){
                        mOut.print("/");}
                    else if (j>size+3-i){
                        fillInside(i);
                    }
                    else {
                        mOut.print(" ");}
                }
                else if (i>=size && j<=size+1){
                    if (j==i-size+1){
                        mOut.print("\\");}
                    else if (j>i-size+1) {
                        fillInside(i);
                    }
                    else {
                        mOut.print(" ");}
                }
                else if (i>size+1 && j>size+1){
                    if (j==3*size-i+2){
                        mOut.print("/");}
                    else if (j<3*size-i+2){
                        fillInside(i);
                    }
                    else {
                        mOut.print(" ");}
                }
                else if (i<=size+1 && j>=size+1){
                    if (j==size+i){
                        mOut.print("\\");}
                    else if (j<size+i){
                        fillInside(i);
                    }
                    else {
                        mOut.print(" ");}
                }
                else {
                    mOut.print(" ");}
            }
            //Gap after each line
            mOut.println('\n') ;
        }

    }
    */
}
