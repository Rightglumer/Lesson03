import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner inSc = new Scanner(System.in);

    public static void main(String[] args) {

        catchDigit(3, 10);
        catchWord();
    }

    // nextInt returns [0..maxValue), so add 1 to [1..maxValue]
    public static int getRandomNumber(int maxValue){
        return new Random().nextInt(maxValue) + 1;
    }

    // beautiful printing
    public static String getStrTries(int currentTry){
        if (currentTry == 1){
            return  "попытка";
        }
        else if (currentTry <= 4){
            return "попытки";
        }
        else{
            return "попыток";
        }
    }

    public static String getLattice(int latticeCount){
        String resValue = "";
        for (int i = 0; i < latticeCount; i++) {
            resValue += "#";
        }
        return resValue;
    }

    public static void catchDigit(int tryCount, int maxValue){
        int currentCount = 0;
        int currentValue = 0;
        int secretValue = getRandomNumber(maxValue);
        String checkStr;
        System.out.printf("Я загадал число от 1 до %d. Угадайте его.\n", maxValue);
        do{

            System.out.printf("У вас осталось %d %s.\n", (tryCount - currentCount), getStrTries(tryCount - currentCount));
            System.out.println("Введите число...");
            currentValue = inSc.nextInt();

            if (currentValue == secretValue){
                System.out.println("Поздравляю! Вы угадали!");
                break;
            }

            if (currentValue > secretValue){
                checkStr = "больше";
            }
            else {
                checkStr = "меньше";
            }

            System.out.println("К сожалению, вы не угадали. Ваше число " + checkStr + " загаданного.\n");

            currentCount ++;
        } while ((currentCount < tryCount));

        if (currentValue != secretValue){
            System.out.printf("К сожалению, у вас закончились попытки. Я загадал число %d.\n", secretValue);
        }
    }

    public static void catchWord(){
        String[] secretArray = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int wordNumber = getRandomNumber(secretArray.length);
        String currentWord;
        String printingWord;
        System.out.printf("Я загадал слово. Попробуйте угадать его.\n");
        do{
            printingWord = "";
            System.out.printf("Введите ваш вариант:\n");
            currentWord = inSc.nextLine();

            if (!currentWord.equals(secretArray[wordNumber])){
                for (int i = 0; i < currentWord.toLowerCase().length(); i++) {
                    if ((i < secretArray[wordNumber].length()) && (secretArray[wordNumber].charAt(i) == currentWord.charAt(i))){
                        printingWord += secretArray[wordNumber].charAt(i);
                    }
                    else{
                        printingWord += "#";
                    }
                }
                System.out.println("К сожалению, вы не угадали.");
                System.out.println("Совпадающие символы (если есть):");
                System.out.printf("%s\n", printingWord + getLattice(15 - printingWord.length()));

            }

        } while (!currentWord.equals(secretArray[wordNumber]));
        System.out.println("Поздравляю! Вы угадали слово!");
    }
}
