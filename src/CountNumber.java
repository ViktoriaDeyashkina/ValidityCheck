
import java.io.IOException;


class CountNumber {
    private String incomingBICNumber;
    private String incomingCountNumber;

    public CountNumber(String incomingBICNumber, String incomingCountNumber) {
        this.incomingBICNumber = incomingBICNumber;
        this.incomingCountNumber = incomingCountNumber;
    }


    public boolean checkValidity() throws IOException {
        String[] BICNumber1 = incomingBICNumber.split("");
        int[] BICNumber = new int[BICNumber1.length];
            for (int i = 0; i < BICNumber1.length; i++) {
                BICNumber[i] = Integer.parseInt(BICNumber1[i]);
            }
            String[] countNumber1 = incomingCountNumber.split("");
            int[] countNumber = new int[countNumber1.length];
            for (int i = 0; i < countNumber1.length; i++) {
                    countNumber[i] = Integer.parseInt(countNumber1[i]);
                }
            int sum = BICNumber[6] * 7 + BICNumber[7] * 1 + BICNumber[8] * 3 + countNumber[0] * 7 + countNumber[1] * 1 + countNumber[2] * 3 + countNumber[3] * 7 + countNumber[4] * 1 + countNumber[5] * 3 + countNumber[6] * 7 + countNumber[7] * 1 + countNumber[8] * 3 + countNumber[9] * 7 + countNumber[10] * 1 + countNumber[11] * 3 + countNumber[12] * 7 + countNumber[13] * 1 + countNumber[14] * 3 + countNumber[15] * 7 + countNumber[16] * 1 + countNumber[17] * 3 + countNumber[18] * 7 + countNumber[19] * 1;
            if (sum % 10 == 0) {
                return true;
            } else return false;
        }
    }

