package numbers;

import java.util.*;

public class Calculation {

    final static Scanner scanner = new Scanner(System.in);
    private boolean end = false;
    private String [] input;

    public void start() {
        greeting();
        while(!end){
            System.out.print("\nEnter a request: ");
            input = scanner.nextLine().split(" ");
            if(!Arrays.toString(input).equals("[]")) {
                if (input.length == 1) {
                    if(input[0].equals("0")){
                        System.out.println("Goodbye");
                        System.exit(0);
                    }
                    singleParameter();
                } else {
                    multipleParameter();
                }
            }else greeting();
        }
    }

    public static void greeting() {
        System.out.println("\nWelcome to Amazing Numbers!\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }

    public void singleParameter() {
        if(input[0].matches("[+]?\\d*(\\.\\d+)?")) {
            Number num = new Number(Long.valueOf(input[0]));
            System.out.println("\nProperties of " + input[0].replaceAll("(\\d)(?=(\\d{3})+$)", "$1,"));
            System.out.println("buzz: " + num.buzz());
            System.out.println("duck: " + num.duck());
            System.out.println("palindromic: " + num.palindro());
            System.out.println("gapful: " + num.gapful());
            System.out.println("spy: " + num.spy());
            System.out.println("square: " + num.square());
            System.out.println("sunny: " + num.sunny());
            System.out.println("jumping: " + num.jumping());
            System.out.println("happy: " + num.isHappynumber());
            System.out.println("sad: " + !num.isHappynumber());
            System.out.println("even: " + num.even());
            System.out.println("odd: " + num.odd());
        }else System.out.println("The first parameter should be a natural number or zero.");
    }

    public void twoParameters() {
        if(checkParameters()) {
            List<Long> numbers = new ArrayList<>();
            for (int i = 0; i < Integer.parseInt(input[1]); i++) {
                numbers.add((Long.parseLong(input[0]) + i));
            }
            for (Long n : numbers) {
                Number num = new Number(n);
                List<String> listWords = Arrays.asList(((num.buzz() ? "buzz," : "") + (num.duck() ? "duck," : "") + (num.palindro() ? "palindromic," : "")
                        + (num.gapful() ? "gapful," : "") + (num.spy() ? "spy," : "") + (num.square() ? "square," : "") + (num.sunny() ? "sunny," : "")+ (num.jumping() ? "jumping," : "") + (num.even() ? "even," : "") +
                        (num.odd() ? "odd," : "") + (num.isHappynumber() ? "happy," : "sad,")).split(","));
                StringBuilder sb = new StringBuilder();
                sb.append(listWords);
                System.out.println(num.getNumber() + " is " + sb.toString().replaceAll("\\[|\\]", ""));
            }
        }
    }

    public boolean testProperty(Long num, String property) {
        Number number = new Number(num);
        switch (property.toLowerCase()) {
            case "jumping": {
                if (number.jumping()) {
                    return true;
                }
                break;
            }
            case "buzz": {
                if (number.buzz()) {
                    return true;
                }
                break;
            }
            case "duck": {
                if (number.duck()) {
                    return true;
                }
                break;
            }
            case "palindromic": {
                if (number.palindro()) {
                    return true;
                }
                break;
            }
            case "gapful": {
                if (number.gapful()) {
                    return true;
                }
                break;
            }
            case "even": {
                if (number.even()) {
                    return true;
                }
                break;
            }
            case "odd": {
                if (number.odd()) {
                    return true;
                }
                break;
            }
            case "square": {
                if (number.square()) {
                    return true;
                }
                break;
            }
            case "sunny": {
                if (number.sunny()) {
                    return true;
                }
                break;
            }
            case "spy": {
                if (number.spy()) {
                    return true;
                }
                break;
            }
            case "happy": {
                if (number.isHappynumber()) {
                    return true;
                }
                break;
            }
            case "sad": {
                if (!number.isHappynumber()) {
                    return true;
                }
                break;
            }
            case "-jumping": {
                if (!number.jumping()) {
                    return true;
                }
                break;
            }
            case "-buzz": {
                if (!number.buzz()) {
                    return true;
                }
                break;
            }
            case "-duck": {
                if (!number.duck()) {
                    return true;
                }
                break;
            }
            case "-palindromic": {
                if (!number.palindro()) {
                    return true;
                }
                break;
            }
            case "-gapful": {
                if (!number.gapful()) {
                    return true;
                }
                break;
            }
            case "-even": {
                if (!number.even()) {
                    return true;
                }
                break;
            }
            case "-odd": {
                if (!number.odd()) {
                    return true;
                }
                break;
            }
            case "-square": {
                if (!number.square()) {
                    return true;
                }
                break;
            }
            case "-sunny": {
                if (!number.sunny()) {
                    return true;
                }
                break;
            }
            case "-spy": {
                if (!number.spy()) {
                    return true;
                }
                break;
            }
            case "-happy": {
                if (!number.isHappynumber()) {
                    return true;
                }
                break;
            }
            case "-sad": {
                if (number.isHappynumber()) {
                    return true;
                }
                break;
            }
        }
        return false;
    }

    public void calcResult(Number num) {
        List<String> listWords = Arrays.asList(((num.buzz() ? "buzz," : "") + (num.duck() ? "duck," : "") + (num.palindro() ? "palindromic," : "")
                + (num.gapful() ? "gapful," : "") + (num.spy() ? "spy," : "") + (num.square() ? "square," : "") + (num.sunny() ? "sunny," : "")+ (num.jumping() ? "jumping," : "") + (num.even() ? "even," : "odd,")
                + (num.isHappynumber() ? "happy," : "sad,")).split(","));
        StringBuilder sb = new StringBuilder();
        sb.append(listWords);
        String formatted = String.valueOf(num.getNumber()).replaceAll("(\\d)(?=(\\d{3})+$)", "$1,");
        System.out.println(formatted + " is " + sb.toString().replaceAll("\\[|\\]",""));
    }

    public boolean checkParameters() {
        if(input[0].matches("[+]?\\d*(\\.\\d+)?")) {
            if(input[1].matches("[+]?\\d*(\\.\\d+)?")){
                return true;
            }else {
                System.out.println("\nThe second parameter should be a natural number.");
                return false;
            }
        }else {
            System.out.println("\nThe first parameter should be a natural number or zero.");
            return false;
        }
    }

    public List<String> prepareInputs(List<String> inputs) {
        ArrayList<String> paras = new ArrayList<String>(Arrays.asList("jumping","spy", "buzz", "duck","palindromic","gapful","even","odd", "square", "sunny","happy","sad",
                "-jumping","-spy", "-buzz", "-duck","-palindromic","-gapful","-even","-odd", "-square", "-sunny","-happy","-sad"));
        List<String> notFitting = new ArrayList<>();
        for (int j = 0; j < inputs.size(); j++) {
            if(!paras.contains(inputs.get(j))){
                notFitting.add(inputs.get(j));
            }
        }
        return notFitting;
    }

    public boolean exclusiveProperties(List<String> inputs) {
        if(inputs.contains("odd") && inputs.contains("even")) {
            System.out.println("The request contains mutually exclusive properties: [ODD, EVEN]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }else if (inputs.contains("square") && inputs.contains("sunny")) {
            System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }else if (inputs.contains("spy") && inputs.contains("duck")) {
            System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }
        else if (inputs.contains("happy") && inputs.contains("sad")) {
            System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }
        else if (inputs.contains("even") && inputs.contains("-odd")) {
            System.out.println("The request contains mutually exclusive properties: [EVEN, -ODD]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }else if (inputs.contains("-even") && inputs.contains("odd")) {
            System.out.println("The request contains mutually exclusive properties: [EVEN, -ODD]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }
        else if (inputs.contains("-even") && inputs.contains("-odd")) {
            System.out.println("The request contains mutually exclusive properties: [-EVEN, -ODD]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }
        else if (inputs.contains("-odd") && inputs.contains("odd")) {
            System.out.println("The request contains mutually exclusive properties: [EVEN, -ODD]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }
        else if (inputs.contains("-even") && inputs.contains("even")) {
            System.out.println("The request contains mutually exclusive properties: [EVEN, -ODD]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }
        else if (inputs.contains("-duck") && inputs.contains("duck")) {
            System.out.println("The request contains mutually exclusive properties: [EVEN, -ODD]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }else return true;
    }

    public void threePlusParameters() {
        List<String> inputs = new ArrayList<>();
        for (int i = 2; i < input.length; i++) {
            inputs.add(input[i].toLowerCase());
        }
        List<String> notFitting = prepareInputs(inputs);
        if(notFitting.isEmpty()) {
            if(exclusiveProperties(inputs)) {
                int count = 0;
                Long numberToTest = Long.parseLong(input[0]);
                while(count < Integer.parseInt(input[1])) {
                    int fits = 0;
                    for (String input: inputs) {
                        if(testProperty(numberToTest,input.toLowerCase())) {
                            fits++;
                        }
                    }
                    if(fits == inputs.size()) {
                        Number number = new Number(numberToTest);
                        calcResult(number);
                        count++;
                    }
                    numberToTest++;
                }
            }
        }else {
            if(notFitting.size() == 1)
                System.out.println("The property "+ Arrays.deepToString(notFitting.toArray()).toUpperCase() +" is wrong.");
            else
                System.out.println("The properties "+ Arrays.deepToString(notFitting.toArray()).toUpperCase() +" are wrong.");
            System.out.println("Available properties:\n" +
                    "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
        }
    }

    public void multipleParameter() {
        if(input.length == 2)
            twoParameters();
        else threePlusParameters();
    }
}