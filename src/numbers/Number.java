package numbers;



public class Number {

    private Long number;

    public Number(Long number) {
        this.number = number;
    }

    public Long getNumber() {
        return number;
    }

    public boolean buzz() {
        boolean divisible = this.number % 7 == 0 ?  true :  false;
        boolean endsWith7 = checkSuffix(this.number,Long.valueOf(7)) ? true : false;
        return divisible || endsWith7;
    }

    public boolean palindro() {
        String rev = (new StringBuilder(Long.toString(this.number))).reverse().toString();
        return Long.toString(this.number).equals(rev) ? true : false;
    }

    public boolean gapful() {
        String str = Long.toString(this.number);
        if(str.length() >= 3) {
            char ch1 = str.charAt(0);
            char ch2 = str.charAt(str.length()-1);
            String fn = Character.toString(ch1) + Character.toString(ch2);
            if(this.number % Integer.parseInt(fn) == 0) {
                return true;
            }
        }
        return false;
    }


    public boolean isHappynumber() {
        long num = this.number;
        long sum = 0;
        long n = num;
        do {
            sum = 0;
            while (n != 0) {
                int d = (int)(n % 10);
                sum += d * d;
                n /= 10;
            }
            n = sum;
        } while (sum > 6);

        if (sum == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean sunny() {
        double square_root = Math.sqrt(this.number + 1);
        return((square_root - Math.floor(square_root)) == 0);
    }

    public boolean square() {
        double square_root = Math.sqrt(this.number);
        return((square_root - Math.floor(square_root)) == 0);
    }

    public boolean spy() {
        String str = Long.toString(this.number);
        int plus = 0;
        for(int i = 0 ; i < str.length(); i++) {
            plus += Character.getNumericValue(str.charAt(i));
        }
        int product = 1;
        for(int i = 0 ; i < str.length(); i++) {
            product *= Character.getNumericValue(str.charAt(i));
        }
        return (plus == product ? true : false);
    }

    public boolean even() {
        return this.number % 2 == 0;
    }

    public boolean odd() {
        return this.number % 2 != 0;
    }


    public boolean duck() {
        String temp = Long.toString(this.number);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            newGuess[i] = temp.charAt(i) - '0';
        }
        for(int j = 1; j < newGuess.length;j++) {
            if(newGuess[j] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean jumping() {
        boolean isJumping = false;
        long value = this.number;
        if (value < 10) {
            isJumping = true;
        } else {
            int n1 = 0;
            int n2 = 0;
            do {
                n1 = (int) value % 10;
                value /= 10;
                n2 = (int) value % 10;
                if ((n1 - n2 == 1) || (n2 - n1 == 1)) {
                    isJumping = true;
                } else {
                    isJumping = false;
                    break;
                }
            }
            while (value > 9);
        }
        return isJumping;
    }



    public boolean checkSuffix(Long A, Long B) {
        String s1 = String.valueOf(A),s2 = String.valueOf(B);
        int n1 = s1.length(),n2 = s2.length();

        if (n1 < n2)
            return false;

        for(int i = 0; i < n2; i++) {
            if (s1.charAt(n1 - i - 1) != s2.charAt(n2 - i - 1))
                return false;
        }
        return true;
    }
}