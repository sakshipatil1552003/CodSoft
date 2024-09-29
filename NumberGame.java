
import java.util.Scanner;
import java.util.Random;

public class NumberGame{
    Scanner sc=new Scanner(System.in);
    Random r=new Random();
    int random_num,get_num,attempt=5;

    void getNumber(){
        //Generating a random number between 1 and 100
        random_num=r.nextInt(100)+1;

        System.out.println("A random number between 1 and 100 has been generated,Try");

        while(attempt>0&&random_num!=get_num)
        {
            System.out.println("Enter a number between 1 and 100:");
            get_num=sc.nextInt();

            if(get_num<1||get_num>100){
                System.out.println("Please enter a valid number!");
                continue;//skip decrementing the attempt if input is invalid
            }
            attempt--;

            if(random_num==get_num){
                System.out.println("you guessed it right,the number was:"+get_num);
                System.out.println("Total attempts taken:"+(5-attempt));
                break;
            }

            else{
                if(random_num>get_num){
                    System.out.println("You guessed too low,please  try again!");
                }
                else{
                    System.out.println("You guessed too high,please try again!");
                }
                System.out.println("Attempts remaining:"+attempt);

            }
        }
        if(random_num!=get_num){
            System.out.println("You are out of attempts!The number was:"+random_num);
        }
        int choice;
        System.out.println("Do you want to play again?\n PRESS1 FOR YES\n PRESS2 FOR NO");
        choice=sc.nextInt();

        if(choice==1){
            attempt=5;//reset attempts
            getNumber();
        }
        else if(choice==2){
            System.out.println("Thank you for playing!");
            sc.close();
        }
        else{
            System.out.println("invalid choice!Exiting the game");
            sc.close();
        }
    }//getNumber


    public static void main(String[]args) {
        NumberGame n=new NumberGame();
        n.getNumber();
    }//main()
}//class