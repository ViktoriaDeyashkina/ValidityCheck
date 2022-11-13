

class TaxNumber {
    private String incomingNumber;

    public TaxNumber (String incomingNumber){
        this.incomingNumber = incomingNumber;
    }

    public boolean checkValidity()  {
            String[] taxNumber1 = incomingNumber.split("");
            int[] taxNumber = new int[taxNumber1.length];
            for (int i = 0; i < taxNumber1.length; i++) {
                taxNumber[i] = Integer.parseInt(taxNumber1[i]);
            }
            int sum1 = (taxNumber[0] * 7) + (taxNumber[1] * 2) + (taxNumber[2] * 4) + (taxNumber[3] * 10) + (taxNumber[4] * 3) + (taxNumber[5] * 5) + (taxNumber[6] * 9) + (taxNumber[7]) * 4 + (taxNumber[8] * 6) + (taxNumber[9] * 8);
            int result1;
            int result11 = sum1 % 11;
            int result12;
            if (result11 > 9) {
                result12 = result11 % 10;
                result1 = result12;
            } else result1 = result11;
            int sum2 = taxNumber[0] * 3 + taxNumber[1] * 7 + taxNumber[2] * 2 + taxNumber[3] * 4 + taxNumber[4] * 10 + taxNumber[5] * 3 + taxNumber[6] * 5 + taxNumber[7] * 9 + taxNumber[8] * 4 + taxNumber[9] * 6 + taxNumber[10] * 8;
            int result2;
            int result21 = sum2 % 11;
            int result22;
            if (result21 > 9) {
                result22 = result21 % 10;
                result2 = result22;
            } else result2 = result21;
            if (result1 == (taxNumber[10]) && result2 == taxNumber[11]) {
                return true;
            } else
                return false;
    }
}




